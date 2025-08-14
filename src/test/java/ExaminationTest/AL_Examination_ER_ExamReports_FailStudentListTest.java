package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ExamReports_FailStudentList;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;


public class AL_Examination_ER_ExamReports_FailStudentListTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReports_FailStudentList fail_stud;
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
	public void aL_Examination_ER_ExamReports_FailStudentListTest () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Fail_Student_List btn");
		
		fail_stud = new AL_Examination_ER_ExamReports_FailStudentList(driver);
		test = reports.createTest("aL_Examination_ER_ExamReports_FailStudentListTest ");
		RF_AdminLoginPage.loginPage();
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		

		Thread.sleep(5000);
		fail_stud.EXAMINATION_REPORT();
		
		Thread.sleep(5000);
		fail_stud.EXAM_REPORT();
		
		Thread.sleep(5000);
		fail_stud.College_Scheme();
		
		Thread.sleep(5000);
		fail_stud.Session();
		
		Thread.sleep(5000);
		fail_stud.Semister();
		
		Thread.sleep(5000);
		fail_stud.Section();
		
		Thread.sleep(5000);
		fail_stud.Exam_Name();
		
		Thread.sleep(5000);
		fail_stud.Sub_Exam();
		
		Thread.sleep(5000);
		fail_stud.Course();
		
		Thread.sleep(5000);
		fail_stud.fail_student_list_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "ExamReports FailStudentList");
	}


}
