package com.shubham.SpringSecurityDemo.configs;

import com.shubham.SpringSecurityDemo.services.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter {

    // This is required for Authentication.
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("shubham").password("shubhamRoot").roles("adminRole", "studentRole")
//                .and()
//                .withUser("amit").password("amitRoot").roles("studentRole");
//    }

    // This is required for Authorization.
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .httpBasic()    // for testing via postman, otherwise we will get html file content
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("adminRole")
//                .antMatchers("/student/**").hasAnyRole("adminRole", "studentRole")
//                .antMatchers("/**").permitAll()
//                .and()
//                .formLogin();
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private MyUserDetailService myUserDetailService;

    // This is required for Authentication.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .httpBasic()    // for testing via postman, otherwise we will get html file content
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("adminRole")
//                .antMatchers("/student/**").hasAnyRole("adminRole", "studentRole")
//                .antMatchers("/**").permitAll()
//                .and()
//                .formLogin();

        httpSecurity
                .httpBasic()    // for testing via postman, otherwise we will get html file content
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("admin")
                .antMatchers("/student/**").hasAnyAuthority("admin", "student")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }
}
