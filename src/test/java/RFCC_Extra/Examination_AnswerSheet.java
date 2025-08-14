package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Examination_AnswerSheet extends BaseClass{
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
	public void examination_AnswerSheet() throws Exception {
		test=reports.createTest("Examination_AnswerSheet");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

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
		
		System.out.println("Click on Degree Dropdown Field");
		WebElement degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Select degree_typ = new Select(degree);
		degree_typ.selectByVisibleText("Bachelor of Science");
		System.out.println("Degree is: Bachelor of Science");
		Thread.sleep(2000);
		System.out.println("Enter Per Unit Price");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPerUnit")).sendKeys("20");
		System.out.println("Per Unit Price is: 20");
	    Thread.sleep(2000);
		System.out.println("Click on Submit button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		Thread.sleep(3000);
		
		String s1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" +s1);
		
		System.out.println("Click on Evaluation Staff Entry");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		
		System.out.println("Click on Evaluator Type");
		WebElement evaluator = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffType"));
		Select evaluator_typ = new Select(evaluator);
		evaluator_typ.selectByVisibleText("INTERNAL");
		System.out.println("Evaluator Type is : INTERNAL");
		Thread.sleep(2000);
		System.out.println("Click on Department");
		WebElement departmnt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Select departmnt_typ = new Select(departmnt);
		departmnt_typ.selectByVisibleText("Department of Aerospace Engineering - Aerospace");
		System.out.println("Department Type is : Department of Aerospace Engineering - Aerospace");
		Thread.sleep(3000);
		
		System.out.println("Click on Staff Name");
		WebElement staff_name = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlName"));
		Select staff_name_typ = new Select(staff_name);
		//staff_name_typ.selectByValue("756");
		staff_name_typ.selectByVisibleText("Dr. KADIRESH PN");
		System.out.println("Staff Name is : Dr. KADIRESH PN");
		Thread.sleep(2000);
		System.out.println("Click on Submit Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        Thread.sleep(2000);
		String s2 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" +s2);
		
		
		
		
	}

}
