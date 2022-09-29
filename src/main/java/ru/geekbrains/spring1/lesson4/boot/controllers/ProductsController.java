package ru.geekbrains.spring1.lesson4.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.boot.dto.ProductDto;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.services.ProductsService;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;


    @GetMapping
    public Page<ProductDto> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                           @RequestParam(name = "min_price", required = false) Integer minPrice,
                                           @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                           @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }

        return productsService.findAll(minPrice, maxPrice, titlePart, page).map(p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice()));
    }


    @PostMapping
    public Product addNewProducts(@RequestBody Product product) {
        return productsService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productsService.save(product);
    }


    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }


}
