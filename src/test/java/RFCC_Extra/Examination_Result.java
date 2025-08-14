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

public class Examination_Result  extends BaseClass{
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
	public void AdminExamination_Result() throws Exception {
		test=reports.createTest("AdminExamination_Result");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.partialLinkText("Results"));
		System.out.println("Examination Result submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		System.out.println("select college & Scheme");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		System.out.println("College is: CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		Thread.sleep(2000);
		System.out.println("select Session");
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessn_typ = new Select(sessn);
		sessn_typ.selectByVisibleText("May 2022");
		System.out.println("Session is: May 2022");
		Thread.sleep(3000);
		System.out.println("select Semester");
		WebElement sem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select sem_typ = new Select(sem);
		sem_typ.selectByVisibleText("III");
		System.out.println("Semester is:III");
		Thread.sleep(3000);
		System.out.println("select Student Type");
		WebElement student = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStudentType"));
		Select student_typ = new Select(student);
		student_typ.selectByVisibleText("Backlog");
		System.out.println("Student Type is: Backlog");
		Thread.sleep(3000);
		System.out.println("Click on Show Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		Thread.sleep(2000);
		String s1= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" +s1);
		
		System.out.println("Click on Publish Result");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		
		System.out.println("select college");
		WebElement colge = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select colge_typ = new Select(colge);
		colge_typ.selectByVisibleText("Crescent School of Architecture");
		System.out.println("College is: Crescent School of Architecture");
		Thread.sleep(2000);
		
		System.out.println("select Session");
		WebElement sessnn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessnn_typ = new Select(sessnn);
		sessnn_typ.selectByVisibleText("May 2022");
		System.out.println("May 2022");
		Thread.sleep(2000);
		
		System.out.println("select Semester");
		WebElement semstr = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select semstr_typ = new Select(semstr);
		semstr_typ.selectByVisibleText("II");
		System.out.println("Semester is: II");
		Thread.sleep(2000);
		
		System.out.println("select Exam Type");
		WebElement exam = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExamType"));
		Select exam_typ = new Select(exam);
		exam_typ.selectByVisibleText("Regular");
		System.out.println("Exam Type is: Regular");
		Thread.sleep(2000);
		
        System.out.println("Select Publish Date");
        WebElement date_input = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfPublish"));
        date_input.click();
        date_input.sendKeys("25/12/2023");
        System.out.println("Publish Date is:25/12/2023");
		Thread.sleep(2000);
        System.out.println("Click on Show Student Button");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
       //driver.switchTo().alert().accept();
	}
}
