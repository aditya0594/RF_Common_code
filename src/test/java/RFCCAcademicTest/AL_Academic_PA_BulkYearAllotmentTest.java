package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import RFCCAcademic.AL_Academic_PA_BulkYearAllotment;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_BulkYearAllotmentTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_BulkYearAllotment al_Academic_PA_BulkYearAllotment;

	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Academic_PA_BulkYearAllotment() throws Throwable {


		test = reports.createTest("AL_Academic_PA_BulkYearAllotment");

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_PA_BulkYearAllotment = new AL_Academic_PA_BulkYearAllotment(driver);

		RF_AdminLoginPage.loginPage(); 

		System.out.println("Academic-> Post Admission-> Bulk Batch Allotment ");
		
		homePageAdmin.Academic();
		threadWait1();
		homePageAdmin.Academic_PostAdmission();
		
		threadWait1();
		al_Academic_PA_BulkYearAllotment.click_BulkYearAllotment();
		
		threadWait1();
		al_Academic_PA_BulkYearAllotment.click_academicYearAllotment_tab();
		
		Thread.sleep(3000);
		al_Academic_PA_BulkYearAllotment.select_admissionBatch();
		threadWait1();
		al_Academic_PA_BulkYearAllotment.select_school();
		threadWait1();
		al_Academic_PA_BulkYearAllotment.click_show_button();
		threadWait1();
		al_Academic_PA_BulkYearAllotment.check_checkbox();
		threadWait1();
		al_Academic_PA_BulkYearAllotment.select_academicYear();
		threadWait1();
		al_Academic_PA_BulkYearAllotment.click_submit_button();
		threadWait1();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Students Alloted Academic Year Successfully Submit"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
