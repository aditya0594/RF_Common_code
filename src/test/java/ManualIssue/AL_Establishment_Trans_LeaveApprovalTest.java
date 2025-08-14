package ManualIssue;

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

public class AL_Establishment_Trans_LeaveApprovalTest extends BaseClass {

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

	@Test
	public void aL_Establishment_Trans_LeaveApprovalTest() throws InterruptedException {
		// TODO Auto-generated method stub

		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ESTABLISHMENT"));
		System.out.println("Click on Establishment");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Click on Transactions option");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement link_Lapprove = driver.findElement(By.linkText("Leave Approval"));
		System.out.println("Click on Leave Approval from submenu");
		action.moveToElement(link_Lapprove);
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvPendingList_ctrl0_btnApproval"));
		btn_submit.click();
		System.out.println("Click on submit button");
		Thread.sleep(2000);		
		
		// To handle dropdown
		WebElement approve = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelect"));
		Select aa = new Select(approve);
		aa.selectByVisibleText("Approve & Final Submit");
		System.out.println("Select - Approve & Final Submit");
		
		Thread.sleep(2000);
		WebElement Remark = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRemarks"));
		Remark.sendKeys("Approve leave by Authority");
		System.out.println("Remark added");
		
		Thread.sleep(2000);
		WebElement Submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Submit);
		Submit.click();
		Thread.sleep(2000);
		
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		
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
