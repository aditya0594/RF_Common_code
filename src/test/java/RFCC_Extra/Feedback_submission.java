package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Feedback_submission extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void FeedBackSubmission() throws Exception {

		RF_AdminLoginPage.loginPage();

		WebElement link_academic = driver.findElement(By.linkText("ACADEMIC")); 
		System.out.println("Main academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_academic).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement link_feedback = driver.findElement(By.linkText("FeedBack"));
		System.out.println("FeedBack submenu selected");
		action.moveToElement(link_feedback);
		action.click().build().perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement link_fsub = driver.findElement(By.linkText("Feedback Submission"));
		System.out.println("Feedback Submission submenu selected");
		action.moveToElement(link_fsub);
		action.click().build().perform();
		
		
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("select2-search__field")).sendKeys("2023-2024", Keys.ENTER);
		System.out.println("session has been selected successfully");

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlFeedbackTyp-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Feedback Level I on Course Teacher",Keys.ENTER);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvSelected_ctrl1_lnkbtnCourse")).click();
		System.out.println("course is selected successfully");

		WebElement Scroll = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Scroll);

		/*
		 * driver.findElement(By.id(
		 * "ctl00_ContentPlaceHolder1_lvSelected_ctrl0_lnkbtnCourse")).click();
		 * driver.findElement(By.id(
		 * "ctl00_ContentPlaceHolder1_lvCourse_ctrl0_rblCourse_0")).click();
		 * driver.findElement(By.id(
		 * "ctl00_ContentPlaceHolder1_lvCourse_ctrl1_rblCourse_0")).click();
		 * 
		 * driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		 */

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl0_rblCourse_0")).click();

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl1_rblCourse_0")).click();

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();

	//	driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		
		alert.accept();
		

	}

}
