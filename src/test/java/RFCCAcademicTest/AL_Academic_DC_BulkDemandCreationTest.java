package RFCCAcademicTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

import RFCCAcademic.AL_Academic_DC_BulkDemandCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;


public class AL_Academic_DC_BulkDemandCreationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_DC_BulkDemandCreation bulkdemandcreation;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*********Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_DC_BulkDemandCreationTest() throws Exception {
		bulkdemandcreation = new AL_Academic_DC_BulkDemandCreation(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Academic_DC_BulkDemandCreationTest");
		Thread.sleep(2000);

		System.out.println("ACADEMIC->Fee Related->Demand Creation->Bulk Demand Creation");
		
		RF_AdminLoginPage.loginPage();
		
		//Select Academic
		HP.Academic();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		HP.Academic_FeesRelated();
		Thread.sleep(2000);
		
		//Click Demand Creation
				
				bulkdemandcreation.click_Demand_Creation_Link();
				Thread.sleep(2000);
				
				//Select Session
				bulkdemandcreation.select_Session();
				Thread.sleep(2000);
				
				//Select School
				bulkdemandcreation.select_School();
				Thread.sleep(2000);
				
				//Select Admission Fee Option
				bulkdemandcreation.Select_Receipt_Type();
				Thread.sleep(2000);
				
				//Select degree
				bulkdemandcreation.select_Degree();
				Thread.sleep(2000);
				
				//Select Branch
				bulkdemandcreation.select_Branch();

				Thread.sleep(1000);
				//Select Semester
				bulkdemandcreation.select_Semester();
				Thread.sleep(2000);
				
				//Select Demand Semester
				bulkdemandcreation.select_DemandSemester();
				Thread.sleep(2000);
				
				//Select Payment Type
				bulkdemandcreation.select_PaymentType();
				Thread.sleep(2000);
				
				//Click show student button
				bulkdemandcreation.click_ShowStudent_Button();
				
				Thread.sleep(2000);
				bulkdemandcreation.click_Student_Checkbox();
				
				Thread.sleep(2000);
				bulkdemandcreation.click_CreateDemandForSelStudent();
				
				Thread.sleep(5000);
				Alert alert = driver.switchTo().alert();
				String Expected_Msg = "Demand successfully created for selected students.";
				String Actual_Msg = alert.getText();
				System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
				Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
				System.out.println("Actual and Expected Msg matched");
				Thread.sleep(2000);
				alert.accept();
	}
}
