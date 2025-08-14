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

public class ELearning_CheckAssignment extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void eLearning_CheckAssignment() throws Throwable {
		test = reports.createTest("Faculty_ELearning_CreateAssignment");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000); 
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(subMenu).click().perform();
		System.out.println(" Transactions submenu selected");
		

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenuA = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		action1.moveToElement(subMenuA);
		action1.click().build().perform();

		System.out.println("select Session");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");

		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele1 = driver.findElement(By.linkText("Check Student Assignment"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		System.out.println("Check Student Assignment");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvAssignment_ctrl0_btnStudeReply")).click();
		System.out.println("click student reply");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvAssignmentReply_ctrl0_btnEdit")).click();
		System.out.println("Click on Edit");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMarks")).clear();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMarks")).sendKeys("15");
		System.out.println("Add Marks");
		
		
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkChecked")).click();
		System.out.println("click on checked");
		
				
		Thread.sleep(3000);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkDisplayMarks")).click();
		System.out.println("click on display result to student");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		System.out.println("click submit");
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept(); 

			
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		//System.out.println("Click submit");
		

	}

}

