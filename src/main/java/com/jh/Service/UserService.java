package com.jh.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
	Map<String, Object> selectUserOne(Map<String,Object> params) throws Exception;
	List<Map<String,Object>> selectUserList() throws Exception;
	List<Map<String,Object>> selectUserList(Map<String,Object> params) throws Exception;
	int insertUser(Map<String,Object> params)  throws Exception;
	int deleteUser(Map<String,Object> params)  throws Exception;
	int updateUser(Map<String,Object> params)  throws Exception;
}
