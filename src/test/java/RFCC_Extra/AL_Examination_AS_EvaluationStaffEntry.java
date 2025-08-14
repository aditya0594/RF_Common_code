package RFCC_Extra;

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

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_AS_EvaluationStaffEntry extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}
	
	@Test
	public void aL_Examination_AS_EvaluationStaffEntry() throws Exception {
		test=reports.createTest("aL_Examination_AS_EvaluationStaffEntry");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		System.out.println("Examination->Answer Sheet->Evaluation Staff Entry");

		//Click on Examination
		WebElement ele = driver.findElement(By.partialLinkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.partialLinkText("Answer Sheet"));
		System.out.println("Examination Answer Sheet submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		System.out.println("Click on Evaluation Staff Entry");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		
		System.out.println("Click on Evaluator Type");
		WebElement evaluator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffType"));
		Select evaluator_typ = new Select(evaluator);
		evaluator_typ.selectByVisibleText("EXTERNAL");
		System.out.println("Evaluator Type is : EXTERNAL");
		Thread.sleep(2000);
		
		System.out.println("Click on Department");
		WebElement departmnt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		
		Select departmnt_typ = new Select(departmnt);
		departmnt_typ.selectByVisibleText("Department of Aerospace Engineering - Aerospace");
		System.out.println("Department Type is : Department of Aerospace Engineering - Aerospace");
		Thread.sleep(3000);
		
		System.out.println("Click on Staff Name");
		WebElement staff_name = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtName"));
				
				
		WebElement MobileNo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile"));
		
		
		WebElement EmailAddress = driver.findElement(By.id("ctl00$ContentPlaceHolder1$txtEmail"));
		
		
		WebElement Address = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress"));
		EmailAddress.sendKeys("Address Details");
		
		Thread.sleep(2000);
		System.out.println("Click on Submit Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
			
		String Expected_Msg = "Record Saved Successfully";
		String Actual_Msg = alert.getText();
		System.out.println(Actual_Msg = Expected_Msg);
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		//alert.accept();
		
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" +Actual_Msg);
	}

}
