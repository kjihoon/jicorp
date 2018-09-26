package com.jh.Service;

import java.util.List;
import java.util.Map;


public interface TestService {
	Map<String, Object> selectTestOne(Map<String,Object> params) throws Exception;
	List<Map<String,Object>> selectTestList() throws Exception;
	List<Map<String,Object>> selectTestList(Map<String,Object> params) throws Exception;
	int insertTest(Map<String,Object> params)  throws Exception;
	int deleteTest(Map<String,Object> params)  throws Exception;
	int updateTest(Map<String,Object> params)  throws Exception;
}
