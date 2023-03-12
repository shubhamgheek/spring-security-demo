package com.shubham.SpringSecurityDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

//    @GetMapping("/get/foo")
//    public String getFoo(){
//        return "Hello Foo";
//    }
//
//    @GetMapping("/get/bar")
//    public String getBar(){
//        return "Hello Bar";
//    }

    // This API requires Authentication and Authorization as well.
    @GetMapping("/student/get")
    public String getStudent(){
        return "Hello Student";
    }

    // This API requires Authentication and Authorization as well.
    @GetMapping("/admin/get")
    public String getAdmin(){
        return "Hello Admin";
    }

    // This API doesn't require Authentication and Authorization.
    @GetMapping("/visitor/get")
    public String getVisitor(){
        return "Hello Visitor";
    }
}
