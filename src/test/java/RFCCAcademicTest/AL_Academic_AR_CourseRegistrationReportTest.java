package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_CourseRegistrationReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_AR_CourseRegistrationReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_AR_CourseRegistrationReport courseregreport;
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
	public void aL_Academic_AR_CourseRegistrationReportTest() throws Exception {
		test = reports.createTest("aL_Academic_AR_CourseRegistrationReportTest");
		HP = new HomePageAdmin(driver);
		courseregreport = new AL_Academic_AR_CourseRegistrationReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		
		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Academic Reports->Course Registration Report");
		
		Thread.sleep(2000);
		//Click on Main Academic link
		HP.Academic();

		Thread.sleep(2000);
		//Click on Academic Reports link
		HP.Academic_AcademicReport();

		Thread.sleep(2000);
		//Click on Course Registration Report
		courseregreport.Click_CourseRegReport();
		
		Thread.sleep(2000);
		//Select Session
		courseregreport.Select_Session();
		
		Thread.sleep(2000);
		//Select College
		courseregreport.Select_College();
		
		Thread.sleep(2000);
		//Select Report Type
		courseregreport.Select_Report();
		
		
		Thread.sleep(2000);
		courseregreport.Select_Course();
		
		Thread.sleep(2000);
		courseregreport.Click_ExcelReport_Button();
		
		Thread.sleep(6000);
		
		excelutilitytest.ReadExcel("LAW","CourseReg_Summary");
	}
}
