package HostelTest; 

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class SL_Hostel_FR_CreateStandardFeeTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
	}

	@Test
	public void sL_Hostel_FR_CreateStandardFeeTest() throws Exception {
		test = reports.createTest("sL_Hostel_FR_CreateStandardFeeTest");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		System.out.println("Student Logged in Successfully");
		Thread.sleep(1000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);
		
		Actions action = new Actions(driver);

		
		System.out.println("HOSTEL->Fee Related->Create Standard Fee");

		// Locating the element from Main Menu
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		Thread.sleep(3000);
		// Locating the element from Sub Menu
		WebElement Hostel_feesSubMenu = driver.findElement(By.linkText("Fees Related"));
		System.out.println("Click on Fees Related");
		Thread.sleep(2000);
		action.moveToElement(Hostel_feesSubMenu);
		action.click().build().perform();
		
		
		Thread.sleep(3000);
		// Locating the element from Sub Menu
		WebElement standard_fee = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		System.out.println("Click on Standard Fee");
		Thread.sleep(2000);
		action.moveToElement(standard_fee);
		action.click().build().perform();
		

		Thread.sleep(2000);
		//Select Session
		System.out.println("click on Session no. -> 2023-2024");
		WebElement sessn_no = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlHostelSessionNo"));
		Select session_no = new Select(sessn_no);
		session_no.selectByVisibleText("2023-2024");
		System.out.println("2023-2024 session selected");
		
		Thread.sleep(2000);
		//Select Hostel
		System.out.println("click on Hostel -> ABC GIRLS HOSTEL"); // rfcautomationuat HOSTEL selected
		WebElement hostel = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlHostel"));
		Select hostel1 = new Select(hostel);
		hostel1.selectByVisibleText("ABC GIRLS HOSTEL");
		
		Thread.sleep(2000);
		//Select Receipt Type
		System.out.println("click Receipt Type");
		WebElement recipt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Select receipt1 = new Select(recipt);
		receipt1.selectByVisibleText("Hostel Fees");
		System.out.println("Hostel Fees selected");
		
		Thread.sleep(2000);
		//Select Room Type
		WebElement rm_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRoomType"));
		Select room_typ1 = new Select(rm_typ);
		room_typ1.selectByVisibleText("REST ROOM"); // guest room1
		System.out.println("Room Type -> REST ROOM");
		
		Thread.sleep(3000);
		//Select Search Fee Item By Name
		WebElement search_item = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lstFeesItems"));
		Select typ_Search = new Select(search_item);
		typ_Search.selectByValue("443");
		System.out.println("Search Fees Item By Name :-443");
		
		Thread.sleep(3000);
		//Select Payment Type
		WebElement type_pay = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lstPaymentType"));
		Select payment_type = new Select(type_pay);
		payment_type.selectByVisibleText(" General");
		System.out.println("pament type ->  General");
		
		Thread.sleep(2000);
		//Click show definition
		WebElement btn_show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		btn_show.click();
		System.out.println("Click on Show Definition");
		
		Thread.sleep(2000);
		//Enter fees
		WebElement txt_fees = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lv_ctrl0_txtSem1"));
		txt_fees.clear();
		txt_fees.sendKeys("500");
		System.out.println("fees -> 500");
		
		Thread.sleep(2000);
		//Enter fees
		WebElement txt_fees1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lv_ctrl1_txtSem1"));
		txt_fees1.clear();
		txt_fees1.sendKeys("200");
		System.out.println("fees -> 2000");
		
		Thread.sleep(2000);
		//Enter fees
		WebElement txt_fees2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lv_ctrl2_txtSem1"));
		txt_fees2.clear();
		txt_fees2.sendKeys("150");
		System.out.println("fees -> 150");
		
		
		Thread.sleep(2000);
		//Click submit
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		System.out.println("Click on Submit button");

		Thread.sleep(2000);
		//Alert
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Standard Fees Saved Successfully.";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println(Actual_Msg + "" + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();

	}

}
