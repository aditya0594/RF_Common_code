package AdministrationTest;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_SRM_Trans_ServiceRegistration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Administration_SRM_Trans_ServiceRegistrationTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Administration_SRM_Trans_ServiceRegistration al_Administration_SRM_Trans_ServiceRegistration;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Administration_SRM_Trans_ServiceRegistrationTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Administration_SRM_Trans_ServiceRegistration = new AL_Administration_SRM_Trans_ServiceRegistration(driver);

		test = reports.createTest("AL_Administration_SRM_Trans_ServiceRegistrationTest");
		Thread.sleep(4000);

		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->Service Request Management->Transactions->Service Registration");

		Thread.sleep(4000);
		//Click on administration menu
		homePageAdmin.ADMINISTRATION();

		Thread.sleep(4000);
		//Click on Service Request Management
		homePageAdmin.Admin_ServiceRequestManagement(); 

		Thread.sleep(4000);
		//Click on Transaction
		homePageAdmin.Admin_SRM_Transaction();

		Thread.sleep(4000);

		//Enter From Date
		al_Administration_SRM_Trans_ServiceRegistration.Select_ServiceRequestDate();

		Thread.sleep(4000);
		//select service Department
		al_Administration_SRM_Trans_ServiceRegistration.Select_Department();

		Thread.sleep(7000);
		//select serive request type
		al_Administration_SRM_Trans_ServiceRegistration.Select_ServiceRequestType();

		Thread.sleep(4000);
		//Request Request Details
		al_Administration_SRM_Trans_ServiceRegistration.Enter_ServiceRequestDetails();
		Thread.sleep(4000);
		//Select Location
		al_Administration_SRM_Trans_ServiceRegistration.Select_Location();

		Thread.sleep(10000);
		//Select Location of Service
		al_Administration_SRM_Trans_ServiceRegistration.Enter_LocationOfService();

		Thread.sleep(4000);
		//Enter Contact No.
		al_Administration_SRM_Trans_ServiceRegistration.Enter_ContactNo();

		Thread.sleep(4000);
		// upload file
		al_Administration_SRM_Trans_ServiceRegistration.Upload_File();

		Thread.sleep(4000);
		//Click Add Button
		al_Administration_SRM_Trans_ServiceRegistration.Click_AddButton();

		Thread.sleep(4000);
		//Scroll and Click on Save Button
		al_Administration_SRM_Trans_ServiceRegistration.Click_SaveButton();

		Thread.sleep(7000);
		Alert alert = driver.switchTo().alert();

		String Act_Msg = alert.getText();
		String Exp_Msg = "Service Requested Successfully.";
		System.out.println(Act_Msg = Exp_Msg);
		Thread.sleep(4000);
		Assert.assertEquals(Act_Msg, Exp_Msg, "Actual and Expected Msg matched");
		alert.accept();

		//code for deleting added record
		Thread.sleep(4000);	
		al_Administration_SRM_Trans_ServiceRegistration.Click_DeleteButton();
		Thread.sleep(7000);

		driver.switchTo().alert();
		Thread.sleep(4000);
		alert.accept();
		Thread.sleep(4000); 
		alert.accept();


	}
}
