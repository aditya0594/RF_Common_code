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

import RFCCAcademic.AL_Academic_PA_SD_SchemeType;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_SD_SchemeTypeTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_PA_SD_SchemeType schemetype;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_PA_SD_SchemeTypeTest() throws Exception {
		
		HP = new HomePageAdmin(driver);
		schemetype = new AL_Academic_PA_SD_SchemeType(driver);

		test = reports.createTest("aL_Academic_PA_SD_SchemeTypeTest");

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic - Post Admission -> Scheme Data -> Scheme Type");


		threadWait1();
		HP.Academic();
		Thread.sleep(3000);

		// Locating the element from Sub Menu
		HP.Academic_PostAdmission();

		threadWait1();
		schemetype.click_SchemeData();

		threadWait1();
		schemetype.click_schemeType();
		threadWait1();
		schemetype.click_editSchemeType();
		threadWait2();
		schemetype.click_submit_btn();
		Thread.sleep(2000);
		// switch focus to alert
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}

}
