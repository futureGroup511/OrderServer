package com.order.dao;

import java.util.List;

import com.order.domain.client.FindSource;

public interface FindSourceDAO {
	
	//根据path返回对应的信息
	public List<FindSource> getSource(String path);
}
