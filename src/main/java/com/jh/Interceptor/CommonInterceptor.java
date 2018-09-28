package com.jh.Interceptor;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mysql.cj.log.Log;


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
	            if (request.getRequestURI().equals(request.getContextPath()+"/load/contents")) {
	            	
	            	 HttpSession sess = request.getSession();
	            	 String master = (String)sess.getAttribute("master");
	            	 logger.info("master:  "+master);
	            	 if (master==null) {
	            		 logger.error("잘못된 이용!");
	            		 response.sendRedirect(request.getContextPath()+"/main/index");     		 
	            	 }	            	
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
