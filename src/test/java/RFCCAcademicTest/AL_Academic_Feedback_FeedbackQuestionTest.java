package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_Feedback_FeedbackQuestion;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_Feedback_FeedbackQuestionTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_Feedback_FeedbackQuestion al_Academic_Feedback_FeedbackQuestion;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void aL_Academic_Feedback_FeedbackQuestionTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_Feedback_FeedbackQuestion = new AL_Academic_Feedback_FeedbackQuestion(driver);
		test = reports.createTest("aL_Academic_Feedback_FeedbackQuestionTest");

		RF_AdminLoginPage.loginPage();

		//Select Academic
		System.out.println("Academic -> Feedback -> Feedback Question");
		Thread.sleep(2000);
		homePageAdmin.Academic();
		Thread.sleep(2000);

		// Locating the element from Sub Menu
		homePageAdmin.Academic_Feedback();
		Thread.sleep(2000);

		// Locating the element from Sub Menu
		al_Academic_Feedback_FeedbackQuestion.click_Feedback_Question();
		Thread.sleep(2000);

		//Select FeedbackType
		al_Academic_Feedback_FeedbackQuestion.select_Feedback_Type();
		Thread.sleep(2000);

//		//Enter Feedback Question
//		al_Academic_Feedback_FeedbackQuestion.enter_Feedback_Question();
//		Thread.sleep(2000);
//	
//		al_Academic_Feedback_FeedbackQuestion.Select_Answer_Option_Type();
//		Thread.sleep(2000);
//
//		al_Academic_Feedback_FeedbackQuestion.enter_Sequence_Number();
//		Thread.sleep(2000);
//
//		Thread.sleep(2000);
//		//Check Active Status Checkbox
//		al_Academic_Feedback_FeedbackQuestion.check_Active_Status_Checkbox();
//		Thread.sleep(2000);

		//Check for Mandatory checkbox
		al_Academic_Feedback_FeedbackQuestion.click_EditButton();
		Thread.sleep(2000);

		//click Submit button
		al_Academic_Feedback_FeedbackQuestion.click_Submit_Button();
		Thread.sleep(2000);

		Alert alert =  driver.switchTo().alert();
		Thread.sleep(3000);
		String Expected_Msg = "Question Updated successfully";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(1000);
		alert.accept();
	
	}

}
