package com.springboot.application.restful_web_service.versioning;

public class PersonVersionOne {
    private String name;

    public PersonVersionOne(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonVersionOne{" +
                "name='" + name + '\'' +
                '}';
    }
}
