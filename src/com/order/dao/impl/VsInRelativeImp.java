package com.order.dao.impl;

import com.order.dao.DAO;
import com.order.dao.VsInRelativeDAO;
import com.order.domain.VsInRelative;

public class VsInRelativeImp extends DAO<VsInRelative> implements VsInRelativeDAO{

	@Override
	public void saveVsIn(VsInRelative vsInRelative) {
		String sql = "insert into vs_ingredient (vsname,ingrename,num) value (?,?,?)";
		update(sql, vsInRelative.getVsname(),vsInRelative.getInname(),vsInRelative.getNum());
	}
	
}
