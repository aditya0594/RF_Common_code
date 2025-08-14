package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_AdmissionApprovalByFinanceDept;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_AdmissionApprovalByFinanceDeptTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_AdmissionApprovalByFinanceDept admissionbyfinace;
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
	public void aL_Academic_AP_AdmissionApprovalByFinanceDeptTest() throws Throwable {
		
		admissionbyfinace = new AL_Academic_AP_AdmissionApprovalByFinanceDept(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_AdmissionApprovalByFinanceDeptTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Admission Approval By Finance Dept."); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(2000);
		admissionbyfinace.Click_AdmissionApprovalByFinanceDept();
		
		Thread.sleep(2000);
		admissionbyfinace.Select_AdmissionBatch();
		
		Thread.sleep(2000);
		admissionbyfinace.Select_SchoolInstitute();
		
		Thread.sleep(2000);
		admissionbyfinace.Select_Degree();
		
		Thread.sleep(2000);
		admissionbyfinace.Select_ProgrammeBranch();
		
		Thread.sleep(2000);
		admissionbyfinace.Click_Reportbn();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("Architecture","2021-22_Overall_Admission_Status"); 
	}
}
