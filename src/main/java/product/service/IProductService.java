package product.service;

import product.dto.ProductDto;
import product.request.CreateProductRequest;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param request - CreateProductRequest Object
     */
    void createProduct (CreateProductRequest request);

    /**
     *
     * @param name - String
     * @return - ProductDto Object
     */
    ProductDto fetchProductByName (String name);

    /**
     *
     * @param departmentName - String
     * @return - list of ProductDto Objects based on department
     */
    List<ProductDto> fetchProductsByDepartment (String departmentName);
}
