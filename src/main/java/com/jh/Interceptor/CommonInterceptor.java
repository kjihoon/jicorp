package com.jh.Interceptor;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CommonInterceptor extends HandlerInterceptorAdapter {
	   
	  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	    @Override
	    @SuppressWarnings("unchecked")
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        if (logger.isDebugEnabled()) {
	            logger.debug("======================================          START         ======================================");
	            logger.debug(" Request URI \t:  " + request.getRequestURI());
				Enumeration<String> list =request.getParameterNames();
	            while (list.hasMoreElements()) {
	            	String param = list.nextElement();
	            	logger.info(" Params\t:  "+param+Arrays.toString(request.getParameterValues(param)));
	            }
	            
	        }
	    
	        return super.preHandle(request, response, handler);
	    }
	     
	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        if (logger.isDebugEnabled()) {
	            logger.debug("======================================           END          ======================================\n");
	        }
	    }
	 
	}
