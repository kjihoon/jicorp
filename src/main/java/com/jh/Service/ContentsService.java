package com.jh.Service;

import java.util.List;
import java.util.Map;

public interface ContentsService {
	Map<String, Object> selectContentsOne(Map<String,Object> params) throws Exception;
	Map<String, Object> selectContentsLength(Map<String,Object> params) throws Exception;
	List<Map<String,Object>> selectContentsList() throws Exception;
	List<Map<String,Object>> selectContentsList(Map<String,Integer> params) throws Exception;
	int insertContents(Map<String,Object> params)  throws Exception;
	int deleteContents(Map<String,Object> params)  throws Exception;
	int updateContents(Map<String,Object> params)  throws Exception;
}
