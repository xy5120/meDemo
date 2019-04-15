package com.xy5120.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetUserProperties {

	public static void main(String[] args) throws IOException {
		String path="user.properties";
		Properties prop=getPIO(path);
		prop.setProperty("name", "zs");
		prop.setProperty("age", "ls");
		
	}
	public static Properties getPIO(String path) throws IOException {
		InputStream is=new FileInputStream(new File(path));
		Properties prop=new Properties();
		prop.load(is);
		return prop;
	}

}
