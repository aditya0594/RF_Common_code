package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.FL_Academic_FR_CreateTeachingPlanFlow01_1;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_Academic_FR_CreateTeachingPlanFlow01_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_Academic_FR_CreateTeachingPlanFlow01_1 fL_Academic_FR_CreateTeachingPlan;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void fL_Academic_FR_CreateTeachingPlanFlow01_1Test() throws Throwable {

		test = reports.createTest("fL_Academic_FR_CreateTeachingPlanFlow01_1Test");

		homePageAdmin = new HomePageAdmin(driver);
		fL_Academic_FR_CreateTeachingPlan = new FL_Academic_FR_CreateTeachingPlanFlow01_1(driver);
		
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.login();
		
		System.out.println("Academic ->Faculty Related-> Teaching Plan Entry");

		Thread.sleep(3000);
		homePageAdmin.Academic();
		Thread.sleep(3000);
		homePageAdmin.Academic_FacultyRelated();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.click_teachingPlanEntry_link();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_session();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_college();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_semester();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_section();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_unitNo();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.select_topicNo();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.enter_description();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.enter_numOfSessionRequired();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan.click_submit_btn();
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Teaching Plan Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000); 
		alert.accept();
	
	}
}
