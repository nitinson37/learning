package de.mobile.model;

import de.mobile.Category;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Ad {

    @NotNull
    private Long id;

    @NotEmpty
    private String make;

    @NotEmpty
    private String model;

    private String description;

    private Category category;

    @Valid
    private Customer customer;

    private BigDecimal price;

    public Ad() {
    }

    public Ad(Long id, String make, String model, String description, Category category, Customer customer, BigDecimal price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.description = description;
        this.category = category;
        this.customer = customer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
