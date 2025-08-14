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

import Stores.AL_Stores_Trans_VendorPaymentApproval_Flow02_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Stores_Trans_VendorPaymentApproval_Flow02_2_Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Trans_VendorPaymentApproval_Flow02_2 vendorPaymentApproval;
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
	public void aL_Stores_Trans_VendorPaymentApproval_Flow02_2_Test() throws Exception {

		vendorPaymentApproval = new AL_Stores_Trans_VendorPaymentApproval_Flow02_2(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Trans_VendorPaymentApproval_Flow02_2_Test"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > TRANSACTION > Vendor Payment Approval");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Store_Transaction();

		threadWait1();
		vendorPaymentApproval.Click_VendorPaymentApproval();
		
		threadWait1();
		vendorPaymentApproval.Click_SearchBar();
		
		
		threadWait1();
		vendorPaymentApproval.Click_SelectButton();
		
		threadWait1();
		vendorPaymentApproval.Enter_PayNowAmount();
		
		threadWait1();
		vendorPaymentApproval.Click_ApproveRadioButton();
		
		threadWait1();
		vendorPaymentApproval.Click_SubmitButton();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Vendor Payment Approved Successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}
}
