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

import Establishment.AL_Establishment_Trans_DirectLeaveApplicationFlow03_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_DirectLeaveApplicationFlow03_1Test extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_DirectLeaveApplicationFlow03_1 al_Establishment_T_DirectLeaveApplication;
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
	public void aL_Establishment_Trans_DirectLeaveApplicationFlow03_1Test() throws Throwable {

		System.out.println("al_Establishment_T_DirectLeaveApplication");

		al_Establishment_T_DirectLeaveApplication = new AL_Establishment_Trans_DirectLeaveApplicationFlow03_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_DirectLeaveApplicationFlow03_1Test");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Establishment->Transaction->Direct Leave Application");

		HP.ESTABLISHMENT();
		Thread.sleep(2000);

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.Transactions();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.DirectLeaveApplication();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.Select_college();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.Selec_staff();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.EmployeeName();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.SelectLeaveName();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.FromDate();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.ToDate();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.Reason();

		Thread.sleep(5000);
		al_Establishment_T_DirectLeaveApplication.submit();   

		Thread.sleep(5000);; 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}

}
