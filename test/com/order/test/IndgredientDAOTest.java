package com.order.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.order.dao.IngredientDAO;
import com.order.dao.impl.IngredientDAOImp;
import com.order.domain.Ingredient;

import sun.management.VMOptionCompositeData;

public class IndgredientDAOTest {
	
	@Test
	public void testsave(){
		IngredientDAO ingredientDAO = new IngredientDAOImp();
		Ingredient ingredient = new Ingredient("海螺","威海市市中心",new Date(),3.00,4);
		ingredientDAO.save(ingredient);
	}
	@Test
	public void getAll(){
		IngredientDAO ingredientDAO = new IngredientDAOImp();
		List<Ingredient> list = ingredientDAO.getAll();
		for(Ingredient list2:list){
			System.out.println(list2.getGoodsname());
		}
	}
	@Test
	public void delete(){
		IngredientDAO ingredientDAO = new IngredientDAOImp();
		ingredientDAO.delete("海螺");
	}
	
	@Test
	public void get(){
		IngredientDAO ingredientDAO = new IngredientDAOImp();
		Ingredient ingredient = ingredientDAO.get("海螺");
		System.out.println(ingredient.getNum());
		
	}
}
