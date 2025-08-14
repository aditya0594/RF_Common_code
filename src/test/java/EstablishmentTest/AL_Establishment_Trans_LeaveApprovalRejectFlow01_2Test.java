package EstablishmentTest;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_LeaveApprovalRejectFlow01_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_LeaveApprovalRejectFlow01_2Test extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_LeaveApprovalRejectFlow01_2 ApproveLeaveReject;
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
	public void aL_Establishment_Trans_LeaveApprovalRejectFlow01_2Test() throws Exception {
		test = reports.createTest("aL_Establishment_Trans_LeaveApprovalRejectFlow01_2Test");

		ApproveLeaveReject = new AL_Establishment_Trans_LeaveApprovalRejectFlow01_2(driver);
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Transactions  > Leave Approwal  > Select > RejectLeave > Submit   ");
		
		Thread.sleep(2000);
		HP.ESTABLISHMENT();
		Thread.sleep(2000);

		Thread.sleep(4000);
		ApproveLeaveReject.Transaction();
		
		Thread.sleep(2000);
		ApproveLeaveReject.LeaveApproval(); 
		
		Thread.sleep(2000);
		ApproveLeaveReject.SelectLeave();
		
		Thread.sleep(2000);
		ApproveLeaveReject.RejectLeave();
		
		Thread.sleep(2000);
		ApproveLeaveReject.SubmitButton();
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Record Saved Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);
			
		alert.accept();

		//Screenshot.takesScreenshot(getCurrentTime());
	}	
	
	
	
}	
