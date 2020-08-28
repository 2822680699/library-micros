package com.wonders.library.common.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	private static Properties config = new Properties();

	static{
		ClassPathResource _host = new ClassPathResource("config.properties");
		try{
			config.load(_host.getInputStream());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String str) {
		return config.getProperty(str);
	}

}
