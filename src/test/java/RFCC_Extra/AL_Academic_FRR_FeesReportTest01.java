package RFCC_Extra;

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

public class AL_Academic_FRR_FeesReportTest01 extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

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
	public void aL_Academic_FRR_FeesReportTest() throws Exception {
		
		test = reports.createTest("AL_Academic_FRR_FeesReportTest");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC->Fees Related Reports->Fees Report"); 
		
		Thread.sleep(2000);
		//Click Main Academic menu
		WebElement link_acad = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_acad).perform();
		
		Thread.sleep(2000);
		//Click Fees Related Report Submenu
		WebElement link_FRR = driver.findElement(By.linkText("Fees Related Reports"));
		System.out.println("Fees Related Reports submenu selected");
		action.moveToElement(link_FRR);
		action.click().build().perform();
		
		Thread.sleep(2000);
		//Click Fees Report Page
		WebElement link_FR = driver.findElement(By.linkText("Fees Report"));
		link_FR.click();
		System.out.println("click fees Report");
		
		Thread.sleep(2000);
		//Select Report type
		WebElement report = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReport"));
		Select typ_report = new Select(report);
		typ_report.selectByVisibleText("Show Data");
		System.out.println("Report - Show Data");
		
		Thread.sleep(3000);
		WebElement AcademicYear = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAcdYear"));
		Select typ_AcademicYear = new Select(AcademicYear);
		typ_AcademicYear.selectByVisibleText("2023-2024");
		System.out.println("Academic Year -> 2023-2024");
	
	    Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //Enter From Date
	    js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox1")), "05/12/2023");
	    System.out.println("From Date -> 05/12/2023");

	    Thread.sleep(2000);
	    //Enter To Date
	    js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox2")), "22/01/2024");
	    System.out.println("To Date -> 22/01/2024");

	    Thread.sleep(3000);
		//Select Degree
		WebElement degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Select typ_degree = new Select (degree);
		typ_degree.selectByVisibleText("Bachelor of Architecture");
		System.out.println("Degree - Bachelor of Architecture");
		
		Thread.sleep(3000);
		//Select Branch
		WebElement branch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Select typ_branch = new Select (branch);
		typ_branch.selectByVisibleText("Architecture");
		System.out.println("Select Program/Branch -> Architecture");
		
		Thread.sleep(2000);
		//Receipt Type
		WebElement rec = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo"));
		rec.click();
		System.out.println("Receipt Type CheckBox -> Admission Fee");

		Thread.sleep(2000);
		//Click on show button
		WebElement btn_show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		btn_show.click();
		System.out.println("Click on Show Data button");
		
		//Scroll bar code is required here
		

		Thread.sleep(4000);
		Screenshot.takesScreenshot(getCurrentDateAndTime()); 
	
	}



}
