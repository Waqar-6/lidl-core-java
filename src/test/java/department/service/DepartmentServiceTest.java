package department.service;

import department.entity.Department;
import department.repository.DepartmentRepository;
import department.requests.CreateDepartmentRequest;
import department.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @InjectMocks
    DepartmentServiceImpl departmentService;
    @Mock
    DepartmentRepository departmentRepository;

    @Test
    void testCreateDepartment_whenDepartmentDetailsProvided_shouldReturnSuccessResponse () {
        // Arrange
        CreateDepartmentRequest departmentRequest = new CreateDepartmentRequest("Fruit & Veg", "department for fruit and veg");
        when(departmentRepository.save(any(Department.class))).thenReturn(new Department(departmentRequest.getName(), departmentRequest.getDescription()));
        // Act
        departmentService.createDepartment(departmentRequest);

        // Assert
    }
}
