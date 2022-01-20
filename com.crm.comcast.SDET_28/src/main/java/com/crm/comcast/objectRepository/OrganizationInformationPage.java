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
public class OrganizationInformationPage {

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="account_name")
	private String orgNameText;
	
	public String getOrgNameText() {
		return orgNameText;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;

	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	/**
	 * It will return the organization information text
	 * @return
	 */
	public String getOrgInformationText() {
		return orgInfoText.getText();
	}
		
	}
	

