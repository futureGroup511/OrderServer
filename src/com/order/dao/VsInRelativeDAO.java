package com.order.dao;

import java.util.List;

import com.order.domain.VsInRelative;

public interface VsInRelativeDAO {

	//����������Ϲ�ϵ���ݵķ���
	public void saveVsIn(VsInRelative vsInRelative);
	
	//���ݲ˵������ҵ�����˵����е�����
	public List<VsInRelative> getPeiliao(String goodsName);
	
}
