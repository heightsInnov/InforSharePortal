package com.ubn.ciss.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

	public static String getPropertiesValue(String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String retValue = "";
		// String config_path = System.getenv("WSCONFIG_HOME") + File.separator +
		// "wsconfig.properties";
		String WSCONFIG_HOME = "/u01/app/oracle/config/domains/weblogicexternal/properties";
		
		if (!new File(WSCONFIG_HOME).isDirectory()) {
			WSCONFIG_HOME = "C:/deploy";
		}
		String config_path = WSCONFIG_HOME + File.separator + "cbnciss.properties";
		System.out.println("Config found on=====" + config_path);
		try {
			input = new FileInputStream(config_path);
			prop.load(input);
			retValue = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
					prop.clear();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return retValue;
	}

}
