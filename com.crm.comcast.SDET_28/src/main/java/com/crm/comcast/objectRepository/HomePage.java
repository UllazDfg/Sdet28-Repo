package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.GenericUtility.WebDriverUtility;


/* * 
 * @author ULLAS
 *
 */

public class HomePage extends WebDriverUtility {
//initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	//declaration of elements
	@FindBy(linkText= "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	public WebDriver getDriver() {
		return driver;
	}

	//getters method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/**
	 * This Method will perform logout action
	 * 
	 */
	public void logout() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}

	public void clickOrganizationLink() {
		// TODO Auto-generated method stub
		
	}
}
