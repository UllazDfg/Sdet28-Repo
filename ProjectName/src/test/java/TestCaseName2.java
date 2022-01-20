

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCaseName2 {

	@Test 
	public void create() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Random random = new Random();
		int ranVal = random.nextInt(1000);
String ranData=Integer.toString(ranVal);
		
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		
		driver.findElement(By.name("accountname")).sendKeys("sdet28"+ranData);
	//	driver.findElement(By.name("industry")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("img[@src='themes/softed/images/user.PNG")));
		
		WebElement sel = driver.findElement(By.name("industry"));
		Select select = new Select(sel);
		select.selectByVisibleText("Banking");
		
		
		
		driver.findElement(By.name("button")).click();
  		
		
		WebElement icon = driver.findElement(By.xpath("img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).perform();
		driver.findElement(By.className("drop_down_usersettings")).click();
		
		
		driver.quit();
		
	}

}
