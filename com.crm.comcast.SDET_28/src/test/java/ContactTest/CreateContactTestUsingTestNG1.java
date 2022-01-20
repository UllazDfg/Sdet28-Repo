package ContactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.objectRepository.CreateContactPage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * This page will create contact using baseClass and pom
 * @author ULLAS
 *
 */
public class CreateContactTestUsingTestNG1 extends BaseClass {
	
	@Test
	public void CreateContact() throws Throwable {
		
				
		//login to Application
		LoginPage login = new LoginPage(driver);
		
		
		CreateContactPage contacts = new CreateContactPage(driver); 
		
		wUtil.mouseOver(driver, contacts.getContactsLink());
		contacts.getContactsLink().click();
		contacts.getPlusButtonCreateContact().click();
		contacts.getSaveButton().click();
		String popUpText = wUtil.getPopUpText(driver);
		String actualResult = eUtil.getStringCellData("Sheet1",1 , 4);
		String ExpectedResult = wUtil.getPopUpText(driver);
		//Hard Assert
		Assert.assertEquals(actualResult, ExpectedResult);
		
		System.out.println(popUpText);
		
		
		driver.quit();
		
}
}
