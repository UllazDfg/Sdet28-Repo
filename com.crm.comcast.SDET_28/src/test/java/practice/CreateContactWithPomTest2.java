package practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathContants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateContactPage;
import com.crm.comcast.objectRepository.LoginPage;

public class CreateContactWithPomTest2 {
	
	public static void main(String[]args) throws Throwable {
	FileUtility fUtil = new FileUtility();
	JavaUtility jUtil = new JavaUtility();
	ExcelUtility eUtil = new ExcelUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	String BrowserName = fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	String userName = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	
	
	WebDriver driver = null;
	System.setProperty(IPathContants.CHROME_KEY,IPathContants.CHROME_PATH);
	driver = new ChromeDriver();
	driver.get(url);
	String title = driver.getTitle();
	System.out.println(title);
	
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(userName, password);
	
	CreateContactPage contacts= new CreateContactPage(driver);
	
	
	wUtil.mouseOver(driver, contacts.getContactsLink());
	contacts.getContactsLink().click();
	contacts.getPlusButtonCreateContact().click();
	
	
	String lastName = eUtil.getStringCellData("Sheet1", 25, 2);
	System.out.println(lastName);
	contacts.getLastName().sendKeys(lastName);
	contacts.getOrganizationButton().click();
	
	
	
	 wUtil.switchToWindow(driver, "George Projects");
	 wUtil.waitForPageLoad(driver);
	
	driver.findElement(By.name("button")).click();
	WebElement headText = contacts.getHeadText();
	System.out.println(headText);
	//driver.quit();
}

	
	}
