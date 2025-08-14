package RFCCAcademicTest;

import java.lang.reflect.Method;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import RFCCAcademic.AL_Academic_AM_TimeTableReport1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;


public class AL_Academic_AM_TimeTableReportTest1 extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_TimeTableReport1 al_Academic_AM_TimeTableReport;
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
	public void aL_Academic_AM_TimeTableReportTest1() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AM_TimeTableReport = new AL_Academic_AM_TimeTableReport1(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Academic_AM_TimeTableReportTest"); 

		RF_AdminLoginPage.loginPage();

		System.out.println("Academics -> Attendance Managment -> Time Table Report");

		Thread.sleep(5000);
		// click academic
		homePageAdmin.Academic();

		Thread.sleep(5000);
		// click attendance management
		homePageAdmin.Academic_AttendanceManagement();

		Thread.sleep(5000);
		// click time table report
		al_Academic_AM_TimeTableReport.click_TimeTableReport_Link();

		Thread.sleep(5000);
		// click college/Scheme
		al_Academic_AM_TimeTableReport.select_College();

		Thread.sleep(5000);
		// Select Session
		al_Academic_AM_TimeTableReport.select_Session();

		Thread.sleep(7000);
		// Select Semester
		al_Academic_AM_TimeTableReport.select_Semester();

		Thread.sleep(5000);
		// Select Section
		al_Academic_AM_TimeTableReport.select_Section();

		Thread.sleep(5000);
		// Select slot
		al_Academic_AM_TimeTableReport.select_SlotType();

		Thread.sleep(5000); // click Time Table Report Format - II
		al_Academic_AM_TimeTableReport.click_TimeTableReportFormatII_Btn();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Timetable Report Formate II");
		Thread.sleep(5000);
		pdfutility.readPDF("Academic - Timetable Report Formate II", "Bachelor");

	}
}
