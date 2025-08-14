package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_PS_ItemSubGroupPerticular;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.PDFUtility;
import utility.Reports;
import utility.BaseClass;

public class AL_Stores_Rpt_PS_ItemSubGroupPerticularTest extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_PS_ItemSubGroupPerticular aL_Stores_Rpt_PurchaseSummary;
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
	public void aL_Stores_Rpt_PS_ItemSubGroupPerticularTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_PurchaseSummary = new AL_Stores_Rpt_PS_ItemSubGroupPerticular(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Stores_Rpt_PS_ItemSubGroupPerticularTest");

		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Purchase Summary->Item Sub Group - Perticular");

		Thread.sleep(5000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(5000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Rpt_PurchaseSummary.click_PurchaseSummary();

		Thread.sleep(5000);
		aL_Stores_Rpt_PurchaseSummary.Select_FromDate();

		Thread.sleep(3000);
		aL_Stores_Rpt_PurchaseSummary.Select_ToDate();
		
		Thread.sleep(5000);
		aL_Stores_Rpt_PurchaseSummary.Select_itemsubgroup();

		Thread.sleep(5000);
		aL_Stores_Rpt_PurchaseSummary.Click_PerticularRadioBtn();
		
		Thread.sleep(3000);
		aL_Stores_Rpt_PurchaseSummary.Select_Item();
				
		Thread.sleep(3000);
		aL_Stores_Rpt_PurchaseSummary.Click_ReportBtn();

		Thread.sleep(5000);
		switchToNextWindow();
 
		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Store - PS - Item Sub Group - Perticular");
		
		Thread.sleep(3000);
		pdfutility.readPDF("Store - PS - Item Sub Group - Perticular", "SAMSUNG MOBILE");

	}

}
