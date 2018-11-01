package com.jwa.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.jwa.exception.ApiError;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author John Anderson
 */
@Component
public class JwtAuthentication implements AuthenticationEntryPoint {
	/**
	 * for catches unauthorized token
	 */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        throw (new ApiError("Responding with unauthorized error. Message - " + e.getMessage()));
    }
}