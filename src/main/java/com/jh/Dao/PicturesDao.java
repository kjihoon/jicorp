package com.jh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("PicturesDao")
public class PicturesDao extends AbstractDao{

	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public Map<String,Object> selectPicturesOne(Map<String,Object> params){
		return(Map<String, Object>) selectOne("pictures.selectPicturesOne",params);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectPicturesList(Map<String,Object> params){
		return (List<Map<String,Object>>) selectList("pictures.selectPicturesList",params);
	}	
	public int insertPictures(Map<String,Object> params){
		return (int) insert("pictures.insertPictures",params);
	}
	public int deletePictures(Map<String, Object> params) {
		return (int) delete ("pictures.deletePictures",params);	
	}

}
