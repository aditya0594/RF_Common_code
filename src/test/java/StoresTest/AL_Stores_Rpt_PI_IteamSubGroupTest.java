package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_PI_ItemSubGroup;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;
import utility.BaseClass;
import utility.PDFUtility;

public class AL_Stores_Rpt_PI_IteamSubGroupTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_PI_ItemSubGroup aL_Stores_Rpt_PI_ItemSubGroup; 
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
	public void aL_Stores_Rpt_PI_IteamSubGroupTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_PI_ItemSubGroup=new AL_Stores_Rpt_PI_ItemSubGroup(driver);
		pdfutility = new PDFUtility(driver);
		
		test=reports.createTest("aL_Stores_Rpt_PI_IteamSubGroupTest");
		
		Thread.sleep(2000);	
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Purchase Iteam");
		
		Thread.sleep(2000);
		homePageAdmin.STORE(); 
		
		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports(); 
		
		Thread.sleep(4000);
		aL_Stores_Rpt_PI_ItemSubGroup.click_purchaseitemreport();
        
        Thread.sleep(2000);
        aL_Stores_Rpt_PI_ItemSubGroup.Select_FromDate(); 
		
		Thread.sleep(3000);
		aL_Stores_Rpt_PI_ItemSubGroup.Select_ToDate();
		
		Thread.sleep(3000);
		
		aL_Stores_Rpt_PI_ItemSubGroup.Select_iteamsubgroupradiobtn();
		
		Thread.sleep(2000);
		aL_Stores_Rpt_PI_ItemSubGroup.Click_ReportBtn();
		
		Thread.sleep(5000);
        switchToNextWindow();
        
        Thread.sleep(3000);
        pdfutility.downloadPDF(driver, "Store - Purchase Iteam - Item Sub Group");
        
        Thread.sleep(3000);
        pdfutility.readPDF("Store - Purchase Iteam - Item Sub Group","PETROL"); 
     
	} 

}
