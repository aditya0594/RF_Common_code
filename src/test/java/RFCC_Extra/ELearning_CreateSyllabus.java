package RFCC_Extra;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class ELearning_CreateSyllabus extends BaseClass{

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
	public void eLearning_CreateSyllabus() throws Throwable
	{
		test = reports.createTest("ELearning_CreateSyllabus");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(3000);
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
		
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenuA = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		System.out.println(" Transactions submenu selected");
		action.moveToElement(subMenuA);
		action.click().build().perform();
		
		System.out.println("select Session");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu1 = driver.findElement(By.linkText("Create Syllabus"));
		System.out.println("Create Syllabus submenu selected");
		js.executeScript("arguments[0].scrollIntoView();",subMenu1);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", subMenu1);	
		
		
		WebElement unit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUnit"));
		unit.sendKeys("Unit 1");
		System.out.println("Unit-> Unit1");
		
		WebElement topic = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTopic"));
		topic.sendKeys("Income Tax Law");
		System.out.println("topic -> Income Tax Law");
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement file = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_fuSyllabus"));
		executor.executeScript("arguments[0].click();", file);

		Thread.sleep(2000);
		String filePath = "C:\\RFCCC Project\\RF_Common_Code_LIVE\\src\\test\\resources\\documentsForTesting\\bcom-syllabus.pdf";
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(200);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File Added added Successfully");
		
		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		
		Thread.sleep(2000);
		WebElement desc = driver.findElement(By.className("cke_show_borders"));
		desc.sendKeys("Income Tax Law Syllabus");
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
	
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record Saved  Successfully...";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		acceptAlert();
		
		/*
		 * Thread.sleep(2000); WebElement lib_report =
		 * driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnViewELibrary"));
		 * lib_report.click();
		 * 
		 * Thread.sleep(2000); System.out.println("entering to next window "); String
		 * currentWindowHandle = driver.getWindowHandle(); Set<String> allWindowHandles
		 * = driver.getWindowHandles();
		 * 
		 * for (String handle : allWindowHandles) { if
		 * (!handle.equals(currentWindowHandle)) { driver.switchTo().window(handle);
		 * break; } }
		 * 
		 * Thread.sleep(2000); WebElement btn_dwn =
		 * driver.findElement(By.id("maskedImage")); btn_dwn.click();
		 * 
		 * Thread.sleep(2000); String dwn_report =
		 * "E:\\MasterSoft\\Automaiton\\RF_Common_Code_LIVE\\src\\test\\resources\\documentsForTesting";
		 * StringSelection selection1 = new StringSelection(dwn_report);
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1,
		 * null);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * robot.delay(300); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
		 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.delay(200); robot.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * Thread.sleep(2000); driver.switchTo().window(currentWindowHandle);
		 * System.out.println("back to original window"); // Thread.sleep(2000);
		 */	}

}
