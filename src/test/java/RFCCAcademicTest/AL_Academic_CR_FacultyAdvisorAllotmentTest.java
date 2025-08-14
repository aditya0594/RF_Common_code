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

import RFCCAcademic.AL_Academic_CR_FacultyAdvisorAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_FacultyAdvisorAllotmentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_FacultyAdvisorAllotment facultyadviser;
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
	public void aL_Academic_CR_FacultyAdvisorAllotmentTest() throws Throwable {
		
		facultyadviser = new AL_Academic_CR_FacultyAdvisorAllotment(driver);
		HP = new HomePageAdmin(driver);

		test = reports.createTest("aL_Academic_CR_FacultyAdvisorAllotmentTest"); 
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("Academic -> Cordinator Related -> Faculty Adviser Allotment"); 
		
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		
		Thread.sleep(2000);
		HP.Academic_CoordinatorRelated();
		
		threadWait1();
		facultyadviser.click_FacultyAdvisorAllotment();
		
		threadWait1();
		facultyadviser.select_SchoolInstitute();
		
		threadWait1();
		facultyadviser.select_Degree();
		
		threadWait1();
		facultyadviser.select_Branch();
		
		threadWait1();
		facultyadviser.select_Semester();
		
		threadWait1();
		facultyadviser.click_ShowStudent();
		
		threadWait1();
		facultyadviser.click_Student1();
		
		
		threadWait1();
		facultyadviser.click_Student2();
		
		threadWait1();
		facultyadviser.click_Student3();
		
		threadWait1();
		facultyadviser.click_Student4();
		
		threadWait1();
		facultyadviser.click_Student5();
		
		threadWait1();
		facultyadviser.Select_Department();
		
		threadWait1();
		facultyadviser.select_FacultyAdvisor();
		
		threadWait1();
		facultyadviser.click_AssignButton();
		
		threadWait1();
		//Accept alert
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Faculty Advisor Allotted Successfully";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Messege - " + Actual_Msg+ "\n"+ "Expected Messege - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
		

	}
}
