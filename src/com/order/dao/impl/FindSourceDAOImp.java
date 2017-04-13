package com.order.dao.impl;

import java.util.List;

import com.order.dao.DAO;
import com.order.dao.FindSourceDAO;
import com.order.domain.client.FindSource;

public class FindSourceDAOImp extends DAO<FindSource> implements FindSourceDAO{

	@Override
	public List<FindSource> getSource(String path) {
		String sql ="SELECT ingre.goodsname,ingre.goodssource,ingre.buyindate,ingre.price,vi.num"+
				" from table_vs ts,vs_ingredient vi,ingredient ingre"+
				" WHERE ts.goodsname=vi.vsname and vi.ingrename=ingre.goodsname and ts.path=?";
			return getForList(sql, path);
	}

}
