package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ConsolidatedMarkEntryReport;
import Examination.AL_Examination_ER_ExamReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_ConsolidatedMarkEntryReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ConsolidatedMarkEntryReport con_repo;
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
	public void aL_Examination_ER_ConsolidatedMarkEntryReportTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==>Consolidated MarkEntry Report");
		
		con_repo = new AL_Examination_ER_ConsolidatedMarkEntryReport(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Examination_ER_ConsolidatedMarkEntryReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		HP.Exam_ExaminationReports();
		
		Thread.sleep(5000);
		con_repo.Click_ConsolidatedMarkEntryReport();
		
		Thread.sleep(5000);
		con_repo.Select_College_Scheme();
		
		Thread.sleep(5000);
		con_repo.Select_Session();
		
		Thread.sleep(5000);
		con_repo.Select_Semister();
		
		Thread.sleep(5000);
		con_repo.Select_Mode();
		
		Thread.sleep(5000);
		con_repo.Select_Section();
		
		Thread.sleep(5000);;
		con_repo.Click_Show_btn();
		
		Thread.sleep(5000);;
		con_repo.Set_PageResolution();
		
		Thread.sleep(5000);
		con_repo.Set_PageOrientation();
		
		Thread.sleep(5000);
		con_repo.Click_GenerateReport_btn();
		
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Consolidated Mark Entry Report");
	}
}
