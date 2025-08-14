package ConfigurationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Configuration_CreateNoticeNews extends BaseClass {
	private WebDriver driver;

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	


	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void aL_Configuration_CreateNoticeNews() throws Exception {

		System.out.println("Configuration->Create Notice/News");

		test = reports.createTest("aL_Configuration_CreateNoticeNews ");
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		
		
		
		RF_AdminLoginPage.loginPage();
		System.out.println("Configuration menu selected");
		HP.CONFIGURATION();
		Thread.sleep(3000);
		Thread.sleep(3000);
		// Locating the element from Sub Menu
		WebElement con_notice = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:2\"]/li[2]/a")); // create
																												// notice/news
		System.out.println("Configuratoin-create notice/news submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(con_notice);
		action.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd")).click();
		System.out.println("select add-new notice");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTitle")).sendKeys("Automation Testing News");
		Thread.sleep(3000);
		System.out.println("select notice title");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtExpiryDate")).sendKeys("31-01-2024");
		Thread.sleep(3000);
		System.out.println("select notice date");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_chklUserType_0")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("ftbDesc_ifr");
		Thread.sleep(3000);
		System.out.println("select checkbox of user-type");
		driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Notice for Testing");
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); 
		Thread.sleep(3000);
		System.out.println("select notice paragraph");
		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		Thread.sleep(3000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", submit);
		
		Thread.sleep(3000);
		submit.click();
		

		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Record Saved Successfully";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(3000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

		// code for deleting added record
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"form-control form-control-sm\"]")).sendKeys("Automation");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvNotice_ctrl0_btnDelete")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel")).click();

	}
}
