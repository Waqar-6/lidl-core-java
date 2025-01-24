package product.service;

import product.dto.ProductDto;
import product.request.CreateProductRequest;

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
}
