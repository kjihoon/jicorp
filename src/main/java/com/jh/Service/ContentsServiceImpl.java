package com.jh.Service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.Dao.ContentsDao;

@Service("ContentsService")
public class ContentsServiceImpl implements ContentsService {

	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ContentsDao ContentsDao;

	@Override
	public Map<String, Object> selectContentsOne(Map<String, Object> params)  {
		return ContentsDao.selectContentsOne(params);
	}
	@Override
	public Map<String, Object> selectArrow(Map<String, Object> params) {
		return ContentsDao.selectArrow(params);
	}

	@Override
	public Map<String, Object> selectContentsLength(Map<String, Object> params)  {
		return ContentsDao.selectContentsLength(params);
	}

	@Override
	public List<Map<String, Object>> selectContentsList()  {
		return ContentsDao.selectContentsList();
	}

	@Override
	public List<Map<String, Object>> selectContentsList(Map<String, Integer> params)  {
		return ContentsDao.selectContentsList(params);
	}

	@Override
	public int insertContents(Map<String, Object> params)  {
		return ContentsDao.insertContents(params);
	}

	@Override
	public int deleteContents(Map<String, Object> params)  {
		return ContentsDao.deleteContents(params);
	}

	@Override
	public int updateContents(Map<String, Object> params)  {
		return ContentsDao.updateContents(params);
	}



}
