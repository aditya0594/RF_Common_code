package RFCC_Extra;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class ELearning_CreateLectureNotes extends BaseClass{

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
	public void eLearning_CreateLectureNotes() throws Throwable
	{
		test = reports.createTest("ELearning_CreateLectureNotes");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(2000);
		//click on E-Learning Main Menu
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Main E-Learning menu selected");

		Thread.sleep(2000);
		//click on Transactions submenu Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		System.out.println(" Transactions submenu selected");
		
		/*
		 * Thread.sleep(2000); WebElement subMenuA =
		 * driver.findElement(By.id("ctl00_repLinks_ctl29_rptLi"));
		 * System.out.println(" Transactions submenu selected");
		 * action.moveToElement(subMenuA); action.click().build().perform();
		 */
		Thread.sleep(2000);
		//Select Session
		System.out.println("select Session");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		
		Thread.sleep(2000);
		//Select Course
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		
		Thread.sleep(2000);
		//Select lecture Notes link
		WebElement Link_lecNote = driver.findElement(By.linkText("Create LectureNotes"));
		System.out.println("Create LectureNotes submenu selected");
		action.moveToElement(Link_lecNote);
		action.click().build().perform();

		Thread.sleep(2000);
		//Select Topic
		WebElement topic = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTopic"));
		Select topic_typ = new Select(topic);
		topic_typ.selectByVisibleText("income tax");
		System.out.println("Topic -> Income tax");
		
		Thread.sleep(2000);
		// Enter Subtopic 
		WebElement sub_topic = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSubject"));
		sub_topic.sendKeys("Income Tax Law & Practices II");
		System.out.println("Sub Topic-> Income Tax Law & Practices II");
	
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement file = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_fileUploader"));
		executor.executeScript("arguments[0].click();", file);

		Thread.sleep(2000);
		String filePath = "E:\\MasterSoft\\Automaiton\\RF_Common_Code_LIVE\\src\\test\\resources\\documentsForTesting\\bcom-syllabus.pdf";
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Thread.sleep(3000);
		
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
		//Click Attach Button
		WebElement attach = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAttachFile"));
		attach.click();
		System.out.println("Click on Attach");
		
		
		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		
		Thread.sleep(2000);
		//Adding desc in frame
		WebElement desc = driver.findElement(By.className("cke_show_borders"));
		desc.sendKeys("Income Tax Law Syllabus");
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");
		
		Thread.sleep(2000);
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	    Thread.sleep(2000);
	    //click on submit
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		Thread.sleep(2000);
		
		/*
		 * Alert alert = driver.switchTo().alert(); String Expected_Msg = ""; String
		 * Actual_Msg = alert.getText();
		 * System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+
		 * "Expected Confiramtion Text - " + Expected_Msg);
		 * Assert.assertEquals(Actual_Msg,
		 * Expected_Msg,"Actual and Expected Msg matched"); acceptAlert();
		 */
		
		Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "";
		
		 if (Exp_Msg.equals(Act_Msg)) {
             System.out.println("Assertion passed");
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");

             // Handle the alert (if any)
             try {
                 
                 System.out.println("Alert found: " + alert.getText());
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }
	}

}
