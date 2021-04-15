package com.biglolPage.introducingBiglolPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.biglolPage.introducingBiglolPage.service.UserDetailServiceImpl;


// The @Configuration and @EnableWebSecurity annotations switch off the default web security configuration, 
// and we can define our own configuration in this class. Inside the configure(HttpSecurity http) method, we can define 
// which endpoints in our application are secure and which are not.

// Add a new configureGlobal method to enable users from the database. We should never save the password as
// plain text to the database. Therefore, we will define a password hashing algorithm in the configureGlobal 
// method. In this example, we are using the BCrypt algorithm. This can be easily implemented with the 
// Spring Security BCryptPasswordEncoder class. The following is the SecurityConfig.java source code. Now, 
// the password must be hashed using BCrypt before it's saved to the database:

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	  private UserDetailServiceImpl userDetailsService; 

	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception{
		  http.csrf().disable().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		  .and().authorizeRequests()
		  .antMatchers(HttpMethod.GET, "/courses/**").permitAll()
		  .antMatchers(HttpMethod.GET, "/skills").permitAll()
		  .antMatchers(HttpMethod.GET, "/projects").permitAll()
		  .antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated().and()
		  .addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		  .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		  ;
	  }
	
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//        .httpBasic().and()
//        .authorizeRequests()
//          .antMatchers(HttpMethod.GET, "/courses/**").hasRole("admin");
//    }
}
