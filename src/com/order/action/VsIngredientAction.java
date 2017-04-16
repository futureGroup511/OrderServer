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
			addFieldError("filleerror", "�������������������������");
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
	 * @throws Exception �쳣���ף��������õĴ����߼��ķ�����
	 * �߼����������쳣���ش�����Ϣ���û�
	 */
	public void parse(String strnum) throws Exception{
		num = Integer.parseInt(strnum);
	}
	
	
	//����һ����ά��
	public void reWeiMa(){
		String goodsName = reques.getParameter("goodsname");

		VsInRelativeDAO v = new VsInRelativeImp();
		List<VsInRelative> list=v.getPeiliao(goodsName);
		StringBuffer sbf=new StringBuffer();
		
		sbf.append(goodsName+"���ϣ�");
		for(int i=0;i<list.size();i++){
			sbf.append(list.get(i).getIngrename()+"    "+list.get(i).getNum()+"��    ");
		}
		String content=sbf.toString();
		
		
		int width = 300;//��ά��ͼƬ�Ŀ��
		int height = 300;//��ά��ͼƬ�ĸ߶�
		String format = "png";//��ά���ʽ
		
		//�����ά�����ݲ���
		HashMap hints = new HashMap();
		//�����ַ��������ʽ
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//�����ݴ�ȼ�������������ʹ��M����
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//���ñ߿��
		hints.put(EncodeHintType.MARGIN, 2);
		
		//���ɶ�ά��
		try {
			//ָ����ά������
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			//ָ������ͼƬ�ı���·��
			Path file = new File("D:/"+goodsName+".png").toPath();
			//���ɶ�ά��
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
