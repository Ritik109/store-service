package com.store.storeservice.configuration
//
////import com.store.storeservice.filter.ApiKeyAuthenticationFilter
//import com.store.storeservice.provider.ApiKeyAuthenticationProvider
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.ProviderManager
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.web.authentication.AnonymousAuthenticationFilter
//
///*
//  - Configuration: Adds a new Spring configuration
//  - Enable web security: Overrides the default web security configuration
//*/
//@Configuration
//@EnableWebSecurity
//class SecurityConfig : WebSecurityConfigurerAdapter() {
//    @Autowired
//    private val apiKeyAuthenticationProvider: ApiKeyAuthenticationProvider? = null
//
//    @Throws(Exception::class)
//    override fun configure(httpSecurity: HttpSecurity) {
//        httpSecurity
//            .authorizeRequests()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .addFilterBefore(
//                ApiKeyAuthenticationFilter(authenticationManager()),
//                AnonymousAuthenticationFilter::class.java
//            )
//
//        httpSecurity.csrf().disable().cors().disable();
//        httpSecurity.headers().frameOptions().disable();
//    }
//
//    @Bean
//    public override fun authenticationManager(): AuthenticationManager {
//        return ProviderManager(listOf(apiKeyAuthenticationProvider))
//    }
//}