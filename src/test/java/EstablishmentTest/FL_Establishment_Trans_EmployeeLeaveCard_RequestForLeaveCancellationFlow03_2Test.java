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

import Establishment.FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2 req_leave_cancel;
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
	public void fL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2Test() throws Exception {

		req_leave_cancel = new FL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("fL_Establishment_Trans_EmployeeLeaveCard_RequestForLeaveCancellationFlow03_2Test"); 
		
		System.out.println("ESTBALISHMENT > Transactions  > Employee Leave card > Request For Leave Cancellation ");

		Thread.sleep(5000);;
		req_leave_cancel.FacultyLoginDetails();
		
		Thread.sleep(5000);;
		HP.ESTABLISHMENT();
		Thread.sleep(2000);

		Thread.sleep(5000);
		req_leave_cancel.Transaction();

		Thread.sleep(5000);;
		req_leave_cancel.Click_EmployeeLeaveCard();
		
		Thread.sleep(5000);;
		req_leave_cancel.Click_LeaveApplicationStatus_btn();
		
		Thread.sleep(5000);;
		req_leave_cancel.Click_SearchBox();
		
		Thread.sleep(5000);
		req_leave_cancel.Click_SendRequest_btn();
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		String expectedMsg = "Leave Cancel Request Applied Successfully";
		System.out.println("Actual Confirmation Text - " + actualMsg + "\n"+ "Expected Confiramtion Text - " + expectedMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		alert.accept();
	}
}
