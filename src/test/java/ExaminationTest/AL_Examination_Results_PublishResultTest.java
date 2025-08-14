package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import Examination.AL_Examination_Results_PublishResult;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_Results_PublishResultTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	Actions action;
	AL_Examination_Results_PublishResult publishresult;
	
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
	public void al_Examination_Results_PublishResultTest() throws Exception {
		
		test = reports.createTest("Examination_PublishResult");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();

		System.out.println("EXAMINATION > Results > Publish Result");

		publishresult = new AL_Examination_Results_PublishResult(driver);
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();

		Thread.sleep(4000);
		//Click Results submenu
		HP.Exam_Results();

		Thread.sleep(5000);
		//Click on Publish Result Page
		publishresult.click_PublishResult();

		Thread.sleep(5000);
		//Select College
		publishresult.select_College();
		
		Thread.sleep(5000);
		//Select Session
		publishresult.select_Session();
		
		Thread.sleep(5000);
		//Select Semester
		publishresult.select_Semester();
		
		Thread.sleep(5000);
		//Select Student Type
		publishresult.select_StudentType();

		Thread.sleep(5000);
		//Select date of publish
		publishresult.select_PublishDate();
		
		Thread.sleep(5000);
		//Click show button
		publishresult.click_Show_Button();
		
		Thread.sleep(5000);
		//Check all students
		publishresult.Search_CheckBox();
		
		Thread.sleep(5000);
		//Click on Publish Result Button
		publishresult.click_PublishResult_Button();

		
		
		
		acceptAlert();
		
		Thread.sleep(5000);; 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Result Published Successfully!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();

		
		Thread.sleep(5000);
		//Click to uncheck chk box
		publishresult.Click_UncheckBox();
		
		Thread.sleep(5000);
		//Click on UNPublish Result Button
		publishresult.Click_UnPublishResultBtn();
		
		Thread.sleep(5000);; 
		Alert alert2 =  driver.switchTo().alert();
		String Expected_Msg2 = "Result Unpublished Successfully"; 
		String Actual_Msg2 = alert2.getText();
		Assert.assertEquals(Actual_Msg2 , Expected_Msg2 );
		System.out.println("Actual Message - " + Actual_Msg2+ "\n"+ "Expected Message - " + Expected_Msg2);
		alert2.accept();
	}
}
