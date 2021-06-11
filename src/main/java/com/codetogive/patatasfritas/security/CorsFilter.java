package com.codetogive.patatasfritas.security;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@Order(value = Integer.MIN_VALUE)
public class CorsFilter extends OncePerRequestFilter {

  private String accessControlAllowOrigin;

  public CorsFilter(@Value("${cors.access-control-allow-origin}") String accessControlAllowOrigin) {
    this.accessControlAllowOrigin = accessControlAllowOrigin;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    String origin = request.getHeader(HttpHeaders.ORIGIN);
    if (Arrays.asList(accessControlAllowOrigin.split(",")).contains(origin)) {
      response.addHeader("Access-Control-Allow-Origin", origin);
      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      response.addHeader("Access-Control-Max-Age", "36000");
      response.setHeader("Access-Control-Allow-Headers",
          "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, "
              + "Access-Control-Request-Headers, patatas-fritas-token");
      response.addHeader("Access-Control-Expose-Headers", "*");
      response.addHeader("Access-Control-Allow-Credentials", "true");
    }

    if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
      response.setStatus(200);
    } else {
      filterChain.doFilter(request, response);
    }
  }
}