package com.xy5120.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *  Class Name: ServletUtil.java
 *  Description: servletd的工具类
 *  @author xy  DateTime 2018-12-6 下午06:40:25 
 *  @version 1.0
 */
public class ServletUtil {


	/**
	 * 360浏览器 =AppleWebKit
	 * 猎豹浏览器 =AppleWebKit
	 * 火狐=Firefox
	 * 搜狗=AppleWebKit
	 * qq浏览器=AppleWebKit
	 *  Description:校验浏览器
	 *  @author xy  DateTime 2018-12-6 下午07:07:32
	 *  @param UserAgent
	 *  @return
	 */
	public static boolean checkUserAgent(String UserAgent){
		boolean falg = false;
		if(UserAgent.indexOf("AppleWebKit")!=-1){
			falg = true;
		}
		if(UserAgent.indexOf("Firefox")!=-1){
			falg = true;
		}
		return falg;
	}
	
	/**
	 * 
	 *  Description:取得用户的ip地址
	 *  @author xy  DateTime 2018-12-6 下午06:52:00
	 *  @param request
	 *  @return
	 */
	public static String getRemoteAddress(HttpServletRequest request) {
		 String ip = request.getHeader("x-forwarded-for"); 
		 // System.out.println("x-forwarded-for ip: " + ip);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
	            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
	            if( ip.indexOf(",")!=-1 ){
	                ip = ip.split(",")[0];
	            }
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	            //  System.out.println("Proxy-Client-IP ip: " + ip);
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	            //  System.out.println("WL-Proxy-Client-IP ip: " + ip);
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_CLIENT_IP");  
	            //  System.out.println("HTTP_CLIENT_IP ip: " + ip);
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	            // System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("X-Real-IP");  
	           // System.out.println("X-Real-IP ip: " + ip);
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	            //  System.out.println("getRemoteAddr ip: " + ip);
	        } 
	        //System.out.println("获取客户端ip: " + ip);
	        return ip;  
	}
	
	/**
	 * 
	 *  Description:response设置编码，写出数据，并关流
	 *  @author xy  DateTime 2018-12-6 下午05:41:49
	 *  @param response
	 *  @param o
	 *  @throws Exception
	 */
	public static void write(HttpServletResponse response,Object o)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
