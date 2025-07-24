package com.springboot.application.restful_web_service.user;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller   //Service class is a service layer responsible for business logic performing operations on resources - communicates with Controller and Repository classes
public class UserServiceDAO {
    private static int userIdIncrement;
    private static List<Users> users = new ArrayList<>();
    static {
        //Users objects are being added into users list
        users.add(new Users(++userIdIncrement, "Darshan Patil", LocalDate.now().minusYears(24)));  //instead of creating object separately and passing over list this would be the better approach
        Users user2 = new Users(++userIdIncrement, "Elon Musk", LocalDate.now().minusYears(50));   //this is also fine
        users.add(user2);
        users.add(new Users(++userIdIncrement, "Warren Buffet", LocalDate.now().minusYears(95)));
        users.add(new Users(++userIdIncrement, "Charlie Munger", LocalDate.now().minusYears(90)));
    }

    public List<Users> findAll(){    //List<Users> return type - returning entire list
        return users;
    }

    public Users returnUserById(int id){      //List<Users> return type is wrong here as we are returning only one user in a list not collection of list
        for(Users user: users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public Users save(Users user){
        user.setId(++userIdIncrement);  //this set the id into "user" object using setId() method of Users class
        users.add(user);   //the POST user data is added into the list and now the data will be stored into the list
        return user;
    }

    public Users deleteUserById(int id){
        for (Users user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return user;
            }
        }
       return null;
    }

}
