package com.example.product_management_backend.service;

import com.example.product_management_backend.entity.Product;
import com.example.product_management_backend.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> getAllproduct() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productDao.findById(id).get();
    }

    @Override
    public void deleteProduct(Integer id) {
       Product product = productDao.findById(id).get();

       if(product!=null){
           productDao.delete(product);
           System.out.println("Product delete successfully");
       }
        System.out.println("something wrong on server");
    }

    @Override
    public Product editProduct(Product product,Integer id) {
        Product oldProduct = productDao.findById(id).get();
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStatus(product.getStatus());

        return productDao.save(oldProduct);
    }
}
