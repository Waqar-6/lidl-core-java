package department.service;

import department.dto.DepartmentDto;
import department.requests.CreateDepartmentRequest;

public interface IDepartmentService {

    /**
     *
     * @param newDepartmentRequest - CreateDepartmentRequest Object
     */
    void createDepartment(CreateDepartmentRequest newDepartmentRequest);

    /**
     *
     * @param departmentName - String
     * @return - DepartmentDto Object
     */
    DepartmentDto fetchDepartmentByName (String departmentName);


}
