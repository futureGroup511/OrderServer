package com.order.dao;

import java.util.List;

import com.order.domain.client.FindSource;

public interface FindSourceDAO {
	
	//����path���ض�Ӧ����Ϣ
	public List<FindSource> getSource(String path);
}
