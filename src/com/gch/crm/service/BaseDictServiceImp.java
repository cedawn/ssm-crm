package com.gch.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gch.crm.mapper.BaseDictDao;
import com.gch.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImp implements BaseDictService {
	@Autowired
	private BaseDictDao baseDictDao;
	
	public List<BaseDict> selectBaseDictByCode(String code){
		return baseDictDao.selectBaseDictListByCode(code);
	}
}
