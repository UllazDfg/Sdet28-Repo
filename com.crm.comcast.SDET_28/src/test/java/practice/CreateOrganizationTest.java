package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathContants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
	
		//create object for utilities
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String browserName = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		
		//generate random number
		int randomNumber = jUtil.getRandomNumber();
		
		
		//get data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("Sheet1", 1, 2);
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
		
		//how to use browser value and launch the browser
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(IPathContants.CHROME_KEY, IPathContants.CHROME_PATH);
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			System.setProperty(IPathContants.FIREFOX_KEY,IPathContants.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}else {
			System.out.println("browser is not supported");
		}
			
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);
		
		//login to application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
		
		//create Organization
		HomePage homePage = new HomePage(driver);
		homePage.clickOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage= new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(ExpectedorganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		//organization name verification
		
		if(actualOrgName.contains(ExpectedorganizationName)) {
			System.out.println("Organization is created");
		}
	//logout action
		homePage.logout();
		//quit the browser
		driver.quit();
	}
}


