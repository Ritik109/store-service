package com.store.storeservice.filter

//
//import com.store.storeservice.models.ApiKeyAuthenticationToken
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
//import java.io.IOException
//import java.util.*
//import javax.servlet.FilterChain
//import javax.servlet.ServletException
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//
//class ApiKeyAuthenticationFilter(
//    @Autowired authenticationManager: AuthenticationManager?
//) :
//    AbstractAuthenticationProcessingFilter("/**") {
//    override fun attemptAuthentication(
//        request: HttpServletRequest, response: HttpServletResponse
//    ): Authentication {
//        val apiKeyOptional = Optional.ofNullable(request.getHeader("api-key"))
//        println("API KEY OPTIONAL $apiKeyOptional")
//        val token: ApiKeyAuthenticationToken =
//            apiKeyOptional.map<Any> { ApiKeyAuthenticationToken() }.orElse(ApiKeyAuthenticationToken()) as ApiKeyAuthenticationToken
//        return authenticationManager.authenticate(token)
//    }
//
//    @Throws(IOException::class, ServletException::class)
//    override fun successfulAuthentication(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        chain: FilterChain,
//        authResult: Authentication
//    ) {
//        SecurityContextHolder.getContext().authentication = authResult
//        chain.doFilter(request, response)
//    }
//
//    init {
//        this.authenticationManager = authenticationManager
//    }
//}