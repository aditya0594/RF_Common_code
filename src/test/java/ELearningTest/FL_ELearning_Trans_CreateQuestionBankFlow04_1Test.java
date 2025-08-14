package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_CreateQuestionBankFlow04_1;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateQuestionBankFlow04_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;

	FL_ELearning_Trans_CreateQuestionBankFlow04_1 CreateQuestionBank;

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
	public void fL_ELearning_Trans_CreateQuestionBankFlow04_1Test() throws Throwable {

		test = reports.createTest("fL_ELearning_Trans_CreateQuestionBankFlow04_1Test");

		CreateQuestionBank = new FL_ELearning_Trans_CreateQuestionBankFlow04_1(driver);

		HP = new HomePageAdmin(driver);

		Thread.sleep(2000);
		CreateQuestionBank.login();

		Thread.sleep(2000);
		HP.ELearning();

		Thread.sleep(2000);
		CreateQuestionBank.ClickTrnasctionTest();

		Thread.sleep(2000);
		CreateQuestionBank.SelectCourseTest();

		Thread.sleep(2000);
		CreateQuestionBank.ClickCreateQuestionBankPageTest();

		Thread.sleep(2000);
		CreateQuestionBank.ClickQuestionTypeRadioTest();

		Thread.sleep(2000);
		CreateQuestionBank.EnterTopicNameTest();

		Thread.sleep(2000);
		CreateQuestionBank.switchtoiframe();

		Thread.sleep(2000);
		CreateQuestionBank.EnterQuestionTest();

		Thread.sleep(2000);
		CreateQuestionBank.EnterAnswerOption1Test();

		Thread.sleep(2000);
		CreateQuestionBank.EnterAnswerOption2Test();

		Thread.sleep(2000);
		CreateQuestionBank.EnterAnswerOption3Test();

		Thread.sleep(2000);
		CreateQuestionBank.EnterAnswerOption4Test();

		Thread.sleep(2000);
		CreateQuestionBank.SelectCorrectAnswerTest();

		Thread.sleep(2000);
		CreateQuestionBank.SubmitButtonTest();

		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Question Saved Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

	}

}
