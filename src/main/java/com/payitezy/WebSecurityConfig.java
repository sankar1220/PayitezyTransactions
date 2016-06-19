package com.payitezy;

import com.payitezy.security.AuthenticationFailureHandler;
import com.payitezy.security.AuthenticationSuccessHandler;
import com.payitezy.security.CustomUserDetailsService;
import com.payitezy.security.RestAuthenticationEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    public void configAuthentication(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
        /*.antMatchers("/Angular/**").access("hasRole('ROLE_ADMIN')").antMatchers("/seller/**")
                                                                                                                                   .access("hasRole('ROLE_SELLER_ADMIN')")*/
                .antMatchers("/", "/register/**", "/useractivation/**", "/common/**", "/js/**", "/users/create", "/mobile/**",
                        "/payitezyOperator/**", "/apiDetails/**", "/payitezyCircle/**", "/apiOperatorMargin/**", "/apiCircle/**",
                        "/apiKeys/**", "/merchant/**", "/rechargePage/**", "/payments/**", "/index/**", "/mobileOperator/**",
                        "/prepaidMobileRechargePlan/**", "/login?logout").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)
                .defaultSuccessUrl("/", false).failureUrl("/login?error")
                /*.defaultSuccessUrl("/", false)*/.usernameParameter("username").passwordParameter("password").permitAll().and().logout()
                .logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();

        // http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        /* http.formLogin().successHandler(authenticationSuccessHandler);*/
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
}