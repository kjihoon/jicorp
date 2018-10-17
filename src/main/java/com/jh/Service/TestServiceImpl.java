package com.jh.Service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.Dao.TestDao;

@Service("TestService")
public class TestServiceImpl implements TestService{
	  Logger log = Logger.getLogger(this.getClass());
	     
	    @Autowired
	    private TestDao testDao;
	    
		@Override
		public Map<String, Object> selectTestOne(Map<String,Object> params)  {
			//log.debug("in service");
			return testDao.selectTestOne(params);
		}
		@Override
		public List<Map<String,Object>> selectTestList()  {
			return testDao.selectTestList();
		}
		@Override
		public List<Map<String,Object>> selectTestList(Map<String,Object> params)  {
			return testDao.selectTestList(params);
		}
		@Override
		public int insertTest(Map<String,Object> params)   {
			return testDao.insertTest(params);
		}
		@Override
		public int deleteTest(Map<String, Object> params)  {
			return testDao.deleteTest(params);
		}
		@Override
		public int updateTest(Map<String, Object> params)  {
			return testDao.updateTest(params);
		}
		
		
}