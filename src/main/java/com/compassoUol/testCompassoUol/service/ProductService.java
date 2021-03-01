package com.compassoUol.testCompassoUol.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.compassoUol.testCompassoUol.models.Product;
import com.compassoUol.testCompassoUol.models.dto.ProductDTO;
import com.compassoUol.testCompassoUol.repositories.ProductRepository;
import com.compassoUol.testCompassoUol.repositories.specifications.ProductSpecification;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(String id) throws NotFoundException {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new NotFoundException());
	}
	
	public List<Product> getProductByFilter(String q, BigDecimal min_price, BigDecimal max_price) {
		List<Product> product = productRepository.findAll(Specification.where(ProductSpecification.Productfilter(q, min_price, max_price)));
		return product;
	}

	public void deleteProduct(String id) throws NotFoundException {
		Product product = getProductById(id);
		productRepository.delete(product);
	}

	public Product changeProduct(String id, @Valid ProductDTO productDTO) throws NotFoundException {
		Product product = getProductById(id);
		updateProduct(product, productDTO);
		return createProduct(product);
	}
	
	private void updateProduct(Product product, ProductDTO productDTO) {
		product.setName(productDTO.getName());
		product.setDescription(product.getDescription());
		product.setPrice(productDTO.getPrice());
	}
}
