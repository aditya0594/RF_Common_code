package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//import Establishment.AL_Estab_Reports_ODAndLeaveSummaryReport;
import Establishment.AL_Establishment_Rpt_ODAndLeaveSummaryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_ODAndLeaveSummaryReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_ODAndLeaveSummaryReport od_leave_summ;
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
	public void aL_Establishment_Rpt_ODAndLeaveSummaryReportTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> OD And Leave Summary Report");
		
		od_leave_summ = new AL_Establishment_Rpt_ODAndLeaveSummaryReport(driver);
		test = reports.createTest("aL_Establishment_Rpt_ODAndLeaveSummaryReportTest");
		RF_AdminLoginPage.loginPage();	
		

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		od_leave_summ.Click_REPORTS();
		
		Thread.sleep(8000);
		od_leave_summ.Click_ODAndLeaveSummaryReport();
		
		Thread.sleep(5000);
		od_leave_summ.Set_from_date();
		
		Thread.sleep(5000);
		od_leave_summ.Set_to_date();
		
		Thread.sleep(5000);
		od_leave_summ.Select_College_name();
		
		Thread.sleep(5000);
		od_leave_summ.Select_Stafff_Type();
		
		// For all Employee
		
		Thread.sleep(5000);
		od_leave_summ.Click_summary_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "OD and Leave Summary Report for all Employee");

		Thread.sleep(5000);
		switchToFrameOrDefault();
		
		System.out.println("Report Generated for All Employee");
		
		// for Particular Employee
		
		Thread.sleep(5000);
		od_leave_summ.Click_perticular_employee_check_btn();
		
		Thread.sleep(5000);
		od_leave_summ.Select_employee();
		
		Thread.sleep(5000);
		od_leave_summ.Click_summary_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "OD and Leave Summary Report for particular Employee");

		
	}

}
