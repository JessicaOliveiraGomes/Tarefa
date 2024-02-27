package com.todo.config;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class SimpleCorsFilter implements Filter {
	
	
	private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200", "https://dev-cdc.curitiba.pr.gov.br","https://web-cdc.hom.ocp.ici.curitiba.org.br", "https://hom-cdc.curitiba.pr.gov.br", "https://dev-cdc.curitiba.pr.gov.br", "https://cdc.curitiba.pr.gov.br"); 

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("cors filter loogerd");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest reque = (HttpServletRequest) request;
		
        // Access-Control-Allow-Origin
        String origin = reque.getHeader("Origin");
        resp.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "*");
        resp.setHeader("Vary", "Origin");
        
        resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
		resp.setHeader("Access-Control-Allow-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Authorization, X-CSRF-TOKEN");
		
		if ("OPTIONS".equalsIgnoreCase(reque.getMethod())) {
			resp.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void destroy() {
	}

}
