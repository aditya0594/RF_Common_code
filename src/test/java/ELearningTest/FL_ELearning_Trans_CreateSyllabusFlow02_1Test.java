package ELearningTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import com.qa.pages.HomePageFaculty;

import ELearning.FL_ELearning_Trans_CreateSyllabusFlow02_1;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.DonwloadPDF;
import utility.Reports;

public class FL_ELearning_Trans_CreateSyllabusFlow02_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	FL_ELearning_Trans_CreateSyllabusFlow02_1 fl_ELearning_Trans_CreateSyllabus;

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
	public void fL_ELearning_Trans_CreateSyllabusFlow02_1Test() throws Throwable {

		HomePageFaculty homePageFaculty = new HomePageFaculty(driver);
		fl_ELearning_Trans_CreateSyllabus = new FL_ELearning_Trans_CreateSyllabusFlow02_1(driver);

		test = reports.createTest("fL_ELearning_Trans_CreateSyllabusFlow02_1Test");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		Thread.sleep(3000);
		homePageFaculty.ELEARNING();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		homePageFaculty.Elearning_Trans();

		Thread.sleep(2000);
		// Locating the Select Course
		fl_ELearning_Trans_CreateSyllabus.click_selectCourse_Link();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.select_Session();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.click_Course();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.click_ok_Btn();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		fl_ELearning_Trans_CreateSyllabus.click_createSyllabus_Link();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.select_Unit();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.select_topic();

		Thread.sleep(2000);
		fl_ELearning_Trans_CreateSyllabus.click_chooseFile_btn();

		Thread.sleep(4000);
		fl_ELearning_Trans_CreateSyllabus.click_submit_button();

		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record saved successfully.";
		String Actual_Msg = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		acceptAlert();

	}

}
