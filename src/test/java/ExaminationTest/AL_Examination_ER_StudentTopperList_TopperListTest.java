package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_ER_StudentTopperList_TopperList;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_StudentTopperList_TopperListTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_StudentTopperList_TopperList stu_top_list;
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
	public void aL_Examination_ER_StudentTopperList_TopperListTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Student Topper List==>Topper list report");
		
		stu_top_list = new AL_Examination_ER_StudentTopperList_TopperList(driver);
		test = reports.createTest("aL_Examination_ER_StudentTopperList_TopperListTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);

		Thread.sleep(2000);
		HP.Exam_ExaminationReports();
		Thread.sleep(2000);
		
		Thread.sleep(5000);;
		stu_top_list.Student_Topper_List();
		
		Thread.sleep(5000);;
		stu_top_list.Select_College_Scheme();
		
		Thread.sleep(5000);;
		stu_top_list.Select_Session();
		
		Thread.sleep(5000);;
		stu_top_list.Select_Semister();
		
		Thread.sleep(5000);;
		stu_top_list.Select_topperListOnBasis();
		
		Thread.sleep(5000);;
		stu_top_list.Select_TopRange();
		
		// Topper List Report
		Thread.sleep(5000);;
		stu_top_list.Click_Report_btn();
		
		Thread.sleep(5000);

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "Student Topper List Topper List report");
		
		Thread.sleep(5000);;
		switchToFrameOrDefault();
		
	}
}
