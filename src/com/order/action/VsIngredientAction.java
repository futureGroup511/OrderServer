package com.order.action;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.oder.domain.service.BaseGoodsInfos;
import com.opensymphony.xwork2.util.logging.Logger;
import com.order.dao.VegetableDAO;
import com.order.dao.VsInRelativeDAO;
import com.order.dao.impl.VegetableDAOImp;
import com.order.dao.impl.VsInRelativeImp;
import com.order.domain.VsInRelative;

public class VsIngredientAction extends SuperAction{

	
	private static final long serialVersionUID = 1L;
	private String vsname;
	private String ingrename;
	private String strnum;
	private int num;
	VegetableDAO vegetableDAO = new VegetableDAOImp();
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
/*	public void reWeiMa(){
		String goodsName = reques.getParameter("goodsname");
		ServletOutputStream stream = null;

		VsInRelativeDAO v = new VsInRelativeImp();
		List<VsInRelative> list=v.getPeiliao(goodsName);
		StringBuffer sbf=new StringBuffer();
		if(list!=null){
			sbf.append(goodsName+"  配料：");
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

				stream = response.getOutputStream();
				//生成二维码
				MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		List<BaseGoodsInfos> baseList = vegetableDAO.getPage(1, 8);
		//System.out.println(baseList.get(1).getGoodsname());
		reques.setAttribute("vegetables", baseList);
		//return "vsqueryall_success";
		
	}*/
	
	
	public void reWeiMa() throws IOException{
		//设置页面不缓存
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);

		BufferedImage image=null;
		String goodsName = reques.getParameter("goodsname");
		ServletOutputStream stream = null;
		//二维码的图片格式 
		String format = "gif"; 
		VsInRelativeDAO v = new VsInRelativeImp();
		List<VsInRelative> list=v.getPeiliao(goodsName);
		System.out.println("list "+list.size());
		StringBuffer sbf=new StringBuffer();
		if(list!=null){
			sbf.append(goodsName+"配料:");
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
				sbf.append(list.get(i).getIngrename()+""+list.get(i).getNum()+"份");
			}
			String content=sbf.toString();
			//String content = "哈哈我是宋民举啊，测试啊";
			int width2 = 200; 
			int height2 = 200; 
			
			Hashtable hints = new Hashtable(); 
			//内容所使用编码 
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
			
			try{
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, width2, height2, hints);
				
				int width = bitMatrix.getWidth(); 
				int height = bitMatrix.getHeight(); 
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
				for (int x = 0; x < width; x++) { 
					for (int y = 0; y < height; y++) { 
						image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF); //二维码图片为黑白两色
					} 
				}
				//ImageIO.write(image,"gif",response.getOutputStream());
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//只有用这种解码方式才不出现乱码
		String s="attachment;filename="+new String(goodsName.getBytes("gb2312"),"ISO8859-1")+".gif";
		response.addHeader("Content-Disposition",s);
		OutputStream os=new BufferedOutputStream(response.getOutputStream());
		response.setContentType("image/gif");
		ImageIO.write(image,format,os);
		os.flush();
		os.close();


	}
}