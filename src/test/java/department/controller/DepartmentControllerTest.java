package department.controller;

import department.repository.DepartmentRepository;
import department.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @Mock
    private DepartmentController departmentController;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    void testCreateDepartment_whenGivenCreateDepartmentRequest_shouldReturnSuccessResponseDto () {
        // Arrange

        // Act

        // Assert
    }
}
