package com.springboot.application.restful_web_service.filtering_custom_responses;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonFilter("listFilter")
@JsonFilter("someBeanFilter")
//@JsonIgnoreProperties({"age","company"})   //static filtering
public class UsersData {

    // @JsonIgnore (static filtering)
    private String name ;
    private String company;
    private int age;

    public UsersData(String name, String company, int age) {
        this.name = name;
        this.company = company;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
