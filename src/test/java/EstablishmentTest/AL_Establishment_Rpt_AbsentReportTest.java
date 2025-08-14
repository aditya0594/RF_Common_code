package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_AbsentReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_AbsentReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_AbsentReport abs_repo;
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
	public void aL_Establishment_Rpt_AbsentReportTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==>AbsentReport");
		
		abs_repo = new AL_Establishment_Rpt_AbsentReport(driver);
		test = reports.createTest("AL_Establishment_Rpt_AbsentReportTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		abs_repo.click_REPORTS();
		
		Thread.sleep(5000);
		abs_repo.click_AbsentReport();
		
		Thread.sleep(5000);
		abs_repo.select_College_name();
		
		Thread.sleep(5000);
		abs_repo.select_Stafff_Type();
		
		Thread.sleep(5000);
		abs_repo.set_from_date();
		
		Thread.sleep(5000);
		abs_repo.set_to_date();
		
		Thread.sleep(5000);
		abs_repo.select_report_type();
		
		//For All Employee
		
		Thread.sleep(5000);
		abs_repo.Click_report_btn();
		
		Thread.sleep(8000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		
		captureScreenshot(driver, "Absent Report");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
		
		System.out.println("Report Generated for All Employee");
		
		//For Particular Employee
		
		Thread.sleep(8000);
		abs_repo.Set_perticular_employee();
		
		Thread.sleep(5000);
		abs_repo.Click_report_btn();
		
		Thread.sleep(8000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		
		captureScreenshot(driver, "Absent Report");
	}

}
