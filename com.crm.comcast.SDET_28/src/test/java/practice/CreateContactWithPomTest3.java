package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathContants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateContactPage;
import com.crm.comcast.objectRepository.LoginPage;

public class CreateContactWithPomTest3 {

	public static void main(String[] args) throws Throwable {
		
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
		int ran = jUtil.getRandomNumber();
		
		System.out.println(lastName);
		contacts.getLastName().sendKeys(lastName+ran);
		contacts.getOrganizationButton().click();
		
		
		
		 wUtil.switchToWindow(driver, "George Projects");
		 wUtil.waitForPageLoad(driver);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,250)");
		// driver.findElement(By.xpath("//input[@type='file']")).click();
		 /* WebElement chooseFile = contacts.getImageUpload();
		 chooseFile.sendKeys("C:\\Users\\ULLAS.DESKTOP-28VPC6Q\\OneDrive\\Desktop\\osho-by-kunal-bansal-chandigarh.png");*/

	}

}
