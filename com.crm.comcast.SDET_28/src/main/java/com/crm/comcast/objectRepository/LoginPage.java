
package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author ULLAS
 *
 */
public class LoginPage {
	//element initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//element identification or declaration
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name ="user_password")
	private WebElement passwordTextFields;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='poweredBy']")
	private WebElement loginPageText;
	
	
	
	//getters methods

	public WebElement getLoginPageText() {
		return loginPageText;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextFields() {
		return passwordTextFields;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//businesss logic for login action
	/**
	 * This method will perform application login action
	 * 
	 */
	public void loginToApplication(String userName, String password) {
		usernameTextField.sendKeys(userName);
		passwordTextFields.sendKeys(password);
		loginButton.click();
	}
	
	
	
	}

