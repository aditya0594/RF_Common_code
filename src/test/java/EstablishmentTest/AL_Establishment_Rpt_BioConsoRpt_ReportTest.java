package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//import Establishment.AL_Estab_Reports_BiometricConsolidateReport_Report;
import Establishment.AL_Establishment_Rpt_BioConsoRpt_Report;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_BioConsoRpt_ReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_BioConsoRpt_Report bio_cons;
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
	public void aL_Establishment_Rpt_BioConsoRpt_ReportTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Biometric Consolidate Report==>Report btn");
		
		bio_cons = new AL_Establishment_Rpt_BioConsoRpt_Report(driver);
		test = reports.createTest("aL_Establishment_Rpt_BioConsoRpt_ReportTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(3000);
		bio_cons.Click_REPORTS();
		
		Thread.sleep(3000);
		bio_cons.Click_BiometricConsolidateReport();
		
		Thread.sleep(3000);
		bio_cons.Select_College_name();
		
		Thread.sleep(3000);
		bio_cons.Select_Stafff_Type();
		
		Thread.sleep(3000);
		bio_cons.Set_from_date();
		
		Thread.sleep(3000);
		bio_cons.Set_to_date();
		
		// For All Employee
		//1.Click Report btn

		Thread.sleep(3000);
		bio_cons.Click_report_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(4000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		
		captureScreenshot(driver, "Biometric Consolidate Report");
		
		Thread.sleep(4000);
		switchToFrameOrDefault();
		
		System.out.println("Report Generated for All Employee");
		
		
//		Report for Particular Employee 
//		Click report btn		
		
		Thread.sleep(4000);
		bio_cons.set_perticular_employee_info();
		
		Thread.sleep(3000);
		bio_cons.Click_report_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(4000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken"); 
		
		captureScreenshot(driver, "Biometric Consolidate Report");	
	}

}
