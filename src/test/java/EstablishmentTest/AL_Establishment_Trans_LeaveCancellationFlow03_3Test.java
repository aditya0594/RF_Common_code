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

import Establishment.AL_Establishment_Trans_LeaveCancellationFlow03_3;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_LeaveCancellationFlow03_3Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_LeaveCancellationFlow03_3 leave_cancel;
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
	public void aL_Establishment_Trans_LeaveCancellationFlow03_3Test() throws InterruptedException, IOException {
		
	System.out.println("Establishment==>Transaction==> Leave Cancellation ");
		
		leave_cancel = new AL_Establishment_Trans_LeaveCancellationFlow03_3(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_LeaveCancellationFlow03_3Test");
		
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		HP.ESTABLISHMENT();
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		leave_cancel.Click_Transactions();
		
		Thread.sleep(5000);
		leave_cancel.Click_LeaveCancellation();
		
		Thread.sleep(5000);;
		leave_cancel.Select_College_name();
		
		Thread.sleep(5000);;
		leave_cancel.Select_staff();
		
		Thread.sleep(5000);;
		leave_cancel.Select_LeaveDateFrom();
		
		Thread.sleep(5000);;
		leave_cancel.Select_LeaveType();
		
		Thread.sleep(5000);
		leave_cancel.Click_CheckBox();
		
		Thread.sleep(5000);;
		leave_cancel.Click_ClickToRestore_btn();
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		String Act_Msg = alert.getText();
		String Exp_Msg = "Records Updated Successfully";
		
		Assert.assertEquals(Act_Msg, Exp_Msg);
		alert.accept(); 
		
	}
}
