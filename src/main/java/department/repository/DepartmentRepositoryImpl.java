package department.repository;

import department.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentRepositoryImpl implements DepartmentRepository{
    private List<Department> departmentDb;

    public DepartmentRepositoryImpl () {
        this.departmentDb = new ArrayList<>();
    }

    public List<Department> getDepartmentDb() {
        return departmentDb;
    }

    public void setDepartmentDb(List<Department> departmentDb) {
        this.departmentDb = departmentDb;
    }

    @Override
    public Department save(Department department) {
        this.departmentDb.add(department);
        return department;
    }

    @Override
    public boolean existsByName(String name) {
        for (Department dep : this.departmentDb) {
            if (dep.getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public Optional<Department> findByName(String name) {
        return this.departmentDb.stream().filter(dep -> dep.getName().equals(name)).findFirst();
    }

    @Override
    public boolean deleteDepartment(Department department) {
        this.departmentDb.remove(department);
        return false;
    }
}
