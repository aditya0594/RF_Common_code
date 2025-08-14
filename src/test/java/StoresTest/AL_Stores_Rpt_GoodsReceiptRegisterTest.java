package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_GoodsReceiptRegister;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_GoodsReceiptRegisterTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_GoodsReceiptRegister goodsReceiptRegister;
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
	public void aL_Stores_Rpt_GoodsReceiptRegisterTest() throws Exception {

		goodsReceiptRegister = new AL_Stores_Rpt_GoodsReceiptRegister(driver);
		pdfutility = new PDFUtility(driver);	
			
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Stores_Rpt_GoodsReceiptRegisterTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("STORES > Reports > Goods Receipt Register");

		threadWait1();
		HP.STORE();
		
		threadWait1();
		HP.Select_StoreReports();

		threadWait1();
		goodsReceiptRegister.Click_RequiredTotalItem();
		
		threadWait1();
		goodsReceiptRegister.Enter_FromDate();
		
		
		threadWait1();
		goodsReceiptRegister.Enter_ToDate();
		
		threadWait1();
		goodsReceiptRegister.Click_GoodsReceiptRegisterButton();
		
		threadWait1();
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Stores - Goods Receipt Register Report");
		pdfutility.readPDF("Stores - Goods Receipt Register Report", "GLACIER");
	}
}
