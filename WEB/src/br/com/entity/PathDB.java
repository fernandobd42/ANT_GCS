package br.com.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathDB {
	
	public static String read() throws IOException
	{
		String db = "C:/Users/ferna/workspace/web2aps1ra1652745/res/db.properties";
		String result = "";
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(db);
		try{
			props.load(file);
		}catch(IllegalArgumentException e){
			System.out.println("Erro: "+e);
		}
		result = props.getProperty("file.db3");
		
		return result;
	}
	
}
