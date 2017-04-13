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
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 直接在struts.xml文件中配置的属性
	private String savePath ;
	
	VegetableDAO vsDao = new VegetableDAOImp();
	VegetableDAO winDao = new WinDAOImp();
	// 接受struts.xml文件配置值的方法
	public void setSavePath(String value){ 
	
		this.savePath = value;
	}
	// 获取上传文件的保存位置
	private String getSavePath() throws Exception
	{
		return savePath;
	}

	// upload的setter和getter方法
	public void setUpload(File upload)
	{
		this.upload = upload;
	}
	public File getUpload()
	{
		return (this.upload);
	}

	// uploadContentType的setter和getter方法
	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}
	public String getUploadContentType()
	{
		return (this.uploadContentType);
	}

	// uploadFileName的setter和getter方法
	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
	public String getUploadFileName()
	{
		return (this.uploadFileName);
	}

	
	public void upload() {
	
		// 以服务器的文件保存地址和原文件名建立上传文件输出流
		System.out.println("我进了upload了啊啊啊啊");
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
	
	//初始化请求的信息
	public void init(){
		System.out.println("这个到底执行了没有啊");
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
		AlllInfoVegetable alllInfoVegetable = new AlllInfoVegetable(goodsname, goodsdesc, strprice, uploadFileName);
		vsDao.save(alllInfoVegetable);
	}
	public void insertWin(){
		AlllInfoVegetable alllInfoVegetable = new AlllInfoVegetable(goodsname, goodsdesc, strprice, uploadFileName);
		winDao.save(alllInfoVegetable);
	}
	public String uploadvs(){
		init();
		System.out.println("初始化结束");
		upload();
		if (type.equals("1")) {
			System.out.println("我要添加菜表了啊");
			insertVs();
		}else{
			System.out.println("我添加酒水了啊");
			insertWin();
		}
		return "uploadvs_success";
	}
	
	
}