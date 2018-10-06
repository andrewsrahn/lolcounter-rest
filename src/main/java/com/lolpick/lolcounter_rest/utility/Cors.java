package com.lolpick.lolcounter_rest.utility;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Cors implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "GET, PUT, POST");
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	public void destroy() {}
}
