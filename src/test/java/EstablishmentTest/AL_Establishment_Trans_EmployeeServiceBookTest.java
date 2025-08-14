package EstablishmentTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_EmployeeServiceBook;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Establishment_Trans_EmployeeServiceBookTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Establishment_Trans_EmployeeServiceBook al_Establishment_Trans_EmployeeServiceBook;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test :" + m.getName()+ "*****" + "\n");
	}

	@Test
	public void aL_Establishment_Trans_EmployeeServiceBookTest() throws Exception {
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Establishment_Trans_EmployeeServiceBook = new AL_Establishment_Trans_EmployeeServiceBook(driver);
	
		test = reports.createTest("Employee_Service_Book");
		Thread.sleep(4000);

		RF_AdminLoginPage.loginPage();
		
		System.out.println("Admin Logged in Successfully");
		Thread.sleep(4000);

		Thread.sleep(4000);
		homePageAdmin.ESTABLISHMENT();

		Thread.sleep(4000);
		// Locating the element from Sub Menu WebElement subMenu =
		homePageAdmin.Estab_Transactions();
		Thread.sleep(4000);
		System.out.println("Establisment -> Transaction -> Employee Service Book -> SERVICE BOOK ENTRY");
//
//		WebElement Employee_srv = driver.findElement(By.id("ctl00_ctl00_repLinks_ctl00_lbLink"));
//		System.out.println("Click on Employee service book");
//		Employee_srv.click();
//		Thread.sleep(1000);

		al_Establishment_Trans_EmployeeServiceBook.click_orderBy();
		Thread.sleep(4000);
		// Note:No data in EmployeeName Dropdown

		Thread.sleep(4000);
		al_Establishment_Trans_EmployeeServiceBook.select_employeeName();

		Thread.sleep(4000);
		al_Establishment_Trans_EmployeeServiceBook.click_personal_link();

		Thread.sleep(4000);
		al_Establishment_Trans_EmployeeServiceBook.click_uploadDocument_link();

		Thread.sleep(4000);
		al_Establishment_Trans_EmployeeServiceBook.select_documentType();

		Thread.sleep(4000);
		al_Establishment_Trans_EmployeeServiceBook.upload_photo();
				
		Thread.sleep(4000);
		//Click Upload Button
		al_Establishment_Trans_EmployeeServiceBook.click_upload_button();
		
		Thread.sleep(4000);
		//Click Submit Button
		al_Establishment_Trans_EmployeeServiceBook.click_submit_button();
		
		Thread.sleep(4000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Record Saved Successfully";
		String Actual_Msg =alert.getText();
		Thread.sleep(4000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

		Thread.sleep(4000);
		//Scroll Down
		al_Establishment_Trans_EmployeeServiceBook.click_delete_btn();
		
		Thread.sleep(4000);
		//Alert
		al_Establishment_Trans_EmployeeServiceBook.click_yesInAlert();
		
		Thread.sleep(7000);
		
		String Expected_Msgs = "Record Deleted Successfully";
		String Actual_Msgs =alert.getText();
		Thread.sleep(4000);
		Assert.assertEquals(Actual_Msgs, Expected_Msgs, "Actual and Expected Msg matched");
		alert.accept();

		

	}
}
