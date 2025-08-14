package ExaminationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ExamRegistrationReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_ExamRegistrationReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamRegistrationReport regi_repo;
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
	public void aL_Examination_ER_ExamRegistrationReportTest() throws Exception {
		
	System.out.println("Examination==>Examination Reports==> Exam Registration Report");
		
		regi_repo = new AL_Examination_ER_ExamRegistrationReport(driver);
		test = reports.createTest("aL_Examination_ER_ExamRegistrationReportTest");
		RF_AdminLoginPage.loginPage();
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		

		Thread.sleep(5000);;
		regi_repo.EXAMINATION_REPORT();
		
		Thread.sleep(5000);;
		regi_repo.Select_SchoolInstituteName();
		
		Thread.sleep(5000);;
		regi_repo.Select_Session();
		
		Thread.sleep(5000);;
		regi_repo.Select_Degree();
		
		Thread.sleep(5000);;
		regi_repo.Select_Branch(); 
		
		Thread.sleep(5000);;
		regi_repo.Select_SchemePath();
		
		Thread.sleep(5000);;
		regi_repo.Select_Semister();
		
		Thread.sleep(5000);;
		regi_repo.Select_OrderBy();
		
		Thread.sleep(5000);;
		regi_repo.Click_Show_btn();
		
		Thread.sleep(5000);;
		regi_repo.ScrollToBottom();
		
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Exam Registration Report");
	}
}
