package com.springboot.application.restful_web_service.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    //@Autowired
    private UserServiceDAO userService;  // Field Dependency Injection, we can use any type of injection

    //Constructor Injection - Autowired is not necessary
    public UserController(UserServiceDAO userService){
        this.userService=userService;
    }

    //GET /users
    @GetMapping("/users")
    public List<Users> retrieveALlUsers(){
        return userService.findAll();
    }

    //GET /users/2
    @GetMapping("/users/{id}")   //mention var name
    public Users retrieveUserById(@PathVariable int id){    //return type Users - we are returning a one user from list not entire list so used Users type as the return item is type of Users
        Users user = userService.returnUserById(id);
        if (user==null){
            throw new UserNotFoundException("id "+id);
         }
        return user ;
    }

    //POST  /users
    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user){
        //users can see the location of their created data
        Users createdUser= userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).body(createdUser);   //path id will be replaced by getId from the createdUser object
        //body() - returns the user data in JSON, if we use build instead it returns response with empty body
    }

    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable int id){  //get the value from the url for the mentioned variable
        Users deletedUser = userService.deleteUserById(id);
        if (deletedUser==null){
            throw new UserNotFoundException("ID -"+id);
        }
        return deletedUser;

    }
}
