package ru.geekbrains.spring1.lesson4.boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.repositories.ProductRepository;
import ru.geekbrains.spring1.lesson4.boot.repositories.specifications.ProductsSpecifications;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer minPrice, Integer maxPrice, String partTitle, Integer page){
        Specification<Product> spec = Specification.where(null);

        if (minPrice != null){
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null){
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }
        if (partTitle != null){
            spec = spec.and(ProductsSpecifications.titleLike(partTitle));
        }

        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));

    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void changePrice(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to change product's price. Product not found, id: " + productId));
        product.setPrice(product.getPrice() + delta);
    }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
