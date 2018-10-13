package com.jh.Service;

import java.util.List;
import java.util.Map;



public interface PicturesService{

	public Map<String,Object> selectPicturesOne(Map<String,Object> params);
	public List<Map<String,Object>> selectPicturesList(Map<String,Object> params);
	public int insertPictures(Map<String,Object> params);
	public int deletePictures(Map<String, Object> params);
	
}
