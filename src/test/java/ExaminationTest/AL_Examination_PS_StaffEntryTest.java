package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import Examination.AL_Examination_PS_StaffEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_PS_StaffEntryTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_PS_StaffEntry al_Examination_PS_StaffEntry;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Examination_PS_StaffEntryTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_PS_StaffEntry = new AL_Examination_PS_StaffEntry(driver);

		test = reports.createTest("aL_Examination_PS_StaffEntryTest");
		threadWait1();
		System.out.println("Examination -> Paper Set -> Staff Entry");
		RF_AdminLoginPage.loginPage();

		threadWait1();
		// Click main Examination Menu
		homePageAdmin.EXAMINATION();

		threadWait1();
		// Click submenu Paper Set
		homePageAdmin.Exam_PaperSet();

		threadWait1();
		// Click Staff Entry
		al_Examination_PS_StaffEntry.click_staffEntry_link();

		threadWait1();
		// Select College
		al_Examination_PS_StaffEntry.select_college();

		threadWait1();
		// Select Department
		al_Examination_PS_StaffEntry.select_department();

		threadWait1();
		// Select staff from List
		al_Examination_PS_StaffEntry.select_staffList();

		threadWait1();
		// Click Add Staff Button
		al_Examination_PS_StaffEntry.click_addStaff_button();

//		threadWait1();
//		Alert alert = driver.switchTo().alert();
//
//		String Expected_Msg = "Staff Added Successfully!";
//		String Actual_Msg = alert.getText();
//		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
//
//		alert.accept();

		acceptAlert();
		
		threadWait1();
		// Click on External
		al_Examination_PS_StaffEntry.click_external_tab();

		threadWait1();
		// Click Edit Button
		al_Examination_PS_StaffEntry.Click_EditBtn();
		
		threadWait1();
		// Click Edit Button
		al_Examination_PS_StaffEntry.Click_UpdateExternalStaffBtn();
		
		threadWait1();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		driver.switchTo().alert();
		String Expected_Msg1 = "Staff Updated Successfully!";
		String Actual_Msg1 = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg1 + "\n" + "Expected Confiramtion Text - " + Expected_Msg1);
		Assert.assertEquals(Actual_Msg1, Expected_Msg1, "Actual and Expected Msg matched");
		alert.accept();
	}
}
