package StoresTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Trans_VendorPaymentEntry_Flow02_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.TestDataSharing;

public class AL_Stores_Trans_VendorPaymentEntry_Flow02_1_Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Trans_VendorPaymentEntry_Flow02_1 vendorPaymentEntry;
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
	public void aL_Stores_Trans_VendorPaymentEntry_Flow02_1_Test() throws Exception {

		vendorPaymentEntry = new AL_Stores_Trans_VendorPaymentEntry_Flow02_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Trans_VendorPaymentEntry_Flow02_1_Test"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > TRANSACTION > Vendor Payment Entry");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Store_Transaction();

		threadWait1();
		vendorPaymentEntry.Click_VendorPaymentEntry();
		
		threadWait1();
		vendorPaymentEntry.Click_AddNewButton();
		
		threadWait1();
		vendorPaymentEntry.Select_Date();
		
		threadWait1();
		vendorPaymentEntry.Select_Vendor();
		
		threadWait1();
		vendorPaymentEntry.Select_PaymentType();
		
		threadWait1();
		vendorPaymentEntry.Select_PO();
		
		threadWait1();
		vendorPaymentEntry.Enter_PayNowAmount();
		
		threadWait1();
		vendorPaymentEntry.Select_ModeOfPayment();
		
		threadWait1();
		vendorPaymentEntry.Click_SubmitButton();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved & VP Number Generated Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		// Capture the VP Number after alert acceptance
		Thread.sleep(5000); // Brief wait for page to update after alert
		String vpNumber = vendorPaymentEntry.getVPNumber();
		
		// Store VP Number for use in later test classes
		TestDataSharing.storeData("VendorPaymentNumber", vpNumber);
		System.out.println("Saved VP Number for later use: " + vpNumber);
		
	}
}
