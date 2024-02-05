package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericUtils 
{
	public static String getPropertyValue(String filePath, String key) 
	{
		String value=null ;
		try 
		{
			FileInputStream fin = new FileInputStream(filePath) ;
			Properties prop = new Properties();
			prop.load(fin);
			value = prop.getProperty(key);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return value ;
	}
}
