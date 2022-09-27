package ru.geekbrains.spring1.lesson4.boot.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1l, "Demon Souls", 10));
        products.add(new Product(2l, "Dark Souls", 10));
        products.add(new Product(3l, "Dark Souls2", 10));
        products.add(new Product(4l, "Dark Souls3", 10));
        products.add(new Product(5l, "Bloodborne", 10));
        products.add(new Product(6l, "Elden Ring", 10));
        products.add(new Product(7l, "Star Craft", 10));
        products.add(new Product(8l, "Sekiro", 10));
        products.add(new Product(9l, "World of Warcraft", 10));
        products.add(new Product(10l, "World of Warcraft: Wrath of the Lich King", 10));
    }


    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id){
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product with id: " + id + " doesnt exist");
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
