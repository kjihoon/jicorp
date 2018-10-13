package com.jh.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.Dao.PicturesDao;

@Service("PicturesService")
public class PicturesServiceImpl implements PicturesService{

	@Autowired
	private PicturesDao picturesDao; 

	@Override
	public Map<String, Object> selectPicturesOne(Map<String, Object> params) {
		return picturesDao.selectPicturesOne(params);
	}
	@Override
	public List<Map<String, Object>> selectPicturesList(Map<String, Object> params) {
		return picturesDao.selectPicturesList(params);
	}
	@Override
	public int insertPictures(Map<String, Object> params) {
		return picturesDao.insertPictures(params);
	}
	@Override
	public int deletePictures(Map<String, Object> params) {
		return picturesDao.deletePictures(params);
	}
	
}
