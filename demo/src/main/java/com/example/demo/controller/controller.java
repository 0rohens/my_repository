package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller{
    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(){
        return "hello world";

    }
}