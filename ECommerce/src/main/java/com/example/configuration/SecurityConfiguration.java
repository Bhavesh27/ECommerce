package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
    DataSource dataSource;
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
    {
    	
    	auth.jdbcAuthentication().dataSource(dataSource)
    	.usersByUsernameQuery("select username, password, isActive from User where username = ?")
    	.authoritiesByUsernameQuery("select u1.username,  u2.role from User u1 , Roles u2 where u1.roleId=u2.user_role_id and u1.username = ?");
    	
    	/*auth.jdbcAuthentication().dataSource(dataSource)
    	.usersByUsernameQuery("select email, password, isActive from User where email = ?")
    	.authoritiesByUsernameQuery("select u1.email , u2.role from User u1 , Roles u2 where u1.roleId=u2.user_role_id and u1.email = ?");  */
    	
    }
   
	/*@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/", "/home").permitAll()
	    .antMatchers("/cart**","/account**").access("hasRole('USER')")
	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("username").passwordParameter("password")
	  	//.usernameParameter("email").passwordParameter("password")
	  	.and().csrf().disable();
	  	//.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

}
