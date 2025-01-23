package product.controller;

import product.request.CreateProductRequest;
import product.service.IProductService;
import shared.ResponseDto;
import shared.constants.AppConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductController {

    private static Logger logger = Logger.getLogger(ProductController.class.getName());

    private final IProductService iProductService;

    public ProductController (IProductService iProductService) {
        this.iProductService = iProductService;
    }

    public ResponseDto createProduct (CreateProductRequest request) {
        logger.log(Level.INFO, "Create product controller method hit");
        iProductService.createProduct(request);
        return new ResponseDto(AppConstants.STATUS_201, AppConstants.STATUS_201);
    }
}
