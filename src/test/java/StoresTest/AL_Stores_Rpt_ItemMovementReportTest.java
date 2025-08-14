package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_ItemMovementReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_ItemMovementReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_ItemMovementReport itemMovementReport;
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
	public void aL_Stores_Rpt_ItemMovementReportTest() throws Exception {

		itemMovementReport = new AL_Stores_Rpt_ItemMovementReport(driver);
		pdfutility = new PDFUtility(driver);	
			
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Rpt_ItemMovementReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > Reports > Item Movement Report");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Select_StoreReports();

		threadWait1();
		itemMovementReport.Click_ItemMovementReport();
		
		threadWait1();
		itemMovementReport.Select_Category();
		
		threadWait1();
		itemMovementReport.Select_SubCategory();
		
		threadWait1();
		itemMovementReport.Select_Item();
		
		threadWait1();
		itemMovementReport.Click_ShowReportButton();
		
		threadWait1();
		
		pdfutility.downloadPDF(driver, "Stores - Item Movement Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Stores - Item Movement Report", "PEN");
	}
}
