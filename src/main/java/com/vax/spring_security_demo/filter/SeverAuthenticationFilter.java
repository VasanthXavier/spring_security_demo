package com.vax.spring_security_demo.filter;

import com.vax.spring_security_demo.dto.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SeverAuthenticationFilter extends OncePerRequestFilter {

    @Value("${auth.secret}")
    private String authSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String header = request.getHeader("secret");
            if (header != null && header.equals(authSecret)) {
                UsernamePasswordAuthenticationToken unpToken = new UsernamePasswordAuthenticationToken(
                        "INTERNAL_SERVER",
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_INTERNAL"))
                );
                SecurityContextHolder.getContext().setAuthentication(unpToken);
            }
            // Authorities i mean third arg in mandatory, or else it will not be authenticated
            // it can be empty but recommended to give one atleast
        }

        filterChain.doFilter(request, response);
    }
}
