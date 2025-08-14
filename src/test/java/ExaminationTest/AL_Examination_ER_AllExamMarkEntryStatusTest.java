package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_ER_AllExamMarkEntryStatus;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_AllExamMarkEntryStatusTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_AllExamMarkEntryStatus status;
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
	public void aL_Examination_ER_AllExamMarkEntryStatusTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==>AllExamMarkEntryStatus");
		
		status = new AL_Examination_ER_AllExamMarkEntryStatus(driver);
		test = reports.createTest("aL_Examination_ER_AllExamMarkEntryStatusTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(5000);;
		HP.Exam_ExaminationReports();
		
		Thread.sleep(5000);;
		status.Click_AllExamMarkEntryStatus();
		
		Thread.sleep(5000);
		status.Select_Session();
		
		Thread.sleep(5000);;
		status.Select_ExamPattern();
		
		Thread.sleep(5000);;
		status.Select_ExamName();
		
		Thread.sleep(5000);;
		status.Select_SubExamName();
		
		Thread.sleep(5000);;
		status.Click_ShowMarkEntryStatus_btn();
		
		Thread.sleep(5000);;
		System.out.println("Take Screenshot of report");
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "All Exam Mark Entry Status");
	}
}
