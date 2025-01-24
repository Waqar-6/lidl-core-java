package product.repository;

import product.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> productDb;

    public ProductRepositoryImpl () {
        this.productDb = new ArrayList<>();
    }

    @Override
    public Product save(Product product) {
        this.productDb.add(product);
        return product;
    }

    @Override
    public boolean existsByName(String productName) {
        for (Product product : this.productDb) {
            if (product.getName().equals(productName)) return true;
        }
        return false;
    }

    @Override
    public Optional<Product> findByName(String productName) {
        return this.productDb.stream().filter(product1 -> product1.getName().equals(productName)).findFirst();
    }

    @Override
    public List<Product> findByDepartment(String departmentName) {
        return this.productDb.stream()
                .filter(product -> product.getDepartment().equals(departmentName)).toList();
    }


}
