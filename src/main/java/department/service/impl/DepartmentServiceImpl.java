package department.service.impl;

import department.entity.Department;
import department.repository.DepartmentRepository;
import department.repository.DepartmentRepositoryImpl;
import department.requests.CreateDepartmentRequest;
import department.service.IDepartmentService;
import shared.exception.ResourceAlreadyExistsException;

import java.util.UUID;
import java.util.logging.Logger;


public class DepartmentServiceImpl implements IDepartmentService {

    private static final Logger log = Logger.getLogger(DepartmentServiceImpl.class.getName());
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createDepartment(CreateDepartmentRequest newDepartmentRequest) {
        boolean exists = departmentRepository.existsByName(newDepartmentRequest.getName());
        UUID id = UUID.randomUUID();

        if (exists) {
            log.info("ResourceAlreadyExistsException thrown");
            throw new ResourceAlreadyExistsException("Department", "name", newDepartmentRequest.getName());
        }

        try{
            Department newDepartment = new Department(id, newDepartmentRequest.getName(), newDepartmentRequest.getDescription());
            departmentRepository.save(newDepartment);
            log.info("new department with name: " + newDepartment.getName() + " created and saved.");
        } catch (Exception e) {
            log.warning("could not save department exception thrown : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
