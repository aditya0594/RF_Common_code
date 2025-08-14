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

import RFCCAcademic.AL_Academic_AP_NewStudent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AP_NewStudentTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AP_NewStudent newStudentPage;
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
	public void aL_Academic_AP_NewStudentTest() throws Exception {
		newStudentPage = new AL_Academic_AP_NewStudent(driver);
		test = reports.createTest("aL_Academic_AP_NewStudentTest");
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC > Admission Process > New Student");
		
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		newStudentPage.admissionProcess();
		
		Thread.sleep(2000);
		newStudentPage.newStudent();
		
		Thread.sleep(2000);
		newStudentPage.clickNewStudentButton();
		
//		Thread.sleep(2000);
//		newStudentPage.enterStudentName();
//
//		Thread.sleep(2000);
//		newStudentPage.enterFatherName();
//
//		Thread.sleep(2000);
//		newStudentPage.enterMobileNumber();
//
//		Thread.sleep(2000);
//		newStudentPage.enterAlternateMobileNumber();
//
//		Thread.sleep(2000);
//		newStudentPage.enterEmailId();
//
		Thread.sleep(2000);
		newStudentPage.selectNationality();
		
		Thread.sleep(2000);
		newStudentPage.selectState();
		
		Thread.sleep(3000);
		newStudentPage.selectCity();
		
//		Thread.sleep(3000);
//		newStudentPage.clickGender();
//
//		Thread.sleep(3000);
//		newStudentPage.selectSession();
//
//		Thread.sleep(3000);
//		newStudentPage.selectSchool();
//
//		Thread.sleep(3000);
//		newStudentPage.selectDegree();
//
//		Thread.sleep(3000);
//		newStudentPage.selectBranch();
//
//		Thread.sleep(3000);
//		newStudentPage.selectAdmThrough();
//
//		Thread.sleep(3000);
//		newStudentPage.selectAdmType();
//
//		Thread.sleep(3000);
//		newStudentPage.selectYear();
//
//		Thread.sleep(3000);
//		newStudentPage.selectSemester();
//
//		Thread.sleep(5000);
//		newStudentPage.selectBatch();
//
//		Thread.sleep(3000);
//		newStudentPage.enterDateOfBirth();
//
//		Thread.sleep(5000);
//		newStudentPage.selectCategory();
//
//		Thread.sleep(3000);
//		newStudentPage.enterDateOfReporting();
//
//		Thread.sleep(5000);
//		newStudentPage.selectPaymentType();
//
//		Thread.sleep(3000);
//		newStudentPage.scrollToBottom();
//
//		Thread.sleep(3000);
//		newStudentPage.clickSubmit();
//
//		Thread.sleep(3000);
//		Alert alert = driver.switchTo().alert();
//		String Expected_Msg = "Student record already saved with entered Email id or mobile no.";
//		String Actual_Msg = alert.getText();
//		Assert.assertEquals(Actual_Msg, Expected_Msg);
//		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
//		Thread.sleep(2000);
//		alert.accept();
	}

}
