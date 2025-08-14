package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_FR_CreateFeeDemand;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_FR_CreateFeeDemandTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_FR_CreateFeeDemand CreateFeeDemand;
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
	public void al_Hostel_FR_CreateFeeDemand() throws Throwable {

		CreateFeeDemand = new Hostel.AL_Hostel_FR_CreateFeeDemand(driver);

		test = reports.createTest("al_Hostel_FR_CreateFeeDemand");

		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel -> Fee Related -> Create Fee Demand");

		HP = new HomePageAdmin(driver);
		Thread.sleep(4000);
		HP.HOSTEL();
		Thread.sleep(4000);

		Thread.sleep(4000);
		CreateFeeDemand.ClickFeesRelatedTest();

		Thread.sleep(4000);
		CreateFeeDemand.ClickCreateFeeDemandTest();

		Thread.sleep(4000);
		CreateFeeDemand.SelectSessionTest();

		Thread.sleep(4000);
		CreateFeeDemand.SelectDemandOfReceiptTypeTest();

		Thread.sleep(4000);
		CreateFeeDemand.SelectCurrentYearSemesterTest();

		Thread.sleep(4000);
		CreateFeeDemand.SelectCreateDemandforYearSemesterTest();

		Thread.sleep(4000);
		CreateFeeDemand.ClickShowStudentButtonTest();

		Thread.sleep(4000);
		CreateFeeDemand.SearchButtonTest();

		Thread.sleep(4000);
		CreateFeeDemand.ClickStudentCheckboxTest();

		Thread.sleep(4000);
		CreateFeeDemand.ClickCreateDemandButtonTest();

		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Demand successfully created for Selected students.";
		String Actual_Msg = alert.getText();
		
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println(Actual_Msg + "" + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
	}
}
