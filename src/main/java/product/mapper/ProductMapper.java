package product.mapper;

import product.dto.ProductDto;
import product.entity.Product;
import product.request.CreateProductRequest;

public final class ProductMapper {

    private ProductMapper () {}


    public static ProductDto mapToProductDto (Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setDepartment(product.getDepartment());
        productDto.setStockLevel(product.getStockLevel());
        productDto.setLocation(product.getLocation());
        return productDto;
    }

    public static Product mapRequestToProduct (Product product, CreateProductRequest request) {
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setDepartment(request.getDepartment());
        product.setStockLevel(request.getStockLevel());
        product.setLocation(request.getLocation());
        return product;
    }
}
