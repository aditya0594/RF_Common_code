package RFCCAcademicTest; 

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FR_LateFees;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_FR_LateFeesTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_FR_LateFees al_Academic_FR_LateFees;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_FR_LateFeesTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_FR_LateFees = new AL_Academic_FR_LateFees(driver);
		System.out.println("Academic -> Fees Related -> Late Fees ");
		test = reports.createTest("aL_Academic_FR_LateFeesTest");
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		//Click on Academic from Navigation Bar
		homePageAdmin.Academic();
		
		Thread.sleep(2000);
		//Click on Fee Related option
		homePageAdmin.Academic_FeesRelated();
		
		Thread.sleep(2000);
		//Click on Late fees from sub menu
		al_Academic_FR_LateFees.click_LateFees();
		
		Thread.sleep(2000);
		//Select Receipt Type
		al_Academic_FR_LateFees.select_ReceiptType();
		
		Thread.sleep(2000); 
		//Select Session
		al_Academic_FR_LateFees.select_Session();
		
		Thread.sleep(2000); 
		//Select Institute
		al_Academic_FR_LateFees.select_School();
		
		Thread.sleep(2000);
		//Click on Check Box of All Semester
		al_Academic_FR_LateFees.select_Semester();
		
		Thread.sleep(2000);
		//Click on Check Box of All Degree
		al_Academic_FR_LateFees.select_Degree();
		
		
		Thread.sleep(3000);
		al_Academic_FR_LateFees.select_Date();	

		Thread.sleep(2000);
		//Click on Check Box of IsFixed
		al_Academic_FR_LateFees.click_IsFixed();
		
		Thread.sleep(2000);
		//Enter Day From
		al_Academic_FR_LateFees.enter_DayFrom();
		
		Thread.sleep(2000);
		//Enter Day to
		al_Academic_FR_LateFees.enter_DayTo();
		
		Thread.sleep(2000);
		//Enter Amount
		al_Academic_FR_LateFees.enter_Amount();
		
		Thread.sleep(2000);
		//Click on Charge Late Fee Button
		al_Academic_FR_LateFees.click_lastFeesCharge_Button();
		
		Thread.sleep(2000);
		//Accept Alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Late Fees Details Saved Successfully!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Messege - " + Actual_Msg+ "\n"+ "Expected Messege - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(2000);
		acceptAlert();
		
	}

}
