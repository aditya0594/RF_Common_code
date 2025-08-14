package EstablishmentTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_BiometricDetailsReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Establishment_Rpt_BiometricDetailsReportTest extends BaseClass
{
	
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_BiometricDetailsReport biometricDetailsReport;
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
	public void aL_Establishment_Rpt_BiometricDetailsReportTest() throws Exception {

		biometricDetailsReport = new AL_Establishment_Rpt_BiometricDetailsReport(driver);
		pdfutility = new PDFUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Rpt_BiometricDetailsReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Reports > Biometric details report");

		threadWait1();
		HP.ESTABLISHMENT();
		
		threadWait1();
		
		HP.Estab_Reports();

		threadWait1();
		biometricDetailsReport.Click_BiometricDetailsReport();
		
		threadWait1();
		biometricDetailsReport.Select_College();
		
		threadWait1();
		biometricDetailsReport.Select_StaffType();
		
		threadWait1();
		biometricDetailsReport.Select_FromDate();
		
		
		threadWait1();
		biometricDetailsReport.Click_ShowButton();
		
		Thread.sleep(10000);
		biometricDetailsReport.Click_ReportButton();
		
		// Download and verify PDF
		Thread.sleep(10000);
		pdfutility.downloadPDF(driver, "Establishment - Biometric Details Report");
		threadWait1();
		pdfutility.readPDF("Establishment - Biometric Details Report", "THILAKAVATHI");	

	}
}
