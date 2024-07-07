package com.kdaito.jwt_practice.authentication

data class JwtRequest(
    val email: String,
    val password: String
)