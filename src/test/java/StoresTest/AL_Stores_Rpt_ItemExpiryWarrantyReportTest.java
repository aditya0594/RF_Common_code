package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_ItemExpiryWarrantyReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.BaseClass;
import utility.PDFUtility;


public class AL_Stores_Rpt_ItemExpiryWarrantyReportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_ItemExpiryWarrantyReport aL_Stores_Rpt_ItemExpiryWarrantyReport;
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
	public void aL_Stores_Rpt_ItemExpiryWarrantyReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_ItemExpiryWarrantyReport=new AL_Stores_Rpt_ItemExpiryWarrantyReport(driver);
		
		test=reports.createTest("aL_Stores_Rpt_ItemExpiryWarrantyReportTest");
		
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(2000);	
		RF_AdminLoginPage.loginPage(); 
		System.out.println("Stores->Reports->Item Expiry Warranty ReportTest");
		
		Thread.sleep(2000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();
				
		Thread.sleep(4000);
		aL_Stores_Rpt_ItemExpiryWarrantyReport.Click_ItemExpiryWarrantyReport();
		
		Thread.sleep(2000);
		aL_Stores_Rpt_ItemExpiryWarrantyReport.Select_FromDate();
		
		Thread.sleep(3000);
		aL_Stores_Rpt_ItemExpiryWarrantyReport.Select_ToDate();
		
		Thread.sleep(3000);
		aL_Stores_Rpt_ItemExpiryWarrantyReport.Select_Item();
		
		Thread.sleep(2000);
		aL_Stores_Rpt_ItemExpiryWarrantyReport.Click_SubmitBtn();
		
		Thread.sleep(5000);
        switchToNextWindow();
        
        Thread.sleep(5000);
        pdfutility.downloadPDF(driver,"Stores - Reports - Item Expiry Warranty Report");
        Thread.sleep(4000); 
        pdfutility.readPDF("Stores - Reports - Item Expiry Warranty Report","ALMIRAH");  
        
      
     
	}
}
