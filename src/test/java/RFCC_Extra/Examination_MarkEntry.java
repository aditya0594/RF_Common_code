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

public class Examination_MarkEntry extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

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
	public void AdminExamination_MarkEntry() throws Exception {
		test = reports.createTest("AdminExamination_MarkEntry");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.partialLinkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu 
		WebElement subMenu = driver.findElement(By.partialLinkText("Mark Entry"));
		System.out.println("Examination Mark Entry submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		System.out.println("Select college & Scheme");
		WebElement colg_schm_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollegeSheme"));
		Select colgSchm_typ = new Select(colg_schm_typ);
		colgSchm_typ.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		Thread.sleep(2000);

		System.out.println("Select session");
		WebElement sessn_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Thread.sleep(1000);
		Select session_type = new Select(sessn_typ);
		session_type.selectByVisibleText("Dec 2022");
		Thread.sleep(2000);

		System.out.println("select semester");
		WebElement sem_typ = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExam"));
		Select semester_typ = new Select(sem_typ);
		semester_typ.selectByVisibleText("semester-1 ");
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("click on show time Table button");
		Thread.sleep(2000);
		String s2 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" + s2);

		System.out.println("Click on Internal Exam Mark Entry by Faculty");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink"));
		Thread.sleep(2000);

		System.out.println("Click on Absent Student Entry");
		driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink")).click();

		// Unable to proceed Further due to no data available
	}
}
