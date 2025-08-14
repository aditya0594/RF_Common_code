package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_HODFeedbackReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_HODFeedbackReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_HODFeedbackReport HODfeedback;
	PDFUtility pdfutility;
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
	public void aL_Academic_FB_CFR_HODFeedbackReportTest() throws Exception {
		
		HODfeedback = new AL_Academic_FB_CFR_HODFeedbackReport(driver);
		pdfutility =new PDFUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FB_CFR_HODFeedbackReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => HOD Feedback Report"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_Feedback();
		
		Thread.sleep(2000);
		HODfeedback.CommonFeedbackReport();
		
		Thread.sleep(2000);
		HODfeedback.SelectReport();
		
		Thread.sleep(2000);
		HODfeedback.SelectSession();
		
		Thread.sleep(2000);
		HODfeedback.SelectCollege();
		
		Thread.sleep(2000);
		HODfeedback.SelectSemester(); 
		
		Thread.sleep(2000);
		HODfeedback.FeedBackType();
		
		Thread.sleep(2000);
		HODfeedback.HODFeedBackReportBtn();
				
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "ACADEMIC - HOD Feedback Report");
		Thread.sleep(5000);
		pdfutility.readPDF("ACADEMIC - HOD Feedback Report", "IBRAHIM");	
		
	}
}
