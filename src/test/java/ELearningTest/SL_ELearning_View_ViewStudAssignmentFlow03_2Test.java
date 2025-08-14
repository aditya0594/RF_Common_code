package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.SL_ELearning_View_ViewStudAssignmentFlow03_2;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class SL_ELearning_View_ViewStudAssignmentFlow03_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	
	SL_ELearning_View_ViewStudAssignmentFlow03_2 ViewStudAssignment;

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
	public void sL_ELearning_View_ViewStudAssignmentFlow03_2Test() throws Throwable
	{
		test = reports.createTest("sL_ELearning_View_ViewStudAssignmentFlow03_2Test");
		
		ViewStudAssignment = new SL_ELearning_View_ViewStudAssignmentFlow03_2(driver);
		
		ViewStudAssignment.login();
		
		System.out.println("Student Logged in Successfully.");
		
		HP = new HomePageAdmin(driver);
		HP.ELearning();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		ViewStudAssignment.ClickTransactionsTest();
		
		Thread.sleep(2000);
		ViewStudAssignment.SelectCourseTest();
		
		Thread.sleep(3000);
		ViewStudAssignment.HoverElearningTest();
		
		Thread.sleep(2000);
		ViewStudAssignment.ClickViewTest();
		
		Thread.sleep(2000);
		ViewStudAssignment.ClickViewStudentAssignmentTest();
		
		Thread.sleep(2000);
		ViewStudAssignment.SearchButtonTest();
		
		Thread.sleep(3000);
		ViewStudAssignment.EditButtonTest();

	}
}

