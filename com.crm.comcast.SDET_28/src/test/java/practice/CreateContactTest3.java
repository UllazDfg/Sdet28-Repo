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

public class CreateContactTest3 {

	
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
				//String hpTilte= driver.getTitle(); 
				eUtil.writeDataIntoExcel("TestReport", 4, 6, "hpTitle");
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				System.out.println("login Pass");
				WebElement contact = driver.findElement(By.linkText("Contacts"));
				Actions action = new Actions(driver);
				action.moveToElement(contact).perform();
				System.out.println("contacts Pass");
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys("Premanand");
				driver.findElement(By.name("imagename")).click();
	}

}
