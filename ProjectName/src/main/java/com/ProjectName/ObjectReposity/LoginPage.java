package com.ProjectName.ObjectReposity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement userNameTxtBox;
	
	@FindBy(name = "user_password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserNameTxtBox() {
		return userNameTxtBox;
	}


	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	
	//Business Lib
	
	public void loginClick() {
		userNameTxtBox.sendKeys("admin");
		passwordTxtBox.sendKeys("admin");
		submitBtn.click();
	}
	
	
}
