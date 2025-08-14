package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_NoDuesCollection;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;


public class AL_Academic_AP_NoDuesCollectionTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AP_NoDuesCollection al_Academic_AP_NoDuesCollection;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception { 
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "********Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Academic_AP_NoDuesCollectionTest() throws Exception {
		test = reports.createTest("aL_Academic_AP_NoDuesCollectionTest");

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AP_NoDuesCollection = new AL_Academic_AP_NoDuesCollection(driver);

		Thread.sleep(3000);
		RF_AdminLoginPage.loginPage();

		System.out.println("ACADEMIC->Admission Process->No Dues Collection");

		Thread.sleep(3000);
		//Click on Main Academic Menu
		homePageAdmin.Academic();

		Thread.sleep(3000);
		//Click on Admission Proccess Submenu
		homePageAdmin.Academic_AdmissionProcess();

		Thread.sleep(3000);
		//Click no Dues Collection
		al_Academic_AP_NoDuesCollection.Click_NoDueCollection_Link();

		Thread.sleep(3000);
		//Select Degree
		al_Academic_AP_NoDuesCollection.Select_Degree();

		Thread.sleep(3000);
		al_Academic_AP_NoDuesCollection.Select_Branch();

		Thread.sleep(3000);
		//Click Show 
		al_Academic_AP_NoDuesCollection.Click_ShowButton();

		Thread.sleep(3000);
		//Enter due Amount
		al_Academic_AP_NoDuesCollection.Enter_DueAmount();

		Thread.sleep(3000);
		//Change Status
		al_Academic_AP_NoDuesCollection.Select_Status();

		Thread.sleep(3000);
		//click on submit
		al_Academic_AP_NoDuesCollection.Click_Submit_Button();

		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Due Amount Saved Successfully!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}

}
