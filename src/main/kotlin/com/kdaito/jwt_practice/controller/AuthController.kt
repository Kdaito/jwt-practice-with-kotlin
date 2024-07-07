package com.kdaito.jwt_practice.controller

import com.kdaito.jwt_practice.authentication.JwtRequest
import com.kdaito.jwt_practice.authentication.JwtResponse
import com.kdaito.jwt_practice.authentication.JwtUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var jwtUtil: JwtUtil

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    @PostMapping("/login")
    fun login(@RequestBody authenticationRequest: JwtRequest): ResponseEntity<JwtResponse> {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(authenticationRequest.email, authenticationRequest.password)
        )

        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authenticationRequest.email)
        val jwt: String = jwtUtil.generateToken(userDetails)

        return ResponseEntity(JwtResponse(jwt), HttpStatus.OK)
    }
}