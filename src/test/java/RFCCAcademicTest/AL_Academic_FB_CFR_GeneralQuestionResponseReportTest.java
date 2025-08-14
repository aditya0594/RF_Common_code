package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_GeneralQuestionResponseReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_GeneralQuestionResponseReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_GeneralQuestionResponseReport generalquestion;
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
	public void aL_Academic_FB_CFR_SurvayReportTest() throws Exception {
		
		generalquestion = new AL_Academic_FB_CFR_GeneralQuestionResponseReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FB_CFR_SurvayReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => General Question Response Report"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_Feedback();
		
		Thread.sleep(2000);
		generalquestion.CommonFeedbackReport();
		
		Thread.sleep(2000);
		generalquestion.SelectReport();
		
		Thread.sleep(2000);
		generalquestion.SelectSession();
		
		Thread.sleep(2000);
		generalquestion.SelectCollege();
		
		Thread.sleep(2000);
		generalquestion.SelectSemester(); 
		
		Thread.sleep(2000);
		generalquestion.FeedBackType();
		
		Thread.sleep(2000);
		generalquestion.GeneralQuestionResponseReportBtn();
				
		Thread.sleep(5000);
		
		excelutilitytest.ReadExcel("ABDUL","Question Wise Response"); 
		
	}
}
