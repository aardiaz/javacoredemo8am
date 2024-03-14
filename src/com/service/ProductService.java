package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {

	void addProduct(Product pd);

	void deleteProduct(int index);

	List<Product> getAllProducts();
}
