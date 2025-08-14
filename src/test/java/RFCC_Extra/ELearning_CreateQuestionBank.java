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

public class ELearning_CreateQuestionBank extends BaseClass {

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
	public void eLearning_CreateQuestionBank() throws Throwable {
		test = reports.createTest("ELearning_CreateQuestionBank");

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
		WebElement subMenuA = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		action1.moveToElement(subMenuA);
		action1.click().build().perform();
		

		WebElement sess = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sess_typ = new Select(sess);
		sess_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		System.out.println("select Session");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		System.out.println("Create Question Bank");
		
		Thread.sleep(2000);
		WebElement radio_Button = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rbnObjectiveDescriptive_0"));
        radio_Button.click();

        if (radio_Button.isSelected()) {
            System.out.println("Radio button is selected.");
        } else {
            System.out.println("Radio button is not selected.");
        }
        System.out.println("Objective radio selected");
        
        Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNewTopic")).sendKeys("Selenium");
		System.out.println("Topic Name->Selenium");
		
		Thread.sleep(2000);
		WebElement radio_Btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdbtnList_0"));
		radio_Btn.click();

        if (radio_Btn.isSelected()) {
            System.out.println("Radio button is selected.");
        } else {
            System.out.println("Radio button is not selected.");
        }
        System.out.println("Text radio selected");
        
        Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("Which of the following browsers supports selenium?");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Assignment Description -> Which of the following browsers supports selenium?");

		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(2000);
		switchToFrame(4);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("Google Chrome");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 1 -> Google Chrome");
		
		Thread.sleep(2000);
		switchToFrame(5);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("Safari");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 2 -> Safari");
		
		Thread.sleep(2000);
		switchToFrame(6);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("Mozilla Firefox");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 3 ->Mozilla Firefox ");
		
		Thread.sleep(2000);
		switchToFrame(7);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("Internet Explorer");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 4 -> Internet Explorer");
		
		Thread.sleep(2000);
		switchToFrame(8);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("All of the above");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 5 ->All of the above ");
		
		je.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(2000);
		System.out.println("select Session");
		WebElement ans = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCorrectAns"));
		Select ans_typ = new Select(ans);
		ans_typ.selectByVisibleText("Answer 5");
		System.out.println("option -> Answer 5");
		
		Thread.sleep(2000);
		WebElement submit =driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		submit.click();
		System.out.println("Click submit");
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		acceptAlert();
		
		// select course and create question bank
		
		
		
		
		
		
		
		
		/*

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele1 = driver.findElement(By.linkText("Test Creation"));
		jse.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		System.out.println("click Test Creation");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnObjectiveTest")).click();
		System.out.println("Click on Objective Type Test");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTestName")).sendKeys("Selenium");
		System.out.println("Test Name->Selenium");
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement Start_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromdate"));
		Start_date.sendKeys("02/08/2024");
		System.out.println("Test Start Date is:02/08/2024");
				
		WebElement end_date = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromdate"));
		end_date.sendKeys("02/08/2024");
		System.out.println("Test End Date is:02/08/2024");

		Thread.sleep(2000);
		WebElement start_time = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromtime"));
		start_time.sendKeys("11:00:00");
		System.out.println("Test Start time 10:00:00");
		
		Thread.sleep(2000);
		WebElement end_time = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromtime"));
		end_time.sendKeys("12:00:00");
		System.out.println("Test End time 10:00:00");
		
		Thread.sleep(2000);
		WebElement duration = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromtime"));
		duration.sendKeys("01:00:00");
		System.out.println("Test Duration time 01:00:00");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAttempts")).sendKeys("1");
		System.out.println("No of Attempts ->");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_cbShowResult")).click();
		System.out.println("checked show result after test");
		*/
		
		

		
		
		
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		//System.out.println("Click submit");
		

	}

}

