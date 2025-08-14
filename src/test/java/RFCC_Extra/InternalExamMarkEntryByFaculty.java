package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class InternalExamMarkEntryByFaculty extends BaseClass
{

	ExtentReports reports;
	ExtentTest test;
	

	  @BeforeMethod
	  public void launchBrowser(Method m) throws Exception 
	  {
			driver = Browser.openBrowser("url_RF_LoginAdmin");
			System.out.println("\n" + " *****Starting Test : " + m.getName() + "*******" + "\n");
	  }
	  

	  @BeforeTest
	  public void configureReport() 
	  {
			reports = Reports.createReport();
	  }
	  
  @Test
  public void InternalExamMarkEntrybyFaculty() throws InterruptedException, IOException 
  {
	    test = reports.createTest("AdminExamination_MarkEntry");

		//Login to website
		RF_AdminLoginPage.loginPage(); 
		
		Thread.sleep(2000);
		
		//Move to Examination 
		WebElement exam = driver.findElement(By.partialLinkText("EXAMINATION"));
		Actions action = new Actions(driver);
		action.moveToElement(exam).perform();
		System.out.println("Hover on Examination in Navigation Bar");
		Thread.sleep(2000);
		
		//Click on Mark Entry
		driver.findElement(By.partialLinkText("Mark Entry")).click();
		System.out.println("Click on Mark Entry option");
		Thread.sleep(2000);
		
		//Click on Internal Exam Mark Entry by Faculty in sub Menu
		WebElement sub_option = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",sub_option);
		System.out.println("Click on Internal Exam Mark Entry by Faculty from sub menu");
		Thread.sleep(2000);
		
		//Select Session
		Select session = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		session.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Select Session");
		Thread.sleep(2000); 
		
 		//Select Course Type
		Select course = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubjectType")));
		course.selectByVisibleText("Theory with Tutorial");
		System.out.println("Select Course Type");
		Thread.sleep(2000);
		
		//Click on Course Name
		driver.findElement(By.partialLinkText("COC 3201~INCOME TAX LAW & PRACTICE - II(SEM:VI- SECTION:B- BRANCH:General)")).click();
		System.out.println("Click on Course Name");
		Thread.sleep(2000);
		
 		//Select Exam
		Select examname = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExam")));
		examname.selectByVisibleText("CAT-1");
		System.out.println("Select Course Type");
		Thread.sleep(2000);
		 
 		//Select Sub Exam
		Select subexamname = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubExam")));
		subexamname.selectByVisibleText("TEST1 + ASSIGNMENT1");
		System.out.println("Select Sub Exam");
		Thread.sleep(2000);
		
		//Click on Show Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("Click on Show Button");
		Thread.sleep(2000);
		
		//Click on Print Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintReport")).click();
		System.out.println("Click on Print Button");
		Thread.sleep(2000);
		
		//Take Screenshot of report window
		switchToNextWindow();
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Take Screenshot");
  }


}
