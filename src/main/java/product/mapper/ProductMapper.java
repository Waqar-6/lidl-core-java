package product.mapper;

import product.entity.Product;
import product.request.CreateProductRequest;

public final class ProductMapper {

    private ProductMapper () {}

    public static Product mapRequestToProduct (Product product, CreateProductRequest request) {
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setDepartment(request.getDepartment());
        product.setStockLevel(request.getStockLevel());
        product.setLocation(request.getLocation());
        return product;
    }
}
