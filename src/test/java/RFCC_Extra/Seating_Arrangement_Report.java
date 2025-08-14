package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Seating_Arrangement_Report extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

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
	public void SeatingArrangement_Report() throws Exception {

		RF_AdminLoginPage.loginPage();
		
		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Seating Arrangement"));
		System.out.println("Examination Seating arrangement submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		Thread.sleep(2000);

		System.out.println("click on SEATING ARRANGEMENT REPORT Menu");
		WebElement room_config_btn = driver.findElement(By.linkText("SEATING ARRANGEMENT REPORT")); 
		room_config_btn.click();
		Thread.sleep(2000);

		System.out.println("Click on Exam Date field");
		WebElement exam_date = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlExamdate-container"));
		exam_date.click();
		Thread.sleep(2000);

		// Unable to proceed further due to data not available
//		Select exm_date = new Select(exam_date);
//		exm_date.selectByVisibleText("");
//		WebElement exm_date_opt = exm_date.getFirstSelectedOption();
//		String exm_date_opt_name = exm_date_opt.getText();
//		System.out.println(exm_date_opt_name);

		System.out.println("Click on Exam Slot field");
		WebElement exam_slot = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlslot-container"));
		exam_slot.click();
		Thread.sleep(2000);

		// Unable to proceed further due to data not available
//		Select exm_slt = new Select(exam_slt);
//		exm_slt.selectByVisibleText("");
//		WebElement exm_slt_opt = exm_slt.getFirstSelectedOption();
//		String exm_slt_opt_name = exm_slt_opt.getText();
//		System.out.println(exm_slt_opt_name);

		System.out.println("Click on Seating Plan");
		WebElement seating_pln = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlslot-container"));
		seating_pln.click();
		Thread.sleep(2000);

//		System.out.println("Click on Door Seating Plan");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtmasterseatplan")).click();

	}
}
