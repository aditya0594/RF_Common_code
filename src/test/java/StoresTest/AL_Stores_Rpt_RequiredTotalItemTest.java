package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_RequiredTotalItem;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_RequiredTotalItemTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_RequiredTotalItem requiredTotalItem;
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
	public void aL_Stores_Rpt_RequiredTotalItemTest() throws Exception {

		requiredTotalItem = new AL_Stores_Rpt_RequiredTotalItem(driver);
		pdfutility = new PDFUtility(driver);	
			
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Rpt_RequiredTotalItemTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > Reports > Required Total Item");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Select_StoreReports();

		threadWait1();
		requiredTotalItem.Click_RequiredTotalItem();
		
		threadWait1();
		requiredTotalItem.Enter_FromDate();
		
		threadWait1();
		
		requiredTotalItem.Enter_ToDate();
		
		threadWait1();
		requiredTotalItem.Click_RequireQtyReportButton();
		
		threadWait1();
		
		pdfutility.downloadPDF(driver, "Stores - Required Total Item Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Stores - Required Total Item Report", "MAIN STORE");
	}
}
