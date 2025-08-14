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

import Hostel.AL_Hostel_HGP_GatePassRequestsStatusFlow02_4;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_HGP_GatePassRequestsStatusFlow02_4Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_GatePassRequestsStatusFlow02_4 al_Hostel_HGP_GatePassRequestsStatus;
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
	public void aL_Hostel_HGP_GatePassRequestsStatusTest() throws Exception {

		al_Hostel_HGP_GatePassRequestsStatus = new AL_Hostel_HGP_GatePassRequestsStatusFlow02_4(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Hostel_HGP_GatePassRequestsStatusTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > HostelGatePass > Gate Pass Request Status");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		al_Hostel_HGP_GatePassRequestsStatus.GatePassRequestStatus();

		Thread.sleep(2000);
		al_Hostel_HGP_GatePassRequestsStatus.search();

		Thread.sleep(2000);
		al_Hostel_HGP_GatePassRequestsStatus.ClickCheckBox();
		
		Thread.sleep(2000);
		al_Hostel_HGP_GatePassRequestsStatus.SelectParentApproval();
		
		Thread.sleep(2000);
		al_Hostel_HGP_GatePassRequestsStatus.ClickSubmitBtn();
		
		Thread.sleep(5000); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Records Updated Sucessfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
