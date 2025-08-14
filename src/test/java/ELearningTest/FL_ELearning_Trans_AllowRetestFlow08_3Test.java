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

import ELearning.FL_ELearning_Trans_AllowRetestFlow08_3;
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class FL_ELearning_Trans_AllowRetestFlow08_3Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	FL_ELearning_Trans_AllowRetestFlow08_3 AllowRetest;
	HomePageAdmin HP;

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
	public void fL_ELearning_Trans_AllowRetestFlow08_3Test() throws Throwable {
		
		test = reports.createTest("fL_ELearning_Trans_AllowRetestFlow08_3Test");
		
		AllowRetest = new FL_ELearning_Trans_AllowRetestFlow08_3(driver);
		HP = new HomePageAdmin(driver);
		System.out.println("ELearing => Transaction => Allow Retest");
		threadWait1();
		AllowRetest.Login_Faculty();
		
		threadWait1();
		HP.ELearning();
		
		threadWait1();
		HP.ELearning_Transaction();
		
		threadWait1();
		AllowRetest.SelectCourseTest();
		
		threadWait1();
		AllowRetest.Click_AllowRetest();
		
		threadWait1();
		AllowRetest.Select_Session();
		
		threadWait1();
		AllowRetest.Select_Degree();
		
		threadWait1();
		AllowRetest.Select_Branch();
		
		threadWait1();
		AllowRetest.Select_Scheme();
		
		threadWait1();
		AllowRetest.Select_Semester();
		
		threadWait1();
		AllowRetest.Select_Course();
		
		threadWait1();
		AllowRetest.Select_Test();
		
		threadWait1();
		AllowRetest.Search_SelectStudent();
		
		threadWait1();
		AllowRetest.SubmitButtonTest();
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
			
		String Expected_Msg = "Retest Allowed Successfully!!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
	

	}
}
