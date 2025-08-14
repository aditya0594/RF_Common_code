package RFCCAcademicTest; 

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_Academic_FR_ExtraCurricularAttendanceTest extends BaseClass {

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
		System.out.println("\n" + "*******Starting : " + m.getName() + "********" + "\n");
	}

	@Test
	public void fL_Academic_FR_ExtraCurricularAttendanceTest() throws Exception {
		
		test = reports.createTest("FL_Academic_FR_ExtraCurricularAttendanceTest");
		HP = new HomePageAdmin(driver);
		
		RF_FacultyLogin.loginPage();

		System.out.println("Faculty Logged in Successfully");
		
		System.out.println("Academic->Faculty Related->Extra-Curricular Attendance");
		Thread.sleep(5000);
		//click main Academic Module 
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		Actions action = new Actions(driver);

		Thread.sleep(5000);
		//click on submodule faculty related
		Thread.sleep(2000);
		HP.Academic_FacultyRelated();
		Thread.sleep(2000);

		//click extra curricular attendance
		WebElement curr_attendcn = driver.findElement(By.xpath("(//a[contains(text(),'Extra- Curricular Attendance')])[3]"));
		curr_attendcn.click();
		System.out.println("Click on Extra Curricular Attendance");

		Thread.sleep(5000);
		//Select Session
		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessn = new Select(session);
		sessn.selectByVisibleText("May 2022");
		System.out.println("Select Session : May 2022");
		
		Thread.sleep(5000);
		//Select Degree
		WebElement Degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddldegree"));
		Select deg = new Select(Degree);
		deg.selectByVisibleText("Bachelor of Commerce");
		System.out.println("Select Degree : Bachelor of Commerce");

		Thread.sleep(5000);
		//Select Degree
		WebElement scheme = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlScheme"));
		Select schm = new Select(scheme);
		schm.selectByVisibleText("B.Com.-General-2017-18-Department of Commerce (Old Scheme)");
		System.out.println("Select scheme : B.Com.-General-2017-18-Department of Commerce (Old Scheme)");
	
		Thread.sleep(5000);
		//Select Semester
		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTerm"));
		Select sem = new Select(semester);
		sem.selectByVisibleText("VI");
		System.out.println("Select Semester : VI");
		
		Thread.sleep(5000);
		//Select Section
		WebElement section = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsection"));
		Select sec = new Select(section);
		sec.selectByVisibleText("A");
		System.out.println("Select Section : A");
		
		Thread.sleep(5000);
		//Select From Date
		WebElement frm_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDate"));
		frm_date.sendKeys("16/08/2024");
		System.out.println("From date -> 16/08/2024");
		
		Thread.sleep(5000);
		//Select From Date
		WebElement to_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTodate"));
		to_date.sendKeys("18/08/2024");
		System.out.println("From date -> 18/08/2024");
		
		Thread.sleep(5000);
		//Select Condition
		WebElement condition = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCondtion"));
		Select con = new Select(condition);
		con.selectByVisibleText("<");
		System.out.println("Select Condition : <");
		
		Thread.sleep(3000);
		//Enter Percentage
		WebElement txt_per = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPercentage"));
		txt_per.sendKeys("80");
		System.out.println("Enter Percentage: 80");
		
		Thread.sleep(3000);
		//Click Extra Curricular Attendance report button
		WebElement btn_EA = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExtraAttendance"));
		btn_EA.click();
		System.out.println("Click on Extra Curricular Attendance report button");
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String Act_Msg = alert.getText();
		String Exp_Msg = "No Record Found.";
		
		 if (Exp_Msg.equals(Act_Msg)) {
			 System.out.println("Assertion passed"+ alert.getText());
			 alert.accept();
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");

             // Handle the alert (if any)
             try {
                 System.out.println("Alert found: " + alert.getText());
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }
		
	}

}
