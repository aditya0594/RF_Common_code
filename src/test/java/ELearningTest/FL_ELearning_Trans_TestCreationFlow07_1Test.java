package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import ELearning.FL_ELearning_Trans_TestCreationFlow07_1;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class FL_ELearning_Trans_TestCreationFlow07_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	FL_ELearning_Trans_TestCreationFlow07_1 fl_ELearning_Trans_TestCreation;
	HomePageAdmin HP;
	PDFUtility pdfutility;

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
	public void fL_ELearning_Trans_TestCreationFlow07_1Test() throws Throwable {
		test = reports.createTest("fL_ELearning_Trans_TestCreationFlow07_1Test");
		fl_ELearning_Trans_TestCreation = new FL_ELearning_Trans_TestCreationFlow07_1(driver);
		pdfutility =new PDFUtility(driver);

		System.out.println("E- LEARNING -> Transactions -> Test Creation");

		Thread.sleep(5000);
		RF_FacultyLogin.loginPage();

		HP = new HomePageAdmin(driver);
		HP.ELearning();
	
		Thread.sleep(5000);
		
		fl_ELearning_Trans_TestCreation.ClickTrnasctionTest();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.SelectCourseTest();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.TestCreation();


		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.ObjectiveTypeTest(); 

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.TestName(); 

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.StartDate();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.EndDate();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.TestStartTime();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.TestEndTime();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.TestDuration();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.NoofAttemptsAllowed();
		
		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.Ratio();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.DownArrowImageAddMarks();

		Thread.sleep(5000);
		fl_ELearning_Trans_TestCreation.SubmitButtonTest();

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Test Created Successfully... ";
		String Actual_Msg = alert.getText();
		System.out.println(
				"Actual Confirmation Text - " + Actual_Msg + "\n" + "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_TestCreation.TestReport();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "ELearning - Create Test");
		Thread.sleep(2000);
		pdfutility.readPDF("ELearning - Create Test", "Income");	 
	
	}

}
