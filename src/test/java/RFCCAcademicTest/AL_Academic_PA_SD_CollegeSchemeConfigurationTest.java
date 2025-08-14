package RFCCAcademicTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_PA_SD_CollegeSchemeConfiguration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_SD_CollegeSchemeConfigurationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_PA_SD_CollegeSchemeConfiguration collogeschemeconfig;

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
	public void aL_Academic_PA_SD_CollegeSchemeConfigurationTest() throws Exception {

		test = reports.createTest("aL_Academics_PA_SD_CollegeSchemeConfigurationTest");
		HP = new HomePageAdmin(driver);
		collogeschemeconfig = new AL_Academic_PA_SD_CollegeSchemeConfiguration(driver);
		Actions action = new Actions(driver);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academics -> Post Admission -> Scheme Data -> College Scheme Configuration");
		Thread.sleep(5000);

		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		HP.Academic_PostAdmission();

		Thread.sleep(2000);
		collogeschemeconfig.click_SchemeData();

		Thread.sleep(2000);
		collogeschemeconfig.click_collegeSchemeConfig_tab();
		
		// acceptNextAlert = true;
		Thread.sleep(2000);
		collogeschemeconfig.select_school();
		
		Thread.sleep(2000);
		collogeschemeconfig.click_submit_button();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}

}