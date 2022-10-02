package ru.geekbrains.spring1.lesson4.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.boot.cart.Cart;
import ru.geekbrains.spring1.lesson4.boot.converters.ProductConverter;
import ru.geekbrains.spring1.lesson4.boot.dto.ProductDto;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.services.ProductsService;
import ru.geekbrains.spring1.lesson4.boot.validators.ProductValidator;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    private final Cart cart;


    @GetMapping
    public Page<ProductDto> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                           @RequestParam(name = "min_price", required = false) Integer minPrice,
                                           @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                           @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }

        return productsService.findAll(minPrice, maxPrice, titlePart, page).map(
                p -> productConverter.entityToDto(p));
    }

    @GetMapping("/{id}")
    public ProductDto getProductByID(@PathVariable Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @GetMapping("/add/{id}")
    public void deleteById(@PathVariable Long id) {
        cart.add(id);
        System.out.println(cart);
    }


    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productsService.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productsService.update(productDto);
        return productConverter.entityToDto(product);
    }

}
