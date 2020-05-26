package com.emart.zuul.filter;

import com.emart.zuul.pojo.User;
import com.emart.zuul.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private RestTemplate restTemplate;

    /**
     *  token Header Key
     */
    public static final String HEADER_STRING = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info( String.format("%s >>> %s" , request.getMethod() , request.getRequestURL()) );
        
    	String token = request.getHeader( HEADER_STRING );
        //do nothing if token is null, spring security will check the url and authority
        if (null != token) {
        	//set authentication info 
        	//then spring security will check it
            String username = jwtTokenUtil.getUsernameFromToken(token);
            if (username != null) {
            	UserDetails userDetails = restTemplate.getForObject("http://SERVICE-USER/user?username=" +  username, User.class );;
                if (!jwtTokenUtil.isTokenExpired(token)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

}
