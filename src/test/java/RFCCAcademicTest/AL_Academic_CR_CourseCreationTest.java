package RFCCAcademicTest;

import java.lang.reflect.Method;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_AbsentReport;
import RFCCAcademic.AL_Academic_CR_CourseCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.Reports;

public class AL_Academic_CR_CourseCreationTest extends utility.BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_CR_CourseCreation al_Academic_CR_Coursecreation;

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
	public void aL_Academic_CR_CoursecreationTest() throws InterruptedException {

		System.out.println("Academic==>Coordinator Related==>Course Creation");

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_CR_Coursecreation = new AL_Academic_CR_CourseCreation(driver);

		test = reports.createTest("aL_Academic_CR_CoursecreationTest");
		RF_AdminLoginPage.loginPage();

		homePageAdmin.Academic();
		Thread.sleep(2000);

		homePageAdmin.Academic_CoordinatorRelated();
		Thread.sleep(2000);

		al_Academic_CR_Coursecreation.select_degree();
		Thread.sleep(2000);

		al_Academic_CR_Coursecreation.select_department();
		Thread.sleep(2000);

		al_Academic_CR_Coursecreation.select_branch();
		Thread.sleep(2000);

		al_Academic_CR_Coursecreation.select_scheme();
		Thread.sleep(2000);
		al_Academic_CR_Coursecreation.select_semester();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");

		//ramdom course Code
		al_Academic_CR_Coursecreation.enter_courseCode();

		Thread.sleep(2000);
		//ramdom course Code

		al_Academic_CR_Coursecreation.enter_courseName();


		Thread.sleep(2000);
		al_Academic_CR_Coursecreation.select_courseType();

		Thread.sleep(2000);
		al_Academic_CR_Coursecreation.select_academicCouncil();

		al_Academic_CR_Coursecreation.enter_credits();
		Thread.sleep(2000);

		al_Academic_CR_Coursecreation.click_submit_button();

		threadWait1();

		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Course Added Successfully!!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

	}

}
