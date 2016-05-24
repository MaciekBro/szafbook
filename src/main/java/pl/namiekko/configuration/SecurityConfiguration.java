package pl.namiekko.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;	

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// sample users
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth, @Value("${user.memory.username}") String username, @Value("${user.memory.password}") String password) throws Exception {
		auth.inMemoryAuthentication()
		.withUser(username).password(password).roles("USER", "ADMIN");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/", "/signup", "/about", "/assets/**","/login").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/actuator/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.anyRequest().authenticated()
			.and()
//		.requiresChannel() 
//			.anyRequest()
//			.requiresSecure()
//			.and()	
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.and()
		.logout()
			.logoutSuccessUrl("/");
	}
	
}
 