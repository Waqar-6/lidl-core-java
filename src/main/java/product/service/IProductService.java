package product.service;

import product.request.CreateProductRequest;

public interface IProductService {

    /**
     *
     * @param request - CreateProductRequest Object
     */
    void createProduct (CreateProductRequest request);
}
