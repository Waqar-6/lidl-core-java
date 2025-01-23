package input;

import department.controller.DepartmentController;
import department.dto.DepartmentDto;
import department.requests.CreateDepartmentRequest;
import input.InputHandler;
import product.controller.ProductController;
import product.request.CreateProductRequest;
import shared.ResponseDto;

public class ConsoleMenu {
    private final DepartmentController departmentController;
    private final ProductController productController;
    private final String[] options = {"1. create department", "2. fetch department by name", "3. create product", "0. exit"};
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