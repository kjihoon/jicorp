package com.jh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
@Repository("ContentsDao")
public class ContentsDao extends AbstractDao{

	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public Map<String,Object> selectContentsOne(Map<String,Object> params) throws Exception{
		log.info("in dao");
		return(Map<String, Object>) selectOne("contents.selectContentsOne",params);
	}
	@SuppressWarnings("unchecked")
	public Map<String,Object> selectContentsLength(Map<String,Object> params) throws Exception{
		log.info("in dao");
		return(Map<String, Object>) selectOne("contents.selectContentsLength",params);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectContentsList() throws Exception{
		return (List<Map<String,Object>>) selectList("contents.selectContentsList");
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectContentsList(Map<String,Integer> params) throws Exception{
		return (List<Map<String,Object>>) selectList("contents.selectContentsList2",params);
	}
	public int insertContents(Map<String,Object> params) throws Exception{
		return (int) insert("contents.insertContents",params);
	}
	public int deleteContents(Map<String, Object> params) {
		return (int) delete ("contents.deleteContents",params);	
	}
	public int updateContents(Map<String, Object> params) {
		return (int) update("contents.updateContents",params);
	}
}
