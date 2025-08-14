package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FB_CFR_FacultyFeedbackReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_FB_CFR_FacultyFeedbackReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FB_CFR_FacultyFeedbackReport CommonFeedbackReport;
	PDFUtility pdfutility;
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
	public void aL_Academic_FB_CFR_FacultyFeedbackReportTest() throws Exception {

		CommonFeedbackReport = new AL_Academic_FB_CFR_FacultyFeedbackReport(driver);
		pdfutility = new PDFUtility(driver);
		HP = new HomePageAdmin(driver);
		

		test = reports.createTest("aL_Academic_FB_CFR_FacultyFeedbackReportTest");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();

		System.out.println("ACADEMIC > FEEDBACK > Common FeedBack Report => Faculty Feedback Report");

		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		Thread.sleep(2000);
		CommonFeedbackReport.FeedBack();

		Thread.sleep(2000);
		CommonFeedbackReport.CommonFeedbackReport();

		Thread.sleep(2000);
		CommonFeedbackReport.SelectReport();

		Thread.sleep(2000);
		CommonFeedbackReport.SelectSession();

		Thread.sleep(2000);
		CommonFeedbackReport.SelectCollege();

		Thread.sleep(2000);
		CommonFeedbackReport.SelectSemester();

		Thread.sleep(2000);
		CommonFeedbackReport.FeedBackType();

		Thread.sleep(2000);
		CommonFeedbackReport.SelectFormat();

		Thread.sleep(2000);
		CommonFeedbackReport.FacultyFeedbackReport();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "ACADEMIC - Faculty Feedback Report");
		Thread.sleep(5000);
		pdfutility.readPDF("ACADEMIC - Faculty Feedback Report", "Teacher");

	}
}
