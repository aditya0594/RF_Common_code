package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AP_DocumentSubmission;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AP_DocumentSubmissionTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_DocumentSubmission docsubmit;
	HomePageAdmin HP;
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
	public void aL_Academic_AP_DocumentSubmissionTest() throws Exception {
		
		docsubmit = new AL_Academic_AP_DocumentSubmission(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_AP_DocumentSubmissionTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Document Submission"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_AdmissionProcess();
		
		threadWait1();
		docsubmit.Click_DocumentSubmission();
		
		threadWait1();
		docsubmit.Enter_RollNumber();
		
		threadWait1();
		docsubmit.Click_SearchBtn();
		
		threadWait1();
		docsubmit.Select_ChooseFileForPhoto();
		
		threadWait1();
		docsubmit.Select_ChooseFileForSignature();
		
		threadWait1();
		docsubmit.Upload_12thMarkSheet();
		
		threadWait1();
		docsubmit.Upload_AdharCard();
		
		threadWait1();
		
	}
}
