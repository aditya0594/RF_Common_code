package EstablishmentTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_ManualBioMetricEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Establishment_Trans_ManualBioMetricEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_ManualBioMetricEntry manualBioMetricEntry;
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
	public void aL_Establishment_Trans_ManualBioMetricEntryTest() throws Exception {

		manualBioMetricEntry = new AL_Establishment_Trans_ManualBioMetricEntry(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_ManualBioMetricEntryTest"); 
		pdfutility =new PDFUtility(driver);	
		
		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Transactions > Manual Bio Metric Entry");

		threadWait1();
		HP.ESTABLISHMENT();
		
		threadWait1();
		HP.Estab_Transactions();

		threadWait1();
		manualBioMetricEntry.Click_ManualBioMetricEntry();
		
		threadWait1();
		manualBioMetricEntry.Select_College();
		
		threadWait1();
		manualBioMetricEntry.Select_StaffType();
		
		threadWait1();
		manualBioMetricEntry.Click_CalendarIcon();
		
		threadWait1();
		manualBioMetricEntry.Select_Employee();
		
//		threadWait1();
//		manualBioMetricEntry.Click_ChooseFile();
//		
//		threadWait1();
//		manualBioMetricEntry.Click_UploadBtn();
		
		threadWait1();
		manualBioMetricEntry.Click_ShowButton();
		
		threadWait1();
		manualBioMetricEntry.Click_Checkbox();
		
		
		threadWait1();
		manualBioMetricEntry.Enter_InTime();
		
		threadWait1();
		manualBioMetricEntry.Enter_OutTime();
		 
		threadWait1();
		manualBioMetricEntry.Click_SubmitButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Records Added Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		threadWait1(); 
		alert.accept();
		
		// Reports
		threadWait1();
		manualBioMetricEntry.Select_College();
		
		threadWait1();
		manualBioMetricEntry.Select_StaffType();
		
		threadWait1();
		manualBioMetricEntry.Click_CalendarIcon();
		
		threadWait1();
		manualBioMetricEntry.Select_Employee();
		
		threadWait1();
		manualBioMetricEntry.Click_ReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Establishment - Manual Bio Metric Entry");
		threadWait1();
		pdfutility.readPDF("Establishment - Manual Bio Metric Entry", "VENKATESAN");	


		
	}
}
