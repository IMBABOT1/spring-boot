package ru.geekbrains.spring1.lesson4.boot.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long productId, Integer delta) {
        Product p = productRepository.findProductById(productId);
        p.setPrice(p.getPrice() + delta);
    }
}
