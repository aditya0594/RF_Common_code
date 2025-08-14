package RFCCAcademicTest;



import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_SR_StudentInformation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_SR_StudentInformationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_SR_StudentInformation studentInfoPage;
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
	public void aL_Academic_SR_StudentInformationTest() throws Exception {
		studentInfoPage = new AL_Academic_SR_StudentInformation(driver);
		test = reports.createTest("aL_Academic_SR_StudentInformationTest");
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Student Related > Student Information");

		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		studentInfoPage.clickStudentRelated();
		
		Thread.sleep(2000);
		studentInfoPage.clickStudentInformation();
		
		Thread.sleep(2000);
		studentInfoPage.selectSearchCriteria();
		
		Thread.sleep(2000);
		studentInfoPage.selectBranch();
		
		Thread.sleep(2000);
		studentInfoPage.clickSearchButton();

		Thread.sleep(2000);
		studentInfoPage.scrollBranchIntoView();

		Thread.sleep(2000);
		String actualText = studentInfoPage.getStudentListHeaderText();
		String expectedText = "Student List";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Assertion Passed: Expected '" + expectedText + "' matches Actual '" + actualText + "'");

		Thread.sleep(2000);
		Screenshot.takesScreenshot(getCurrentDate());
	}

}
