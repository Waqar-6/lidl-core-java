package product.service.impl;

import department.entity.Department;
import department.repository.DepartmentRepository;
import product.dto.ProductDto;
import product.entity.Product;
import product.mapper.ProductMapper;
import product.repository.ProductRepository;
import product.repository.ProductRepositoryImpl;
import product.request.CreateProductRequest;
import product.service.IProductService;
import shared.exception.ResourceAlreadyExistsException;
import shared.exception.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductServiceImpl implements IProductService {

    private final static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());

    private final ProductRepository productRepository;
    private final DepartmentRepository departmentRepository;

    public ProductServiceImpl(ProductRepository productRepository, DepartmentRepository departmentRepository) {
        this.productRepository = productRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createProduct(CreateProductRequest request) {

        boolean alreadyExists = productRepository.existsByName(request.getName());

        if (alreadyExists) {
            logger.log(Level.WARNING, "ResourceAlreadyExistsException thrown while creating product with name " + request.getName());
            throw new ResourceAlreadyExistsException("Product", "name", request.getName());
        }

        Department department = departmentRepository
                .findByName(request.getDepartment()).orElseThrow(() -> new ResourceNotFoundException("Department", "name", request.getDepartment()));


        UUID id = UUID.randomUUID();
       Product product =  ProductMapper.mapRequestToProduct(new Product(), request);
       product.setId(id);
       productRepository.save(product);
       logger.log(Level.INFO, "new Product created and saved with the name " + product.getName());
    }

    @Override
    public ProductDto fetchProductByName(String name) {
        Product product = productRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Product", "name", name));
        logger.log(Level.INFO, "product: " + name + " fetched");
        return ProductMapper.mapToProductDto(product, new ProductDto());
    }

    @Override
    public List<ProductDto> fetchProductsByDepartment(String departmentName) {
        List<Product> products = productRepository.findByDepartment(departmentName);
        logger.log(Level.INFO, "all of " + departmentName + " products fetched");
        return products.stream()
                .map(product -> ProductMapper.mapToProductDto(product, new ProductDto()))
                .toList();
    }
}
