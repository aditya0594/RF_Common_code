package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_SurvayReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_SurvayReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_SurvayReport survayreport;
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
		
		survayreport = new AL_Academic_FB_CFR_SurvayReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FB_CFR_SurvayReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => Survay Report"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(3000);
		HP.Academic_Feedback();
		
		Thread.sleep(3000);
		survayreport.CommonFeedbackReport();
		
		Thread.sleep(3000);
		survayreport.SelectReport();
		
		Thread.sleep(3000);
		survayreport.SelectSession();
		
		Thread.sleep(3000);
		survayreport.SelectCollege();
		
		Thread.sleep(3000);
		survayreport.SelectSemester(); 
		
		Thread.sleep(3000);
		survayreport.Select_Section();
		
		Thread.sleep(3000);
		survayreport.FeedBackType();
		
		Thread.sleep(3000);
		survayreport.SurvayReportBtn();
				
		Thread.sleep(5000);
		
		excelutilitytest.ReadExcel("ABDUL","SSS Servey Report"); 
		
	}
}
