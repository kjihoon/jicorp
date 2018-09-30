package com.jh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
//@Repository("UserDao")
public class UserDao extends AbstractDao{

	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public Map<String,Object> selectUserOne(Map<String,Object> params) throws Exception{
		return(Map<String, Object>) selectOne("User.selectUserOne",params);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectUserList() throws Exception{
		return (List<Map<String,Object>>) selectList("User.selectUserList");
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectUserList(Map<String,Object> params) throws Exception{
		return (List<Map<String,Object>>) selectList("User.selectUserList",params);
	}
	public int insertUser(Map<String,Object> params) throws Exception{
		return (int) insert("User.insertUser",params);
	}
	public int deleteUser(Map<String, Object> params) {
		return (int) delete ("User.deleteUser",params);	
	}
	public int updateUser(Map<String, Object> params) {
		return (int) update("User.updateUser",params);
	}
}
