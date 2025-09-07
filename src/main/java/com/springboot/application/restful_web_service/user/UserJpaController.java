package com.springboot.application.restful_web_service.user;

import com.springboot.application.restful_web_service.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserJpaController {

    //@Autowired
    private UserServiceDAO userService;  // Field Dependency Injection, we can use any type of injection
    private UserRepository repository;

    //Constructor Injection - Autowired is not necessary
    public UserJpaController(UserServiceDAO userService, UserRepository repository){
        this.userService=userService;
        this.repository=repository;
    }

    //GET /users
    @GetMapping("/jpa/users")
    public List<Users> retrieveALlUsers(){
        return repository.findAll();
    }

    //GET /users/2
    @GetMapping("/jpa/users/{id}")   //mention var names
    public Users retrieveUserById(@PathVariable int id){    //return type Users - we are returning a one user from list not entire list so used Users type as the return item is type of Users
        Users user = repository.findById(id).orElse(null);
        if (user==null){
            throw new UserNotFoundException("id "+id);
         }
        return user ;

    }

    //POST  /users
    @PostMapping("/jpa/users")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user){
        //users can see the location of their created data
        Users createdUser= repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).body(createdUser);   //path id will be replaced by getId from the createdUser object
        //body() - returns the user data in JSON, if we use build instead it returns response with empty body
    }

    @DeleteMapping("/jpa/users/{id}")
    public Users deleteUser(@PathVariable int id){  //get the value from the url for the mentioned variable
        //Users deletedUser = repository.deleteById(id); //deleteById() will return void so we cannot return anything for
        Users deletedUser = repository.findById(id).orElse(null);
        if (deletedUser==null){
            throw new UserNotFoundException("ID -"+id);
        }
        repository.delete(deletedUser);
        return deletedUser;
    }

//    @DeleteMapping("jpa/users/delete/{id}")
//    public void deleteUserById(@PathVariable int id){
//        if(!repository.existsById(id)){
//            throw new UserNotFoundException("ID- "+id);
//        }
//        repository.deleteById(id);
//    }
}
