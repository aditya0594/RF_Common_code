package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Administration_SRM_Transaction_ServicstatusreportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n"); 
	}

	@Test
	public void aL_Administration_SRM_Transaction_ServicstatusreportTest() throws Exception {
		test = reports.createTest("aL_Administration_SRM_Transaction_ServicstatusreportTest");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Administration->Service Request Management->Transaction->Service Status Report");
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement adminTrans = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[10]/a"));
		System.out.println("Administration menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(adminTrans).perform();
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Admin_ServiceRequestSubMenu = driver.findElement(By.linkText("Service Request Management"));
		// Admin_ServiceRequestSubMenu.click();
		System.out.println("Administration Service Request Management submenu selected");
		action.moveToElement(Admin_ServiceRequestSubMenu).perform();
		Thread.sleep(2000);
		
		WebElement ServiceRequest_ReportSubMenu =
		driver.findElement(By.linkText("Reports"));
		System.out.println("Reports");
		action.moveToElement(ServiceRequest_ReportSubMenu);
		action.click().build().perform(); Thread.sleep(2000);
		  
		  
		WebElement servicestatsreport = driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink"));
		System.out.println("Service Status report");
		action.moveToElement(servicestatsreport);
		action.click().build().perform(); Thread.sleep(2000);

		//start date  
		WebElement startdate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSDate"));
		startdate.clear();
		Thread.sleep(2000); 
				  
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImgBntCalc")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_0_1")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_1")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_6")).click(); 
	
		Thread.sleep(3000); 
		 		  
		System.out.println("Click on show Report");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click(); 

		switchToNextWindow();
		Screenshot.takesScreenshotReports(getCurrentDateAndTime()); 
		
		captureScreenshot(driver, "Service request report");
		System.out.println("Take Screenshot with Name");
		
		
  }
		
}
