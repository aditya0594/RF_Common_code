package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;


public class AL_Academic_FR_ReprintOrCancelReceiptTest extends BaseClass{
	
		ExtentReports reports;
		ExtentTest test;
		HomePageAdmin HP;
		

		
		@BeforeTest
		public void configureReport() {
			reports=Reports.createReport();
		}
		
		@BeforeMethod
		public void launchBrowser(Method m) throws Exception {
			driver=Browser.openBrowser("url_RF_LoginAdmin");
			System.out.println("\n" + "*******Starting Test : " + m.getName() + "******" + "\n");
		}
		
		@Test
		
		public void aL_Academic_FR_ReprintOrCancelReceiptTest() throws Exception {
			test=reports.createTest("AL_Academic_FR_ReprintOrCancelReceiptTest");
			HP = new HomePageAdmin(driver);
			
			RF_AdminLoginPage.loginPage();
			
			System.out.println("Academic->Fee Related->Reprint or Cancel receipt");
			
			//Click on Academic
			Thread.sleep(2000);
			HP.Academic();
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			//Click on Fee Related
			WebElement subMenu = driver.findElement(By.partialLinkText("Fee Related"));
			action.moveToElement(subMenu);
			action.click().build().perform();
			System.out.println("Click on Fee Related");
			Thread.sleep(2000);
			
		    //Click on Reprint or Cancel receipt
		    driver.findElement(By.id("ctl00_repLinks_ctl10_lbLink")).click();
		    System.out.println("Click on Reprint or Cancel receipt");
		    
		    Thread.sleep(2000);
		    System.out.println("Search String -> 170101601014");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).sendKeys("170101601014");
		    
		    System.out.println("Click on Search Button");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch")).click();
		    
		    Thread.sleep(2000);
		    System.out.println("Student List -> Click on 1st Name -> KEERTHANA PRIYA. R");  ////
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")).click();
		    
		    Thread.sleep(2000);
		    System.out.println("Scroll down till Reprint Receipt button visible");
		    WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReprint"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();", Element);
		    
		    driver.findElement(By.id("rdoSelectRecord")).click();
		    System.out.println("Select Receipt No. -> BSACIST/20-06-2022/O/7009");
		    
		    Thread.sleep(2000);
		    System.out.println("Click on Reprint Receipt button");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReprint")).click();
		    
		    Thread.sleep(5000);
		    switchToNextWindow();
		    Screenshot.takesScreenshotReports(getCurrentDateAndTime());
	  }
		
		@AfterMethod
		public void getTestResult(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS, result.getName());
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getName());
			}
			else 
			{
				test.log(Status.SKIP, result.getName());
			}
		}
		
		@AfterTest
		public void publishResult() {
			reports.flush();
		}

	}