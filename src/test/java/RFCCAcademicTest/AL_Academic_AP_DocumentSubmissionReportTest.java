package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_DocumentSubmissionReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_DocumentSubmissionReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_DocumentSubmissionReport documentsubmit;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_AP_DocumentSubmissionReportTest() throws Throwable {
		
		documentsubmit = new AL_Academic_AP_DocumentSubmissionReport(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_DocumentSubmissionReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Document Submission Report"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(2000);
		documentsubmit.Click_DocumentSubmissionReport();
		
		Thread.sleep(2000);
		documentsubmit.Select_SchoolInstitute();
		
		Thread.sleep(2000);
		documentsubmit.Select_Degree();
		
		Thread.sleep(2000);
		documentsubmit.Select_AdmissionBatch();
		
		Thread.sleep(2000);
		documentsubmit.Click_DocumentSubmissionReportBtn();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("Crescent School of Architecture","DocumentSubmissionReport"); 
		
	}
}
