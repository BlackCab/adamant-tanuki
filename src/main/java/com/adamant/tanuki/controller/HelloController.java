package com.adamant.tanuki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by igor on 11.09.2015.
 */
@Controller
@RequestMapping("/")
public class HelloController {

    public String hello() {
        return "hello";
    }
}
