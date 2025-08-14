package RFCCAcademicTest; 

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_StudentAdmissionReports;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AR_StudentAdmissionReportsTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AR_StudentAdmissionReports studAddReport;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;

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
	public void aL_Academic_AR_StudentAdmissionReportsTest() throws Exception {

		test = reports.createTest("aL_Academic_AR_StudentAdmissionReportsTest");
		studAddReport = new AL_Academic_AR_StudentAdmissionReports(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		HP.Academic_AcademicReport();
		
		Thread.sleep(2000);
		studAddReport.Click_Student_AdmissionReports_Link();
		
		Thread.sleep(2000);
		studAddReport.Select_Report();
		
		Thread.sleep(2000);
		studAddReport.Select_AcademicYear();
		
		Thread.sleep(2000);
		studAddReport.Click_View_Button();
		
		Thread.sleep(2000);
		studAddReport.Click_ExportInExcel_Button();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("208021601040","AllYear_SemesterAdmitted"); 

		
	}
}
