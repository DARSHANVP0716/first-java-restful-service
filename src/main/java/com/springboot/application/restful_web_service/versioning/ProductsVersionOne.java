package com.springboot.application.restful_web_service.versioning;

public class ProductsVersionOne {
    private String orderCriteria;

    public ProductsVersionOne(String orderCriteria) {
        this.orderCriteria = orderCriteria;
    }

    public String getOrderCriteria() {
        return orderCriteria;
    }

    public void setOrderCriteria(String orderCriteria) {
        this.orderCriteria = orderCriteria;
    }

    @Override
    public String toString() {
        return "ProductsVersionOne{" +
                "orderCriteria='" + orderCriteria + '\'' +
                '}';
    }
}
