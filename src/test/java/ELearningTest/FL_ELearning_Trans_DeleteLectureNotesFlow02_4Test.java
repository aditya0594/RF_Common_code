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

import ELearning.FL_ELearning_Trans_DeleteLectureNotesFlow02_4;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_DeleteLectureNotesFlow02_4Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	FL_ELearning_Trans_DeleteLectureNotesFlow02_4 DeleteLectureNotes;

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
	public void fL_ELearning_Trans_DeleteLectureNotesFlow02_4Test() throws Throwable {
		
		test = reports.createTest("fL_ELearning_Trans_DeleteLectureNotesFlow02_4Test");
		
		RF_FacultyLogin.loginPage();
		
		DeleteLectureNotes = new FL_ELearning_Trans_DeleteLectureNotesFlow02_4(driver);
		
		HP = new HomePageAdmin(driver);
		HP.ELearning();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		DeleteLectureNotes.ClickTrnasctionTest();
		
		Thread.sleep(2000);
		DeleteLectureNotes.SelectCourseTest();
		
		Thread.sleep(2000);
		DeleteLectureNotes.ClickCreateLectureNotesTest();
		
		Thread.sleep(2000);
		DeleteLectureNotes.DeleteButtonTest();
		
		Thread.sleep(2000);
		DeleteLectureNotes.ConfirmOKButtonTest();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Notes Deleted Successfully...";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
	}
}
