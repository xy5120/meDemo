package com.xy5120.main;

import java.io.File;

import com.xy5120.util.FileUtils;

public class FileDemo {

	public static void main(String[] args) {
		//A1-装饰Z100_4#厂房一层原建筑图
		//图号
		String[] pictureNumber= {"A0","A1","A2","A2+1"};
		//开始的序号
		int startNumber=1;
		//图名
		String[] name= {"原建筑图","平面布置图","机电点位图","隔墙尺寸图","管道井点位图","地坪尺寸图","顶棚布置图","灯具定位图","立面索引图","门表索引图"};
		//格式名
		//String fileFormat="pdf";
		//拼接文件名
		//
		//System.out.println(newFileName);
		//要命名的文件夹位置
		String path="C:\\Users\\xy\\Desktop\\2019.03.21沐家护理院施工图最终版PDF";
		//保存的文件夹路径
		String newPath=path+File.separator+"重命名文件";
		File newPakage = new File(newPath);
		newPakage.mkdirs();
		
		File file = new File(path);
		
		//如果不是文件夹就结束程序
		if(!file.isDirectory()) {
			System.out.println("路径不是文件夹");
			System.exit(0);
		}
		File[] listFiles = file.listFiles();
//		for (File f : listFiles) {
		for (int i=0;i<10;i++) {
			//获取文件格式
			String fileFormat = FileUtils.getFileFormat(listFiles[i]);
			//开始复制
			String newFileName=pictureNumber[0]+"-装饰Z"+String.format("%03d", startNumber)+"_4#厂房一层"+name[i]+"."+fileFormat;
			//System.out.println(newPath+File.separator+newFileName);
			boolean flog = FileUtils.CopyFile(listFiles[i], new File(newPath+File.separator+newFileName));
			if(flog) {
				System.out.println("错误：第"+i+"个文件重命名失败，文件名是："+listFiles[i].getName());
			}
			startNumber++;
		}
		
		/*
		
		// TODO Auto-generated method stub
		String path="D:\\0.mp3";
		String newPath="D:\\1.mp3";
		//FileUtils.copyFile(path, newPath);
		File f=new File(path);
		boolean isDir = f.isDirectory();
		if(isDir) {
			File[] listFiles = f.listFiles();
			for (File file : listFiles) {
				if(file.isFile()) {
					file.delete();
				}
			}
		}*/
	}

}
