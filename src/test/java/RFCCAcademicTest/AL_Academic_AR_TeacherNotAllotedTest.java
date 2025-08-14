package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_TeacherNotAlloted;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AR_TeacherNotAllotedTest extends BaseClass{


	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AR_TeacherNotAlloted aL_Academic_AR_TeacherNotAlloted;
	ExcelUtility excelutilitytest;
	
	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Academic_PA_AdmissionCancellationTest() throws Throwable {


		test = reports.createTest("aL_Academic_PA_AdmissionCancellationTest");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AR_TeacherNotAlloted = new AL_Academic_AR_TeacherNotAlloted(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Post Admission-> Teacher Not Alloted ");

		homePageAdmin.Academic();
		threadWait1();
		homePageAdmin.Academic_AcademicReport();
		threadWait1();
		
		aL_Academic_AR_TeacherNotAlloted.click_teacherNotAlloted_link();
		
		threadWait1();
		aL_Academic_AR_TeacherNotAlloted.select_report();
		
		threadWait1();
		aL_Academic_AR_TeacherNotAlloted.select_session();
		
		threadWait1();
		aL_Academic_AR_TeacherNotAlloted.click_excelReportBtn();
		
		threadWait1();
		excelutilitytest.ReadExcel("Islamic","Course-Teacher Not Allotted"); 
		
	}
	
}
