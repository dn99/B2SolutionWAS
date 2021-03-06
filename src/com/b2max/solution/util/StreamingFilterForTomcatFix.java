package com.b2max.solution.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
 
public class StreamingFilterForTomcatFix implements Filter {
 
@Override
 
public void destroy() {
 
}
     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
               public void setHeader(String name, String value) {
                    if (!("Connection".equalsIgnoreCase(name) && "Close".equalsIgnoreCase(value))) {
                         super.setHeader(name, value);
                    }
               }
          });
     }
     @Override
     public void init(FilterConfig arg0) throws ServletException {
     }
}