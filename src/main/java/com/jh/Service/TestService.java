package com.jh.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


public interface TestService {
	Map<String, Object> selectTestOne(Map<String,Object> params) ;
	List<Map<String,Object>> selectTestList() ;
	List<Map<String,Object>> selectTestList(Map<String,Object> params) ;
	int insertTest(Map<String,Object> params)  ;
	int deleteTest(Map<String,Object> params)  ;
	int updateTest(Map<String,Object> params)  ;
}
