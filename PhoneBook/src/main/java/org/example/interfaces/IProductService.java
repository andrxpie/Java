package org.example.interfaces;

import org.example.dtos.ProductDto;
import org.example.models.PaginationResponse;
import org.example.models.ProductCreateDto;
import org.example.models.SearchData;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public interface IProductService {
    Long saveProduct(ProductCreateDto productModel);
    PaginationResponse<ProductDto> getProducts(int page,int size);
    PaginationResponse<ProductDto> searchProducts(SearchData searchData);
    ProductDto getProductById(Long id);
    boolean deleteProductById(Long id) throws IOException;
    boolean updateProduct(ProductCreateDto productModel) throws IOException;
}