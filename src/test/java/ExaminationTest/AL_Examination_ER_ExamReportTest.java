package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_ER_ExamReport;
//import AdminPayroll.Payroll_report_EmployeesAbstactSalary;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Examination_ER_ExamReportTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_ER_ExamReport exam_report;
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
	public void aL_Examination_ER_ExamReportTest() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Examination==>Examination Reports==> Exam Report");
		
		exam_report = new AL_Examination_ER_ExamReport(driver);
		pdfutility =new PDFUtility(driver);	
	
		test = reports.createTest("Examination_ExaminationReport_ExamReport_Test");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(4000);
		exam_report.EXAMINATION_REPORT(); 
		
		Thread.sleep(4000);
		exam_report.EXAM_REPORT();
		
		Thread.sleep(4000);
		exam_report.College_Scheme(); 
		
		Thread.sleep(4000);
		exam_report.Session();
		
		Thread.sleep(4000);
		exam_report.Semister();
		
		Thread.sleep(4000);
		exam_report.Section();
		
		Thread.sleep(4000);
		exam_report.Exam_Name();
		
		
		Thread.sleep(4000);
		exam_report.Sub_Exam();
		
		Thread.sleep(4000);
		exam_report.Course();
		
		Thread.sleep(5000);
		exam_report.overall_subject_percentage_btn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Examination - Exam Reports");
		Thread.sleep(2000);
		pdfutility.readPDF("Examination - Exam Reports", "MANIVANNAN");	
		
	}

}
