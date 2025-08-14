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

import RFCCAcademic.AL_Academic_CR_CourseWiseSectionAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_CR_CourseWiseSectionAllotmentTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_CR_CourseWiseSectionAllotment sectionallotment;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
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
	public void aL_Academic_CR_CourseWiseSectionAllotmentTest() throws Throwable {
		
		sectionallotment = new AL_Academic_CR_CourseWiseSectionAllotment(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		test = reports.createTest("aL_Academic_CR_CourseWiseSectionAllotmentTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Coordinator Related > Course Wise Section allotment"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_CoordinatorRelated();
		
		threadWait1();
		sectionallotment.Click_CourseWiseSectionAllotment();
		
		threadWait1();
		sectionallotment.Select_Session();
		
		threadWait1();
		sectionallotment.Select_Course();
		
		threadWait1();
		sectionallotment.Click_ShowStudentBtn();
		
		threadWait1();
		sectionallotment.Click_CheckBox();
		
		threadWait1();
		sectionallotment.Select_Section();
		

		
		threadWait1();
		sectionallotment.Click_SubmitBtn();
		
		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Student Section Allotted Successfully";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(5000); 
		alert.accept();
		
		threadWait1();
		sectionallotment.Click_ReportExcel();
		
		threadWait2();
		excelutilitytest.ReadExcel("YUVAN","Coursewise_Section_Allotment_Report"); 
	}
}
