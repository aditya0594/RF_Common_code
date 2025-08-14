package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Examination_StudentRelated extends BaseClass {
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
	public void AdminExam_Student_Related() throws Exception {
		test = reports.createTest("AdminExam_Student_Related");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();

		//Click on Examination
		WebElement Exm = driver.findElement(By.partialLinkText("EXAMINATION"));
		System.out.println("Click on Examination");
		Actions action = new Actions(driver);
		action.moveToElement(Exm).perform();
		Thread.sleep(2000);
		
		// Click on Conduction of Examination
		WebElement Trans = driver.findElement(By.partialLinkText("Student Related"));
		Trans.click();
		System.out.println("Click Student Related submenu selected");
		Thread.sleep(2000);

		String s1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert Text is:" + s1);
		// unable to proceed further it is giving alert You are not authorized to view
		// this page
	}

}
