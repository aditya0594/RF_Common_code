package ConfigurationTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;

public class AL_Configuration_UM_UpdateNewUserLinkTest {
	private WebDriver driver;
	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "******" + "\n");
	}
  
  @Test
  public void aL_Configuration_UM_UpdateNewUserLinkTest() throws Exception {
	  
	    test = reports.createTest("AL_Configuration_UM_UpdateNewUserLinkTest");
	    HP = new HomePageAdmin(driver);
		
	    Thread.sleep(5000);

		RF_AdminLoginPage.loginPage(); 
		
		
		System.out.println("CONFIGURATION->User Management->New User Link");
	  
	    Thread.sleep(5000);	  
	     // configuration 
	    System.out.println("Configuration menu selected");
	    Actions action = new Actions(driver);
	    Thread.sleep(2000);
		HP.CONFIGURATION();
		Thread.sleep(2000);

	  // Locating the element from Sub Menu
	    WebElement con_usermanage = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:2\"]/li[1]/a"));  // user management
	    System.out.println("Configuratoin-user management submenu selected");
	    action.moveToElement(con_usermanage);
	    action.click().build().perform();
	  
	    driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl07_lbLink\"]")).click(); 
	    System.out.println("New user link page selected");
	  
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlUserType-container")).click();
		Thread.sleep(5000);		  
	  
	    driver.findElement(By.className("select2-search__field")).sendKeys("Admin",Keys.ENTER);
		System.out.println("select user-type");
		Thread.sleep(1000);		  
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvlinks_ctl01_btnEdit")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvlinks_ctl01_btnEdit")));

		System.out.println("Click on edit icon");
		Thread.sleep(5000);	
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnSubmit\"]")).click(); 
		System.out.println("Link update successfully");
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Link(s) Updated successfully !!";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(5000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept(); 
		
}
}
