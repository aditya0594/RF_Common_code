package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.Screenshot;
import utility.BaseClass;
import utility.PDFUtility;
import Stores.AL_Stores_Rpt_ItemSaleReport;
import com.qa.pages.HomePageAdmin;

public class AL_Stores_Rpt_ItemSaleReportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_ItemSaleReport aL_Stores_Rpt_ItemSaleReport;
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
	public void aL_Stores_Rpt_ItemSaleReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_ItemSaleReport=new AL_Stores_Rpt_ItemSaleReport(driver);
		
		test=reports.createTest("aL_Stores_Rpt_ItemSaleReportTest");
		
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(5000);	
		RF_AdminLoginPage.loginPage(); 
		System.out.println("Stores->Reports->Item Category Report");
		
		Thread.sleep(5000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(5000);
		homePageAdmin.Select_StoreReports();
				
		Thread.sleep(4000);
		aL_Stores_Rpt_ItemSaleReport.Click_IteamSaleReport();
		
		Thread.sleep(5000);
		aL_Stores_Rpt_ItemSaleReport.Select_FromDate();
		
		Thread.sleep(5000);
		aL_Stores_Rpt_ItemSaleReport.Select_ToDate();
		
		Thread.sleep(5000);
		aL_Stores_Rpt_ItemSaleReport.Click_SubmitBtn();
		
		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Store - Item Sale Report");

		Thread.sleep(3000);
		pdfutility.readPDF("Store - Item Sale Report", "FURNITURE");
		
		
		}

}
