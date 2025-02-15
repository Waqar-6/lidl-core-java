package input;

import department.controller.DepartmentController;
import department.dto.DepartmentDto;
import department.requests.CreateDepartmentRequest;
import product.controller.ProductController;
import product.dto.ProductDto;
import product.request.CreateProductRequest;
import shared.ResponseDto;

public class ConsoleMenu {
    private final DepartmentController departmentController;
    private final ProductController productController;
    private final String[] options = {
            "1. create department",
            "2. fetch department by name",
            "3. create product",
            "4. fetch product by name",
            "5. delete department by name",
            "6. fetch all departments",
            "7. fetch products by department",
            "0. exit"};
    private boolean running = true;

    public ConsoleMenu(DepartmentController departmentController, ProductController productController) {
        this.departmentController = departmentController;
        this.productController = productController;
    }

    // Department methods
    public void createDepartment() {
        String name = InputHandler.readString("Enter new Department name");
        String description = InputHandler.readString("Enter department description");

        CreateDepartmentRequest request = new CreateDepartmentRequest(name, description);
        ResponseDto res = departmentController.createDepartment(request);
        System.out.println(res.getResponseMsg());
    }

    public void fetchDepartmentByName() {
        String departmentName = InputHandler.readString("Enter department name");
        try {
            DepartmentDto departmentDto = departmentController.fetchDepartmentByName(departmentName);
            System.out.println(departmentDto.toString());
        } catch (Exception e) {
            System.out.println("Error fetching department: " + e.getMessage());
        }
    }

    public void deleteDepartmentByName () {
        String departmentName = InputHandler.readString("Enter department name to delete");
        ResponseDto res = departmentController.deleteDepartmentByName(departmentName);
        System.out.println("msg: " + res.getResponseMsg() + " status: " + res.getResponseStatus());
    }

    public void fetchAllDepartments () {
        System.out.println(departmentController.fetchAllDepartments());;
    }


    // Product Methods
    public void createProduct () {
        String name = InputHandler.readString("Enter product name");
        String category = InputHandler.readString("Enter Category");
        String department = InputHandler.readString("Enter department");
        Integer stockLevel = InputHandler.readInt("Enter stock level");
        String location = InputHandler.readString("Enter location");
        CreateProductRequest createProductRequest = new CreateProductRequest(name, category, department, stockLevel, location);
        ResponseDto res = productController.createProduct(createProductRequest);
        System.out.println(res.getResponseMsg());
    }

    public void fetchProductByName () {
        String name = InputHandler.readString("Enter product Name");
        ProductDto productDto = productController.fetchProductByName(name);
        System.out.println(productDto.toString());
    }

    public void fetchProductsByDepartment () {
        String departmentName = InputHandler.readString("Enter department name");
        System.out.println(productController.fetchProductsByDepartment(departmentName));
    }



    // menu code

    public void displayMenu() {
        System.out.println("\n=== Department Management System ===");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("===============================");
    }

    public void start() {
        while (running) {
            try {
                displayMenu();
                int choice = InputHandler.readInt("Enter your choice");

                switch (choice) {
                    case 1 -> createDepartment();
                    case 2 -> fetchDepartmentByName();
                    case 3 -> createProduct();
                    case 4 -> fetchProductByName();
                    case 5 -> deleteDepartmentByName();
                    case 6 -> fetchAllDepartments();
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting program...");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }
}