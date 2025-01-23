package product.repository;

import product.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save (Product product);

    boolean existsByName (String productName);

    Optional<Product> findByName (String productName);
}
