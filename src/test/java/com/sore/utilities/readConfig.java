package com.sore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties prop;
	String path="C:\\Users\\abhijain\\eclipse-workspace\\StoreTest\\Configuration\\config.properties";
	
	public readConfig()
	{
		try {
		prop = new Properties();
		
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBaseUrl() {
		String value = prop.getProperty("baseurl");
		
		if (value!=null)
			return value;
		else
			throw new RuntimeException ("No value in URL in config fle");
	}
	
	public String getbrowser() {
		String value = prop.getProperty("browser");
		
		if (value!=null)
			return value;
		else
			throw new RuntimeException ("No value in URL in config fle");
	}

}
