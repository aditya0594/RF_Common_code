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

import RFCCAcademic.AL_Academic_CR_ClassAdvisorAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_CR_ClassAdvisorAllotmentTests extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_ClassAdvisorAllotment ClassAdvisorAllotment;
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
	public void aL_Academic_CR_ClassAdvisorAllotmentTests() throws Throwable {
		
		ClassAdvisorAllotment = new AL_Academic_CR_ClassAdvisorAllotment(driver); 
		
		test = reports.createTest("aL_Academic_CR_ClassAdvisorAllotmentTests"); 
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage(); 
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		
		HP.Academic_CoordinatorRelated();
		Thread.sleep(2000);

		System.out.println("Academic -> Cordinator Related -> Course Teacher Allotment"); 
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.ClickClassAdvisorAllotmentTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectInstituteTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectDepartmentTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectDegreeTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectProgramTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectSemesterTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.ClickShowStudentButtonTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.ClickCheckBoxButtonTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectTeacherDepartmentTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectClassAdvisorTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.AssignClassAdvisorButtonTest();
		
		
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Class Advisor Allotted Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		alert.accept();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.SelectClassAdvisorTest();
		
		Thread.sleep(5000);
		ClassAdvisorAllotment.ReportExcelButtonTest();
		
}
}
