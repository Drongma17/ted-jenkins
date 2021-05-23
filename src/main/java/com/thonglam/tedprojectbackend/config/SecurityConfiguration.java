package com.thonglam.tedprojectbackend.config;


import com.thonglam.tedprojectbackend.intercepter.AuthenticationTokenFilter;
import com.thonglam.tedprojectbackend.security.CsrfHeaderFilter;
import com.thonglam.tedprojectbackend.security.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JwtAuthenticationEntryPoint authenticationEntryPoint;


    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
    }


    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean(){
        return new AuthenticationTokenFilter();
    }



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/entrepreneurship/**", "/events/**", "/galleryProfile/**", "/guestProfile/**", "**/loadMultipleFileUpload/**",
                        "/email/**", "/finance", "/announcement/**", "/finance/**", "/category/**", "/ehubProfile/**", "/investment/**", "/steprofile/**", "/ehubcategory/**", "/snowbank/**", "/lendmoney/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated();

              httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
                      .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);

              httpSecurity.headers().cacheControl();
              httpSecurity.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);

    }


    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
            }
        };
    }




}
