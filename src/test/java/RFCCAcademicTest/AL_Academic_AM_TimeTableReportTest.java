package RFCCAcademicTest;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_TimeTableReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_AM_TimeTableReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_TimeTableReport al_Academic_AM_TimeTableReport;
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
	public void aL_Academic_AM_TimeTableReportTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AM_TimeTableReport = new AL_Academic_AM_TimeTableReport(driver);
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
		//Select Session
		al_Academic_AM_TimeTableReport.select_Session();

		Thread.sleep(7000);
		//Select Semester
		al_Academic_AM_TimeTableReport.select_Semester();

		Thread.sleep(5000);
		//Select Section
		al_Academic_AM_TimeTableReport.select_Section();

		Thread.sleep(5000);
		//Select slot
		al_Academic_AM_TimeTableReport.select_SlotType();

		Thread.sleep(5000);
		//click Time Table Report Format - I
		al_Academic_AM_TimeTableReport.click_TimeTableReportFormatI_Btn();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Timetable Report Formate I");
		Thread.sleep(5000);
		pdfutility.readPDF("Academic - Timetable Report Formate I", "Bachelor");
		

		/*
		 * Thread.sleep(5000); System.out.println("entering to next window "); String
		 * currentWindowHandle = driver.getWindowHandle(); Set<String> allWindowHandles
		 * = driver.getWindowHandles();
		 * 
		 * for (String handle : allWindowHandles) { if
		 * (!handle.equals(currentWindowHandle)) { driver.switchTo().window(handle);
		 * break; } }
		 * 
		 * Thread.sleep(5000); Screenshot.takesScreenshot(getCurrentDateAndTime());
		 * 
		 * Thread.sleep(5000); driver.switchTo().window(currentWindowHandle);
		 * System.out.println("back to original window");
		 * 
		 * Thread.sleep(5000); //click Time Table Report Format - II
		 * al_Academic_AM_TimeTableReport.click_TimeTableReportFormatII_Btn();
		 * 
		 * for (String handle : allWindowHandles) { if
		 * (!handle.equals(currentWindowHandle)) { driver.switchTo().window(handle);
		 * break; } }
		 * 
		 * Thread.sleep(5000); Screenshot.takesScreenshot(getCurrentDateAndTime());
		 * captureScreenshot(driver, "Time Table Report 1");
		 * 
		 * Thread.sleep(5000); driver.switchTo().window(currentWindowHandle);
		 * System.out.println("back to original window");
		 * 
		 * Thread.sleep(5000); //Enter From Date //WebElement frm_date =
		 * driver.findElement(By.id(""));
		 * al_Academic_AM_TimeTableReport.enter_FromDate();
		 * 
		 * Thread.sleep(5000); //Enter To Date //WebElement to_date =
		 * driver.findElement(By.id("")); al_Academic_AM_TimeTableReport.enter_ToDate();
		 * 
		 * Thread.sleep(5000); //click Master Time Table
		 * al_Academic_AM_TimeTableReport.click_MasterTimeTable_Button();
		 * 
		 * 
		 * Thread.sleep(5000); Screenshot.takesScreenshot(getCurrentDateAndTime());
		 * 
		 * captureScreenshot(driver, "Time Table Report 2"); Thread.sleep(5000);
		 */
	}
}
