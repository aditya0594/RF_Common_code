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

public class ELearning_CreateElibrary extends BaseClass{

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
	public void eLearning_CreateElibrary() throws Throwable
	{
		test = reports.createTest("ELearning_CreateElibrary");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		Thread.sleep(2000);
		//Click main E-Learning Menu
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Main E-Learning menu selected");

		Thread.sleep(2000);
		//Click Transactions submenu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		System.out.println(" Transactions submenu selected");
		
		/*
		 * Thread.sleep(2000);
		 * 
		 * WebElement subMenuA =
		 * driver.findElement(By.id("ctl00_repLinks_ctl29_rptLi"));
		 * System.out.println(" Transactions submenu selected");
		 * action.moveToElement(subMenuA); action.click().build().perform();
		 */
		
		Thread.sleep(2000);
		//Select Session
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		
		Thread.sleep(2000);
		//Select Course
		WebElement course = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect"));
		course.click();
		System.out.println("Select Course");
		
		Thread.sleep(2000);
		//Select Course
		WebElement btn_ok = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
		btn_ok.click();
		
		Thread.sleep(2000);
		//Click E-Library Submenu
		WebElement link_CEL = driver.findElement(By.linkText("Create E-Library"));
		System.out.println("Create E-Library submenu selected");
		action.moveToElement(link_CEL);
		action.click().build().perform();
		
		Thread.sleep(2000);
		//Enter Title
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBTitle"));
		title.sendKeys("Income Tax amd Law Practice");
		System.out.println("Title-> Income Tax amd Law Practices");
		
		Thread.sleep(2000);
		//Enter Author
		WebElement author = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAuthor"));
		author.sendKeys("Bansal Anshika");
		System.out.println("Author -> Bansal Anshika");
		
		Thread.sleep(2000);
		//Enter Publisher
		WebElement publisher = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPublisher"));
		publisher.sendKeys("Sultan Chand & Sons");
		System.out.println("Publisher ->Sultan Chand & Sons");
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement file = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_fileUploader"));
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
		//Click Attach		
		WebElement attach = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAttachFile"));
		attach.click();
		System.out.println("Click on Attach");
		
		Thread.sleep(2000);
		//Click Submit
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "e-Book added successfully.....";
		
		 if (Exp_Msg.equals(Act_Msg)) {
             System.out.println("Assertion passed"+ alert.getText());
             alert.accept();
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
