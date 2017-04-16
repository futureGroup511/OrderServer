package com.order.action;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.order.dao.VsInRelativeDAO;
import com.order.dao.impl.VsInRelativeImp;
import com.order.domain.VsInRelative;

public class VsIngredientAction extends SuperAction{

	
	private static final long serialVersionUID = 1L;
	private String vsname;
	private String ingrename;
	private String strnum;
	private int num;
	
	public String reflectvsin(){
		return "reflectvsin";
	}
	
	public String addrelative(){
		try {
			initParam();
		} catch (Exception e) {
			addFieldError("filleerror", "请您在输入框中输入整数！！");
			return "addrelative_success";
		}
		VsInRelativeDAO vsInRelativeDAO = new VsInRelativeImp();
		VsInRelative vsInRelative = new VsInRelative(vsname,ingrename,num);
		vsInRelativeDAO.saveVsIn(vsInRelative);
		
		return "addrelative_success";
	}
	
	public void initParam() throws Exception{
		vsname = reques.getParameter("vsname");
		ingrename = reques.getParameter("ingrename");
		strnum = reques.getParameter("num");
		
		System.out.println(vsname);
		System.out.println(ingrename);
		System.out.println(strnum);
		
		parse(strnum);
	}
	
	/**
	 * @param strnum
	 * @throws Exception 异常上抛，交给调用的处理逻辑的方法，
	 * 逻辑方法处理异常返回错误信息给用户
	 */
	public void parse(String strnum) throws Exception{
		num = Integer.parseInt(strnum);
	}
	
	
	//生成一个二维码
	public void reWeiMa(){
		String goodsName = reques.getParameter("goodsname");

		VsInRelativeDAO v = new VsInRelativeImp();
		List<VsInRelative> list=v.getPeiliao(goodsName);
		StringBuffer sbf=new StringBuffer();
		
		sbf.append(goodsName+"配料：");
		for(int i=0;i<list.size();i++){
			sbf.append(list.get(i).getIngrename()+"    "+list.get(i).getNum()+"份    ");
		}
		String content=sbf.toString();
		
		
		int width = 300;//二维码图片的宽度
		int height = 300;//二维码图片的高度
		String format = "png";//二维码格式
		
		//定义二维码内容参数
		HashMap hints = new HashMap();
		//设置字符集编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//设置容错等级，在这里我们使用M级别
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//设置边框距
		hints.put(EncodeHintType.MARGIN, 2);
		
		//生成二维码
		try {
			//指定二维码内容
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			//指定生成图片的保存路径
			Path file = new File("D:/"+goodsName+".png").toPath();
			//生成二维码
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
