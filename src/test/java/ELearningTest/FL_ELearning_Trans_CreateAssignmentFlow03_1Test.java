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

import ELearning.FL_ELearning_Trans_CreateAssignmentFlow03_1;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;


public class FL_ELearning_Trans_CreateAssignmentFlow03_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	FL_ELearning_Trans_CreateAssignmentFlow03_1 CreateAssignment;
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
	public void fL_ELearning_Trans_CreateAssignmentFlow03_1Test() throws Throwable {
		test = reports.createTest("fL_ELearning_Trans_CreateAssignmentFlow03_1Test");
		CreateAssignment = new FL_ELearning_Trans_CreateAssignmentFlow03_1(driver); 
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
	
		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		Thread.sleep(2000);
		HP.ELearning();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		CreateAssignment.Click_Transaction();
		
		Thread.sleep(2000);
		CreateAssignment.Select_Course();
		
		Thread.sleep(3000);
		CreateAssignment.Click_CreateAssignment();
		
		Thread.sleep(2000);
		CreateAssignment.Enter_AssignmentTopic();
	
		Thread.sleep(2000);
		CreateAssignment.Set_SubmissionFromDate();
		
		Thread.sleep(3000);
		CreateAssignment.Set_SubmissionFromtime();
		
		Thread.sleep(3000);
		CreateAssignment.Set_DueDate();
		
		Thread.sleep(3000);
		CreateAssignment.Set_DueTime();
		
		Thread.sleep(2000);
		CreateAssignment.Enter_AssignmentMarks();
		
		Thread.sleep(2000);
		CreateAssignment.Select_AssignmentType();
		
		Thread.sleep(2000);
		CreateAssignment.Set_RemindDate();
		
		Thread.sleep(2000);
		CreateAssignment.Set_RemindTime();
		
		Thread.sleep(2000);
		CreateAssignment.Click_CheckBox();
		
		Thread.sleep(2000);
		CreateAssignment.Click_SubmitButton();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Assignment added successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(2000);
		CreateAssignment.Click_AssingmentReport();
		
		Thread.sleep(5000);
        switchToNextWindow();
        
        Thread.sleep(5000);
        pdfutility.downloadPDF(driver, "Elearning - Create Assignment Report");
        Thread.sleep(2000);
        pdfutility.readPDF("Elearning - Create Assignment Report","Automation");
		
	}

}
