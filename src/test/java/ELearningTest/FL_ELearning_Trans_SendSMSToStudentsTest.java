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

import ELearning.FL_ELearning_Trans_SendSMSToStudents;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_SendSMSToStudentsTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_SendSMSToStudents fL_ELearning_Trans_SendSMSToStudents;

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
	public void fL_ELearning_Trans_SendSMSToStudents() throws Throwable {

		test = reports.createTest("FL_ELearning_Trans_SendSMSToStudents");

		//	RF_FacultyLogin.loginPage();

		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_SendSMSToStudents = new FL_ELearning_Trans_SendSMSToStudents(driver);

		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.login();
		
		System.out.println("Elearning-> Transactions-> Send SMS To Students");

		Thread.sleep(3000);
		homePageAdmin.ELearning();
		Thread.sleep(3000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.SelectCourseTest();	
		Thread.sleep(4000);
		fL_ELearning_Trans_SendSMSToStudents.click_sendSMSToStudents_link();
		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.select_session();
		Thread.sleep(5000);
		fL_ELearning_Trans_SendSMSToStudents.select_course(); 
		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.click_checkbox();
		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.enter_templateToSend();
		Thread.sleep(3000);
		fL_ELearning_Trans_SendSMSToStudents.click_sendSms_btn();

		//Data Saved Successfully!
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Data Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
