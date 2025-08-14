package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_PSR_DeliveredDateCrossed;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.PDFUtility;
import utility.Reports;
import utility.BaseClass;

public class AL_Stores_Rpt_PSR_DeliveredDateCrossedTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_PSR_DeliveredDateCrossed aL_Stores_Prt_PSR_DeliveredDateCrossed;
	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test : " + m.getName() + "*******" + "\n");

	}

	@Test
	public void aL_Stores_Rpt_PSR_DeliveredDateCrossedTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Prt_PSR_DeliveredDateCrossed = new AL_Stores_Rpt_PSR_DeliveredDateCrossed(driver);
		pdfutility = new PDFUtility(driver); 

		test = reports.createTest("aL_Stores_Rpt_PSR_DeliveredDateCrossedTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->PO Stock Reports -> Delivered Date Crossed"); 

		Thread.sleep(3000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.click_POStockReports();

		Thread.sleep(2000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.Select_POType();
		
		Thread.sleep(3000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.Select_DeliverDateCross();
		
		Thread.sleep(3000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.Select_FromDate(); 

		Thread.sleep(3000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.Select_ToDate();

		Thread.sleep(3000);
		aL_Stores_Prt_PSR_DeliveredDateCrossed.Click_ReportBtn();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store - PSR - Delivered Date Crossed"); 
		
		Thread.sleep(3000);
		pdfutility.readPDF("Store - PSR - Delivered Date Crossed", "CONSUMABLE");
	}
}
