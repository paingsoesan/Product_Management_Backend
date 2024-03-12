package com.example.product_management_backend.controller;

import com.example.product_management_backend.entity.Product;
import com.example.product_management_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllproduct(),HttpStatus.OK);
    }

    @GetMapping("/getAllProduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public  ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        productService.deleteProduct(id);
        System.out.println("Deleted successfully");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/editProduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id){
        return new ResponseEntity<>(productService.editProduct(product,id),HttpStatus.CREATED);
    }

}
