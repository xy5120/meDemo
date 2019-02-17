package com.xy5120.test;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.xy5120.util.MD5Util;



public class Text {

	private static Logger logger=Logger.getLogger(Text.class);
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	
	/**
	 *  Description:
	 *  @author xy  DateTime 2018-12-6 下午05:19:09
	 *  @param args
	 *  @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="hello";
		String md5Encode = MD5Util.MD5Encode(str,null);
		System.out.println(md5Encode);
		//demo11();
		
	}
	private static void demo11() {
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(1);
		set.add(3);
		set.add(4);
		set.add(5);
		for (Integer integer : set) {
			System.out.println(integer);
		}
		System.out.println(set.toString());

		// 记录debug级别的信息  
	        logger.debug("This is debug message.");  
	        // 记录info级别的信息  
	        logger.info("This is info message.");  
	        // 记录error级别的信息  
	        logger.error("This is error message."); 
		
		logger.error("cuowu");
	}

}
