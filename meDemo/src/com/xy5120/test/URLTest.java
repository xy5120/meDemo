package com.xy5120.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.xy5120.util.FileUtil;

public class URLTest {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String url="https://www.baidu.com/";
//		String url="https://blog.csdn.net/weixin_41753022/article/details/79925683";
		//readURL(url);
		demoURL(url);
		
	}

	private static void demoURL(String url){
		String path ="C:\\Users\\xy\\Desktop\\baidu";
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		try {
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Element baiduImgNode = doc.getElementById("lg").child(0);
			System.out.println(baiduImgNode);
			String attr = baiduImgNode.attr("abs:src");
			System.out.println(attr);
			FileUtil.downURLFile(attr, path+File.separator+FileUtil.getFileName(attr)+"."+FileUtil.getTypePart(attr));
			/*Elements select = doc.select("img");
			for (Element element : select) {
				String attr = element.attr("abs:src");
				System.out.println(attr);
				FileUtil.downURLFile(attr, path+File.separator+"1.jpg");
				break;
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void readURL(String url) throws IOException {
		URL u=new URL(url);
		URLConnection conn = u.openConnection();
		conn.getInputStream();
		System.out.println(conn.getContentEncoding());
		System.out.println(conn.getContentType());
		InputStream is = u.openStream();
		
//		InputStreamReader isr = new InputStreamReader(is,"utf-8");
//		BufferedReader bfr = new BufferedReader(isr);
//		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d://index.html"))));
//		String text=null;
//		while((text=bfr.readLine())!=null){
//			bfw.write(text);
//			
//			bfw.write(LINE_SEPARATOR);
//		}
//		bfr.close();
//		isr.close();
		is.close();
//		bfw.close();
	}

}
