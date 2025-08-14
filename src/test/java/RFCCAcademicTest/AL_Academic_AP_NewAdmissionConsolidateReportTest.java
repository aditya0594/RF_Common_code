package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_DocumentSubmissionReport;
import RFCCAcademic.AL_Academic_AP_NewAdmissionConsolidateReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_NewAdmissionConsolidateReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_NewAdmissionConsolidateReport consolidatereport;
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
	public void aL_Academic_AP_NewAdmissionConsolidateReportTest() throws Throwable {
		
		consolidatereport = new AL_Academic_AP_NewAdmissionConsolidateReport(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_NewAdmissionConsolidateReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > New Admission Consolidate Report"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(2000);
		consolidatereport.Click_NewAdmissionConsolidateReport();
		
		Thread.sleep(2000);
		consolidatereport.Select_AdmissionType();
		
		Thread.sleep(2000);
		consolidatereport.Click_GenerateReportBtn();
		
		Thread.sleep(3000);
		consolidatereport.Click_OverallAdmissionStatusBtn();
		
		Thread.sleep(3000);
		consolidatereport.Click_InformationFillUpStatusBtn();
		
		Thread.sleep(3000);
		consolidatereport.Click_ApprovalStatusbyHOD();
		
		Thread.sleep(3000);
		consolidatereport.Click_ApprovalStatusbyFinancedept();
		
		Thread.sleep(3000);
		consolidatereport.Click_PaymentStatusByStudent();
		
	}
}
