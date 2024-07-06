package com.kdaito.jwt_practice.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping("/hello")
    fun get(): String {
        return "Hello world"
    }
}