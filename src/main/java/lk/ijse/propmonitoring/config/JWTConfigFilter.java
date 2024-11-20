package lk.ijse.propmonitoring.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.propmonitoring.Service.JWTService;
import lk.ijse.propmonitoring.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@Component
public class JWTConfigFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String initToken = request.getHeader("Authorization");
        String userEmail;
        String extractedJwtToken;

        //validate token
        if(StringUtils.isEmpty(initToken)|| !initToken.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }
        extractedJwtToken = initToken.substring(7);
        userEmail = jwtService.extractUserName(extractedJwtToken);

        //user email
        if (StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null) {
            var userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
            if (jwtService.validateToken(extractedJwtToken,userDetails)) {
                SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
                emptyContext.setAuthentication(authToken);
                SecurityContextHolder.setContext(emptyContext);
            }
            filterChain.doFilter(request,response);
        }
    }
}