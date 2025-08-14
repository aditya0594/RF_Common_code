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

import ELearning.FL_ELearning_Trans_CreateForumFlow05_1;
import ELearning.FL_ELearning_Trans_ExportQuestionBank;
import ELearning.FL_ELearning_Trans_ImportQuestionBank;
import pojo.Browser;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class FL_ELearning_Trans_ExportQuestionBankTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_ExportQuestionBank fL_ELearning_Trans_ExportQuestionBank;
	FL_ELearning_Trans_CreateForumFlow05_1 fL_ELearning_Trans_CreateForum;
	ExcelUtility excelutilitytest;
	
	
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
	public void fL_ELearning_Trans_ExportQuestionBank() throws Throwable {
		
		test = reports.createTest("FL_ELearning_Trans_ExportQuestionBank");
		
		//RF_FacultyLogin.loginPage();
		
		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_ExportQuestionBank = new FL_ELearning_Trans_ExportQuestionBank(driver);
		fL_ELearning_Trans_CreateForum = new FL_ELearning_Trans_CreateForumFlow05_1(driver);
		excelutilitytest = new ExcelUtility(driver);
		
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateForum.login();;
		homePageAdmin.ELearning();
		Thread.sleep(2000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(2000);
		fL_ELearning_Trans_CreateForum.SelectCourseTest();	
		Thread.sleep(2000);
		fL_ELearning_Trans_ExportQuestionBank.click_exportQuestionBank_link();
		Thread.sleep(3000);
		fL_ELearning_Trans_ExportQuestionBank.select_course();
		Thread.sleep(3000);
		fL_ELearning_Trans_ExportQuestionBank.select_questionType();
		Thread.sleep(3000);
		fL_ELearning_Trans_ExportQuestionBank.click_showQuestionsToExport();
		Thread.sleep(3000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		Thread.sleep(2000);
		fL_ELearning_Trans_ExportQuestionBank.click_exportToExcel();
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("Workshop - V","QUESTION"); 
	}
}
