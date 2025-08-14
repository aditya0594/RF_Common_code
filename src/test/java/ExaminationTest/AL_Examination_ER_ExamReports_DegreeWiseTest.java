package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ExamReports_DegreeWise;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
import utility.BaseClass;

public class AL_Examination_ER_ExamReports_DegreeWiseTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReports_DegreeWise degree_repo;
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
	public void aL_Examination_ER_ExamReports_DegreeWiseTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>DegreeWise btn");
		
		degree_repo = new AL_Examination_ER_ExamReports_DegreeWise(driver);
		test = reports.createTest("aL_Examination_ER_ExamReports_DegreeWiseTest");
		RF_AdminLoginPage.loginPage();
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		

		Thread.sleep(5000);;
		degree_repo.EXAMINATION_REPORT();
		
		Thread.sleep(5000);;
		degree_repo.EXAM_REPORT();
		
		Thread.sleep(5000);;
		degree_repo.College_Scheme();
		
		Thread.sleep(5000);
		degree_repo.Session();
		
		Thread.sleep(5000);
		degree_repo.Semister();
		
		Thread.sleep(5000);
		degree_repo.Section();
		
		Thread.sleep(5000);
		degree_repo.Exam_Name();
		
		Thread.sleep(5000);
		degree_repo.Sub_Exam();
		
		Thread.sleep(5000);
		degree_repo.Course();
		
		Thread.sleep(5000);
		degree_repo.degreeWise();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

//		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "ExamReports_DegreeWise");
	}


}
