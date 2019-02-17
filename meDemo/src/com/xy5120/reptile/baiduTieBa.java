package com.xy5120.reptile;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.xy5120.util.FileUtil;

public class baiduTieBa {

	/**
	 *  Description:
	 *  @author xy  DateTime 2018-12-6 下午11:41:42
	 *  @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//贴吧地址
		//String url="https://tieba.baidu.com/p/5920477877";
		String url="https://tieba.baidu.com/p/5957448697";
		//保存路径
		String path="C:\\Users\\xy\\Desktop\\baidu\\tieba";
		
		Document doc = Jsoup.connect(url).get();
		//获取标题用作文件夹
		String title=doc.getElementById("j_core_title_wrap").child(1).text();
		//获取页数
		Elements lReplyNum = doc.getElementsByClass("l_reply_num");
		String strPage = lReplyNum.get(0).child(1).text();
		System.out.println("标题："+title+"此贴共有"+strPage+"页");
		//以贴吧名作为文件夹名
		String savePath=path+File.separator+title;
		//判断保存得文件夹是否存在
		File file=new File(savePath);
		if(!file.exists()){
			file.mkdirs();
			//对每一页进行图片爬取
			for (int x=1;x<=Integer.parseInt(strPage);x++) {
				 getImage(url+"?pn="+x,savePath);
				 System.out.println("第"+x+"页图片下载完毕");
			}
		}else{
			System.out.println("文件夹已存在，看看是不是已经爬过了");
		}
		
		
		
	}

	static void getImage(String url,String savePath) throws IOException{
		Connection conn = Jsoup.connect(url);
		conn.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.6788.400 QQBrowser/10.3.2727.400");
		Document doc = conn.get();
		//Document doc = Jsoup.connect(url).get();
		Elements eImages = doc.getElementsByClass("BDE_Image");
		for (Element element : eImages) {
			String image = element.attr("abs:src");
			boolean downURLFile = FileUtil.downURLFile(image, savePath+File.separator+FileUtil.getFileName(image)+"."+FileUtil.getTypePart(image));
			if(downURLFile){
				//System.out.println("下载"+FileUtil.getFileName(image)+"."+FileUtil.getTypePart(image)+"成功");
			}else{
				System.out.println("下载"+FileUtil.getFileName(image)+"."+FileUtil.getTypePart(image)+"，失败。");
			}
		}
	}
	
}
