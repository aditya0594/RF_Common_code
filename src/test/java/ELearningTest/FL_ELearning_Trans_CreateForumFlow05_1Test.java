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
import pojo.Browser;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class FL_ELearning_Trans_CreateForumFlow05_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	HomePageAdmin HP;
	
	FL_ELearning_Trans_CreateForumFlow05_1 CreateForum;

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
	public void fL_ELearning_Trans_CreateForumFlow05_1Test() throws Throwable {
		
		test = reports.createTest("fL_ELearning_Trans_CreateForumFlow05_1Test");
		System.out.println("ELearning (FL)-> Transacyion ->CreateForum ");
		CreateForum = new FL_ELearning_Trans_CreateForumFlow05_1(driver);
		HP = new HomePageAdmin(driver);
		
		pdfutility =new PDFUtility(driver);
		Thread.sleep(1000);
		
		
		Thread.sleep(2000);
		CreateForum.login();
		
		Thread.sleep(2000);
		HP.ELearning();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		CreateForum.ClickTrnasctionTest();
		
		Thread.sleep(2000);
		CreateForum.SelectCourseTest();
		
		Thread.sleep(2000);
		CreateForum.Click_CreateForum();
		
		Thread.sleep(2000);
		CreateForum.Enter_ForumName();
		
		Thread.sleep(2000);
		CreateForum.Select_StartDate();
		
		Thread.sleep(2000);
		CreateForum.Select_EndDate();
		
		/*
		 * Thread.sleep(2000); CreateForum.EnterDescriptionTest();
		 */
		
		Thread.sleep(2000);
		CreateForum.SubmitButtonTest();
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Forum created successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(2000);
		CreateForum.ForumReportButtonTest();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "ELearning - Create Forum Report");
		Thread.sleep(2000);
		pdfutility.readPDF("ELearning - Create Forum Report", "Selenium");	
	}
}
