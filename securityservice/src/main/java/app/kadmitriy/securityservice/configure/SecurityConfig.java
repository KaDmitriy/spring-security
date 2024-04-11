package app.kadmitriy.securityservice.configure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import app.kadmitriy.securityservice.user.model.UserModel;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	@Autowired
	private List<UserModel> listUserModel;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/help/*").permitAll()
				.requestMatchers("/info").hasAnyRole("ADMIN")
				//.requestMatchers("/info").hasAnyAuthority(null)
				//.requestMatchers("/api/user/del/*").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable());
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		
		List<UserDetails> users = new ArrayList<UserDetails>(); 
		
		listUserModel.stream().forEach(um -> 
			users.add(User.withDefaultPasswordEncoder()
				.username(um.getName())
				.password(um.getPassord())
				.roles("ADMIN")
				.build())
				
		);
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
