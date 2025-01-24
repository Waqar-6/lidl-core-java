package department.service.impl;

import department.dto.DepartmentDto;
import department.entity.Department;
import department.mapper.DepartmentMapper;
import department.repository.DepartmentRepository;
import department.repository.DepartmentRepositoryImpl;
import department.requests.CreateDepartmentRequest;
import department.service.IDepartmentService;
import shared.exception.ResourceAlreadyExistsException;
import shared.exception.ResourceNotFoundException;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DepartmentServiceImpl implements IDepartmentService {

    private static final Logger logger = Logger.getLogger(DepartmentServiceImpl.class.getName());
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     *
     * @param newDepartmentRequest - CreateDepartmentRequest Object
     */
    @Override
    public void createDepartment(CreateDepartmentRequest newDepartmentRequest) {
        boolean exists = departmentRepository.existsByName(newDepartmentRequest.getName());
        UUID id = UUID.randomUUID();

        if (exists) {
            logger.log(Level.INFO, "ResourceAlreadyExistsException thrown");
            throw new ResourceAlreadyExistsException("Department", "name", newDepartmentRequest.getName());
        }

        try{
            Department newDepartment = new Department(id, newDepartmentRequest.getName(), newDepartmentRequest.getDescription());
            departmentRepository.save(newDepartment);
            logger.log(Level.INFO, "new department with name: " + newDepartment.getName() + " created and saved.");
        } catch (Exception e) {
            logger.log(Level.WARNING, "could not save department exception thrown :" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public DepartmentDto fetchDepartmentByName(String departmentName) {

        Department department = departmentRepository.findByName(departmentName)
                   .orElseThrow(() -> new ResourceNotFoundException("Department", "name", departmentName));

        logger.log(Level.INFO, "Department : " + departmentName + " fetched" );
        return DepartmentMapper.mapToDepartmentDto(department, new DepartmentDto());
    }

    @Override
    public boolean deleteDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "name", departmentName));
        boolean isDeleted =  departmentRepository.deleteDepartment(department);
        logger.log(Level.INFO, "department deleted with the name: " + departmentName + " : " + isDeleted);
        return isDeleted;
    }

}
