package com.jh.Service;

import java.util.List;
import java.util.Map;


public interface ContentsService {
	Map<String, Object> selectContentsOne(Map<String,Object> params);
	Map<String, Object> selectArrow (Map<String,Object> params);
	Map<String, Object> selectContentsLength(Map<String,Object> params);
	List<Map<String,Object>> selectContentsList();
	List<Map<String,Object>> selectContentsList(Map<String,Integer> params);
	int insertContents(Map<String,Object> params);
	int deleteContents(Map<String,Object> params);
	int updateContents(Map<String,Object> params);
}
