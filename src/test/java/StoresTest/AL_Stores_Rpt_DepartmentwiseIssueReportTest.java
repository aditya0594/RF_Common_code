package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_DepartmentwiseIssueReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.BaseClass;
import utility.PDFUtility;

public class AL_Stores_Rpt_DepartmentwiseIssueReportTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_DepartmentwiseIssueReport aL_Stores_Rpt_DepartmentwiseIssueReport;
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
	public void aL_Stores_Rpt_DepartmentwiseIssueReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_DepartmentwiseIssueReport=new AL_Stores_Rpt_DepartmentwiseIssueReport(driver);
		pdfutility = new PDFUtility(driver);
		
		test=reports.createTest("aL_Stores_Rpt_DepartmentwiseIssueReportTest");
		
		Thread.sleep(2000);	
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Department wise Issue Report");
		
		Thread.sleep(2000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports
		();
		
		Thread.sleep(4000);
		aL_Stores_Rpt_DepartmentwiseIssueReport.click_departmentwiseIssuereport();
        
        Thread.sleep(2000);
        aL_Stores_Rpt_DepartmentwiseIssueReport.Select_FromDate(); 
		
		Thread.sleep(3000);
		aL_Stores_Rpt_DepartmentwiseIssueReport.Select_ToDate();
		
		Thread.sleep(2000);
        aL_Stores_Rpt_DepartmentwiseIssueReport.Click_SubmitBtn();
		
		Thread.sleep(5000);
        switchToNextWindow();
        
        Thread.sleep(3000);
        pdfutility.downloadPDF(driver, "Store - Department Wise Issue Report");
        
        Thread.sleep(3000);
        pdfutility.readPDF("Store - Department Wise Issue Report","Issue2022120622"); 
     
	} 

}
