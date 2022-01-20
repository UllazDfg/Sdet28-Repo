package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	/**
	 * @author ULLAS
	 * @param driver
	 */
	
	
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	// Create Contact Plus Button
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusButtonCreateContact;
	

	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement organizationButton;
	//Save Button Click
	
	@FindBy(name="imagename")
	private WebElement imageUpload;
	


	public WebElement getImageUpload() {
		return imageUpload;
	}


	@FindBy(name = "button")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headText;
	
	
	
	





	public WebElement getHeadText() {
		return headText;
	}





	public WebElement getOrganizationButton() {
		return organizationButton;
	}





	public WebElement getLastName() {
		return lastName;
	}





	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getPlusButtonCreateContact() {
		return plusButtonCreateContact;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
