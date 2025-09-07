package com.springboot.application.restful_web_service.jpa;

import com.springboot.application.restful_web_service.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
