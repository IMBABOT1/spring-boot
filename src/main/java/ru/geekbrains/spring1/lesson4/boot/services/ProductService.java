package ru.geekbrains.spring1.lesson4.boot.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.repositories.InMemProductRepository;
import ru.geekbrains.spring1.lesson4.boot.repositories.ProductDao;
import ru.geekbrains.spring1.lesson4.boot.repositories.SqlProductImpl;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    public ProductService(SqlProductImpl sqlProduct) {
        this.productDao = sqlProduct;
    }


    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findProductById(Long id) {
        return productDao.findById(id);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void changePrice(Long productId, Integer delta) {
        Product p = productDao.findById(productId);
        p.setPrice(p.getPrice() + delta);
    }
}
