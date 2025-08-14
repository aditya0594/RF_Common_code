package RFCC_Extra;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class ELearning_View extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "\n");
	}

	@Test
	public void Student_ELearning_View() throws Exception {
		test = reports.createTest("Student_ELearning_View");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		//191291601067
		System.out.println("Student Logged in Successfully");
		Thread.sleep(2000);

//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		WebElement Elearn = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Elearn).perform();
		
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Elearn_ViewSubMenu = driver.findElement(By.linkText("View"));
		System.out.println("E-Learning View submenu selected");
		action.moveToElement(Elearn_ViewSubMenu);
		action.click().build().perform();
		Thread.sleep(2000);

		System.out.println("Please select Session of Select Course");
		WebElement session_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Thread.sleep(2000);
		Select sessn_sel = new Select(session_select);
		sessn_sel.selectByValue("191");
		Thread.sleep(2000);
		System.out.println("DEC 2021-Cresent School of Architecture selected");
		Thread.sleep(3000);

		System.out.println("Click on Personal Calender");
		WebElement personal_calndr = driver.findElement(By.id("ctl00_repLinks_ctl14_lbLink"));
		personal_calndr.click();
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.id("ctl00_repLinks_ctl28_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);

		System.out.println("Click on Request For ReTest");
		WebElement request_ReTest = driver.findElement(By.id("ctl00_repLinks_ctl23_lbLink"));
		request_ReTest.click();
		Thread.sleep(2000);

		System.out.println("Please select session");
		WebElement session_select1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Thread.sleep(2000);
		Select sessn_sel1 = new Select(session_select1);
		sessn_sel1.selectByValue("203");
		Thread.sleep(2000);
		System.out.println("May 2022-Cresent School of Architecture selected");

//	      //Note:course list option in table are disable so unable to proceed further
		Thread.sleep(2000);
		System.out.println("Click on Submit button");
		WebElement Submit_Btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		Submit_Btn.click();
		

		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
		// Screenshot
		
		Thread.sleep(2000);
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\CresentScreenshot.png");
			FileUtils.copyFile(SrcFile, DestFile.getAbsoluteFile());
			System.out.println("Screenshot captured: " + DestFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}

	}

}
