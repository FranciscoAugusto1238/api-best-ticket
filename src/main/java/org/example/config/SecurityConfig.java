package org.example.config;

import org.example.entidade.Role;
import org.example.entidade.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UsuarioRepository usuarioRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Desabilita a proteção CSRF
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

      /*http.csrf().disable() // Desabilita a proteção CSRF
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/usuarios/**").hasRole("ADMIN")
                .antMatchers("/eventos/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
                .httpBasic();*/
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        
        return username -> {
            Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
            Set<GrantedAuthority> authorities = new HashSet<>();
            /*for (Role role : usuario.get().getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }*/
            return new User(usuario.get().getEmail(), usuario.get().getSenha(), authorities);
        };
    }
}
