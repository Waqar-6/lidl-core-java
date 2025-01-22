import department.controller.DepartmentController;
import department.repository.DepartmentRepositoryImpl;
import department.service.impl.DepartmentServiceImpl;
import input.ConsoleMenu;

public class Main {
    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu(new DepartmentController(new DepartmentServiceImpl(new DepartmentRepositoryImpl())));

        menu.start();
    }
}
