package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_SA_BlockManagement;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_SA_BlockManagementTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_SA_BlockManagement al_Examination_SA_BlockManagement;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n"); 
	}

	@Test
	public void aL_Examination_SA_BlockManagementTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_SA_BlockManagement = new AL_Examination_SA_BlockManagement(driver);

		test = reports.createTest("AdminExamination_SeatingArrangement");
		Thread.sleep(3000);

		RF_AdminLoginPage.loginPage();

		Thread.sleep(3000);
		//click on Examination Menu
		homePageAdmin.EXAMINATION();

		Thread.sleep(3000);
		//Click on Seating Arrangement submenu
		homePageAdmin.Exam_SeatingArrangement();

		Thread.sleep(3000);
		//Click on Block Managememt page
		al_Examination_SA_BlockManagement.click_Block();

		Thread.sleep(3000);
		//Click on txt_Block
		al_Examination_SA_BlockManagement.enter_Block();

		Thread.sleep(3000);
		//Click on check box
		al_Examination_SA_BlockManagement.click_Checkbox();

		Thread.sleep(3000);
		//Click on submit
		al_Examination_SA_BlockManagement.click_SubmitButton();

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();

		String Expected_Msg = "Record Saved Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();



	}
}
