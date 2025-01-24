package department.repository;

import department.entity.Department;

import java.util.Optional;

public interface DepartmentRepository {
    Department save (Department department);

    boolean existsByName (String name);

    Optional<Department> findByName (String name);


    boolean deleteDepartment (Department department);
}
