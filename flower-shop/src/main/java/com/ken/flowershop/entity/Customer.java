package com.ken.flowershop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="short_name")
    @Size(min = 1, max = 20, message = "Short Name should be between length 1 and 20.")
    private String shortName;

    @Column(name="full_name")
    @NotNull
    @Size(min = 1, max = 66, message = "Full Name should be between length 1 and 20.")
    private String fullName;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="contact_number")
    @Pattern(regexp = "[+][0-9]{10}", message = "Format for Contact Number is incorrect.")
    @NotNull
    private String contactNumber;

    @Column(name="address")
    @NotNull
    private String address;

    @Column(name="postal_code")
    @Pattern(regexp = "[0-9]{6}", message = "Format for Postal Code is incorrect.")
    @NotNull
    private String postalCode;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Orders> orders;

    public Customer() {}

    public Customer(@NotNull String shortName, @NotNull String fullName, @NotNull String email, @NotNull String contactNumber, @NotNull String address, @NotNull String postalCode) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

