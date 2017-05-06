package com.order.dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.order.dao.DAO;
import com.order.dao.VsInRelativeDAO;
import com.order.domain.VsInRelative;

public class VsInRelativeImp extends DAO<VsInRelative> implements VsInRelativeDAO{

	@Override
	public void saveVsIn(VsInRelative vsInRelative) {
		String sql = "insert into vs_ingredient (vsname,ingrename,num) value (?,?,?)";
		update(sql, vsInRelative.getVsname(),vsInRelative.getIngrename(),vsInRelative.getNum());
	}

	@Override
	public List<VsInRelative> getPeiliao(String goodsName) {
		String good="";
		try {
			good=new String(goodsName.getBytes(),"utf-8");
			//System.out.println("good  "+good);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="select * from vs_ingredient where vsname=?";
		return getForList(sql,goodsName);
	}
	
}
