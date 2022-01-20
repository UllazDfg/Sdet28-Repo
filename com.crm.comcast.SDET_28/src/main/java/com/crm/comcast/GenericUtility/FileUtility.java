package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
public String getPropertyFileData(String key) throws Throwable {
		
		FileInputStream file = new FileInputStream(IPathContants.PROPERTY_FILEPATH);
		Properties property = new Properties();
		property.load(file);
		return property.getProperty(key);
}

}
