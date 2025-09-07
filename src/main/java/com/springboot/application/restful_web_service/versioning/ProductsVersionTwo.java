package com.springboot.application.restful_web_service.versioning;

public class ProductsVersionTwo {
    private String orderCriteria;

    public ProductsVersionTwo(String orderCriteria) {
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
        return "ProductsVersionTwo{" +
                "orderCriteria='" + orderCriteria + '\'' +
                '}';
    }
}
