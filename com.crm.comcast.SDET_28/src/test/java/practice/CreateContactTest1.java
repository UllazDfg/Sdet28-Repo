package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class CreateContactTest1 {
	/**
	 * Author Ullas OU
	 * @param args
	 * @throws Throwable
	 */
	
		public static void main(String[] args) throws Throwable {
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
			
				//Open application
			
				driver.get(url);
				String title = driver.findElement(By.xpath("//div[text()='Powered by vtiger CRM - 5.4.0']")).getText();
				System.out.println(title);
			    //eUtil.writeDataIntoExcel("Sheet1", 4, 6, title);
				
				//Login to application
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				System.out.println("login Pass");
				
				WebElement mOver = driver.findElement(By.linkText("Contacts"));
			    wUtil.mouseOver( driver, mOver);
			    mOver.click();
			    
			    String homeText = driver.findElement(By.className("hdrLink")).getText();
				System.out.println("contacts Pass");
				System.out.println(homeText);
				
				
				
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("button")).click();
				String popUpmessage = driver.switchTo().alert().getText();
				
				
				System.out.println(popUpmessage);
				/*String expected = eUtil.getStringCellData("Sheet1", 11, 3);
				if(popUpmessage.equals(expected)) {
				
					System.out.println("Pop-Up Message verification Passed");
				}else {
					
				System.out.println("Pop-up message verification Failed");*/
				
				
				driver.quit();
	}
		}

