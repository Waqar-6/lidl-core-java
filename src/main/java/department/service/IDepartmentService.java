package department.service;

import department.requests.CreateDepartmentRequest;

public interface IDepartmentService {

    void createDepartment(CreateDepartmentRequest newDepartmentRequest);
}
