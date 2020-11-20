package com.example.Webshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/signIn.css","/MHLogo.png","/landingPage",
                        "/productList","/background.jpg","/addCustomer","/shoppingCart",
                        "/checkout","/h2","/h2/**","/orderConfirmation").permitAll()
                .antMatchers("/myAccount").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/landingPage",true)
                    .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("test@hm.com").password("password123").roles("USER","ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user@hm.com").password("password123").roles("USER","ADMIN").build());
        return manager;
    }

}
