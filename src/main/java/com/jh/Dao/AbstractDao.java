package com.jh.Dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {
    protected Log log = LogFactory.getLog(AbstractDao.class);
     
    @Autowired
	SqlSessionTemplate sqlSession;
    
    
    
    protected void printQueryId(String queryId) {
        if(log.isDebugEnabled()){
            log.debug("QueryId  \t\t:  " + queryId);
        }
    }

     
    public Object insert(String queryId, Object params){
    	printQueryId(queryId);
        Object result = null;
        try {
        	 result =  sqlSession.insert(queryId, params);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;   
       
    }
     
    public Object update(String queryId, Object params){
    	printQueryId(queryId);
        Object result = null;
        try {
        	 result = sqlSession.update(queryId, params);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;   
    }
     
    public Object delete(String queryId, Object params){
    	printQueryId(queryId);
        Object result = null;
        try {
        	 result = sqlSession.delete(queryId, params);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;       
    }
     
    public Object selectOne(String queryId){
    	printQueryId(queryId);
        Object result = null;
        try {
        	 result = sqlSession.selectOne(queryId);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;
    }
     
    public Object selectOne(String queryId, Object params){
    	printQueryId(queryId);
        Object result = null;
        try {
        	 result = sqlSession.selectOne(queryId, params);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
    	 printQueryId(queryId);
         List result = null;
         try {
         	 result = sqlSession.selectList(queryId);
         }catch(Exception e){
         	log.error(e.getMessage());
         }
         return result;
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
        printQueryId(queryId);
        List result = null;
        try {
        	 result = sqlSession.selectList(queryId,params);
        }catch(Exception e){
        	log.error(e.getMessage());
        }
        return result;
    }
}