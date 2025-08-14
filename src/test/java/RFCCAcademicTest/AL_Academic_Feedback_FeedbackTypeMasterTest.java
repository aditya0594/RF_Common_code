package RFCCAcademicTest;

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

import RFCCAcademic.AL_Academic_Feedback_FeedbackTypeMaster;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_Feedback_FeedbackTypeMasterTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_Feedback_FeedbackTypeMaster al_Academic_Feedback_FeedbackTypeMaster;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception { 
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "\n");
	}

	@Test
	public void aL_Academic_Feedback_FeedbackTypeMasterTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_Feedback_FeedbackTypeMaster = new AL_Academic_Feedback_FeedbackTypeMaster(driver);
		test = reports.createTest("feedback_Type_Master");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();	
		System.out.println("ACADEMIC->FeedBack->FeedBack Type Master");


		//Hover on Academic from Navigation bar
		homePageAdmin.Academic();
		System.out.println("Hover on Academic from Navigation bar");
		Thread.sleep(2000);

		//Click on FeedBack from Drop Down
		homePageAdmin.Academic_Feedback();
		System.out.println("Click on FeedBack from Drop Down");
		Thread.sleep(2000);

		//Click on FeedBack Type Master from subMenu
		al_Academic_Feedback_FeedbackTypeMaster.click_Feedback_Type_Master();
		System.out.println("Click on FeedBack Type Master from subMenu");
		Thread.sleep(2000);

		//Enter Feedback Type
		Thread.sleep(2000);
		al_Academic_Feedback_FeedbackTypeMaster.enter_Feedback_Type();

		Thread.sleep(2000);
		al_Academic_Feedback_FeedbackTypeMaster.select_Feedback_Mode();
		
		Thread.sleep(2000);
		al_Academic_Feedback_FeedbackTypeMaster.select_UserType();


		Thread.sleep(2000);
		System.out.println("Click on Submit");
		al_Academic_Feedback_FeedbackTypeMaster.click_Submit_Button();
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record already exist";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();

	}

}
