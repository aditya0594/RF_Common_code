package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_LeaveAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_LeaveAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_LeaveAllotment leave_allot;
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
	public void aL_Establishment_Trans_LeaveAllotmentTest() throws InterruptedException, IOException {
		
	System.out.println("Establishment==>Transaction==> Leave_allotment");
		
		leave_allot = new AL_Establishment_Trans_LeaveAllotment(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_LeaveAllotmentTest");
		RF_AdminLoginPage.loginPage();
		
		threadWait1();
		HP.ESTABLISHMENT();
		
		threadWait1();
		leave_allot.Click_Transactions();
		
		threadWait1();
		leave_allot.Click_Leave_allotment();
		
		threadWait1();
		leave_allot.Select_College_name();
		
		threadWait1();
		leave_allot.Select_Stafff_Type();
		
		threadWait1();
		leave_allot.Select_Period();
		
		threadWait1();
		leave_allot.Select_Year();
		
		threadWait1();
		leave_allot.Select_Leave_name();

		threadWait1();
		leave_allot.Click_Show_btn();
		
		threadWait1();
		leave_allot.Click_check_box();

		threadWait1();
		leave_allot.Click_Transfer_btn();
		

		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Records Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
		
		
	}

}
