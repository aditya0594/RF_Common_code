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

import RFCCAcademic.AL_Academic_CR_BacklogCourseTeacherAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_CR_BacklogCourseTeacherAllotmentTest extends BaseClass{


	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_CR_BacklogCourseTeacherAllotment aL_Academic_CR_BacklogCourseTeacherAllotment;
	PDFUtility pdfutility;
	
	
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
	public void aL_Academic_CR_BacklogCourseTeacherAllotment() throws Exception {


		test = reports.createTest("AL_Academic_CR_BacklogCourseTeacherAllotment");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_CR_BacklogCourseTeacherAllotment = new AL_Academic_CR_BacklogCourseTeacherAllotment(driver);
		pdfutility = new PDFUtility(driver);
		
		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Coordinated Related-> Backlog Course Teacher Allotment");

		homePageAdmin.Academic();
		threadWait1();
		homePageAdmin.Academic_CoordinatorRelated();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.click_backlogCourseTeacherAllotment_link();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.click_backlogCourseTeacherAllotment_radioBtn();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.select_college();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.select_session();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.click_show_button();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.check_checkbox();
		threadWait1();
		aL_Academic_CR_BacklogCourseTeacherAllotment.select_teacher();
		Thread.sleep(3000);
		aL_Academic_CR_BacklogCourseTeacherAllotment.click_submit_btn();
		Thread.sleep(3000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Data Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(3000);
		
	}
}
