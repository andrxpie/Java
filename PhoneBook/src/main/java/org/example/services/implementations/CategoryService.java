package org.example.services.implementations;

import org.example.DTOs.CategoryDto;
import org.example.entities.Category;
import org.example.exceptions.CategoryException;
import org.example.repositories.ICategoryRepository;
import org.example.services.ICategoryService;
import org.example.storage.IStorageService;
import org.example.mappers.CategoryMapper;
import org.example.DTOs.FileFormats;
import org.example.DTOs.CategoryCreateDto;
import org.example.DTOs.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repo;
    @Autowired
    private IStorageService storageService;
    @Autowired(required=true)
    private CategoryMapper mapper;

    @Override
    public Long saveCategory(CategoryCreateDto categoryModel) {
        try {
            Category category = mapper.fromCreationModel(categoryModel);
            String imageName = storageService.saveImage(categoryModel.getFile(), FileFormats.JPG);
            category.setImage(imageName);
            category.setCreationTime(LocalDateTime.now());
            Category savedCategory = repo.save(category);
            return savedCategory.getId();
        } catch (Exception e) { throw new CategoryException("Invoice save error"); }
    }

    @Override
    public PaginationResponse<CategoryDto> getCategoryByName(int page, int size, String name) {
        Page<Category> categoryPage = repo.findByNameContainingIgnoreCase(name, PageRequest.of(page, size));
        return new PaginationResponse<CategoryDto>(mapper.toDto(categoryPage.getContent()),categoryPage.getTotalElements());
    }

    public PaginationResponse<CategoryDto> getCategories(int page,int size) {
        size = size == 0 ? Integer.MAX_VALUE:size;
        PageRequest pageRequest = PageRequest.of(
                page, size,Sort.by("id").and(Sort.by("name")));
        Page<Category> categoriesPage = repo.findAll(pageRequest);
        Iterable<CategoryDto> categories = mapper.toDto(categoriesPage.getContent());
        return  new PaginationResponse<CategoryDto>(categories,categoriesPage.getTotalElements());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Optional<Category> category = repo.findById(id);
        if(category.isPresent()) { return mapper.toDto(category.get()); }
        else { throw new CategoryException("Invalid category id"); }
    }

    @Override
    public boolean deleteCategoryById(Long id) throws IOException {
        Optional<Category> optCategory = repo.findById(id);
        boolean isPresent = optCategory.isPresent();
        if(isPresent) {
            Category category = optCategory.get();
            repo.delete(category);
            storageService.deleteImage(category.getImage());
        } return isPresent;
    }

    @Override
    public boolean updateCategory(CategoryCreateDto categoryModel) throws IOException {
        Optional<Category> optCategory = repo.findById(categoryModel.getId());
        boolean isPresent = optCategory.isPresent();
        if(isPresent) {
            Category category = mapper.fromCreationModel(categoryModel);
            category.setImage(optCategory.get().getImage());
            category.setCreationTime(LocalDateTime.now());
            if(categoryModel.getFile()!=null && !categoryModel.getFile().isEmpty() ){
                storageService.deleteImage(optCategory.get().getImage());
                String imageName = storageService.saveImage(categoryModel.getFile(),FileFormats.WEBP);
                category.setImage(imageName);
            } repo.save(category);
        } return isPresent;
    }
}