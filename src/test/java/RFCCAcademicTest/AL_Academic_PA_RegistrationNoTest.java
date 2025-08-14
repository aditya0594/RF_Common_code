package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_GenerateRegistrationNo;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_RegistrationNoTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_GenerateRegistrationNo al_Academic_PA_GenerateRegistrationNo;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Academic_PA_GenerateRegistrationNoTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_PA_GenerateRegistrationNo = new AL_Academic_PA_GenerateRegistrationNo(driver);
		
		test = reports.createTest("AL_Academic_PA_GenerateRegistrationNoTest");

		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Post Admission->Registration No. and Class Roll No. Generation");
		
		Thread.sleep(2000);
		homePageAdmin.Academic();
		
		Thread.sleep(2000);
		homePageAdmin.Academic_PostAdmission();
		
		Thread.sleep(2000);
		System.out.println("Click on Registration No. and Class Roll No. Generation Page");

		al_Academic_PA_GenerateRegistrationNo.select_AdmissionBatch();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_School();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_Degree();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_Branch();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_Semester();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_AdmissionType();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.select_SortByOption1();

		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.click_Show_Button();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "No student found for selected criteria.";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(2000);
		al_Academic_PA_GenerateRegistrationNo.click_GenerateRRNo_Button();
		Thread.sleep(2000);
		
		String Expected_GMsg = "Do You Really Want to Generate No.?";
		String Actual_GMsg =alert.getText();
		System.out.println("Actual Message - " + Actual_GMsg+ "\n"+ "Expected Message - " + Expected_GMsg);
		Assert.assertEquals(Actual_GMsg, Expected_GMsg, "Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		System.out.println("Click on Ok Button");
		alert.accept();

		Thread.sleep(2000);
		String Expected_RMsg = "RR Number Generated Successfully!";
		String Actual_RMsg =alert.getText();
		System.out.println("Actual Message - " + Actual_RMsg+ "\n"+ "Expected Message - " + Expected_RMsg);
		Assert.assertEquals(Actual_RMsg, Expected_RMsg, "Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		alert.accept();
	}

}
