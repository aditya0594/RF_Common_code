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

import RFCCAcademic.AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 CancelCourseTeacherAllotment;
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
	public void aL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2Test() throws Throwable {
		
		CancelCourseTeacherAllotment = new AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2(driver);
		
		test = reports.createTest("aL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2Test"); 
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Cordinator Related -> Cancel Teacher Allotment"); 
		
		Thread.sleep(2000);
		HP.Academic();

		Thread.sleep(5000);
		CancelCourseTeacherAllotment.ClickCordinatorRelatedTest();
		
		Thread.sleep(5000);
		CancelCourseTeacherAllotment.ClickCourseTeacherAllotmentTest();
		
		Thread.sleep(5000);
		CancelCourseTeacherAllotment.ClickCancelTeacherAllotmentTabTest();
		
		Thread.sleep(5000);
		CancelCourseTeacherAllotment.SelectCollegeTest(); 
		
		Thread.sleep(3000);
		CancelCourseTeacherAllotment.SelectSessionTest();
		
		Thread.sleep(3000);
		CancelCourseTeacherAllotment.SelectDepartmentTest();
		
		Thread.sleep(3000);
		CancelCourseTeacherAllotment.SelectSemesterTest();
		
		Thread.sleep(3000);
		CancelCourseTeacherAllotment.ClickShowButtonTest();
		
		Thread.sleep(3000);
		CancelCourseTeacherAllotment.EnterSearchButtonTest();
		
		Thread.sleep(5000);
		CancelCourseTeacherAllotment.ClickCheckBoxButtonTest();
		
		Thread.sleep(5000);
		CancelCourseTeacherAllotment.ClickSubmitButtonTest();
		
		Thread.sleep(5000);
		acceptAlert();
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Subject teachers allotment successfully cancelled !!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
		
}
}
