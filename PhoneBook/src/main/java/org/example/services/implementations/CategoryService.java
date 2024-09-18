package org.example.services.implementations;

import org.example.DTOs.CategoryDto;
import org.example.DTOs.CategoryResponse;
import org.example.entities.Category;
import org.example.mappers.CategoryMapper;
import org.example.DTOs.CategoryCreateDto;
import org.example.repositories.CategoryRepository;
import org.example.services.ICategoryService;
import org.example.DTOs.FileFormats;
import org.example.storage.implementations.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository repo;
    @Autowired
    private StorageService storageService;
    @Autowired
    private CategoryMapper mapper;

    @Override
    public Integer saveCategory(CategoryCreateDto model) {
        try {
            Category category = mapper.fromCategoryCreateDto(model);
            String imageName = storageService.saveImage(model.getFile(), FileFormats.WEBP);
            category.setImage(imageName);
            category.setCreationTime(LocalDateTime.now());
            Category savedCategory = repo.save(category);
            return savedCategory.getId();
        } catch (Exception e) { return null; }
    }

    @Override
    public CategoryResponse getCategoryByName(int page, int size, String name) {
        Page<Category> categoryPage = repo.findByNameContainingIgnoreCase(name, PageRequest.of(page, size));
        return new CategoryResponse(mapper.toDto(categoryPage.getContent()), categoryPage.getTotalElements());
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        Optional<Category> category = repo.findById(id);
        if(category.isPresent()) {
            return mapper.toDto(category.get());
        } else { return null; }
    }

    @Override
    public boolean deleteCategoryById(Integer id) throws IOException {
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
        if(isPresent){
            Category category = mapper.fromCategoryCreateDto(categoryModel);
            category.setImage(optCategory.get().getImage());
            category.setCreationTime(LocalDateTime.now());
            if(categoryModel.getFile()!= null && !categoryModel.getFile().isEmpty()) {
                storageService.deleteImage(optCategory.get().getImage());
                String imageName = storageService.saveImage(categoryModel.getFile(), FileFormats.WEBP);
                category.setImage(imageName);
            } repo.save(category);
        } return isPresent;
    }
}