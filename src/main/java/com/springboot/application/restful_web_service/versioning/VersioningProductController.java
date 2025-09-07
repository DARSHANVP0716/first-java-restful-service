package com.springboot.application.restful_web_service.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningProductController {
    @GetMapping("/v1/products")
    public ProductsVersionOne firstVersionProducts(){
        return new ProductsVersionOne("Minimum 2 items should be purchased");
    }

    @GetMapping("/v2/products")
    public ProductsVersionTwo secondVersionProducts(){
        return new ProductsVersionTwo("There is no minimum items to be purchased!");
    }

    //Request Param Versioning
    @GetMapping(path = "/persion", params = "version=1")
    public PersonVersionOne personVersionOneMethod(){
        return new PersonVersionOne("John Wick");
    }

    @GetMapping(path = "/persion", params = "version=2")
    public PersionVersionTwo persionVersionTwo(){
        return new PersionVersionTwo(new Name("John", "Wick"));
    }
}
