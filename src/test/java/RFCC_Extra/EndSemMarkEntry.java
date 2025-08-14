package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class EndSemMarkEntry extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;  
	
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
  public void EndsemMarkEntry() throws InterruptedException, IOException 
  {
	    test = reports.createTest("EndsemMarkEntry");
		Thread.sleep(2000);

		//Login to website 
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		//Move to Examination 
		WebElement exam = driver.findElement(By.partialLinkText("EXAMINATION"));
		Actions action = new Actions(driver);
		action.moveToElement(exam).perform();
		System.out.println("Hover on Examination in Navigation Bar");
		Thread.sleep(2000);
		 
		//Click on Mark Entry Option
		driver.findElement(By.partialLinkText("Mark Entry")).click();
		System.out.println("Click on Mark Entry option");
		Thread.sleep(2000);
		
		//Click on End Sem Mark Entry in sub Menu
		WebElement sub_option = driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",sub_option);
		System.out.println("Click on End Sem Mark Entry from sub menu");
		Thread.sleep(2000);
		
		//Select Session
		Select session = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		session.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Select Session");
		Thread.sleep(2000);
		
		//Click on Course Name
		driver.findElement(By.partialLinkText("COC 3201 - Income Tax Law & Practice - II")).click();
		System.out.println("Click on Course Name");
		Thread.sleep(2000);
		
		//Click on Format Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();
		System.out.println("Click on Format Button");
		Thread.sleep(2000);
		
		//Take Screenshot of report window
		switchToNextWindow();
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Take Screenshot");
		
		
  }
  
}
