package RFCC_Extra;

import org.openqa.selenium.By;
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

import java.lang.reflect.Method;

public class ApproveLeave extends BaseClass {

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
	public void Approve_Leave() throws InterruptedException {
		// TODO Auto-generated method stub

		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ESTABLISHMENT"));
		System.out.println("Main ESTABLISHMENT menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Transactions submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement link_Lapprove = driver.findElement(By.linkText("Leave Approval"));
		System.out.println("Leave Approval submenu selected");
		action.moveToElement(link_Lapprove);
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvPendingList_ctrl0_btnApproval"));
		btn_submit.click();
		System.out.println("click submit");
				
		
		// To handle dropdown
		WebElement approve = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelect"));
		Select aa = new Select(approve);
		aa.selectByVisibleText("Approve & Final Submit");
		System.out.println("drop down value handled");
		
		Thread.sleep(2000);
		WebElement Remark = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRemarks"));
		Remark.sendKeys("Approve leave by Authority");
		System.out.println("Remark added");
		
		Thread.sleep(2000);
		WebElement Submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		Submit.click();
		System.out.println("Leave Approved Successfully");

	}

}
