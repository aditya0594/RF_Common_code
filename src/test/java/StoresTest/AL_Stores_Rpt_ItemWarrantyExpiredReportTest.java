package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_ItemWarrantyExpiredReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_ItemWarrantyExpiredReportTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_ItemWarrantyExpiredReport ItemWarrantyExpiredReport;
	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport(); 
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test : " + m.getName() + "*******" + "\n");
		
	}
	
	@Test
	public void aL_Stores_Rpt_ItemWarrantyExpiredReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		ItemWarrantyExpiredReport=new AL_Stores_Rpt_ItemWarrantyExpiredReport(driver);
		
		test=reports.createTest("aL_Stores_Rpt_ItemExpiryWarrantyReportTest");
		
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(5000);	
		RF_AdminLoginPage.loginPage(); 
		System.out.println("Stores->Reports->Item Expiry Warranty ReportTest");
		
		Thread.sleep(5000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(5000);
		homePageAdmin.Select_StoreReports();
		
		Thread.sleep(4000);
		ItemWarrantyExpiredReport.Click_ItemExpiryWarrantyReport();
        
        Thread.sleep(3000);
        ItemWarrantyExpiredReport.Click_ItemWarrantyExpiredReport(); 
        
        Thread.sleep(5000);
        ItemWarrantyExpiredReport.Select_FromDate();
		
		Thread.sleep(3000);
		ItemWarrantyExpiredReport.Select_ToDate();
		
		Thread.sleep(3000);
		ItemWarrantyExpiredReport.Select_Item();
        
        Thread.sleep(5000);
        ItemWarrantyExpiredReport.Click_SubmitBtn();
		
		Thread.sleep(5000);
        switchToNextWindow();
        
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store -Item Warranty Expired Report");

		Thread.sleep(3000);
		pdfutility.readPDF("Store -Item Warranty Expired Report", "ALMIRAH");
     
	}
}
