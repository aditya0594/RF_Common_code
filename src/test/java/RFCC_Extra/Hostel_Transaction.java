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
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Hostel_Transaction  extends  BaseClass{ 

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
	}
	
	@Test
	public void Student_Hostel_Transaction() throws Exception 
	{
		test=reports.createTest("Student_Hostel_Transaction");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		System.out.println("Student Logged in Successfully");
		Thread.sleep(2000);
		
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);
		
		WebElement hostelTrans = driver.findElement(By.linkText("HOSTEL"));
		System.out.println("Hostel menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(hostelTrans).perform();
		   Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Hostel_TransSubMenu = driver.findElement(By.linkText("Transaction"));
		System.out.println("Hostel Transaction submenu selected");
		action.moveToElement(Hostel_TransSubMenu);
		   Thread.sleep(2000);
		   action.click().build().perform();
		   Thread.sleep(2000);
		   
		   //=== Retrieve message from alert====/
//			String s2 = driver.switchTo().alert().getText();
//			driver.switchTo().alert().accept();
//			System.out.println("Alert Text is:" + s2);
		    Thread.sleep(2000);
		   WebElement HostelDrpDowm = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Mainpnl\"]/div[3]/div[1]/div/div[2]/span[1]/span[1]/span"));
		   HostelDrpDowm.click();
		   System.out.println("Hostel Dropdown field clicked");
		   Thread.sleep(2000);
		   
		   WebElement BlockDrpDowm = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBlock-container"));
		   BlockDrpDowm.click();
		   System.out.println("Block Dropdown field clicked");
		   Thread.sleep(2000);
		   
		   WebElement CreatDmdSem = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDemandSem-container"));
		   CreatDmdSem.click();
		   System.out.println("Create Demand For Semester Dropdown field clicked");
//		   WebElement drpdwnValue = driver.findElement(By.className("select2-results__option select2-results__message"));
//		   String s3 = drpdwnValue.getText();
//		   System.out.println(s3);
		   //=========================Reason not to proceed further==================
		   {/* No Data is present in dropdown list*/}
		   
	}
}
