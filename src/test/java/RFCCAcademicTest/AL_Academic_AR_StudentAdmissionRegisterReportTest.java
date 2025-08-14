package RFCCAcademicTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AR_StudentAdmissionRegisterReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.DonwloadPDF;
import utility.Reports;
import utility.Screenshot;
import utility.PDFUtility;

public class AL_Academic_AR_StudentAdmissionRegisterReportTest extends BaseClass { 

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AR_StudentAdmissionRegisterReport al_Academic_AR_StudentAdmissionRegisterReport;
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
	public void aL_Academic_AR_StudentAdmissionRegisterReportTest() throws Exception { 
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AR_StudentAdmissionRegisterReport = new AL_Academic_AR_StudentAdmissionRegisterReport(driver);
		test = reports.createTest("aL_Academic_AR_StudentAdmissionRegisterReportTest");
		pdfutility =new PDFUtility(driver);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(3000);
		
		System.out.println("Academic->Academic Reports->Student Admission Register Report");
		
		Thread.sleep(5000);
		homePageAdmin.Academic();
		Thread.sleep(5000);

		// Locating the element from Sub Menu
		homePageAdmin.Academic_AcademicReport();

		Thread.sleep(5000);
		//Click on Student Admission Register Report
		al_Academic_AR_StudentAdmissionRegisterReport.Click_StudentAdmissionRegReport();

		Thread.sleep(5000);
		//Select Academic Year
		al_Academic_AR_StudentAdmissionRegisterReport.Select_AcademicYear();
		
		Thread.sleep(7000);
		//Select School/Institute
		al_Academic_AR_StudentAdmissionRegisterReport.Select_School();

		Thread.sleep(7000);
		//Select Department
		al_Academic_AR_StudentAdmissionRegisterReport.Select_Department();

		Thread.sleep(7000);
		//Select Degree
		al_Academic_AR_StudentAdmissionRegisterReport.Select_Degree();

		Thread.sleep(8000);
		//Click Admission Roll List Button 
		al_Academic_AR_StudentAdmissionRegisterReport.Click_AdmissionRollist_Button();
		
		Thread.sleep(6000);
        switchToNextWindow();
        
        Thread.sleep(5000);
        pdfutility.downloadPDF(driver, "Academic - Student Admission Register Report");
        Thread.sleep(2000);
        pdfutility.readPDF("Academic - Student Admission Register Report","SOHAM");
	}

}
