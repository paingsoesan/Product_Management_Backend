package com.example.product_management_backend.service;

import com.example.product_management_backend.entity.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllproduct();

    public Product getProductById(Integer id);

    public void deleteProduct(Integer id);

    public Product editProduct(Product product,Integer id);

}
