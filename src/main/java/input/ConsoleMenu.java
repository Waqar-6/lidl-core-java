package input;

import department.controller.DepartmentController;
import department.entity.Department;
import department.requests.CreateDepartmentRequest;
import shared.ResponseDto;

public class ConsoleMenu {

    private final DepartmentController departmentController;

    public ConsoleMenu(DepartmentController departmentController) {
        this.departmentController = departmentController;
    }

    public void createDepartment () {
        String name = InputHandler.readString("Enter new Department name: ");
        String description = InputHandler.readString("Enter department description: ");
        CreateDepartmentRequest request = new CreateDepartmentRequest(name, description);
        ResponseDto res = departmentController.createDepartment(request);
        System.out.println(res.getResponseMsg());
    }

    String[] options = {"1. create department"};

    public void displayMenu () {
        for (String option : options) System.out.println(option);
    }

    boolean running = true;

    public void start () {

        while (running) {
            displayMenu();
            int choice = InputHandler.readInt("Enter your choice: ");

            try{
                switch (choice) {
                    case 1 -> createDepartment();
                    case 0 -> running = false;
                }

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
