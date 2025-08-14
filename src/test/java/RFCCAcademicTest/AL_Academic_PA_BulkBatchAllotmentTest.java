package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import RFCCAcademic.AL_Academic_PA_BulkBatchAllotment;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_BulkBatchAllotmentTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_BulkBatchAllotment al_Academic_PA_BulkBatchAllotment;

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
	public void aL_Academic_PA_BulkBatchAllotmentTest() throws Exception {


		test = reports.createTest("AL_Academic_PA_BulkBatchAllotmentTest");

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_PA_BulkBatchAllotment = new AL_Academic_PA_BulkBatchAllotment(driver);

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Post Admission-> Bulk Batch Allotment ");
		
		homePageAdmin.Academic();
		threadWait1();
		homePageAdmin.Academic_PostAdmission();
		threadWait1();
		
		al_Academic_PA_BulkBatchAllotment.click_bulkBatchAndYearAllotment_link();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.select_admissionBatch();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.select_school();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.click_show_button();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.check_checkbox();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.select_academicBatch();
		threadWait1();
		al_Academic_PA_BulkBatchAllotment.click_submit_button();
		threadWait1();
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Academic batch allotted successfully!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		
	}
}
