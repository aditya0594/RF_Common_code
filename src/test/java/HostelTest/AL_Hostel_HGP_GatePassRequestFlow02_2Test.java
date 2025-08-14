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

import Hostel.AL_Hostel_HGP_GatePassRequestFlow02_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_HGP_GatePassRequestFlow02_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_GatePassRequestFlow02_2 gatepassreq;
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
	public void aL_Hostel_HGP_GatePassRequestTest() throws Exception {

		gatepassreq = new AL_Hostel_HGP_GatePassRequestFlow02_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Hostel_HGP_GatePassRequestTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > HostelGatePass > Gate Pass Request");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		gatepassreq.GatePassRequest();
		
		Thread.sleep(2000);
		gatepassreq.Click_ApplyGatePassBtn();
		
		Thread.sleep(2000);
		gatepassreq.Select_Student();
		
		Thread.sleep(2000);
		gatepassreq.Select_StudentType();
		
		
		Thread.sleep(2000);
		gatepassreq.Select_OutDatee();
		
		Thread.sleep(2000);
		gatepassreq.Select_OUTAMPM();
		
		Thread.sleep(2000);
		gatepassreq.Select_InDate();
		
		Thread.sleep(2000);
		gatepassreq.Select_INAMPM();
		
		Thread.sleep(2000);
		gatepassreq.Select_Purpose();
		
		Thread.sleep(2000);
		gatepassreq.Click_SubmitBtn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(2000);
		acceptAlert();
		
	}
}
