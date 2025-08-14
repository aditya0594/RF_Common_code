package RFCCAcademicTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import RFCCAcademic.AL_Academic_PA_SD_SchemeCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_PA_SD_SchemeCreationTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Academic_PA_SD_SchemeCreation schemecreation;
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
	public void aL_Academic_PA_SD_SchemeCreationTest() throws Exception {
		HP = new HomePageAdmin(driver);
	
		test = reports.createTest("aL_Academic_PA_SD_SchemeCreationTest");
		schemecreation = new AL_Academic_PA_SD_SchemeCreation(driver);
		System.out.println("Academic - Post Admission -> Scheme Data -> SchemeCreation");
		
		RF_AdminLoginPage.loginPage();
		threadWait1();
		HP.Academic();
		Thread.sleep(3000);

		// Locating the element from Sub Menu
		HP.Academic_PostAdmission();

		threadWait1();
		schemecreation.click_SchemeData();

		Thread.sleep(2000);
		schemecreation.click_SchemeCreation_Tab();

		Thread.sleep(2000);
		schemecreation.select_Degree();
		Thread.sleep(2000);

		schemecreation.select_department();
		Thread.sleep(2000);

		schemecreation.select_branch();
		Thread.sleep(2000);

		schemecreation.select_AdmissionBatch();
		Thread.sleep(2000);

		schemecreation.select_SchemeType();
		Thread.sleep(2000);

		schemecreation.select_grade();
		Thread.sleep(2000);

		schemecreation.select_resultProcessPattern();
		Thread.sleep(2000);

		schemecreation.select_patternName();
		Thread.sleep(2000);

		schemecreation.select_studyPattern();
		Thread.sleep(2000);

		schemecreation.click_submit_button();
		

		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Already Exists!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}

}