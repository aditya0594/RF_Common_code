package ExaminationTest;

import java.lang.reflect.Method;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
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

import Examination.AL_Examination_AS_EvaluationStaffEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_AS_EvaluationStaffEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_AS_EvaluationStaffEntry al_Examination_AS_EvaluationStaffEntry ;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n"); 
	}
	
	@Test
	public void aL_Examination_AS_EvaluationStaffEntry() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_AS_EvaluationStaffEntry = new AL_Examination_AS_EvaluationStaffEntry(driver);
		
		test=reports.createTest("aL_Examination_AS_EvaluationStaffEntry");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		System.out.println("Examination->Answer Sheet->Evaluation Staff Entry");

		//Click on Examination
		homePageAdmin.EXAMINATION();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		homePageAdmin.Exam_AnswerSheet();
		
		al_Examination_AS_EvaluationStaffEntry.click_EvaluationStaffEntry_Link();
		
		al_Examination_AS_EvaluationStaffEntry.select_EvaluatorType();
		Thread.sleep(2000);
		
		al_Examination_AS_EvaluationStaffEntry.select_Department();
		Thread.sleep(3000);
		// Staff Name
		al_Examination_AS_EvaluationStaffEntry.enter_StaffName();
		Thread.sleep(2000);
		// Mobile number ==> Random mobile number
		al_Examination_AS_EvaluationStaffEntry.enter_mobileNo();
		Thread.sleep(2000);
		// Email address ===> Random Email address
		al_Examination_AS_EvaluationStaffEntry.enter_emailId();
		Thread.sleep(2000);
		// Address Details
		al_Examination_AS_EvaluationStaffEntry.enter_address();
		
		Thread.sleep(2000);
		al_Examination_AS_EvaluationStaffEntry.click_submit_button();
		
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
			
		String Expected_Msg = "Record Saved Successfully"; 
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(1000);
		alert.accept();
		
	}
}
