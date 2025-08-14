package EstablishmentTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import Establishment.AL_Establishment_Trans_AssignDefaultShift;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Trans_AssignDefaultShiftTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Establishment_Trans_AssignDefaultShift al_Establishment_Trans_AssignDefaultShift;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test :" + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Establishment_Trans_AssignDefaultShiftTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Establishment_Trans_AssignDefaultShift = new AL_Establishment_Trans_AssignDefaultShift(driver);
		test = reports.createTest("assign_Default_Shift");
		Thread.sleep(4000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");

		Thread.sleep(4000);
		// Click on Establishment
		homePageAdmin.ESTABLISHMENT();

		Thread.sleep(4000);
		// Click on Transactions
		homePageAdmin.Estab_Transactions();

		Thread.sleep(4000);
		// Click on Assign Default Shift
		al_Establishment_Trans_AssignDefaultShift.Click_AssignDefaultShift();

		Thread.sleep(4000);
		// Select College
		al_Establishment_Trans_AssignDefaultShift.Select_College();

		Thread.sleep(4000);
		// Select Staff Type
		al_Establishment_Trans_AssignDefaultShift.Select_StaffType();

		Thread.sleep(4000);
		// Select Shift Type
		al_Establishment_Trans_AssignDefaultShift.Select_ShiftType(); 

		Thread.sleep(4000);
		// Select student
		al_Establishment_Trans_AssignDefaultShift.Click_Student_Link();

		// Record Updated successfully
		Thread.sleep(4000);
		// click button assign
		al_Establishment_Trans_AssignDefaultShift.Click_Submit_Button();

		Thread.sleep(4000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();

	}
}
