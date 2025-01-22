package department.requests;

import java.util.UUID;

public class CreateDepartmentRequest {

    private String name;
    private String description;

    public CreateDepartmentRequest (String name, String description) {

        this.name = name;
        this.description = description;
    }

    public CreateDepartmentRequest () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
