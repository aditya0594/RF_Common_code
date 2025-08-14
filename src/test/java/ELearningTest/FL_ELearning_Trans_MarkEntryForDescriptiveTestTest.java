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

import ELearning.FL_ELearning_Trans_MarkEntryForDescriptiveTest;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_MarkEntryForDescriptiveTestTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_MarkEntryForDescriptiveTest fL_ELearning_Trans_MarkEntryForDescriptiveTest;

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
	public void fL_ELearning_Trans_MarkEntryForDescriptiveTest() throws Throwable
	{
		test = reports.createTest("FL_ELearning_Trans_MarkEntryForDescriptiveTest");
		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest = new FL_ELearning_Trans_MarkEntryForDescriptiveTest(driver);
		

		RF_FacultyLogin.loginPage();
		System.out.println("ELearning >> Transaction >> Mark Entry for Descriptive Test");
		
		Thread.sleep(2000);
		homePageAdmin.ELearning();
		Thread.sleep(2000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.SelectCourseTest();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.click_markEntryforDescriptiveTest_link();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.enter_search();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.click_check_btn();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.click_edit_btn();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.click_editQuestion_btn();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.enter_remark();
		Thread.sleep(2000);
		fL_ELearning_Trans_MarkEntryForDescriptiveTest.click_submit_btn();
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Submitted Succesfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(2000); 
	}
}
