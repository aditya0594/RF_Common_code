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

import ELearning.FL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;

	FL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2 DeleteQuestionBank;

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
	public void fL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2Test() throws Throwable {

		test = reports.createTest("fL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2Test");

		DeleteQuestionBank = new FL_ELearning_Trans_CreateQuestionBank_DeleteFlow04_2(driver);

		HP = new HomePageAdmin(driver);

		Thread.sleep(2000);
		DeleteQuestionBank.login();

		Thread.sleep(2000);
		HP.ELearning();

		Thread.sleep(2000);
		DeleteQuestionBank.ClickTrnasctionTest();

		Thread.sleep(2000);
		DeleteQuestionBank.SelectCourseTest();

		Thread.sleep(2000);
		DeleteQuestionBank.ClickCreateQuestionBankPageTest();
		
		Thread.sleep(2000);
		DeleteQuestionBank.SearchText();
		
		Thread.sleep(2000);
		DeleteQuestionBank.ClickDelete();
		
		Thread.sleep(2000);
		DeleteQuestionBank.ClickDeleteOK();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Question Deleted Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
		
	}

}
