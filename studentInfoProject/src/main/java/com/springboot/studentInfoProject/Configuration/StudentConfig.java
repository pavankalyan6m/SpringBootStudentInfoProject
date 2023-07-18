package com.springboot.studentInfoProject.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class StudentConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("Student")
                .password(encoder.encode("student123"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("Admin")
                .password(encoder.encode("admin123"))
                .roles("USER","ADMIN","HR")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

        //return new StudentInfoUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/studentInfo/all").hasRole("USER")
                        .requestMatchers("/studentInfo/welcome").permitAll()
                        .requestMatchers("/studentInfo/{id}").hasAnyRole("USER", "ADMIN", "HR")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());


        return http.build();

    }

}