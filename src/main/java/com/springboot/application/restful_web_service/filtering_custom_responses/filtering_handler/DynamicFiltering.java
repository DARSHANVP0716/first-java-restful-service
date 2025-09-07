package com.springboot.application.restful_web_service.filtering_custom_responses.filtering_handler;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
public class DynamicFiltering {

    public MappingJacksonValue filter(Object usersData, String fiterId, String field1, String field2){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(usersData);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(field1,field2);
        FilterProvider filters = new SimpleFilterProvider().addFilter(fiterId, filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
