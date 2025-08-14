package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_AP_NewAdmissionConsolidateReport_SendEmailTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail mailsend;
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
	public void aL_Academic_AP_NewAdmissionConsolidateReport_SendEmailTest() throws Throwable {
		
		mailsend = new AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_AP_NewAdmissionConsolidateReport_SendEmailTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > New Admission Consolidate Report => Send Email "); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_AdmissionProcess();
		
		threadWait1();
		mailsend.Click_NewAdmissionConsolidateReport();
		
		threadWait1();
		mailsend.Select_AdmissionType();
		
		threadWait1();
		mailsend.Click_SendEmailBtn();
		
		threadWait1();
		mailsend.Click_StudentInformationIncompleteBtn();
		
		threadWait1();
		mailsend.Click_HODNotApprovedbtn();
		
	}
}
