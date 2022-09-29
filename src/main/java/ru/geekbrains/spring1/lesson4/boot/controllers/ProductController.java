package ru.geekbrains.spring1.lesson4.boot.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.services.ProductService;


@RestController
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public Page<Product> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                        @RequestParam(name = "min_price", required = false) Integer minPrice,
                                        @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                        @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1){
            page = 1;
        }
        return productService.find(minPrice, maxPrice, titlePart, page);
    }


    @PostMapping("/products")
    public Product addNewProducts(@RequestBody Product product) {
        return productService.save(product);
    }


    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
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
