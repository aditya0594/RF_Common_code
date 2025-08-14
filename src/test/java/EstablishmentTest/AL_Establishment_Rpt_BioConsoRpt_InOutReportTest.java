package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//mport Establishment.AL_Estab_Reports_BiometricConsolidateReport_InOutReport;
import Establishment.AL_Establishment_Rpt_BioConsoRpt_InOutReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_BioConsoRpt_InOutReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_BioConsoRpt_InOutReport bio_in_out_cons;
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
	public void aL_Establishment_Rpt_BioConsoRpt_InOutReportTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Biometric Consolidate Report ==> In Out Report");
		
		bio_in_out_cons = new AL_Establishment_Rpt_BioConsoRpt_InOutReport(driver);
		test = reports.createTest("aL_Establishment_Rpt_BioConsoRpt_InOutReportTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();

		Thread.sleep(5000);
		bio_in_out_cons.Click_REPORTS();
		
		Thread.sleep(5000);
		bio_in_out_cons.Click_BiometricConsolidateReport();
		
		Thread.sleep(5000);
		bio_in_out_cons.Select_College_name();
		
		Thread.sleep(5000);
		bio_in_out_cons.Select_Stafff_Type();
		
		Thread.sleep(5000);
		bio_in_out_cons.Set_from_date();
		
		Thread.sleep(5000);
		bio_in_out_cons.Set_to_date();
		
		// For All Employee
		//1.Click In Out Report btn

		Thread.sleep(5000);
		bio_in_out_cons.Click_In_Out_report_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		
		captureScreenshot(driver, "Biometric Consolidate Report In Out");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
		
		System.out.println("In Out Report Generated for All Employee");
		
		
//		Report for Particular Employee 
//		Click report btn		
		
		Thread.sleep(5000);
		bio_in_out_cons.set_perticular_employee_info();
		
		Thread.sleep(5000);
		bio_in_out_cons.Click_In_Out_report_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(6000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken"); 
		
		captureScreenshot(driver, "Biometric Consolidate Report In Out");
	}
}
