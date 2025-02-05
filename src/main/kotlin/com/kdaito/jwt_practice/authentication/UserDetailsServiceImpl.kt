package com.kdaito.jwt_practice.authentication

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == "user@example.com") {
            return User("user@example.com", "{noop}password", ArrayList())
        }
        throw UsernameNotFoundException("User not found")
    }
}