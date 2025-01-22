package department.entity;

import java.util.UUID;

public class Department {
    private UUID id;
    private String name;
    private String description;

    public Department(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Department (String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Department () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
