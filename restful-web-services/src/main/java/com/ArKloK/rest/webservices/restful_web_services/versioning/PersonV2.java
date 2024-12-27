package com.ArKloK.rest.webservices.restful_web_services.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2() {
    }

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }

}