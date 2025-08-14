package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class StudentFeedback extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n"); 
	}

	@Test
	public void student_Feedback_Submission() throws Exception {

		test = reports.createTest("student_Feedback_Submission");
		Thread.sleep(2000);

		RF_StudentLoginPage.loginPage();
		System.out.println("Student Logged in Successfully");
		

//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		WebElement accdemic = driver.findElement(By.partialLinkText("ACADEMIC"));
		System.out.println("Click on Academic");
		Actions action = new Actions(driver);
		action.moveToElement(accdemic).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Academic_feedbckSubMenu = driver.findElement(By.partialLinkText("FeedBack"));
		System.out.println("Click on Feedback");
		action.moveToElement(Academic_feedbckSubMenu);
		action.click().build().perform();
//
//		Thread.sleep(2000);
//		String s1 = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s1);
		
		//Click on Feedback Submission
		driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink")).click();
//		WebElement wb = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("arguments[0].click();",wb);
		
		System.out.println("Click on Feedback Submission");

		Thread.sleep(2000);
//		System.out.println("Click on Academic -> Feedback -> Feedback Submission");
//		driver.get("https://rfcautomationuat.mastersofterp.in/ACADEMIC/iitmsrMg3+HCQYQW0DwugkH9A2YONXFYVx+h6NQCuLzeLYUdo7wJsh0xginZ0LDKlBvfr?pageno=2861");

		Thread.sleep(2000);
		WebElement sessn = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container"));
		sessn.click();
		System.out.println("click on session dropdown field -> 2023-2024");
		driver.findElement(By.className("select2-search__field")).sendKeys("2023-2024", Keys.ENTER);

		Thread.sleep(2000);
		WebElement Feedback = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlFeedbackTyp-container"));
		Feedback.click();
		System.out.println("Feedback Type -> Feedback Level I on Course Teacher");
		driver.findElement(By.className("select2-search__field")).sendKeys("Feedback Level I on Course Teacher",
				Keys.ENTER);

		Thread.sleep(3000);
		System.out.println("click on Subject Code -> REG - Radiumology [ V S GOPALAKRISHNAN ] [ MT ]");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvSelected_ctrl0_lnkbtnCourse")).click();

		// Create JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the page by 500 pixels
		js.executeScript("window.scrollBy(0,500)");
		// Alternatively, you can scroll to a specific element
		WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvSelected_ctrl0_lnkbtnCourse"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(2000);
		System.out.println("Question No. 1 -> The course teacher prepares well for the classes. -> Good");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl0_rblCourse_0")).click();

		Thread.sleep(2000);
		System.out.println("Question No. 2 -> Teacher Student Feedback -> Excellent");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl1_rblCourse_0")).click();

		Thread.sleep(2000);
		System.out.println("Click on Submit");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click(); 

		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		/*
		 * String Expected_Msg = ""; //No feedback questions found for this semester
		 * course. String Actual_Msg =alert.getText(); Thread.sleep(2000);
		 * Assert.assertEquals(Actual_Msg, Expected_Msg,
		 * "Actual and Expected Msg matched");
		 */
		alert.accept();

	}
}
