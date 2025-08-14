package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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

import Examination.AL_Examination_Results_ResultProccessing;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_Results_ResultProccessingTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	AL_Examination_Results_ResultProccessing resultproccesing;
	

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
	public void al_Examination_Results_ResultProccessingTest() throws Exception {
		
		test = reports.createTest("Examination_ResultProccessing");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();

		System.out.println("EXAMINATION > Results > Result Proccessing");

		Thread.sleep(4000);
		resultproccesing = new AL_Examination_Results_ResultProccessing(driver);
		HP = new HomePageAdmin(driver);
		Thread.sleep(4000);
		HP.EXAMINATION();
		Thread.sleep(4000);
		
		Thread.sleep(4000);
		//Click Results submenu
		HP.Exam_Results();
		
		Thread.sleep(4000);
		//Click Results Proccessing Page
		resultproccesing.click_ResultProcessing();
		
		Thread.sleep(4000);
		//Select College 
		resultproccesing.select_College();
		
		Thread.sleep(4000);
		//Select Session
		resultproccesing.select_Session();
		
		Thread.sleep(4000);
		//Select Semester
		resultproccesing.select_Semester();
		
		Thread.sleep(4000);
		//Select Student Type
		resultproccesing.select_StudentType();
		
		Thread.sleep(5000);
		//click show button
		resultproccesing.click_ShowButton();
		
		Thread.sleep(5000);
		//check checkbox 
		resultproccesing.check_StudentFromList();
		
		Thread.sleep(5000);
		//click Proccess Result
		resultproccesing.Click_UnlockBtn();
		
		Thread.sleep(5000);
		resultproccesing.click_ProcessResult_Button();
		
		Thread.sleep(5000);
		resultproccesing.click_StudentListAll_Checkbox();
		
		Thread.sleep(5000);
		resultproccesing.Click_LockBtn();
			
	}

}
