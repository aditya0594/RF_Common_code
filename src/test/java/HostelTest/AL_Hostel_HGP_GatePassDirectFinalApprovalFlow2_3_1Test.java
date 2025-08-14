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

import Hostel.AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 directapproval;
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
	public void aL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1Test() throws Exception {

		directapproval = new AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1Test");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > HostelGatePass > Gate Pass Direct Final Approval");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		directapproval.Click_GatePassDirectFinalApproval();
		
		Thread.sleep(2000);
		directapproval.Search_DateAndClickCheckbox();
		
		Thread.sleep(2000);
		directapproval.Select_Status();
		
		Thread.sleep(2000);
		directapproval.Enter_Remark();
		
		Thread.sleep(2000);
		directapproval.Click_SubmitBtn();
		
		
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	
	}	
}
