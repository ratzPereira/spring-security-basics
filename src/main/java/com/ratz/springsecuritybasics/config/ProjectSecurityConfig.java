package com.ratz.springsecuritybasics.config;

import com.ratz.springsecuritybasics.filter.JWTTokenGeneratorFilter;
import com.ratz.springsecuritybasics.filter.JWTTokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //indicates spring security to not generate any tokens

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and().csrf().disable()
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/myAccount").hasRole("USER")
                .antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").hasAnyRole("USER","ADMIN")
                .antMatchers("/user").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll().and().httpBasic();

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("User").password(passwordEncoder().encode("abc")).authorities("admin").build();
//        UserDetails user1 = User.withUsername("Admin").password(passwordEncoder().encode("abc")).authorities("admin").build();
//        userDetailsManager.createUser(user);
//        userDetailsManager.createUser(user1);
//        auth.userDetailsService(userDetailsManager);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
