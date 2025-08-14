package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_AdmissionApproval;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_AdmissionApprovalTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_AdmissionApproval admissionapproval;
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
	public void aL_Academic_AP_AdmissionApprovalTest() throws Throwable {
		
		admissionapproval = new AL_Academic_AP_AdmissionApproval(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_AdmissionApprovalTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Admission Approval"); 
		
		Thread.sleep(4000);
		HP.Academic();
		
		Thread.sleep(4000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(4000);
		admissionapproval.Click_AdmissionApproval();
		
		Thread.sleep(4000);
		admissionapproval.Select_AdmissionBatch();
		
		Thread.sleep(4000);
		admissionapproval.Select_SchoolInstitute();
		
		Thread.sleep(4000);
		admissionapproval.Select_Status();
		
		Thread.sleep(4000);
		admissionapproval.Select_Showbtn();
		
		Thread.sleep(4000);
		admissionapproval.Verify_Content();
		
		Thread.sleep(4000);
		admissionapproval.Click_DocumentStatusReport();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("ABIRAMI","2021-22_Document_Status"); 

		
		
	}
}
