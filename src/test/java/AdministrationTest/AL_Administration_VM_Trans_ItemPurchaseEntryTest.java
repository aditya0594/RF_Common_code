package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_ItemPurchaseEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_ItemPurchaseEntryTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_ItemPurchaseEntry itemPurchaseEntry;
	HomePageAdmin HP;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}


	@Test
	public void aL_Administration_VM_Trans_ItemPurchaseEntryTest() throws Exception {

		itemPurchaseEntry = new AL_Administration_VM_Trans_ItemPurchaseEntry(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("AL_Administration_VM_Trans_ItemPurchaseEntryTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Item Purchase Entry");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		itemPurchaseEntry.Click_ItemPurchaseEntryLink();
		
		threadWait1();
		itemPurchaseEntry.Select_ItemType();
		
		threadWait1();
		itemPurchaseEntry.Select_ItemName();
		
		threadWait1();
		itemPurchaseEntry.Select_VendorName();
		
		threadWait1();
		itemPurchaseEntry.Enter_PurchaseDate();
		
		threadWait1();
		itemPurchaseEntry.Enter_CRNNumber();
		
		threadWait1();
		itemPurchaseEntry.Select_PurchaseFor();
		
		threadWait1();
		itemPurchaseEntry.Enter_PurchaseCouponNumber();
		
		threadWait1();
		itemPurchaseEntry.Enter_Quantity();
		
		threadWait1();
		itemPurchaseEntry.Click_SubmitBtn();
		
		Thread.sleep(2000);
		
		// Verify alert message
		String Expected_Msg = "Record save successfully";
		String Actual_Msg = itemPurchaseEntry.Get_AlertText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		itemPurchaseEntry.Accept_Alert();
	
	}
}

