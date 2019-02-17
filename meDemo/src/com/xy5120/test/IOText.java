package com.xy5120.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOText {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//File file=new File("zzx.txt");
		File file=new File("D:\\0.mp3");
		System.out.println(file.getName());
		System.out.println("getAbsolutePath:"+file.getAbsolutePath());
		System.out.println("getParent:"+file.getParent());
		System.out.println("getParentFile:"+file.getParentFile());
		System.out.println("getAbsoluteFile:"+file.getAbsoluteFile());
		System.out.println("getPath:"+file.getPath());
		System.out.println("getFreeSpace:"+file.getFreeSpace());
		System.out.println("getTotalSpace:"+file.getTotalSpace());
		//demo1();
	}
	public static void demo1() throws IOException{
		String path="D:\\workspace\\SSMPro";
		String copyPath="D:\\workspace\\SSMProCopy";
		
		File f=new File(path);
		File cf=new File(copyPath);
		if(!cf.exists()){
			cf.mkdirs();
		}
		
		File[] files = f.listFiles(new MyFilter());
		for (File file : files) {
			System.out.println(file.getParentFile());
			if(file.isDirectory()){
				//源目录
				String dir=path+File.separator+file.getName();
				//目标目录
				//String copyDir=copyPath+File.separator+file.getName();
				copyDir(dir,copyPath);
			}else{
				File copyFile=new File(cf,file.getName());
				copyFile(file,copyFile);
			}
		}
	}
	
	
	public static void copyDir(String dir,String copyDir) throws IOException{
		File f=new File(dir);
		File cf=new File(copyDir);
		//cf.mkdirs();
		File[] files = f.listFiles(new MyFilter());
		for (File file : files) {
			if(file.isDirectory()){
				//源目录
				String d=dir+File.separator+file.getName();
				//目标目录
				//String cd=copyDir+File.separator+file.getName();
				copyDir(d,copyDir);
			}else{
				File copyFile=new File(cf,file.getName());
				copyFile(file,copyFile);
			}
		}
	}
	public static void copyFile(File file,File copyFile) throws IOException{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(copyFile));
		byte[] buf=new byte[1024];
		int len=-1;
		while((len=bis.read(buf))!=-1){
			bos.write(buf, 0, len);
		}
		bis.close();
		bos.close();
			
		
	}
}
