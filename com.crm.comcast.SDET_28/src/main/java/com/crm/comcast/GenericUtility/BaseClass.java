package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * this is the base class this  contains the configuration and annotations
 * @author ULLAS
 *
 */
public class BaseClass {
public WebDriver driver;
public FileUtility fUtil = new FileUtility();
public WebDriverUtility wUtil = new WebDriverUtility();
public JavaUtility jUtil = new JavaUtility();
public ExcelUtility eUtil = new ExcelUtility();

@BeforeSuite(groups = {"smokeTest","reggressionTest"})
public void configBs() {
	//connection to db
	System.out.println("===Connect to DB==");
}
@Parameters("browser")
@BeforeClass(groups = {"smokeTest","reggressionTest"})
public void configBc() throws Throwable {
	//launching the browser
	String browser = fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	
	if(browser.equals("chrome")) {
		System.setProperty(IPathContants.CHROME_KEY, IPathContants.CHROME_PATH);
		driver = new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		System.setProperty(IPathContants.FIREFOX_KEY, IPathContants.FIREFOX_PATH);
		driver = new FirefoxDriver();
	}else {
		System.out.println("Browser not available");
	}
	driver.manage().window().maximize();
	wUtil.waitForPageLoad(driver);
	driver.get(url); 
	
}
@BeforeMethod
public void configBm() throws Throwable {
	String username = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(username, password);
}
@AfterMethod
public void configAm() {
	LoginPage login = new LoginPage(driver);
	
	
	//logout from application
	//homepage.logout();
	
}
@AfterClass
public void configAC() {
//closing or quiting the browser
	driver.quit();
}
@AfterSuite
public void configAS() {
	//closing the database connection
	System.out.println("===Daabase connection is closed");
}
}
