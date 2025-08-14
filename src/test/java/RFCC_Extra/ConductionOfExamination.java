package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class ConductionOfExamination extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test

	public void lock_Unlock_Marks() throws Exception {

		test = reports.createTest("ConductionOfExamination");
		RF_AdminLoginPage.loginPage();

		// driver.manage().window().maximize();

		driver.get(
				"https://rfcautomationuat.mastersofterp.in/academic/iitmsdCz+3wR/wowhTQ6Af/1QpZguCAS1GWiYL61PSrt3wEo=?enc=M1EsHDAeRhaekcwzmtddkrOLRdDdoaumIfdvyOcchp8=");

//To Select dropdown value
		Thread.sleep(3000);
		WebElement colgg = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClgname-container")); // --------Select
																												// College
		colgg.click();
		System.out.println(
				"College & Scheme -> SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		driver.findElement(By.className("select2-search__field")).sendKeys(
				"SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)", Keys.ENTER);

		Thread.sleep(3000);
		WebElement Session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")); // -------Select
																													// Session
		Session.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("May 2022", Keys.ENTER);
		System.out.println("Session - >May 2022");

		Thread.sleep(3000);
		WebElement Semester = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container"));// -------Select
		Semester.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("VI", Keys.ENTER);
		System.out.println("Semester -> VI");

		Thread.sleep(3000);
		WebElement CourseType = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSubType-container"));// --------Select
		CourseType.click(); // Course Type
		System.out.println("CourseType -> Theory with Tutorial");
		driver.findElement(By.className("select2-search__field")).sendKeys("Theory with Tutorial", Keys.ENTER);

		Thread.sleep(3000);
		WebElement ExamType = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlExamType-container")); // -----Select
																													// Exam
		ExamType.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("CAT-1", Keys.ENTER);// Type
		System.out.println("ExamType -> CAT-1");

		Thread.sleep(3000);
		WebElement SubExam = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSubExamType-container")); // -------Select
																														// Sub
		SubExam.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("TEST1 + ASSIGNMENT1", Keys.ENTER);// Exam
		System.out.println("SubExam -> TEST1 + ASSIGNMENT1");

		Thread.sleep(3000);
		WebElement StudType = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStuType-container")); // -------Select
		StudType.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Regular", Keys.ENTER);// Student Type
		System.out.println("StudType -> Regular");

		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtremark")).sendKeys("Testing"); // ------- Enter Remark
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
//-----------For uncheck checkbox
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl0_chklock")).click();
		System.out.println("DeSelect Check Box");

		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click(); // ----click on lock unlock marks button

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(2000);
		alert.accept();
		//driver.switchTo().alert().accept();
		
		//System.out.println("Report generated");
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnlock")).click(); // ----click on Lock unlock Report

		// button
		Thread.sleep(5000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());

	}
}