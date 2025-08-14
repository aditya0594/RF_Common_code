package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class FL_ELearning_Trans_ImportQuestionBankTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	FL_ELearning_Trans_ImportQuestionBank fL_ELearning_Trans_ImportQuestionBank;
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
	public void fL_ELearning_Trans_ImportQuestionBankTest() throws Throwable {
		
		test = reports.createTest("FL_ELearning_Trans_ImportQuestionBankTest");
		
		
		//RF_FacultyLogin.loginPage();
		
		homePageAdmin = new HomePageAdmin(driver);
		fL_ELearning_Trans_ImportQuestionBank = new FL_ELearning_Trans_ImportQuestionBank(driver);
		fL_ELearning_Trans_CreateForum = new FL_ELearning_Trans_CreateForumFlow05_1(driver);
			
		System.out.println("Elearning-> Transactions-> Import question bank");
		
		Thread.sleep(2000);
		fL_ELearning_Trans_ImportQuestionBank.login();
		

		homePageAdmin.ELearning();
		Thread.sleep(2000);
		homePageAdmin.ELearning_Transaction();
		Thread.sleep(2000);

		fL_ELearning_Trans_CreateForum.SelectCourseTest();	
		Thread.sleep(2000);
		fL_ELearning_Trans_ImportQuestionBank.click_ImportQuestionBank_link(); 
		Thread.sleep(2000);
		fL_ELearning_Trans_ImportQuestionBank.select_fileFormat();
		Thread.sleep(2000);
		fL_ELearning_Trans_ImportQuestionBank.upload_file();
		Thread.sleep(2000);
		fL_ELearning_Trans_ImportQuestionBank.click_show_button();
		Thread.sleep(2000);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight)", driver.findElement(By.id("ctl00_tabcontent")));
	
		String Actual_Msg=fL_ELearning_Trans_ImportQuestionBank.getTextFromElement();
		
		String Expected_Msg = "Computer";  
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg); 
	
	}	
}
