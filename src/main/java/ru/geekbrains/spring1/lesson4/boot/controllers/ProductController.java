package ru.geekbrains.spring1.lesson4.boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_price")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }
}
