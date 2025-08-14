package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

import utility.BaseClass;

public class AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport sgpa_cgpa;
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
	public void aL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReportTest () throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Subject wise result analysis");
		
		sgpa_cgpa = new AL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReport(driver);
		test = reports.createTest("aL_Examination_ER_ExamReports_SubjectWiseResultAnalysisReportTest ");
		RF_AdminLoginPage.loginPage();
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();


		Thread.sleep(5000);
		sgpa_cgpa.EXAMINATION_REPORT();
		
		Thread.sleep(5000);
		sgpa_cgpa.EXAM_REPORT();
		
		Thread.sleep(5000);
		sgpa_cgpa.College_Scheme();
		
		Thread.sleep(5000);
		sgpa_cgpa.Session();
		
		Thread.sleep(5000);
		sgpa_cgpa.Semister();
		
		Thread.sleep(5000);
		sgpa_cgpa.Section();
		
		Thread.sleep(5000);
		sgpa_cgpa.Exam_Name();
		
		Thread.sleep(5000);
		sgpa_cgpa.Sub_Exam();
		
		Thread.sleep(5000);
		sgpa_cgpa.Course();
		
		Thread.sleep(5000);
		sgpa_cgpa.Click_SubjectWiseResultAnalysisReportBtn();
		
	}


}
