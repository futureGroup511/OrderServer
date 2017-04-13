package com.order.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.dao.DAO;
import com.order.dao.VegetableDAO;
import com.order.domain.AlllInfoVegetable;
import com.order.domain.BaseGoodsInfo;
import com.order.domain.User;

public class VegetableDAOImp extends DAO<BaseGoodsInfo> implements VegetableDAO{

	@Override
	public void save(AlllInfoVegetable vegetable) {
		String sql = "insert into table_vs(goodsname,goodsdesc,price,path)value(?,?,?,?)";
		update(sql, vegetable.getGoodsname(),vegetable.getGoodsdesc(),vegetable.getPrice(),vegetable.getPath());
	}

	@Override
	public List<BaseGoodsInfo> getAll() {
		String sql ="select goodsname,goodsdesc,price from table_vs";
		return getForList(sql);
	}
	
	@Override
	public void delete(String name) {
		String sql = "delete from table_vs where goodsname = ?";
		update(sql, name);
	}

	@Override
	public void update(BaseGoodsInfo vegetable) {
		// TODO Auto-generated method stub
		String sql = "update table_vs set price=?, goodsdesc=? where goodsname=?";
		update(sql, vegetable.getPrice(),vegetable.getGoodsdesc(),vegetable.getGoodsname());
	}

	@Override
	public BaseGoodsInfo get(String name) {
		String sql ="select goodsname, price,goodsdesc from table_vs where goodsname=?";
		return  get(sql, name);
	}

	@Override
	public List<BaseGoodsInfo> getAll(String name) {
		String sql ="select goodsname,goodsdesc,price from table_vs where goodsname=?";
		return getForList(sql, name);
	}

	@Override
	public List<BaseGoodsInfos> getPage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql ="select goodsname,goodsdesc,price from table_vs";
		CachedRowSet set=findByPage(sql, pageNo, pageSize);
		List<BaseGoodsInfos> list=new ArrayList<>();
		try {
			while(set.next()){
				BaseGoodsInfos info=new BaseGoodsInfos();
				 info.setGoodsname(set.getString(1));
				 info.setGoodsdesc(set.getString(2));
				 info.setPrice(set.getString(3));
				 
				 
				 
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
