package com.bridgelabz.springboot.controller;

import com.bridgelabz.springboot.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // curl localhost:8080/hello/ -w "\n"
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {

        return "Hello From Bridgelabz!!!";
    }

    //curl localhost:8080/hello/query?name=Madhu -w "\n"
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {

        return "Hello " + name + " !";
    }

    //curl localhost:8080/hello/param/Madhu -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {

        return "Hello " + name + " !";
    }

    //curl -x POST -H "Content-Type: application/json"
    //  -d '{"firstName": "Mark","lastName": "Taylor"}'
    //http://localhost:8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    //curl -X PUT localhost:8080/hello/put/Lisa/?lastName=Terrisa -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value= "lastName") String lastName){
        return "Hello "+firstName+" "+lastName+"!";
    }
}