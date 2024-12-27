package com.ArKloK.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new SomeBean("value1", "value2", "value3"));

        applyJsonFilters(mappingJacksonValue, new String[] { "field1", "field2" });

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {

        List<SomeBean> beanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beanList);

        applyJsonFilters(mappingJacksonValue, new String[] { "field2", "field3" });
        
        return mappingJacksonValue;
    }

    private void applyJsonFilters(MappingJacksonValue mappingJacksonValue, String[] fields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
    }
}
