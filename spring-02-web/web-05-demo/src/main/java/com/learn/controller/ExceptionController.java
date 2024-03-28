package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("RuntimeException")
    public String showException(){
        System.out.println("throw a RuntimeException");
        throw new RuntimeException("it is a RuntimeException");
    }

    @RequestMapping("Illegal")
    public String showIllegalArgumentException(){
        System.out.println("throw a IllegalArgumentException");
        throw new IllegalArgumentException("it is a IllegalArgumentException");
    }

}
