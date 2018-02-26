package com.gch.crm.service;

import java.util.List;

import com.gch.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictByCode(String code);
}
