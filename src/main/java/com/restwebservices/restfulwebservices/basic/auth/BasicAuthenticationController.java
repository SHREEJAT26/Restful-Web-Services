package com.restwebservices.restfulwebservices.basic.auth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController
{

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean()
    {
        //throw new RuntimeException("Error occured. Contact Springboot support");
        return new AuthenticationBean("You are Authenticated!!");

    }

}
