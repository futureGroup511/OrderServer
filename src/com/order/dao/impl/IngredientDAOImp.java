package com.order.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.dao.DAO;
import com.order.dao.IngredientDAO;
import com.order.domain.Ingredient;

public class IngredientDAOImp extends DAO<Ingredient> implements IngredientDAO{

	@Override
	public void save(Ingredient ingredient) {
		String sql = "insert into ingredient(goodsname,goodssource,buyindate,price,num)value(?,?,?,?,?)";
		update(sql, ingredient.getGoodsname(),ingredient.getGoodssource(),ingredient.getBuyindate(),ingredient.getPrice(),ingredient.getNum());
	}

	@Override
	public List<Ingredient> getAll() {
		String sql ="select goodsname,goodssource,buyindate,price,num from ingredient";
		return getForList(sql);
	}
	
	@Override
	public void delete(String name) {
		String sql = "delete from ingredient where goodsname = ?";
		update(sql, name);
	}

	@Override
	public void update(Ingredient ingredient) {
		// TODO Auto-generated method stub
		String sql = "update ingredient set goodssource=?, buyindate=?,price=?,num=? where goodsname=?";
		update(sql, ingredient.getGoodssource(),ingredient.getBuyindate(),ingredient.getPrice(),ingredient.getNum(),ingredient.getGoodsname());
	}
	
	@Override
	public Ingredient get(String name) {
		String sql ="select goodsname, goodssource,buyindate,price,num from ingredient where goodsname=?";
		return  get(sql, name);
	}

	@Override
	public List<Ingredient> getAll(String goodsname) {
		System.out.println("*********");
		String sql ="select goodsname,goodssource,buyindate,price,num from ingredient where goodsname like '%"+goodsname+"%'";
		return getForList(sql);
	}
	@Override
	public List<Ingredient> getPage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql ="select goodsname,goodssource,buyindate,price,num from ingredient";
		CachedRowSet set=findByPage(sql, pageNo, pageSize);
		List<Ingredient> list=new ArrayList<>();
		try {
			while(set.next()){
				Ingredient info=new Ingredient();
				 info.setGoodsname(set.getString(1));
				 info.setGoodssource(set.getString(2));
				 info.setBuyindate(set.getDate(3));
				 info.setPrice(set.getDouble(4));
				 info.setNum(set.getInt(5));
				 
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
