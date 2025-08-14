package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_SA_RoomConfiguration;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_SA_RoomConfigurationTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Examination_SA_RoomConfiguration al_Examination_SA_RoomConfiguration;
	
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
	public void aL_Examination_SA_RoomConfigurationTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Examination_SA_RoomConfiguration = new AL_Examination_SA_RoomConfiguration(driver);
		
		test = reports.createTest("AdminExamination_PaperSet");
		Thread.sleep(3000);

		RF_AdminLoginPage.loginPage();

		Thread.sleep(3000);
		//Click main examination menu
		homePageAdmin.EXAMINATION();

		Thread.sleep(3000);
		//Click Seating Arrangement Submenu
		homePageAdmin.Exam_SeatingArrangement();

		Thread.sleep(3000);
		//Click Room Configuration Page
		al_Examination_SA_RoomConfiguration.click_RoomConfiguration_Link();

		Thread.sleep(3000);
		//Select Room
		al_Examination_SA_RoomConfiguration.Select_Room();
		
		Thread.sleep(3000);
		//Enter Rows
		al_Examination_SA_RoomConfiguration.enter_Row();

		Thread.sleep(3000);
		//Enter Columns
		al_Examination_SA_RoomConfiguration.enter_Column();

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(3000);
		//click configure Button
		al_Examination_SA_RoomConfiguration.click_ConfigureButton();

		Thread.sleep(3000);
		// Click save button
		al_Examination_SA_RoomConfiguration.click_SaveButton();

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record Updated Successfully!.."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		 
			
	}
}
