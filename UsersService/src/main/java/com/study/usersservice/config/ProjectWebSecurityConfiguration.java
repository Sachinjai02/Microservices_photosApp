package com.study.usersservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity()
public class ProjectWebSecurityConfiguration {

    @Configuration
    public class SecurityConfiguration {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable().
                    headers().frameOptions().disable().and().
                    authorizeHttpRequests((authz) -> authz.anyRequest().permitAll()
                    );
            return http.build();
        }

        @Bean
        public PasswordEncoder getBcryptPwdEncoder() {
            return new BCryptPasswordEncoder();
        }

    }
}
