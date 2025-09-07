package com.springboot.application.restful_web_service.filtering_custom_responses;

import com.springboot.application.restful_web_service.filtering_custom_responses.filtering_handler.DynamicFiltering;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    DynamicFiltering dynamicFiltering;

    public FilteringController(DynamicFiltering dynamicFiltering) {
        this.dynamicFiltering = dynamicFiltering;
    }

    //Static Filtering
    @GetMapping("/filtering-users")
    public UsersData usersDataFiltering(){
        return new UsersData("John Wick","Google", 40);
    }

    @GetMapping("/filtering-users-list")
    public List<UsersData> usersDataFilteringList(){
        return List.of(new UsersData("Cillian Murphy", "Amazon", 50),
                new UsersData("Will Smith", "Adobe", 60));
    }

    //Dynamic Filtering
    @GetMapping("/users-DynamicFiltering")
    public MappingJacksonValue usersDataDynamicFiltering(){
        UsersData usersData = new UsersData("Robert Downey", "Microsoft", 50);
        return dynamicFiltering.filter(usersData, "listFilter","name","company");

//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(usersData);  //it will also do serialize the object
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
//        mappingJacksonValue.setFilters(filters);
//        return mappingJacksonValue;
    }


    @GetMapping("/users-dynamicfiltering-list")
    public MappingJacksonValue userDataDynamicFilteringList(){
        List<UsersData> list = List.of(new UsersData("Leonardo Dicaprio", "SpaceX", 45),
                new UsersData("Jony Depp", "OpenAI", 50)
        );          //total two objects
        return dynamicFiltering.filter(list, "someBeanFilter", "name", "company");
    }
}
