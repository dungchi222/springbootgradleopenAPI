package com.samsung.sds.emarket.marketing.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @GetMapping("/apitest")
    public String apitest() {
        return "apifunctest";
    }



}
