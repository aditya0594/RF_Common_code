package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class ELearning_ContentMaster extends BaseClass{

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");  
	}
	
	@Test
	public void eLearning_ContentMaster() throws Throwable
	{
		test = reports.createTest("ELearning_ContentMaster");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		//Click on E-Learning from navigation bar 
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Click on E-Learning from navigation bar");
		Thread.sleep(2000);

		//Click on Transaction option
		driver.findElement(By.linkText("Transactions")).click();
		System.out.println("Click on Transaction option");
		Thread.sleep(2000);
		
		//Click on Select Course from Sub menu
		WebElement subMenuA = driver.findElement(By.id("ctl00_repLinks_ctl17_rptLi"));// ctl00_repLinks_ctl00_lbLink
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",subMenuA);
		System.out.println("Click on Select Course from Sub menu"); 
		Thread.sleep(2000);

		//Select Session
		Select colg_typ = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Select Session -> May 2022 - School of Social Sciences and Humanities");
		Thread.sleep(2000);
		
		//Click on Course
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("COC 3201 - Income Tax Law & Practice - II - [B.Com. - GEN]");
		Thread.sleep(2000);
		
		//Click on ok button
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");
		Thread.sleep(2000); 
		
		//Click on Content Master from sub menu
		WebElement sub_Menu = driver.findElement(By.id("ctl00_repLinks_ctl29_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();", sub_Menu);
		js.executeScript("arguments[0].click();",sub_Menu);
		System.out.println("Click on Content Master from sub menu"); 
		Thread.sleep(2000);
		
		//Click on Module button
		Thread.sleep(2000);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnModule")).click();
		System.out.println("Click on Module button");
		
		//Enter Sequence number
		WebElement wb = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUnitSequence"));
		wb.clear();
		wb.sendKeys("8"); //Change Every time
		System.out.println("Enter Sequence number -> 8"); 
		Thread.sleep(2000);
		
		//Enter Module name
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUnitTitleName")).sendKeys("Tax Calculation2"); //Change Every time
		System.out.println("Enter Module name -> Tax Calculation 2"); 
		Thread.sleep(2000);
		
		//Switch inside frame
		switchToFrame(2);
		System.out.println("Inside Frame");
		Thread.sleep(2000);
		
		//Enter text
		driver.findElement(By.className("cke_show_borders")).sendKeys("In this eLearning module on Tax Planning, we will learn about the principles of tax planning. We will start with the basics of understanding several modes of income for an individual and available deductions and exemptions to save on taxes. Additionally we will explore the tax aspects of the investment products.");
		System.out.println("Enter text");
		Thread.sleep(2000);
		
		//Switch outside frame
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");
		Thread.sleep(2000);
		
		//Click on submit button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnModuleSubmit")).click();
		System.out.println("Click on submit button");
		Thread.sleep(2000);		
	
		//Check alert and accept
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "MODULE Created Successfully... ";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Messege - " + Actual_Msg+ "\n"+ "Expected Messege - " + Expected_Msg); 
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		Thread.sleep(2000);	
		alert.accept();	
	}

}
