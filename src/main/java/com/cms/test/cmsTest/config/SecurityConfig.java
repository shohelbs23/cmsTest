package com.cms.test.cmsTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder =User.builder().passwordEncoder(encoder::encode);

        UserDetails userDetails =userBuilder.username("myuser1").password("password").roles("USER").build();
        UserDetails userDetails2 =userBuilder.username("myuser2").password("password").roles("USER","ADMIN").build();
        return  new InMemoryUserDetailsManager(userDetails,userDetails2);
    }
}
