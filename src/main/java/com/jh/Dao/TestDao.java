package com.jh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.jh.Service.TestService;


@Repository("TestDao")
public class TestDao extends AbstractDao{
	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public Map<String,Object> selectTestOne(Map<String,Object> params) throws Exception{
		//log.debug("in dao");
		return(Map<String, Object>) selectOne("test.selectTestOne",params);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectTestList() throws Exception{
		return (List<Map<String,Object>>) selectList("test.selectTestList");
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectTestList(Map<String,Object> params) throws Exception{
		return (List<Map<String,Object>>) selectList("test.selectTestList",params);
	}
	//Object insert(String queryId, Object params)
	public int insertTest(Map<String,Object> params) throws Exception{
		return (int) insert("test.insertTest",params);
	}
	public int deleteTest(Map<String, Object> params) {
		return (int) delete ("test.deleteTest",params);
		
	}
	public int updateTest(Map<String, Object> params) {
		return (int) update("test.deleteTest",params);
	}
	
 
}
