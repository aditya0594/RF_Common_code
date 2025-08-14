package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_PermissionApprovalFlow02_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_PermissionApprovalFlow02_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_PermissionApprovalFlow02_2 permission_appr;
	HomePageAdmin HP;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Throwable {
		
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
	
	@Test
	public void aL_Establishment_Trans_PermissionApprovalFlow02_2Test() throws InterruptedException, IOException {
		
	System.out.println("Establishment==>Transaction==> Permission Approval ");
		
		permission_appr = new AL_Establishment_Trans_PermissionApprovalFlow02_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_PermissionApprovalFlow02_2Test");
		
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		HP.ESTABLISHMENT();
		Thread.sleep(2000);
		
		threadWait1();
		permission_appr.Click_Transactions();
		
		threadWait1();
		permission_appr.Click_PermissionApproval();
		
		threadWait1();
		permission_appr.Click_Select_btn();
		
		threadWait1();
		permission_appr.Click_SelectStatus();
		
		threadWait1();
		permission_appr.Click_Submit_btn();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String Act_Msg = alert.getText();
		String Exp_Msg = "Record Updated Successfully";
		
		Assert.assertEquals(Act_Msg, Exp_Msg);
		System.out.println("Actual Confirmation Text - " + Act_Msg + "\n"+ "Expected Confiramtion Text - " + Exp_Msg);

		alert.accept();
	}
}
