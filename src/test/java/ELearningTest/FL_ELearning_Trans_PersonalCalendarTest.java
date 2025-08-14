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

import ELearning.FL_ELearning_Trans_CreateForumFlow05_1;
import ELearning.FL_ELearning_Trans_ImportQuestionBank;
import ELearning.FL_ELearning_Trans_PersonalCalendar;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_PersonalCalendarTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_PersonalCalendar fL_ELearning_Trans_PersonalCalendar;
	FL_ELearning_Trans_CreateForumFlow05_1 fL_ELearning_Trans_CreateForum;
	
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
	public void fL_ELearning_Trans_PersonalCalendar() throws Throwable {
		
		test = reports.createTest("FL_ELearning_Trans_PersonalCalendar");
		
		//RF_FacultyLogin.loginPage();
		
		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_PersonalCalendar = new FL_ELearning_Trans_PersonalCalendar(driver);
		fL_ELearning_Trans_CreateForum = new FL_ELearning_Trans_CreateForumFlow05_1(driver);
		
		fL_ELearning_Trans_PersonalCalendar.login();

		System.out.println("Elearning-> Transactions-> Personal Calendar ");
		homePageAdmin.ELearning();
		Thread.sleep(2000);
		homePageAdmin.ELearning_Transaction(); 
		Thread.sleep(2000);

		fL_ELearning_Trans_CreateForum.SelectCourseTest();	
		Thread.sleep(2000);
		
		fL_ELearning_Trans_PersonalCalendar.click_personalCalendar_link();
		Thread.sleep(2000);
		fL_ELearning_Trans_PersonalCalendar.select_date();
		Thread.sleep(2000);
		fL_ELearning_Trans_PersonalCalendar.enter_header();
		Thread.sleep(2000);
		fL_ELearning_Trans_PersonalCalendar.enter_description();
		Thread.sleep(2000);
		fL_ELearning_Trans_PersonalCalendar.click_submit_btn();
		Thread.sleep(4000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved successfully!!";  
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(5000);
		
		fL_ELearning_Trans_PersonalCalendar.edit_calendar();
		Thread.sleep(3000);
		fL_ELearning_Trans_PersonalCalendar.click_submit_btn();
		Thread.sleep(3000);
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Record Updated successfully!!"; 
		String Actual_Msg1 = alert1.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		threadWait1();
		fL_ELearning_Trans_PersonalCalendar.click_deleteCalendar();
		Thread.sleep(3000);
		Alert alert2 =  driver.switchTo().alert();
		String Expected_Msg2 = "Record Delete successfully!!"; 
		String Actual_Msg2 = alert2.getText();
		Assert.assertEquals(Actual_Msg2 , Expected_Msg2 );
		System.out.println("Actual Message - " + Actual_Msg2+ "\n"+ "Expected Message - " + Expected_Msg2);
		alert2.accept();
		Thread.sleep(3000);
	}
}
