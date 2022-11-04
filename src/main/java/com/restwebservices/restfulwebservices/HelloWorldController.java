package com.restwebservices.restfulwebservices;

import com.restwebservices.restfulwebservices.HelloWorldBean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.HelloWorld;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController
{
    //GET
    //URI - /hello-world
    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld()
    {
        return "<H1>Hello World!!</H1>";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        //return new HelloWorldBean("Welcome to the Springboot Application!!");
        throw new RuntimeException("Error occured. Contact Springboot support");

    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Welcome to the Springboot Application, %s",name));
    }

}
