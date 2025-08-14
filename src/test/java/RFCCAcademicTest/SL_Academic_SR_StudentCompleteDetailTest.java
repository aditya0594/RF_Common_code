package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.SL_Academic_SR_SCD_AttendanceDetails;
import RFCCAcademic.SL_Academic_SR_SCD_CourseRegistered;
import RFCCAcademic.SL_Academic_SR_SCD_FeesDetails;
import RFCCAcademic.SL_Academic_SR_SCD_QualificationDetails;
import RFCCAcademic.SL_Academic_SR_SCD_ResultDetails;
import RFCCAcademic.SL_Academic_SR_SCD_StudentInformation;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class SL_Academic_SR_StudentCompleteDetailTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;
	
	SL_Academic_SR_SCD_StudentInformation studentInformation; 
	RFCCAcademic.SL_Academic_SR_SCD_PersonalDetails personaldetails;
	RFCCAcademic.SL_Academic_SR_SCD_AddressDetails addressdetails;
	SL_Academic_SR_SCD_QualificationDetails qaulificationdetails;
	SL_Academic_SR_SCD_FeesDetails feesdetails;
	SL_Academic_SR_SCD_CourseRegistered courseregister;
	SL_Academic_SR_SCD_AttendanceDetails attendancedetails;
	SL_Academic_SR_SCD_ResultDetails resultdetails;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test(priority = 1)
	public void SL_Academic_SR_SCD_StudentInformationTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		studentInformation = new SL_Academic_SR_SCD_StudentInformation(driver);
		
		test = reports.createTest("SL_Academic_SR_SCD_StudentInformationTest");

		System.out.println("Academic -> Student Related -> Student Complete Detail > Student Information");
		
		Thread.sleep(2000);
		studentInformation.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		studentInformation.Click_StudentCompleteDetail_Link();
		threadWait1();
		captureScreenshot(driver, "Student Complete Details - Student Information");
		threadWait1();
		
	
//		String Expected_Msg = "School of Infrastructure"; 
//		String Actual_Msg = studentInformation.Alert_Msg();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	}
	
	@Test(priority = 2)
	public void SL_Academic_SR_SCD_PersonalDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		personaldetails = new RFCCAcademic.SL_Academic_SR_SCD_PersonalDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_PersonalDetails");

		System.out.println("Academic -> Student Related -> Student Complete Detail > Personal Details");
		
		Thread.sleep(2000);
		studentInformation.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		personaldetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		personaldetails.Click_Personal_Details();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Personal Details");
		threadWait1();
		
//		String Expected_Msg = "School of Infrastructure"; 
//		String Actual_Msg = personaldetails.Alert_Msg();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	
	}
	
	@Test(priority = 3)
	public void SL_Academic_SR_SCD_AddressDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		addressdetails = new RFCCAcademic.SL_Academic_SR_SCD_AddressDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_AddressDetails");

		System.out.println("Academic -> Student Related -> Student Complete Detail > Address Details");
		
		Thread.sleep(2000);
		addressdetails.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		addressdetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		addressdetails.Click_AddressDetails();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Address Details");
		threadWait1();
		
//		String Expected_Msg = "School of Infrastructure"; 
//		String Actual_Msg = personaldetails.Alert_Msg();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	
	}
	
	
	@Test(priority = 4)
	public void SL_Academic_SR_SCD_QualificationDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		qaulificationdetails = new SL_Academic_SR_SCD_QualificationDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_QualificationDetails");
		
		System.out.println("Academic -> Student Related -> Student Complete Detail > Qualification Details");
		
		Thread.sleep(2000);
		qaulificationdetails.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		qaulificationdetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		qaulificationdetails.Click_QualificationDetails();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Qualification Details");
		threadWait1();
		
		String Expected_Msg = "Secondary/10th Marks"; 
		String Actual_Msg = qaulificationdetails.Alert_Msg();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	
	}
	
	@Test(priority = 5)
	public void SL_Academic_SR_SCD_FeesDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		feesdetails = new SL_Academic_SR_SCD_FeesDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_QualificationDetails");
		pdfutility =new PDFUtility(driver);	
		System.out.println("Academic -> Student Related -> Student Complete Detail > Fees Details");
		
		Thread.sleep(2000);
		feesdetails.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		feesdetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		feesdetails.Click_FeesDetails();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Fee Details");
		threadWait1();
	
		feesdetails.Click_ReceiptNo();
		threadWait1();
			
		pdfutility.downloadPDF(driver, "Student Complete Details - Fees Details");
		Thread.sleep(5000);
		pdfutility.readPDF("Student Complete Details - Fees Details", "ABDUL");
	}
	
	@Test(priority = 6)
	public void SL_Academic_SR_SCD_CourseRegistered() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		courseregister = new SL_Academic_SR_SCD_CourseRegistered(driver);
		test = reports.createTest("SL_Academic_SR_SCD_CourseRegistered");
		
		System.out.println("Academic -> Student Related -> Student Complete Detail > Course Registered");
		
		Thread.sleep(2000);
		courseregister.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		courseregister.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		courseregister.Click_CourseRegistered();
		threadWait1();
		
		courseregister.Select_Session();
		threadWait1();
		
		courseregister.Click_CCode();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Course Registered");
		threadWait1();
		
		String Expected_Msg = "Mr. SAIBULLA A"; 
		String Actual_Msg = courseregister.Alert_Msg();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	
	}
	
	@Test(priority = 7)
	public void SL_Academic_SR_SCD_AttendanceDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		attendancedetails = new SL_Academic_SR_SCD_AttendanceDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_CourseRegistered");
		
		System.out.println("Academic -> Student Related -> Student Complete Detail > Attendance Details");
		
		Thread.sleep(2000);
		attendancedetails.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		attendancedetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		attendancedetails.Click_AttendanceDetails();
		threadWait1();
		
		attendancedetails.Select_Session();
		threadWait1();
		
		captureScreenshot(driver, "Student Complete Details - Attendance Details");
		threadWait1();
		
//		String Expected_Msg = "Mr. SAIBULLA A"; 
//		String Actual_Msg = courseregister.Alert_Msg();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
	
	}
	
	@Test(priority = 8)
	public void SL_Academic_SR_SCD_ResultDetails() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		resultdetails = new SL_Academic_SR_SCD_ResultDetails(driver);
		test = reports.createTest("SL_Academic_SR_SCD_ResultDetails");
		pdfutility =new PDFUtility(driver);
		
		System.out.println("Academic -> Student Related -> Student Complete Detail > Result Details");
		
		Thread.sleep(2000);
		resultdetails.loginPage();
		System.out.println("Student Logged in Successfully");
		
		Thread.sleep(2000);
		//Click on Academic
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Student Related
		homePageAdmin.Academic_StudentRelated();
		Thread.sleep(2000);
		
	    //Click on Student Complete Detail
		resultdetails.Click_StudentCompleteDetail_Link();
		threadWait1();
		
		resultdetails.Click_ResultDetails();
		threadWait1();
		
		resultdetails.Select_Session();
		threadWait1();
		
		resultdetails.Click_I_btn();
		threadWait2();
		
		captureScreenshot(driver, "Student Complete Details - Result Details");
		threadWait1();
		
		resultdetails.Click_PrintIcon();
		threadWait1();
		
		pdfutility.downloadPDF(driver, "Student Complete Details - Result Details");
		Thread.sleep(2000);
		pdfutility.readPDF("Student Complete Details - Result Details", "ABDUL");
	
	}
	
}
