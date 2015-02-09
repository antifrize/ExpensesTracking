package ru.vmakarenko.filters;

import com.sun.jersey.spi.container.ContainerRequestFilter;
import ru.vmakarenko.services.AuthService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Provider
@WebFilter(filterName = "TimeOfDayFilter",
        urlPatterns = {"/*"})
public class AuthSecurityFilter implements Filter {

    // 401 - Access denied
    private static final Response ACCESS_UNAUTHORIZED = Response.status(Response.Status.UNAUTHORIZED).entity("Not authorized.").build();

    @Inject
    AuthService authService;

    @Context
    private HttpServletRequest request;

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest req = (HttpServletRequest)servletRequest;
            String authId = servletRequest.getHeader("auth_id");
            String authToken = servletRequest.getHeader("auth_token");


            if (!authService.isAuthorized(authId, authToken)) {
                requestContext.abortWith(ACCESS_UNAUTHORIZED);
            }
            // Get method invoked.
        }

    }

    @Override
    public void destroy() {

    }
}