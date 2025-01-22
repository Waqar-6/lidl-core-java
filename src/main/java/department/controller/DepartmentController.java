package department.controller;

import department.requests.CreateDepartmentRequest;
import department.service.IDepartmentService;
import department.service.impl.DepartmentServiceImpl;
import shared.ResponseDto;
import shared.constants.AppConstants;

public class DepartmentController {

    private final IDepartmentService iDepartmentService;

    public DepartmentController(IDepartmentService iDepartmentService) {
        this.iDepartmentService = iDepartmentService;
    }

    public ResponseDto createDepartment (CreateDepartmentRequest request) {
        iDepartmentService.createDepartment(request);
        return new ResponseDto(AppConstants.MESSAGE_201, AppConstants.STATUS_201);
    }
}
