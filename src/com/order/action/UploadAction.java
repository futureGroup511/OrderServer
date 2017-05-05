package com.order.action;

import java.io.*;

import com.order.dao.VegetableDAO;
import com.order.dao.impl.VegetableDAOImp;
import com.order.dao.impl.WinDAOImp;
import com.order.domain.AlllInfoVegetable;


public class UploadAction extends SuperAction {
	
	private static final long serialVersionUID = 1L;
	
	private String goodsname;
	
	private String strprice;
	
	private String goodsdesc;
	
	private String type;
	// ��װ�ϴ��ļ��������
	private File upload;
	// ��װ�ϴ��ļ����͵�����
	private String uploadContentType;
	// ��װ�ϴ��ļ���������
	private String uploadFileName;
	// ֱ����struts.xml�ļ������õ�����
	private String savePath ;
	
	VegetableDAO vsDao = new VegetableDAOImp();
	VegetableDAO winDao = new WinDAOImp();
	// ����struts.xml�ļ�����ֵ�ķ���
	public void setSavePath(String value){ 
	
		this.savePath = value;
	}
	// ��ȡ�ϴ��ļ��ı���λ��
	private String getSavePath() throws Exception
	{
		return savePath;
	}

	// upload��setter��getter����
	public void setUpload(File upload)
	{
		this.upload = upload;
	}
	public File getUpload()
	{
		return (this.upload);
	}

	// uploadContentType��setter��getter����
	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}
	public String getUploadContentType()
	{
		return (this.uploadContentType);
	}

	// uploadFileName��setter��getter����
	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
	public String getUploadFileName()
	{
		return (this.uploadFileName);
	}

	
	public void upload() {
	
		// �Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
		System.out.println("�ҽ���upload�˰�������");
		try {
			FileOutputStream fos = new FileOutputStream(getSavePath()
				+ "\\" + getUploadFileName());
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0)
			{
				fos.write(buffer , 0 , len);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	//��ʼ���������Ϣ
	public void init(){
		System.out.println("����������ִ����û�а�");
		goodsname = reques.getParameter("goodsname");
		goodsdesc = reques.getParameter("goodsdesc");
		strprice = reques.getParameter("price");
		type = reques.getParameter("type");
		System.out.println(type+"********************");
		System.out.println(goodsname+"**************");
		System.out.println(goodsdesc);
		System.out.println(uploadFileName);
		System.out.println(strprice+"*******");
		
	}
	
	public void insertVs(){
		System.out.println("--vs");
		AlllInfoVegetable alllInfoVegetable = new AlllInfoVegetable(goodsname, goodsdesc, strprice, uploadFileName);
		vsDao.save(alllInfoVegetable);
	}
	public void insertWin(){
		System.out.println("--win");
		AlllInfoVegetable alllInfoVegetable = new AlllInfoVegetable(goodsname, goodsdesc, strprice, uploadFileName);
		winDao.save(alllInfoVegetable);
	}
	public String uploadvs(){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		init();
		System.out.println("��ʼ������");
		upload();
		if (type.equals("1")) {
			System.out.println("��Ҫ��Ӳ˱��˰�");
			insertVs();
		}else{
			System.out.println("����Ӿ�ˮ�˰�");
			insertWin();
		}
		return "uploadvs_success";
	}
	
	
}