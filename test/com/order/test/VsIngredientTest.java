package com.order.test;

import org.junit.Test;

import com.order.dao.VsInRelativeDAO;
import com.order.dao.impl.VsInRelativeImp;
import com.order.domain.VsInRelative;

public class VsIngredientTest {
	
	@Test
	public void testsave(){
		VsInRelativeDAO vsInRelativeDAO = new VsInRelativeImp();
		VsInRelative vsInRelative = new VsInRelative("¥–±¨»‚Àø","÷Ì»‚",2);
		vsInRelativeDAO.saveVsIn(vsInRelative);
	}
}
