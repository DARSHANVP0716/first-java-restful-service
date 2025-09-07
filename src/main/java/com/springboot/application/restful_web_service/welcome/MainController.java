package com.springboot.application.restful_web_service.welcome;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MainController {

    private MessageSource messageSource;

    public MainController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @GetMapping(path = "/home")  //since return type is string, so it returns response body in string format - when spring sees RestController method return type as string
    public String homePage(){
        return "This is Home page!"; }

    @GetMapping(path="/welcome")
    public WelcomeName welcomeName(){
        return new WelcomeName("Darshan");
    }

    @GetMapping(path="/welcome/{name}")   //
    public WelcomeName welcomePathParameter(@PathVariable String name){
        return new WelcomeName("Hi Mr. "+name);
    }

    @GetMapping(path="/welcome-internationlization")
    public String welcomeNameGreeting(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "default Message",locale) ;
    }
}
