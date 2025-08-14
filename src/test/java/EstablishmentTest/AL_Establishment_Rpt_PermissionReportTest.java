package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//import Establishment.AL_Estab_Reports_PermissionReport;
import Establishment.AL_Establishment_Rpt_PermissionReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Establishment_Rpt_PermissionReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_PermissionReport permission_repo;
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
	public void aL_Establishment_Rpt_PermissionReportTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Permission Report ");
		
		permission_repo = new AL_Establishment_Rpt_PermissionReport(driver);
		test = reports.createTest("aL_Establishment_Rpt_PermissionReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();

		
		Thread.sleep(4000);
		permission_repo.Click_REPORTS();
		
		Thread.sleep(4000);
		permission_repo.Click_Permission_Report();
		
		Thread.sleep(4000);
		permission_repo.Select_College();
		
		Thread.sleep(4000);
		permission_repo.Select_Stafff_Type();
		
		Thread.sleep(4000);
		permission_repo.Set_from_date();
		
		Thread.sleep(4000);
		permission_repo.Set_to_date();
		
		Thread.sleep(4000);
		permission_repo.Click_report_btn();
		
		System.out.println("Prmission Report is generated");
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(4000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "Permission Report");

	}

}
