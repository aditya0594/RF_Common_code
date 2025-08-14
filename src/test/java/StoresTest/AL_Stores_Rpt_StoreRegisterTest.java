package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_StoreRegister;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_StoreRegisterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_StoreRegister storeregister;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	
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
	public void aL_Stores_Rpt_StoreRegisterTest() throws Exception {

		storeregister = new AL_Stores_Rpt_StoreRegister(driver);
		pdfutility = new PDFUtility(driver);	
			
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Rpt_StoreRegisterTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > Reports > Store Register");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Select_StoreReports();

		threadWait1();
		storeregister.Click_StoreRegister();
		
		threadWait1();
		storeregister.Enter_FromDate();
		
		
		threadWait1();
		storeregister.Enter_ToDate();
		
		threadWait1();
		storeregister.Click_GoodsReceiptRegisterButton();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Stores - Store Register Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Stores - Store Register Report", "GLACIER");
	}
}
