package com.abhinav.nimap.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abhinav.nimap.Dto.ProductDto;
import com.abhinav.nimap.Entity.Product;
import com.abhinav.nimap.Repository.ProductRepo;
import com.abhinav.nimap.Services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
        Product product = this.modelMapper.map(productDto, Product.class);
		
		Product savedProduct = this.productRepo.save(product);
		
		return this.modelMapper.map(savedProduct,ProductDto.class);
	}

	

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId) {

		Product product = this.productRepo.findById(productId).orElseThrow();
		product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());        
        Product updatedProduct = this.productRepo.save(product);
          return this.modelMapper.map(updatedProduct,ProductDto.class);        
	}
	  

	@Override
	public ProductDto getProductById(Integer productId) {

		   Product product = this.productRepo.findById(productId).orElseThrow();
			return this.modelMapper.map(product,ProductDto.class);

	}

	@Override
       public List<ProductDto> getAllProduct(Integer pageNumber,Integer pageSize) {

		//int PageSize=5;
		//int pageNumber=1;

		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<Product> pageProduct =  this.productRepo.findAll(p);
		List<Product> products = pageProduct.getContent();
		
		List<ProductDto> productDtos = products.stream().map(product ->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
		
		
		return productDtos;
	}
	
	@Override
	public void deleteProduct(Integer productId) {


		Product product =	this.productRepo.findById(productId).orElseThrow();
		this.productRepo.delete(product);
		
		
	}

}
