package RFCC_Extra;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import Establishment.AL_Establishment_Trans_DirectLeaveApplication;
import RFCCExtra.AL_Establishment_Trans_DirectLeaveApprovalReject;
//import Establishment.AL_Establishment_Trans_LeaveApproval;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_DirectLeaveApprovalRejectTest extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_DirectLeaveApprovalReject ApproveLeaveReject;

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
	public void aL_Establishment_Trans_DirectLeaveApprovalRejectTest() throws Exception {
		test = reports.createTest("aL_Establishment_Trans_DirectLeaveApprovalRejectTest");

		ApproveLeaveReject = new AL_Establishment_Trans_DirectLeaveApprovalReject(driver);
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Transactions  > Leave Approwal  > Select > RejectLeave > Submit   ");
		
		Thread.sleep(4000);
		//ApproveLeaveReject.Establishment();
		
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ESTABLISHMENT"));
		System.out.println("Main ESTABLISHMENT menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

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
		
