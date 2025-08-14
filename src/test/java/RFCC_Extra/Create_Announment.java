package RFCC_Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Create_Announment extends BaseClass {
	
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
	public void CreateAnnouncment () throws InterruptedException {
		
		RF_AdminLoginPage.loginPage();


		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Main E-Learning menu selected");

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		System.out.println(" Transactions submenu selected");

		Select ddl = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlSession"))); // ctl00$ContentPlaceHolder1$ddlSession
		ddl.selectByVisibleText("May 2022 - School of Mechanical Sciences");
		//select Subject
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_pnlCourseList")).click();

		Thread.sleep(2000);
		System.out.println("Click on Create Announcement");
		WebElement link_cretannounce = driver.findElement(By.linkText(""));
		link_cretannounce.click();
		Thread.sleep(2000);

		System.out.println("Enter Announcement Title");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSubject")).sendKeys("Atomic Battery");
		Thread.sleep(2000);
		
		System.out.println("Enter Expiry Date");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgSubmitDate")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceSubmitDate_day_3_1")).click(); 
		Thread.sleep(4000);
		
		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		
		System.out.println("Click on Submit button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
		String s = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert text is:" +s);
	}

}
