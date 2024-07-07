package com.kdaito.jwt_practice.controller

import com.kdaito.jwt_practice.dao.GreetingRequest
import com.kdaito.jwt_practice.dao.GreetingResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @PostMapping("/greeting")
    fun get(@RequestBody request: GreetingRequest):  ResponseEntity<GreetingResponse> {
        return ResponseEntity(GreetingResponse(request.greeting + "," + "!"), HttpStatus.OK)
    }
}