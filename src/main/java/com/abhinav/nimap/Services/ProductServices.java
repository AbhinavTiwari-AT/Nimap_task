package com.abhinav.nimap.Services;

import java.util.List;

import com.abhinav.nimap.Dto.ProductDto;


public interface ProductServices {
	

    ProductDto createProduct(ProductDto productDto);
  
  ProductDto updateProduct(ProductDto productDto,Integer productId);
  
  ProductDto getProductById(Integer productId);
  
 List<ProductDto> getAllProduct(Integer pageNumber,Integer pageSize);
 
 void deleteProduct(Integer productId);    
	

}
