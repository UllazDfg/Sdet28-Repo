package ContactTest;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrg() throws Throwable {
	//create object for Utilities
		
		
		
		//generate random number
		int randomNumber = jUtil.getRandomNumber();
		
		//get data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("sheet1", 1, 2);
		ExpectedorganizationName = ExpectedorganizationName+randomNumber;
		
		//create organization
		HomePage homePage=  new HomePage(driver);
		homePage.getOrganizationLink().click();
		
		 OrganizationPage createOrg = new OrganizationPage(driver);
		 createOrg.getCreateOrgPlusImage().click();
		
		
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(ExpectedorganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		//organization name verification
		if(actualOrgName.contains(ExpectedorganizationName)) {
			System.out.println("organization is created");
		}else {
			System.out.println("Organization is not created");
		}
	}
}
