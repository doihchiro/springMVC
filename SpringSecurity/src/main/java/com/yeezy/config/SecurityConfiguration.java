package com.yeezy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((auth) ->
                auth.requestMatchers("/**").permitAll()
                    .requestMatchers("/board/**").authenticated()
        );
        http.formLogin((formLogin) -> formLogin.loginPage("/member/login")
                        .defaultSuccessUrl("/board/list")
//                .failureUrl("/fail")
        );
        http.logout(logout -> logout.logoutUrl("/member/logout").logoutSuccessUrl("/"));

        return http.build();
    }
}
