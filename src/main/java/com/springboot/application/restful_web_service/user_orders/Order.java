package com.springboot.application.restful_web_service.user_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.application.restful_web_service.user.Users;
import jakarta.persistence.*;

@Entity(name ="orders")
public class Order {

    @Id
    @GeneratedValue
    int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Users user;   // many orders can be placed by one user

    String orderName;

    public Order(int orderId, Users user, String orderName) {
        this.orderId = orderId;
        this.user = user;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
