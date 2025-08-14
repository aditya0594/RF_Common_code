package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Faculty_CreateAssignment extends BaseClass {

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
		//hover to main e-Learning MENU
		WebElement link_elearn = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_elearn).perform();

		Thread.sleep(2000);
		//Click Transaction submenu
		WebElement link_transac = driver.findElement(By.linkText("Transactions"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(link_transac).click().perform();
		System.out.println(" Transactions submenu selected");
		

		Thread.sleep(2000);
		//Click select Course
		WebElement subMenuA = driver.findElement(By.linkText("Select Course"));
		action1.moveToElement(subMenuA);
		action1.click().build().perform();

		Thread.sleep(2000);
		//Click on Session
		System.out.println("select Session");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");

		Thread.sleep(2000);
		//Select course
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		
		Thread.sleep(2000);
		//Click ok
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");

		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		//Click Create Assignment
		WebElement link_CA = driver.findElement(By.linkText("Create Assignment"));
		js.executeScript("arguments[0].scrollIntoView(true);", link_CA);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", link_CA);	
		System.out.println("click Create Assignment");

		
		Thread.sleep(2000);
		//Enter Topic
		WebElement Topic =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTopic"));
		js.executeScript("arguments[0].scrollIntoView(true);", Topic);
		Topic.sendKeys("Automation Assignment");
		System.out.println("Assignment Topic -> Automation Assignment");

		Thread.sleep(2000);
		//Switch Inside Frame
		switchToFrame(2);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("What is Selenium?");
		System.out.println("Assignment Description -> What is Selenium?");
		
		Thread.sleep(2000);
		//Switch to wndow
		driver.switchTo().defaultContent();
		

		Thread.sleep(2000);
		//Select Assignment Type
		WebElement desc = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddldoc-container"));
		desc.click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Description based", Keys.ENTER);
		System.out.println("Assignment Type-> Description");
		
		Thread.sleep(2000);
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime deadline = currentTime.plus(Duration.ofDays(1));
		LocalDateTime reminderDateTime = deadline.plus(Duration.ofDays(1));
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

	    String currentDateStr = currentTime.format(dateFormatter);
	    String currentTimeStr = currentTime.format(timeFormatter);
	    String nextDateStr = deadline.format(dateFormatter);
	    String nextTimeStr = deadline.format(timeFormatter);
	    String reminderDateStr = reminderDateTime.format(dateFormatter);
        String reminderTimeStr = reminderDateTime.format(timeFormatter);
	    
        
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromdate').value='" + currentDateStr + "';");
        System.out.println("Submission from date-> " + currentDateStr);
        
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromtime').value='" + currentTimeStr + "';");
        //js.executeScript("arguments[0].value = arguments[1];", subFromTime, currentTimeStr);
        System.out.println("Submission from time-> " + currentTimeStr);
    
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtDueDate').value='" + nextDateStr + "';");
        System.out.println("Due Date-> " + nextDateStr);
        
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtduetime').value='" + nextTimeStr + "';");
        //js.executeScript("arguments[0].value = arguments[1];", subDueTime, nextTimeStr);
        System.out.println("Due time-> " + nextTimeStr);
        
        
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtRdate').value='" + reminderDateStr + "';");
        System.out.println("Remainder Date-> " + reminderDateStr);
        
        Thread.sleep(3000);
        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtRtime').value='" + reminderTimeStr + "';");
        System.out.println("Remainder Time-> " + reminderTimeStr);
        
       
		Thread.sleep(2000);
		//Enter Marks
		WebElement marks = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAMarks"));
		js.executeScript("arguments[0].scrollIntoView(true);", marks);
		// marks.click();
		marks.clear();
		marks.sendKeys("20");
		System.out.println("Assignment Marks->20");
	
			
		Thread.sleep(4000);	
		//Click checkbox
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
				
		

	}

}
