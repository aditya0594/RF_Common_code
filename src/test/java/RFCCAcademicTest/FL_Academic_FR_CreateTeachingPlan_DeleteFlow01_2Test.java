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

import RFCCAcademic.FL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2 fL_Academic_FR_CreateTeachingPlan_Delete;
	
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
	public void fL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2Test() throws Throwable {

		test = reports.createTest("fL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2Test");

		homePageAdmin = new HomePageAdmin(driver);
		fL_Academic_FR_CreateTeachingPlan_Delete = new FL_Academic_FR_CreateTeachingPlan_DeleteFlow01_2(driver);
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.login();
		
		System.out.println("Academic ->Faculty Related-> Teaching Plan Entry");
		Thread.sleep(3000);
		homePageAdmin.Academic();
		Thread.sleep(3000);
		homePageAdmin.Academic_FacultyRelated();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.click_teachingPlanEntry_link();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.select_session();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.select_college();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.select_semester();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.select_section();
		Thread.sleep(3000);
		fL_Academic_FR_CreateTeachingPlan_Delete.click_deleteIcon(); 
		Thread.sleep(3000);
	
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Are you sure to Delete this Teaching Plan Entry?"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000); 
		alert.accept();
		
		Thread.sleep(3000); 
		driver.switchTo().alert();
		String Expected_Msg1 = "Teaching Plan Entry Deleted Succesfully !!"; 
		String Actual_Msg1 = alert.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		Thread.sleep(2000); 
		alert.accept();
			
	}
}
