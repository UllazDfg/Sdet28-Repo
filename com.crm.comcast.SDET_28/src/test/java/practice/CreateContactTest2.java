package practice;
import practice.LoginClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
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

public class CreateContactTest2 {
	
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
				

			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			System.out.println("login Pass");

			WebElement mOver = driver.findElement(By.linkText("Contacts"));
		    wUtil.mouseOver( driver, mOver);
		    mOver.click();
		    
			System.out.println("contacts Pass");
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
			driver.findElement(By.name("lastname")).sendKeys("Maj Singh");
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			
			
			
			
			
			
		    
		    
		    
			driver.findElement(By.linkText("George Projects")).click();
			driver.findElement(By.name("button")).click();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			String conText = driver.findElement(By.className("//input[@title='Save [Alt+S]']")).getText();
			
			String expected = eUtil.getStringCellData("Sheet1", 27, 3);
			if(conText.equals(expected)) {
				System.out.println("Contact information passed");
				
			}else {
				System.out.println("Contact information Failed");
			}
			}


}
