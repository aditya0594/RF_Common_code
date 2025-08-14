package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class Faculty_WorkLoad_Report extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting :" + m.getName() + "*******" + "\n");
	}

	@Test
	public void FacultyRelated_report() throws Exception {
		test = reports.createTest("FacultyRelated_report"); 
		Thread.sleep(2000);

		RF_FacultyLogin.loginPage();

		System.out.println("Faculty Logged in Successfully");
		Thread.sleep(2000);

		// Hover on Academin from navigation bar
		WebElement Cdcele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Faculty Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Cdcele).perform();

		// Locating the element from Sub Menu
		driver.findElement(By.linkText("Faculty Related")).click(); 
		System.out.println("Academic Faculty Related submenu selected");
		Thread.sleep(3000);

		WebElement faculty_rpt = driver.findElement(By.linkText("Faculty Workload Report"));
		faculty_rpt.click();
		System.out.println("Click on Faculty Work Load Report");

		Thread.sleep(2000);
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select colg_schm = new Select(colg); 
		colg_schm.selectByVisibleText("SSSH - B.Com.-Accounts and Finance-2017-18-Department of Commerce (Old Scheme)"); // SIS // BTech-Department // of // (Old // Scheme)
		Thread.sleep(2000);
		System.out.println(
				"Select college and Scheme : SSSH - B.Com.-Accounts and Finance-2017-18-Department of Commerce (Old Scheme)");

		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessn = new Select(session);
		sessn.selectByVisibleText("May 2022");
		System.out.println("Select Session : May 2022");
		Thread.sleep(3000);

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select sem = new Select(semester);
		sem.selectByVisibleText("II");
		System.out.println("Select Semester : II");
		Thread.sleep(3000);

		WebElement Course_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubjectType"));
		Select course = new Select(Course_typ);
		course.selectByVisibleText("Theory with Tutorial");
		System.out.println("Select Course Type : Theory with Tutorial"); 
		Thread.sleep(3000);

		System.out.println("Click on Calender icon to select From date"); //
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_dvcal1")).click(); // 01/01/2024
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_dvcal1")));

		Thread.sleep(2000);
		String Month_yr = driver.findElement(By.className("ajax__calendar_title")).getText();
		System.out.println(Month_yr);

		while (!(Month_yr.equals("January, 2022"))) { // while(!(Month_yr.equals("May, 2024"))) {
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_prevArrow")).click();
			Month_yr = driver.findElement(By.className("ajax__calendar_title")).getText();
		}

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_day_0_6")).click(); //// *[@id=\"ctl00_ContentPlaceHolder1_ceFromDate_day_0_3\"]
		System.out.println("selected From date is : 01/01/2022 "); // 01/05/2024 

		Thread.sleep(2000);
		System.out.println("Click on Calender icon to select To date"); //
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_dvcal2")).click();
//
//		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_dvcal2")));
//		
//		String Month_yrrrr = driver.findElement(By.className("ajax__calendar_title")).getText();
//		System.out.println(Month_yrrrr);
//		while(!(Month_yrrrr.equals("July, 2024"))) {
//			
//			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceToDate_nextArrow")).click();
//			Month_yrrrr = driver.findElement(By.className("ajax__calendar_title")).getText();
//		}
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ceToDate_day_0_3\"]")).click();
//		System.out.println("selected To date is : 03/07/2024 ");
		System.out.println("Select To Date : 14/06/2024");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtToDate")).sendKeys("14/06/2024");

		Thread.sleep(2000);
		System.out.println("Click on Work Load Report");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();

		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
	}

}
