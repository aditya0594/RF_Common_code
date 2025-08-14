package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_QuestionWiseResponseReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_QuestionWiseResponseReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_QuestionWiseResponseReport questionwiseresponse;
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
	public void aL_Academic_FB_CFR_QuestionWiseResponseReportTest() throws Exception {
		
		questionwiseresponse = new AL_Academic_FB_CFR_QuestionWiseResponseReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FB_CFR_QuestionWiseResponseReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => Question Wise Response Report"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_Feedback();
		
		Thread.sleep(2000);
		questionwiseresponse.CommonFeedbackReport();
		
		Thread.sleep(2000);
		questionwiseresponse.SelectReport();
		
		Thread.sleep(2000);
		questionwiseresponse.SelectSession();
		
		Thread.sleep(2000);
		questionwiseresponse.SelectCollege();
		
		Thread.sleep(2000);
		questionwiseresponse.SelectSemester(); 
		
		Thread.sleep(2000);
		questionwiseresponse.FeedBackType();
		
		Thread.sleep(2000);
		questionwiseresponse.QuestionWiseResponseReportbtn();
				
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("ABDUL","Question Wise Response"); 
		
	}
}
