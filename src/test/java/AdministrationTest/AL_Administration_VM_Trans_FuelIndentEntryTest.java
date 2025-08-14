package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_FuelIndentEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

//import org.apache.commons.io.FileUtils;

public class AL_Administration_VM_Trans_FuelIndentEntryTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Administration_VM_Trans_FuelIndentEntry al_Administration_VM_Trans_FuelIndentEntry;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Administration_VM_Trans_FuelIndentEntryTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);
		al_Administration_VM_Trans_FuelIndentEntry = new AL_Administration_VM_Trans_FuelIndentEntry(driver);
		
		test = reports.createTest("FuelIndentEntry");
		
		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		//Click main Administration menu
		homePageAdmin.ADMINISTRATION();
		
		Thread.sleep(2000);
		//Click Vehicle Management submenu
		homePageAdmin.Admin_VehicleManagement();
		
		Thread.sleep(3000);
		//Click transactions submenu		
		homePageAdmin.Admin_VM_Transaction();
		
		Thread.sleep(3000);
		//Click Fuel nd Indent Entry Page		
		al_Administration_VM_Trans_FuelIndentEntry.click_fuelAndIndentEntry_link();
		
		Thread.sleep(3000);
		//click on fuel radio button
		al_Administration_VM_Trans_FuelIndentEntry.click_fuel_radioButton();
		
		Thread.sleep(3000);
		//Click on Issue Type
		al_Administration_VM_Trans_FuelIndentEntry.select_issueType();
		
		Thread.sleep(3000);
		//Click on Item Name
		al_Administration_VM_Trans_FuelIndentEntry.select_itemName();
		
		Thread.sleep(3000);
		//Click on Vehicle
		al_Administration_VM_Trans_FuelIndentEntry.select_vehicle();
		
		Thread.sleep(3000);
	    
	    //Enter From Date
		al_Administration_VM_Trans_FuelIndentEntry.select_issueDate();	
		
	    Thread.sleep(3000);
	    //Coupon NO
	    al_Administration_VM_Trans_FuelIndentEntry.enter_couponNo();
	    
	    Thread.sleep(3000);
	    //Quantity
	    al_Administration_VM_Trans_FuelIndentEntry.enter_quantity();
	    
	    Thread.sleep(3000);
	    //Rate
	  //  WebElement txt_rate = driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtRate"));
	   // txt_rate.clear();	   
	    al_Administration_VM_Trans_FuelIndentEntry.enter_rate();
	    
	    Thread.sleep(3000);
	    //Total Amount
	    al_Administration_VM_Trans_FuelIndentEntry.enter_totalAmount();
	    
	    Thread.sleep(3000);
	    //Start Meter Reading
	    al_Administration_VM_Trans_FuelIndentEntry.enter_startMeterReading();
	    
	    Thread.sleep(3000);
	    //End Meter Reading
	    al_Administration_VM_Trans_FuelIndentEntry.enter_endMeterReading();
		
	    Thread.sleep(3000);
	    //Click Submit
	    al_Administration_VM_Trans_FuelIndentEntry.click_submit_button();
		
		Thread.sleep(3000);
		//Alert
		Alert alert = driver.switchTo().alert();
		
		String Actual_Msg = alert.getText();
		//String Expected_Msg = "Coupon No. saved Successfully.";
		String Expected_Msg = "Record Save Successfully.";
		
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}



}
