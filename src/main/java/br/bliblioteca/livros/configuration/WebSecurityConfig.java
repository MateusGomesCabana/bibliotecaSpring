/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bliblioteca.livros.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Mateus
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    //Permite onde posso navegar
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HABILITA O FRAME DO H2-CONSOLE
        http.headers().frameOptions().disable();
        //Não é necessario usar ROLE
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/registration").permitAll()
                .antMatchers(HttpMethod.POST, "/user/registration").permitAll()
                .antMatchers(HttpMethod.GET, "/user/list").hasRole("BASIC")
                .antMatchers(HttpMethod.GET, "/user/listadmin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/livro/list").hasRole("BASIC")
                .antMatchers(HttpMethod.GET, "/livro/novo").hasRole("BASIC")
                .antMatchers(HttpMethod.POST, "/livro/gravar").hasRole("BASIC")
                .antMatchers(HttpMethod.GET, "/livro/alterar/{id}").hasRole("BASIC")
                .antMatchers(HttpMethod.GET, "/livro/excluir/{id}").hasRole("BASIC")
                .antMatchers(HttpMethod.GET, "/autor/list").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/autor/novo").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/autor/gravar").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/autor/alterar/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/autor/excluir/{id}").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/user/login")
                .permitAll()
                .and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
