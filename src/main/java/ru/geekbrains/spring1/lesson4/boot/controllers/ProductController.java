package ru.geekbrains.spring1.lesson4.boot.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.boot.dto.ProductDto;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.services.ProductService;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public Page<ProductDto> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                           @RequestParam(name = "min_price", required = false) Integer minPrice,
                                           @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                           @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1){
            page = 1;
        }

        return productService.find(minPrice, maxPrice, titlePart, page).map(p -> new ProductDto(p));
    }


    @PostMapping
    public ProductDto addNewProducts(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice(),"secretKey");
        product.setId(null);
        productService.save(product);
        return productDto;
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice(),"secretKey");
        productService.save(product);
        return productDto;
    }


    @GetMapping("/{id}")
    public ProductDto getProductByID(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return new ProductDto(p);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/change_price")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }

}
