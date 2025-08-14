package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

public class ELearning_CreateAssignment extends BaseClass {

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
	public void eLearning_CreateAssignment() throws Throwable {
		test = reports.createTest("Faculty_ELearning_CreateAssignment");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		Thread.sleep(2000);
		//Click main menu E-Learning
		WebElement link_elear = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_elear).perform();

		Thread.sleep(2000);
		//Click on Trnsaction
		WebElement link_transac = driver.findElement(By.linkText("Transactions"));
		action.moveToElement(link_transac).click().perform();
		System.out.println(" Transactions submenu selected");
		

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Click on Select Course
		WebElement link_selectcourse = driver.findElement(By.linkText("Select Course"));
		js.executeScript("arguments[0].scrollIntoView();", link_selectcourse);
		
		
		Thread.sleep(2000);
		//Select Session
		System.out.println("select Session");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");

		Thread.sleep(2000);
		//Click on Course
		WebElement course = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect"));
		course.click();
		System.out.println("Select Course");
		
		Thread.sleep(2000);
		//Click on Button OK
		WebElement btn_ok = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
		btn_ok.click();
		System.out.println("Click OK");

		Thread.sleep(2000);
		//Click on Create Assignment
		WebElement ele1 = driver.findElement(By.linkText("Create Assignment"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		
		System.out.println("click Create Assignment");

		
		Thread.sleep(2000);
		//Enter Topic
		WebElement Topic =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTopic"));
		Topic.sendKeys("Automation Assignment");
		System.out.println("Assignment Topic -> Automation Assignment");

		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("What is Selenium?");
		System.out.println("Assignment Description -> What is Selenium?");
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");
	
		
		Thread.sleep(2000);
		//Select Assignment Type
		WebElement assigntyp = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddldoc"));
		js.executeScript("arguments[0].scrollIntoView(true);", assigntyp);
		Select type_assigntyp = new Select (assigntyp);
		type_assigntyp.selectByVisibleText("Description based");
		System.out.println("Assignment Type-> Description");
		
		Thread.sleep(2000);
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime deadline = currentTime.plus(Duration.ofDays(1));
		LocalDateTime reminderDateTime = deadline.plus(Duration.ofDays(1));
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	    String currentDateStr = currentTime.format(dateFormatter);
	    String currentTimeStr = currentTime.format(timeFormatter);
	    String nextDateStr = deadline.format(dateFormatter);
	    String nextTimeStr = deadline.format(timeFormatter);
	    String reminderDateStr = reminderDateTime.format(dateFormatter);
        String reminderTimeStr = reminderDateTime.format(timeFormatter);
	    
        
        Thread.sleep(2000);
        //Enter Submission From Date
        WebElement sub_from =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromdate"));
        js.executeScript("arguments[0].scrollIntoView(true);", sub_from);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromdate').value='" + currentDateStr + "';");
        System.out.println("Submission from date-> " + currentDateStr);
        
        Thread.sleep(2000);
        //Enter Submission From Time
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromtime').value='" + currentTimeStr + "';");
        System.out.println("Submission from time-> " + currentTimeStr);
        
        Thread.sleep(2000);
        //Enter Submission Due Date
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtDueDate').value='" + nextDateStr + "';");
        System.out.println("Due Date-> " + nextDateStr);
        
        Thread.sleep(2000);
        //Enter Submission Due Time
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtduetime').value='" + nextTimeStr + "';");
        System.out.println("Due time-> " + nextTimeStr);
        
        Thread.sleep(2000);
        //Enter Remainder Date
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtRdate').value='" + reminderDateStr + "';");
        System.out.println("Remainder Date-> " + reminderDateStr);
        
        Thread.sleep(2000);
        //Enter Remainder Time
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtRtime').value='" + reminderTimeStr + "';");
        System.out.println("Remainder Time-> " + reminderTimeStr);
        
       
		Thread.sleep(2000);
		//Enter Marks
		WebElement marks = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAMarks"));
		// marks.click();
		marks.sendKeys("20");
		System.out.println("Assignment Marks->20");
	
			
		Thread.sleep(4000);	
		//Click on Checkbox
		WebElement chkbox =driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_cbHead"));
		js.executeScript("arguments[0].scrollIntoView(true);", chkbox);
		chkbox.click();
		System.out.println("click Checkbox");
		
		Thread.sleep(4000);
		//Click on submit
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		js.executeScript("arguments[0].scrollIntoView(true);", btn_submit);
		btn_submit.click();
		System.out.println("Click submit");
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Assignment Added Successfully";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
		
	}

}
