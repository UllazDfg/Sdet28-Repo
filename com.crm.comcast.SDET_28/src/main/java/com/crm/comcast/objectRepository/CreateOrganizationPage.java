package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	/**
	 * @author ULLAS
	 * @param driver
	 */
public CreateOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

@FindBy(name="accountname")
private WebElement organizationTextField;

@FindBy(name="button")
private WebElement saveButton;

//getters method

public WebElement getOrganizationTextField() {
	return organizationTextField;
}

public WebElement getSaveButton() {
	return saveButton;
}

/**
 * This method will create an organization
 */

public void createOrganization(String orgName) {
	organizationTextField.sendKeys(orgName);
	saveButton.click();


}
}
