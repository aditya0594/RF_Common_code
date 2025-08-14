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

import RFCCAcademic.AL_Academic_AP_StudentInformationVerification;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_AP_StudentInformationVerificationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_StudentInformationVerification infoVerification;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	
	
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
	public void aL_Academic_AP_StudentInformationVerificationTest() throws Throwable {
		
		infoVerification = new AL_Academic_AP_StudentInformationVerification(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Academic_AP_StudentInformationVerificationTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Admission Procces > Student Information Verification"); 
		
		Thread.sleep(3000);
		HP.Academic();
		
		Thread.sleep(3000);
		HP.Academic_AdmissionProcess();
		
		Thread.sleep(3000);
		infoVerification.Click_StudentInformationVerification();
		
		Thread.sleep(3000);
		infoVerification.Select_AdmissionBatch();
		
		Thread.sleep(3000);
		infoVerification.Select_SchoolInstitute();
		
		Thread.sleep(3000);
		infoVerification.Select_Degree();
		
		Thread.sleep(3000);
		infoVerification.Select_ProgrammeBranch();
		
		Thread.sleep(3000);
		infoVerification.Select_Status();
		
		Thread.sleep(3000);
		infoVerification.Click_ShowBtn();
		
		Thread.sleep(3000);
		infoVerification.Click_StudentName();
		
		Thread.sleep(3000);
		infoVerification.Click_VerifyInformationTab();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Admission Status Updated Successfully!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		Thread.sleep(3000);
		infoVerification.Click_PrintApplication();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Academic - Student Information Verification");
		Thread.sleep(5000);
		pdfutility.readPDF("StudP210101601001", "210101601001");
	}
}
