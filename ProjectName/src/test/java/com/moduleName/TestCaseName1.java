

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.ProjectName.ObjectReposity.LoginPage;

public class TestCaseName1 {

	public static void main(String[]args) {
		//Open the Browser
		WebDriver driver = new ChromeDriver();
		
		//Enter the Url
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
		//Login to the application
	
		//
		lp.loginClick();
		//perform required Action
		//Logout
		
		WebElement mouseOver = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseOver).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		//Close the browser
		driver.quit();
		
		
	}
}
