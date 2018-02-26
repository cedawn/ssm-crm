package com.gch.crm.mapper;

import java.util.List;

import com.gch.crm.pojo.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictListByCode(String code);
}
