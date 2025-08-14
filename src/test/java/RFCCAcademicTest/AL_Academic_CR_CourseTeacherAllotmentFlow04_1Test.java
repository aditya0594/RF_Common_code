package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_CR_CourseTeacherAllotmentFlow04_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_CourseTeacherAllotmentFlow04_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CourseTeacherAllotmentFlow04_1 CourseTeacherAllotment;
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
	public void aL_Academic_CR_CourseTeacherAllotmentFlow04_1Test() throws Throwable {
		
		CourseTeacherAllotment = new AL_Academic_CR_CourseTeacherAllotmentFlow04_1(driver);
		HP = new HomePageAdmin(driver);
		
		Actions action = new Actions(driver);

		test = reports.createTest("aL_Academic_CR_CourseTeacherAllotmentFlow04_1Test"); 
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Cordinator Related -> Course Teacher Allotment"); 
		
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		
		Thread.sleep(2000);
		CourseTeacherAllotment.ClickCordinatorRelatedTest();
		
		threadWait1();
		CourseTeacherAllotment.ClickCourseTeacherAllotmentTest();
		
		threadWait1();
		CourseTeacherAllotment.SelectCollegeTest();
		
		threadWait1();
		CourseTeacherAllotment.SelectSessionTest();
		
		threadWait1();
		CourseTeacherAllotment.SelectSemesterTest();
		
		threadWait1();
		CourseTeacherAllotment.SelectCourseTest();
		
		Thread.sleep(4000);
		CourseTeacherAllotment.SelectDepartmentTest();
		
		Thread.sleep(4000);
		CourseTeacherAllotment.ClickShowButtonTest();
		
		threadWait1();
		CourseTeacherAllotment.EnterSearchButtonTest();
		
		threadWait1();
		CourseTeacherAllotment.ClickCheckBoxButtonTest();
		
		threadWait1();
		CourseTeacherAllotment.SelectSectionTest();
		
		threadWait2();
		CourseTeacherAllotment.ClickSubmitButtonTest();
		
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Course Teacher Allotted Successfully!!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
		
}
}
