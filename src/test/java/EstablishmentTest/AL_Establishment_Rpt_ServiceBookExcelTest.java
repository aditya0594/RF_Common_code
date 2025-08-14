package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_ServiceBookExcel;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Establishment_Rpt_ServiceBookExcelTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_ServiceBookExcel servic_book;
	HomePageAdmin HP;

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
	public void aL_Establishment_Rpt_ServiceBookExcelTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Leave Report==> Service Book Excel");
		
		servic_book = new AL_Establishment_Rpt_ServiceBookExcel(driver);
		test = reports.createTest("aL_Establishment_Rpt_ServiceBookExcelTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();

		
		Thread.sleep(4000);
		servic_book.Click_REPORTS();
		
		Thread.sleep(4000);
		servic_book.Click_SeviceBookExcel();
		
		Thread.sleep(4000);
		servic_book.Select_College_name();
		
	//	Thread.sleep(4000);
	//	servic_book.select_Stafff_Type();
		
		Thread.sleep(4000);
		servic_book.Select_seviceBookCategory();
	
		Thread.sleep(4000);
		servic_book.Click_excel_Btn();
		
		Thread.sleep(2000);


		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of Exel file is taken");
		captureScreenshot(driver, "Service Book Excel");
		
		System.out.println("Excel File is Downloaded");
	}

}
