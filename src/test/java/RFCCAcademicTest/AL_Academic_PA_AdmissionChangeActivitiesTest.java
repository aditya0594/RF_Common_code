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

import RFCCAcademic.AL_Academic_PA_AdmissionChangeActivities;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_AdmissionChangeActivitiesTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_PA_AdmissionChangeActivities aL_Academic_PA_AdmissionChangeActivities;

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
	public void aL_Academic_PA_AdmissionChangeActivities() throws Exception {


		test = reports.createTest("AL_Academic_PA_AdmissionChangeActivities");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_PA_AdmissionChangeActivities = new AL_Academic_PA_AdmissionChangeActivities(driver);

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Post Admission-> Admission Change Activities ");

		homePageAdmin.Academic();
		Thread.sleep(2000);
		homePageAdmin.Academic_PostAdmission();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.click_admissionChangeActivities_link();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.select_searchCriteria();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.enter_searchString();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.click_search_button();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.click_name_link();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.click_readmissionWithBranchChangeAndPayTypeMod();
		Thread.sleep(2000);
		aL_Academic_PA_AdmissionChangeActivities.select_newCollege();
		Thread.sleep(3000);
		aL_Academic_PA_AdmissionChangeActivities.select_newDegree();
		Thread.sleep(3000);
		aL_Academic_PA_AdmissionChangeActivities.select_newBranch();
		Thread.sleep(3000);
		aL_Academic_PA_AdmissionChangeActivities.select_newPaymentType();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Are you sure you want to change the selected payment type?"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(3000);
		
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Selected student re-admission already done."; 
		String Actual_Msg1 = alert1.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		
	
	}
}
