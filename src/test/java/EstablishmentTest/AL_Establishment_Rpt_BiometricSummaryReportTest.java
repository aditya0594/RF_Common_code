package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_BiometricSummaryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_BiometricSummaryReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_BiometricSummaryReport BiometricSummaryReport;
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
	public void aL_Establishment_Rpt_BiometricSummaryReportTest() throws InterruptedException, IOException {
		
		System.out.println("Establishment==> Reports==> Biometric Summary Report");
		
		BiometricSummaryReport=new AL_Establishment_Rpt_BiometricSummaryReport(driver);
		test = reports.createTest("InvigilatorEntryPage");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		BiometricSummaryReport.click_Report();
		
		Thread.sleep(5000);
		BiometricSummaryReport.click_BiometricSummaryReport();
		
		Thread.sleep(5000);
		BiometricSummaryReport.Select_college();
		
		Thread.sleep(5000);
		BiometricSummaryReport.Selec_staff();
		
		Thread.sleep(5000);
		BiometricSummaryReport.Select_Department();
		
		Thread.sleep(5000);
		BiometricSummaryReport.Select_month_year();
		
		Thread.sleep(5000);
		BiometricSummaryReport.click_reportBtn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken"); 
		
	}

}
