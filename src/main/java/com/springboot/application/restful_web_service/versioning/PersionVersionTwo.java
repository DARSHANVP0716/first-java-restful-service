package com.springboot.application.restful_web_service.versioning;

public class PersionVersionTwo {
    private Name name;

    public PersionVersionTwo(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
