package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_ER_BacklogExamRegistrationReport;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_BacklogExamRegistrationReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_BacklogExamRegistrationReport back_log;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	
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
	public void aL_Examination_ER_BacklogExamRegistrationReportTest() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Backlog Exam Registration Report");
		
		back_log = new AL_Examination_ER_BacklogExamRegistrationReport(driver);
		test = reports.createTest("aL_Examination_ER_BacklogExamRegistrationReportTest");
		RF_AdminLoginPage.loginPage();
		
		pdfutility =new PDFUtility(driver);	
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		HP.Exam_ExaminationReports();
		
		Thread.sleep(5000);
		back_log.Click_BacklogExamRegistrationReport();
		
		Thread.sleep(5000);
		back_log.Select_Session();
		
		Thread.sleep(5000);
		back_log.Select_College_Scheme();
		
		
		Thread.sleep(5000);
		back_log.Select_Semister();
		
		Thread.sleep(5000);
		back_log.Select_Course();
		
		Thread.sleep(5000);
		back_log.Click_StudentBackLogList_btn();
		
		// time increases to 2 minutes
		Thread.sleep(120000);
		pdfutility.downloadPDF(driver, "Examination - Backlog Exam Registration Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Examination - Backlog Exam Registration Report", "PRENAV");	
		
		
	}
}
