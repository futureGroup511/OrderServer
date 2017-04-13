package com.order.test;

import java.util.List;

import org.junit.Test;

import com.order.dao.FindSourceDAO;
import com.order.dao.impl.FindSourceDAOImp;
import com.order.domain.client.FindSource;

public class FindSourceTest {
	
	
	@Test
	public void getfind(){
		
		FindSourceDAO findSourceDAO = new FindSourceDAOImp();
		List<FindSource> list= findSourceDAO.getSource("congbaoyangrou.jpg");
		for(FindSource findSource :list){
			System.out.println(findSource.getBuyindate());
		}
	}
}
