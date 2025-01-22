package department.mapper;

import department.dto.DepartmentDto;
import department.entity.Department;

public final class DepartmentMapper {

    private DepartmentMapper () {}

    public static DepartmentDto mapToDepartmentDto (Department department, DepartmentDto departmentDto) {
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        return departmentDto;
    }

    public static Department mapToDepartment (DepartmentDto departmentDto, Department department) {
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return department;
    }


}
