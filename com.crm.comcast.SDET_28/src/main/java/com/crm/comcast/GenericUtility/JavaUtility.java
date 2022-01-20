package com.crm.comcast.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	 
		
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
	}
	
		
		
		public String systemDateAndTime() {
			Date date = new Date();
			String dateAndTime = date.toString();
			return dateAndTime;
		}
}
