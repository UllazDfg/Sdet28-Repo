package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginClass {
	void Login() throws Throwable
	{
		

	FileInputStream Fis = new FileInputStream("./src/test/resources/data.properties");
	Properties property = new Properties();
	property.load(Fis);
	
	String browserName = property.getProperty("browser");
	String url = property.getProperty("url");
	String username = property.getProperty("username");
	String password = property.getProperty("password");
	
	// use browser value and launch browser
	WebDriver driver = null;
	
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("login Pass");

}
}
