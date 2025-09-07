package com.springboot.application.restful_web_service.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.application.restful_web_service.user_orders.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "users")
//POJO which is a container holds data - User bean
public class Users {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, message = "Atleast 3 characters needed")
    @JsonProperty("User_Name")   
    @Column(name ="full_name")
    private String name;

    @Past(message = "give valid DOB")
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")  //it specifies the field in the Order class that owns the relationship
    @JsonIgnore
    List<Order> list;

    public Users(int id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
