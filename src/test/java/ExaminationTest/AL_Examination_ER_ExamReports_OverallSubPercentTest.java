package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ExamReports_OverallSubPercent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_ExamReports_OverallSubPercentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReports_OverallSubPercent exam_report;
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
	public void aL_Examination_ER_ExamReports_OverallSubPercentTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Overall_Subject_Percentage_btn");
		
		exam_report = new AL_Examination_ER_ExamReports_OverallSubPercent (driver);
		test = reports.createTest("aL_Examination_ER_ExamReports_OverallSubPercentTest ");
		RF_AdminLoginPage.loginPage();
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();

		

		Thread.sleep(5000);
		exam_report.EXAMINATION_REPORT();
		
		Thread.sleep(5000);
		exam_report.EXAM_REPORT();
		
		Thread.sleep(5000);
		exam_report.College_Scheme();
		
		Thread.sleep(5000);
		exam_report.Session();
		
		Thread.sleep(5000);
		exam_report.Semister();
		
		Thread.sleep(5000);
		exam_report.Section();
		
		Thread.sleep(5000);
		exam_report.Exam_Name();
		
		Thread.sleep(5000);
		exam_report.Sub_Exam();
		
		Thread.sleep(5000);
		exam_report.Course();
		
		Thread.sleep(5000);
		exam_report.overall_subject_percentage_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "ExamReports OverallSubPercent");
	}


}
