package com.springboot.application.restful_web_service.welcome;

public class WelcomeName {
    private String name;

    WelcomeName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
