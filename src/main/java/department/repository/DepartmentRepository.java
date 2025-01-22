package department.repository;

import department.entity.Department;

public interface DepartmentRepository {
    Department save (Department department);

    boolean existsByName (String name);
}
