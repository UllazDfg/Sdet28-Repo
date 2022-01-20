package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathContants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateContactPage;
import com.crm.comcast.objectRepository.LoginPage;

public class CreateContactWithPomTest1 {

	public static void main(String[] args) throws Throwable {
		// create Object for Utilities
		
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String browserName = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		// use browser value and launch browser
		WebDriver driver = null;
		System.setProperty(IPathContants.CHROME_KEY, IPathContants.CHROME_PATH);
		driver= new ChromeDriver();
		driver.get(url);
		
		wUtil.waitForPageLoad(driver);
		String title = driver.getTitle();
		System.out.println(title);
		
		
		//login to Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
	
		CreateContactPage contacts = new CreateContactPage(driver); 
		
		wUtil.mouseOver(driver, contacts.getContactsLink());
		contacts.getContactsLink().click();
		contacts.getPlusButtonCreateContact().click();
		contacts.getSaveButton().click();
		String popUpText = wUtil.getPopUpText(driver);
		
		System.out.println(popUpText);
		
		
		driver.quit();
		
	}
	
}
