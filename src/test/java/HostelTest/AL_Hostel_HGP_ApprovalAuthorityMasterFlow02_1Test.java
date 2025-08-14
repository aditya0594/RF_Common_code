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

import Hostel.AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 approvalAuthority;
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
	public void aL_Hostel_HGP_ApprovalAuthorityMasterTest() throws Exception {

		approvalAuthority = new AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Hostel_HGP_ApprovalAuthorityMasterTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > HostelGatePass > Approval Authority Master");

		Thread.sleep(2000);
		HP.HOSTEL();
		
		Thread.sleep(2000);
		HP.Hostel_HostelGatePass();

		Thread.sleep(2000);
		approvalAuthority.ApprovalAuthorityMaste();
		
		Thread.sleep(2000);
		approvalAuthority.Click_AddAuthorityApprovalBtn();
		
		Thread.sleep(2000);
		approvalAuthority.Click_EditIcon();
		
		Thread.sleep(2000);
		approvalAuthority.Enter_SearchBox();
		
		Thread.sleep(2000);
		approvalAuthority.Click_SubmitBtn();
		
		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
