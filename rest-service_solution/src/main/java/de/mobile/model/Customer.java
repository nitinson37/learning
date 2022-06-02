package de.mobile.model;

import de.mobile.Category;
import de.mobile.annotations.CustomerNameConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Customer {

    @NotNull
    private Long id;

    @NotEmpty(message = "First Name cannot be empty")
    @CustomerNameConstraint
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty")
    @CustomerNameConstraint
    private String lastName;

    private String companyName;

    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String companyName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
