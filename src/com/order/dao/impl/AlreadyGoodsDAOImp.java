package com.order.dao.impl;

import java.util.List;

import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.DAO;
import com.order.domain.Already;
import com.order.domain.client.AlreadyGoods;

public class AlreadyGoodsDAOImp extends DAO<AlreadyGoods> implements AlreadyGoodsDAO{

	@Override
	public void saveAlready(AlreadyGoods alreadyGoods) {
		String sql ="insert into already (goodsname,tablenum,num) value(?,?,?)";
		update(sql, alreadyGoods.getGoodsname(),alreadyGoods.getTablenum(),alreadyGoods.getNum());
	}

	@Override
	public List<AlreadyGoods> getAll() {
		String sql = "select * from already";
		return getForList(sql);
	}

	@Override
	public List<AlreadyGoods> getByTablenum(int n) {
		// TODO Auto-generated method stub
		String sql = "select * from already where tablenum = ?";
		return this.getForList(sql, n);
	}

	@Override
	public boolean deleteAll(int tablenum) {
		// TODO Auto-generated method stub
		return this.update("delete from already where tablenum = ?",tablenum);
	}

}
