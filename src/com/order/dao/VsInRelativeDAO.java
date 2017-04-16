package com.order.dao;

import java.util.List;

import com.order.domain.VsInRelative;

public interface VsInRelativeDAO {

	//保存菜与配料关系数据的方法
	public void saveVsIn(VsInRelative vsInRelative);
	
	//根据菜的名字找到这道菜的所有的配料
	public List<VsInRelative> getPeiliao(String goodsName);
	
}
