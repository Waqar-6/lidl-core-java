package department.controller;

import department.dto.DepartmentDto;
import department.requests.CreateDepartmentRequest;
import department.service.IDepartmentService;
import shared.ResponseDto;
import shared.constants.AppConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartmentController {

    private static final Logger logger = Logger.getLogger(DepartmentController.class.getName());

    private final IDepartmentService iDepartmentService;

    public DepartmentController(IDepartmentService iDepartmentService) {

        this.iDepartmentService = iDepartmentService;
    }

    public ResponseDto createDepartment (CreateDepartmentRequest request) {
        logger.log(Level.INFO, "department controller create department hit");
        iDepartmentService.createDepartment(request);
        return new ResponseDto(AppConstants.MESSAGE_201, AppConstants.STATUS_201);
    }

    public DepartmentDto fetchDepartmentByName (String departmentName) {
        logger.log(Level.INFO, "department controller fetchDepartmentByName hit");
        return iDepartmentService.fetchDepartmentByName(departmentName);
    }
}
