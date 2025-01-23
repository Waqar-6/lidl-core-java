import department.controller.DepartmentController;
import department.repository.DepartmentRepositoryImpl;
import department.service.impl.DepartmentServiceImpl;
import input.ConsoleMenu;
import product.controller.ProductController;
import product.repository.ProductRepositoryImpl;
import product.service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu(new DepartmentController(new DepartmentServiceImpl(new DepartmentRepositoryImpl())), new ProductController(new ProductServiceImpl(new ProductRepositoryImpl(), new DepartmentRepositoryImpl())));

        menu.start();
    }
}
