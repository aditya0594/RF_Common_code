package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_LeaveReport_type_OD;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_LeaveReport_type_ODTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_LeaveReport_type_OD od_typ_repo;
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
	public void aL_Establishment_Rpt_LeaveReport_type_ODTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Leave Report ==> Type OD");
		
		od_typ_repo = new AL_Establishment_Rpt_LeaveReport_type_OD(driver);
		test = reports.createTest("aL_Establishment_Rpt_LeaveReport_type_ODTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		od_typ_repo.Click_REPORTS();
		
		Thread.sleep(5000);
		od_typ_repo.Click_LeaveReport();
		
		Thread.sleep(5000);
		od_typ_repo.Select_College_name();
		
		Thread.sleep(5000);
		od_typ_repo.Select_leave();
		
		Thread.sleep(5000);
		od_typ_repo.Select_Stafff_Type();
		
		Thread.sleep(5000);
		od_typ_repo.Set_from_date();
		
		Thread.sleep(5000);
		od_typ_repo.Set_to_date();
		
		// Report for...... Type=>Leave
		
		Thread.sleep(5000);
		od_typ_repo.Click_OD_type_radioBtn();
		
		Thread.sleep(5000);
		od_typ_repo.Click_report_btn();
		
		Thread.sleep(5000);;

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "Leave Report-Type OD");

	}
	
}
