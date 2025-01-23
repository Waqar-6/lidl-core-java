package product.entity;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String category;
    private String department;
    private Integer stockLevel;
    private String location;

    public Product(UUID id, String name, String category,String department, Integer stockLevel, String location) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.department = department;
        this.stockLevel = stockLevel;
        this.location = location;
    }

    public Product(String name, String category,String department, Integer stockLevel, String location) {
        this.name = name;
        this.category = category;
        this.department = department;
        this.stockLevel = stockLevel;
        this.location = location;
    }

    public Product () {}

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
