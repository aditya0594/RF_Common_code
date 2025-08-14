package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

import RFCCAcademic.AL_Academic_FR_CancelFeesRefund;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;

public class AL_Academic_FR_CancelFeesRefundTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FR_CancelFeesRefund CancelFeesRefund;
	HomePageAdmin HP;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_FR_CancelFeesRefundTest() throws Throwable {
		
		test = reports.createTest("aL_Academic_FR_CancelFeesRefundTest"); 
		HP =new HomePageAdmin(driver);
		CancelFeesRefund = new AL_Academic_FR_CancelFeesRefund(driver);
		
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic -> Fee Related -> Cancel Fees Refund"); 
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated();
		
		threadWait1();
		CancelFeesRefund.ClickFeesRefundTest();
		
		threadWait1();
		CancelFeesRefund.ClickRefundCancelTabTest();
		
		threadWait1();
		CancelFeesRefund.SearchRRNTest();
		
		threadWait1();
		CancelFeesRefund.SearchButtonTest();
		
		threadWait1();
		CancelFeesRefund.ClickStudentNameTest();
		
		threadWait1();
		CancelFeesRefund.SearchNotCancelledAmountTest();
		
		threadWait1();
		CancelFeesRefund.ClickStudentCheckboxTest();
		
		Thread.sleep(3000);
		CancelFeesRefund.ClickRefundCancelButtonTest();
	
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Refund Cancel Successfully ";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
	}
}
