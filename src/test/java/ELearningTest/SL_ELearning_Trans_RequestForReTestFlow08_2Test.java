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

import ELearning.SL_ELearning_Trans_RequestForReTestFlow08_2;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class SL_ELearning_Trans_RequestForReTestFlow08_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	SL_ELearning_Trans_RequestForReTestFlow08_2 sL_ELearning_Trans_RequestForReTest;

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
	public void sL_ELearning_Trans_RequestForReTestFlow08_2Test() throws Throwable
	{
		test = reports.createTest("sL_ELearning_Trans_RequestForReTestFlow08_2Test");
		homePageAdmin = new HomePageAdmin(driver);
		sL_ELearning_Trans_RequestForReTest = new SL_ELearning_Trans_RequestForReTestFlow08_2(driver);
		
		
		System.out.println("ELearning >> Transaction >> Requet for Retest");
		
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.Login_Student();
		
		threadWait1();
		homePageAdmin.ELearning();
		threadWait1();
		homePageAdmin.ELearning_Transaction();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.SelectCourseTest();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.click_requestForRetest_link();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.select_session();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.Search_Course();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.click_checkbox();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.select_test();
		threadWait1();
		sL_ELearning_Trans_RequestForReTest.click_submit_btn();
		
		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Submitted Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}
}
