package com.ProjectName.ObjectReposity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText   = "Contacts")
	private WebElement contactLnk;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getContactLnk() {
		return contactLnk;
	}
	

}
