package com.proinproject.registrationconsumer.Secuconfig;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.proinproject.registrationconsumer.service.PersonInfoUserDetails;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class securityConfiguration {
	
	@Bean
	public UserDetailsService dsd() {
		return new PersonInfoUserDetails();
	}
	
	@Bean
	public PasswordEncoder sdas() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain kfdrd(HttpSecurity http) throws Exception {
		//http.cors(AbstractHttpConfigurer::disable)
		System.out.println("im in filetr");
		return http
			.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->
		auth.requestMatchers("/login").permitAll().requestMatchers("/all")
		.authenticated()).httpBasic(Customizer.withDefaults())
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(axsxa()).build();
	}
	
	
	
	@Bean
	public AuthenticationProvider axsxa() {
		DaoAuthenticationProvider qd=new DaoAuthenticationProvider();
		qd.setUserDetailsService(dsd());
		qd.setPasswordEncoder(sdas());
		return qd;
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
	

//  @Bean
//  CorsConfigurationSource corsConfigurationSource(){
//      CorsConfiguration configuration = new CorsConfiguration();
//      configuration.setAllowedOrigins(Arrays.asList("*"));
//      configuration.setAllowedMethods(Arrays.asList("*"));
//      configuration.setAllowedHeaders(Arrays.asList("*"));
//      configuration.setAllowCredentials(false);
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", configuration);
//      return source;
//  }

}
