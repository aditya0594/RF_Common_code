package StudentAdmissionTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.SL_Academic_SR_StudentInformation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class SL_Academic_SR_StudentInformationTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	SL_Academic_SR_StudentInformation studentInfoPage;
	SL_Academic_SR_SI_QualificationDetails qualificationdetails;
	HomePageAdmin HP;
	
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
	public void sL_Academic_SR_StudentInformationTest() throws Exception {
		studentInfoPage = new SL_Academic_SR_StudentInformation(driver);
		test = reports.createTest("sL_Academic_SR_StudentInformationTest");
		HP = new HomePageAdmin(driver);
		qualificationdetails = new SL_Academic_SR_SI_QualificationDetails(driver);
		Thread.sleep(4000);
		studentInfoPage.loginPage(); 
		
		System.out.println("ACADEMIC(SL) > Student Related > Student Information");

		threadWait1();
		HP.Academic();
		threadWait1();
		
		threadWait1();
		studentInfoPage.clickStudentRelated();
		
		threadWait1();
		studentInfoPage.clickStudentInformation();
		
		// Personal Details
		
		threadWait1();
		studentInfoPage.Enter_MobileNo();
		
		threadWait1();
		studentInfoPage.Enter_BirthPlace();
		
		threadWait1();
		studentInfoPage.Select_Nationality();

		threadWait1();
		studentInfoPage.Enter_AdharCard();
		
//		threadWait1();
//		studentInfoPage.Enter_ABC_ID();
		
		threadWait1();
		studentInfoPage.Upload_Photo();

		threadWait1();
		studentInfoPage.Click_SaveContinueBtn();

		// Address Details
		
		threadWait1();
		studentInfoPage.Click_AddressDetails();
		
		threadWait1();
		studentInfoPage.Enter_Country();
		
		threadWait1();
		studentInfoPage.Enter_State();
		
		threadWait1();
		studentInfoPage.Enter_District();
		
		threadWait1();
		studentInfoPage.Enter_City();
		
		threadWait1();
		studentInfoPage.Enter_PinCode();
		
		threadWait1();
		studentInfoPage.Click_SaveContinueBtn();

		// Document Upload
		
		threadWait1();
		studentInfoPage.Upload_10th_Marksheet();
		
		threadWait1();
		studentInfoPage.Upload_12th_Marksheet();
		
		threadWait1();
		studentInfoPage.Upload_AdharCard();
		
		threadWait1();
		studentInfoPage.Upload_Addressparticulars();
		
		threadWait1();
		studentInfoPage.Upload_CandidateMedicalRecord();
		
		threadWait1();
		studentInfoPage.Upload_CommunityCertificate();
		
		threadWait1();
		studentInfoPage.Upload_ConductCertificate();
		
		threadWait1();
		studentInfoPage.Upload_JointDeclaration();
		
		threadWait1();
		studentInfoPage.Upload_JointUndertakingHindi();
		
		threadWait1();
		studentInfoPage.Upload_JointUndertakingTamil();
		
		threadWait1();
		studentInfoPage.Upload_Otherdocuments();
		
		threadWait1();
		studentInfoPage.Upload_Photograph();
		
		threadWait1();
		studentInfoPage.Upload_Profileofthestudent();
		
		threadWait1();
		studentInfoPage.Upload_TransferCertificate();
		
		threadWait1();
		studentInfoPage.Click_NextContinueBtn();
		

	}
}
