package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_CourseTeacherFeedbackReport;
import RFCCAcademic.AL_Academic_FB_CFR_QuestionWiseResponseReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_CourseTeacherFeedbackReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_CourseTeacherFeedbackReport courseteacherfeedbback;
	ExcelUtility excelutilitytest;
	HomePageAdmin HP;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_FB_CFR_CourseTeacherFeedbackReport() throws Exception {
		
		courseteacherfeedbback = new AL_Academic_FB_CFR_CourseTeacherFeedbackReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("aL_Academic_FB_CFR_CourseTeacherFeedbackReport"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => Course Teacher Feedback Report"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		threadWait1();
		HP.Academic_Feedback();
		
		threadWait1();
		courseteacherfeedbback.CommonFeedbackReport();
		
		threadWait1();
		courseteacherfeedbback.SelectReport();
		
		threadWait1();
		courseteacherfeedbback.Select_CollegeSession();
		
		threadWait1();
		courseteacherfeedbback.FeedBackType();
		
		threadWait1();
		courseteacherfeedbback.CourseTeacherFeedbackReportBtn();
	
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("ABDUL","Feedback Submitted Details"); 
		
	}
}
