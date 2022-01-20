package ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.objectRepository.CreateContactPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
/**
 * Create Contact and Fetch data  From Excel and Confirm the Organization name
 * @author ULLAS
 *
 */

public class CreateContactPageUsingTestNGTest2 extends BaseClass{

	@Test
	public void CreateContactTest() throws Throwable {
		
	//LoginPage login = new LoginPage(driver);
	
	CreateContactPage contacts= new CreateContactPage(driver);
	
	//generate random number
	int randomNumber = jUtil.getRandomNumber();
	
	//get data from excel sheet
	String ExpectedLastName = eUtil.getStringCellData("sheet1", 5, 2);
	ExpectedLastName= ExpectedLastName+randomNumber;
	
	//To Move the cursor to contacts and click on contacts
	
	wUtil.mouseOver(driver, contacts.getContactsLink());
	contacts.getContactsLink().click();
	
	//To click on create contact Button
	contacts.getPlusButtonCreateContact().click();
	
	
	
	System.out.println(ExpectedLastName);
	contacts.getLastName().sendKeys(ExpectedLastName);
	contacts.getOrganizationButton().click();
	
	
	
	 wUtil.switchToWindow(driver, "George Projects");
	 wUtil.waitForPageLoad(driver);
	
	driver.findElement(By.name("button")).click();
	WebElement headText = contacts.getHeadText();
	System.out.println(headText);

	OrganizationInformationPage orgInfo= new OrganizationInformationPage(driver);
	String actualOrgName = orgInfo.getOrgNameText();
	
	String ExpectedorganizationName = orgInfo.getOrgNameText();
	
	//organization name verification
	if(actualOrgName.contains(ExpectedorganizationName)) {
		System.out.println("organization is created");
	}else {
		System.out.println("Organization is not created");
}

	
}
}
