package department.service;

import department.dto.DepartmentDto;
import department.requests.CreateDepartmentRequest;

import java.util.List;

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


    /**
     *
     * @param departmentName - String
     * @return - True or False based on deletion
     */
    boolean deleteDepartmentByName (String departmentName);

    /**
     *
     * @return - List of DepartmentDto Objects
     */
    List<DepartmentDto> fetchAllDepartments ();

}
