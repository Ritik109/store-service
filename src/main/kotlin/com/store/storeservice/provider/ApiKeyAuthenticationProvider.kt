package com.store.storeservice.provider
//
//import com.store.storeservice.models.ApiKeyAuthenticationToken
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.BadCredentialsException
//import org.springframework.security.authentication.InsufficientAuthenticationException
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.AuthenticationException
//import org.springframework.stereotype.Component
//import org.springframework.util.ObjectUtils
//
//
//@Component
//class ApiKeyAuthenticationProvider : AuthenticationProvider {
//    @Throws(AuthenticationException::class)
//    override fun authenticate(authentication: Authentication): Authentication {
//        val apiKey = authentication.principal as String
//        if (ObjectUtils.isEmpty(apiKey)) {
//            throw InsufficientAuthenticationException("No API key in request")
//        } else {
//            if ("ValidApiKey" == apiKey) {
//                return ApiKeyAuthenticationToken(apiKey, true)
//            }
//            throw BadCredentialsException("API Key is invalid")
//        }
//    }
//
//    override fun supports(authentication: Class<*>?): Boolean {
//        return ApiKeyAuthenticationToken::class.java.isAssignableFrom(authentication)
//    }
//}