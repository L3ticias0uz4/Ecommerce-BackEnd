package com.list.ecommerce.config;

import com.list.ecommerce.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter {


    @Component
    public class jwtFilter extends OncePerRequestFilter {

        private final com.list.ecommerce.config.JwtFilter jwtService;
        private final UserDetailsService userDetailsService;

        public jwtFilter(com.list.ecommerce.config.JwtFilter jwtService, UserDetailsService userDetailsService){
            this.jwtService = jwtService;
            this.userDetailsService = userDetailsService;
        }


        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain)
                throws ServletException, IOException {
            String header = request.getHeader("Authorization");

            if (header != null && header.startsWith("Bearer ")){

                String token = header.substring(7);
                String email = JwtService.pegarEmail(token);
                UserDetails user = userDetailsService.loadUserByUsername(email);
                var auth = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            chain.doFilter(request, response);

        }
    }

}
