package Jobseeking.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebMvc
public class SecurityConfig extends WsConfigurerAdapter  {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests((requests) -> requests
	                .anyRequest().authenticated() 
	            )
	            .formLogin(form -> form
	            	    .loginPage("/login")
	            	    .permitAll()
	            	)
	            .logout(logout -> logout
	                .logoutUrl("/logout") 
	                .logoutSuccessHandler(logoutSuccessHandler()) 
	                .invalidateHttpSession(true) 
	                .deleteCookies("JSESSIONID") 
	            )
	            .csrf(csrf -> csrf
	                .ignoringRequestMatchers("/logout") 
	            );

	        return http.build();
	    }

	    @Bean
	    public LogoutSuccessHandler logoutSuccessHandler() {
	        return (request, response, authentication) -> {
	            response.setStatus(HttpServletResponse.SC_OK);
	            response.getWriter().write("Logout thành công!");
	        };
	    }
}
