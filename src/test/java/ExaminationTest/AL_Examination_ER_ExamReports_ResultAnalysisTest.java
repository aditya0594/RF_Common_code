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

import Examination.AL_Examination_ER_ExamReports_ResultAnalysis;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_ER_ExamReports_ResultAnalysisTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReports_ResultAnalysis result_ana;
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
	public void aL_Examination_ER_ExamReports_ResultAnalysisTest() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report=>Result Analysys btn");
		
		result_ana = new AL_Examination_ER_ExamReports_ResultAnalysis (driver);
		test = reports.createTest("aL_Examination_ER_ExamReports_ResultAnalysisTest ");
		RF_AdminLoginPage.loginPage();
		pdfutility =new PDFUtility(driver);	

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(4000);
		result_ana.EXAMINATION_REPORT();
		
		Thread.sleep(4000);
		result_ana.EXAM_REPORT();
		
		Thread.sleep(4000);
		result_ana.College_Scheme();
		
		Thread.sleep(4000);
		result_ana.Session();
		
		Thread.sleep(4000);
		result_ana.Semister();
		
		Thread.sleep(4000);
		result_ana.Section();
		
		Thread.sleep(4000);
		result_ana.Exam_Name();
		
		Thread.sleep(4000);
		result_ana.Sub_Exam();
		
		Thread.sleep(4000);
		result_ana.Course();
		
		Thread.sleep(4000);
		result_ana.Result_analysis_btn();
	
		Thread.sleep(8000);
		pdfutility.downloadPDF(driver, "Examination - Result Analysis");
		Thread.sleep(2000);
		pdfutility.readPDF("Examination - Result Analysis","Passed");	

	}


}
