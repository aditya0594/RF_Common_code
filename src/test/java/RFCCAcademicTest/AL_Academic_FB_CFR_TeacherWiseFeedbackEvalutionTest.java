package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_TeacherWiseFeedbackEvalution;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_TeacherWiseFeedbackEvalutionTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_TeacherWiseFeedbackEvalution Teacherwisefeedback;
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
	public void aL_Academic_FB_CFR_TeacherWiseFeedbackEvalutionTest() throws Exception {
		
		Teacherwisefeedback = new AL_Academic_FB_CFR_TeacherWiseFeedbackEvalution(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FB_CFR_TeacherWiseFeedbackEvalutionTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => TEACHER WISE FEEDBACK EVALUTION REPORT(EXCEL)"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(3000);
		HP.Academic_Feedback();
		
		Thread.sleep(3000);
		Teacherwisefeedback.CommonFeedbackReport();
		
		Thread.sleep(3000);
		Teacherwisefeedback.SelectReport();
		
		Thread.sleep(3000);
		Teacherwisefeedback.SelectSession();
		
		Thread.sleep(3000);
		Teacherwisefeedback.SelectCollege();
		
		Thread.sleep(3000);
		Teacherwisefeedback.SelectSemester(); 
		
		Thread.sleep(3000);
		Teacherwisefeedback.FeedBackType();
		
		Thread.sleep(3000);
		Teacherwisefeedback.TeacherWiseFeedbackEvalution(); 
				
		Thread.sleep(5000);
		
		excelutilitytest.ReadExcel("IBRAHIM","Faculty Feedback Report"); 
		
	}
}
