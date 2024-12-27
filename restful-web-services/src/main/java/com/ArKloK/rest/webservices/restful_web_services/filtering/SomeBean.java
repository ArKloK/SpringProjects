package com.ArKloK.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value = { "field1", "field2" })
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;

    public SomeBean(String string, String string2, String string3) {
        this.field1 = string;
        this.field2 = string2;
        this.field3 = string3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }

}
