package com.kdaito.jwt_practice.controller

import com.kdaito.jwt_practice.dao.GreetingRequest
import com.kdaito.jwt_practice.dao.GreetingResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @PostMapping("/greeting")
    fun get(@RequestBody request: GreetingRequest, @AuthenticationPrincipal userDetails: UserDetails?):  ResponseEntity<GreetingResponse> {
        if (userDetails != null) {
            return ResponseEntity(GreetingResponse(request.greeting + "," + userDetails.username + "!"), HttpStatus.OK)
        }
        return ResponseEntity(GreetingResponse(request.greeting + "!"), HttpStatus.OK)
    }
}