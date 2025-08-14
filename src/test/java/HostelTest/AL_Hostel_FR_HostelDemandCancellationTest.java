package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_FR_HostelDemandCancellation;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_FR_HostelDemandCancellationTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_FR_HostelDemandCancellation DemandCancellation;
	HomePageAdmin HP;
	


	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void aL_Hostel_FR_HostelDemandCancellationTest() throws Throwable {

		DemandCancellation = new Hostel.AL_Hostel_FR_HostelDemandCancellation(driver);

		test = reports.createTest("aL_Hostel_FR_HostelDemandCancellationTest");

		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Academic -> Fee Related -> Demand Cancellation");
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_FeesRelated();
	
		Thread.sleep(4000);
		DemandCancellation.ClickDemandCancellationTest();

		Thread.sleep(4000);
		DemandCancellation.SelectSearchCriteriaTest();

		Thread.sleep(4000);
		DemandCancellation.SearchStringTest();

		Thread.sleep(4000);
		DemandCancellation.ClickSearchButtonTest();

		Thread.sleep(4000);
		DemandCancellation.ClickStudentName();
		
//		Thread.sleep(4000);
//		DemandCancellation.SearchBoxTest();

		Thread.sleep(4000);
		DemandCancellation.EnterRemarkTest();

		Thread.sleep(4000);
		DemandCancellation.ClickCancelDemandButton();

		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(1000);
		String Expected_Msg = "Demand Cancelled successfully.";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println(Actual_Msg + "" + Expected_Msg);
		
		Thread.sleep(1000);
		alert.accept();

	}
}
