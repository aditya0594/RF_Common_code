package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_PEA_ExamTimeTableReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_PEA_ExamTimeTableReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_PEA_ExamTimeTableReport al_Examination_PEA_ExamTimeTableReport;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {

		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Examination_PEA_ExamTimeTableReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_PEA_ExamTimeTableReport = new AL_Examination_PEA_ExamTimeTableReport(driver);

		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		// Click Main Examination Menu
		homePageAdmin.EXAMINATION();

		Thread.sleep(4000);
		// Click Pre Examination Activities
		homePageAdmin.Exam_PreExamActivities();

		Thread.sleep(2000);
		// Click Exam Timetable Report
		al_Examination_PEA_ExamTimeTableReport.click_examTimeTableReport_link();

		Thread.sleep(2000);
		// Select Session
		al_Examination_PEA_ExamTimeTableReport.select_session();

		Thread.sleep(2000);
		// Select Institute
		al_Examination_PEA_ExamTimeTableReport.select_institute();

		Thread.sleep(2000);
		// Select Degree
		al_Examination_PEA_ExamTimeTableReport.select_degree();

		Thread.sleep(2000);
		// Select Branch
		al_Examination_PEA_ExamTimeTableReport.select_branchName();

		Thread.sleep(2000);
		// Select Scheme
		al_Examination_PEA_ExamTimeTableReport.select_scheme();

		Thread.sleep(2000);
		// Select Semester
		al_Examination_PEA_ExamTimeTableReport.select_semester();

		Thread.sleep(2000);
		// Select Exam Name
		al_Examination_PEA_ExamTimeTableReport.select_examName();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Enter From Date
		al_Examination_PEA_ExamTimeTableReport.enter_fromDate();

		Thread.sleep(2000);
		// Enter To Date
		al_Examination_PEA_ExamTimeTableReport.enter_toDate();

		Thread.sleep(2000);
		// Click on Date wise Timetable Access
		al_Examination_PEA_ExamTimeTableReport.click_datawiseTimeTable_button();

		Thread.sleep(5000);
		excelutilitytest = new ExcelUtility(driver);
		excelutilitytest.ReadExcel("Architecture", "DateWiseTimeTable");
		
		
		Thread.sleep(2000);
		// Click on Exam Time Table Report Button
		al_Examination_PEA_ExamTimeTableReport.click_examTimeTableReport_button();

		Thread.sleep(5000);
		pdfutility = new PDFUtility(driver);
		pdfutility.downloadPDF(driver, "Examination - Exam Time Table Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Examination - Exam Time Table Report", "Monday");

	}

}
