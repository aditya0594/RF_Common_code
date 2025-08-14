package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class SectionOrEnrollmentNoAllotmentTests extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}

	@Test()

	public void Section_Or_Enrollment_No_Allotment() throws IOException, Exception {
		
		test = reports.createTest("Bundle_Creation");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academic-> POST ADMISSION -> Section/Enrollment No. Allotment");
		
		Thread.sleep(2000);
		//Click on Academics from navigation bar
		WebElement link_academics = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(link_academics).perform();
		System.out.println("Click on Academics from navigation bar");
		
		Thread.sleep(2000);
		//Click on Post Admission Option
		WebElement link_PostAdm = driver.findElement(By.linkText("Post Admission"));
		action.moveToElement(link_PostAdm);
		action.click().build().perform();
		System.out.println("Click on Post Admission Option");
		
		Thread.sleep(2000);
		//Click on Section/Enrollment No. Allotment
		WebElement link_SEA = driver.findElement(By.linkText("Section/Enrollment No. Allotment"));
		link_SEA.click();
		System.out.println("Click on Section/Enrollment No. Allotment");
		
		Thread.sleep(2000);
		//Select School/Institute
		WebElement schl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlInsName"));
		Select typ_schl = new Select(schl);
		typ_schl.selectByVisibleText("Crescent School of Architecture - Chennai");
		System.out.println("click on School/Institute -> Crescent School of Architecture - Chennai");
		
		Thread.sleep(2000);
		//Select Degree
		WebElement deg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Select typ_deg = new Select(deg);
		typ_deg.selectByVisibleText("Bachelor of Architecture");
		System.out.println("click on Degree - Bachelor of Architecture");
		
		Thread.sleep(2000);
		//Select Batch
		WebElement batch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Select typ_batch = new Select(batch);
		typ_batch.selectByVisibleText("Architecture");
		System.out.println("click on Programme/Branch - Architecture");
		
		Thread.sleep(2000);
		//Click on Filter Button
		WebElement btn_filter = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFilter"));
		btn_filter.click();
		System.out.println("click on Filter");
		
		/*
		 * Thread.sleep(2000); //Enter Roll NO . WebElement txt_Roll1 =
		 * driver.findElement(By.id(
		 * "ctl00_ContentPlaceHolder1_lvStudents_ctrl1_TextBox1")); txt_Roll1.clear();
		 * txt_Roll1.sendKeys("10000112");
		 * System.out.println("Roll no for student 1 -> 10000112");
		 * 
		 * 
		 */
		
		Thread.sleep(2000);
		WebElement sec = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl4_ddlsec"));
		Select typ_sec = new Select(sec);
		typ_sec.selectByVisibleText("B");
		
		
		Thread.sleep(2000);
		//Enter Roll NO .
		WebElement txt_Roll2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl4_TextBox1"));
		txt_Roll2.clear();
		txt_Roll2.sendKeys("10000113");
		System.out.println("Roll no for student 2 ->10000113");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Click on Filter Button
		WebElement btn_Submit = driver.findElement(By.className("ctl00$ContentPlaceHolder1$btnSubmit"));
		//js.executeScript("arguments[0].scrollIntoView();",btn_Submit);
		//btn_Submit.sendKeys(Keys.ENTER);
		js.executeScript("arguments[0].click();", btn_Submit);
		System.out.println("click on Submit");
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Updated Successfully!!!";
		String Actual_Msg =alert.getText();

		if (Expected_Msg.equals(Actual_Msg)) 
		{
			System.out.println("Assertion passed");
			Thread.sleep(2000);
			alert.accept();
		} 
		else 
		{
			System.out.println("Assertion failed: Expected '" + Expected_Msg + "' but got '" + Actual_Msg + "'.");
			// Handle the alert (if any)
			try 
			{
				System.out.println("Alert found: " + alert.getText());
				//Thread.sleep(2000);
				alert.accept(); // Accept the alert
				System.out.println("Alert accepted.");
			}
			catch (NoAlertPresentException e) 
			{
				System.out.println("No alert present.");
			}
		}
		
		
	}
}
