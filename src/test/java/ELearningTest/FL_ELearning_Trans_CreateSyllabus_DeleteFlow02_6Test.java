package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import ELearning.FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 fL_ELearning_Trans_CreateSyllabus_Delete;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}
	
	@Test
	public void fL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6Test() throws Throwable
	{
		HP = new HomePageAdmin(driver);
		fL_ELearning_Trans_CreateSyllabus_Delete = new FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6(driver);
		
		test = reports.createTest("fL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6Test");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(3000);
		HP.ELearning();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		HP.ELearning_Transaction();
		
		Thread.sleep(2000);
		// Locating the Select Course
		fL_ELearning_Trans_CreateSyllabus_Delete.click_selectCourse_Link();
		
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateSyllabus_Delete.select_Session();
		
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateSyllabus_Delete.click_Course();
		
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateSyllabus_Delete.click_ok_Btn();
		
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		fL_ELearning_Trans_CreateSyllabus_Delete.click_createSyllabus_Link();
		
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateSyllabus_Delete.search_txt();
		
		fL_ELearning_Trans_CreateSyllabus_Delete.delete_record();
		
		// Asseresion
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record deleted successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
	}
		
}
