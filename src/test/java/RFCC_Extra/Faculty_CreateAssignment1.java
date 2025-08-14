package RFCC_Extra;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.Alert;
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

public class Faculty_CreateAssignment1 extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	public static Properties conpro;

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
	public void faculty_CreateAssignment1() throws Throwable {
		test = reports.createTest("Faculty_CreateAssignment1");

		conpro = new Properties();
		conpro.load(new FileInputStream(".\\src\\test\\resources\\properties\\createassign.properties"));
		
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
		WebElement ele1 = driver.findElement(By.linkText("Create Assignment"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ele1);
		System.out.println("click Create Assignment");

		
		Thread.sleep(2000);
		WebElement Topic =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTopic"));
		Topic.sendKeys("Automation Assignment");
		System.out.println("Assignment Topic -> Assignment Testing");

		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		driver.findElement(By.className("cke_show_borders")).sendKeys("What is Selenium?");
		System.out.println("Assignment Description -> What is Selenium?");
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		WebElement date_start = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromdate"));
		date_start.sendKeys(conpro.getProperty("start-date"));
		System.out.println("Start Date ->" + date_start);
		
		Thread.sleep(2000);
		WebElement time_start = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtsubfromtime"));
		time_start.sendKeys(conpro.getProperty("start-time"));
		System.out.println("Start time ->" + time_start);
		
		Thread.sleep(2000);
		WebElement date_end = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDueDate"));
		date_end.sendKeys(conpro.getProperty("due-date"));
		System.out.println("Due Date ->" + date_end);
		
		Thread.sleep(2000);
		WebElement time_end = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtduetime"));
		time_end.sendKeys(conpro.getProperty("due-time"));
		System.out.println("Due Time ->" + time_end);
		
		Thread.sleep(2000);
		WebElement date_rem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRdate"));
		date_rem.sendKeys(conpro.getProperty("rem-date"));
		System.out.println("Remainder Date ->" + date_rem);
		
		Thread.sleep(2000);
		WebElement time_rem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRtime"));
		time_rem.sendKeys(conpro.getProperty("rem-time"));
		System.out.println("Remainder Time ->" + time_rem);
				
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddldoc-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Description based", Keys.ENTER);
		System.out.println("Assignment Type-> Description");
		
		Thread.sleep(2000);
		/*
		 * LocalDateTime currentTime = LocalDateTime.now(); LocalDateTime deadline =
		 * currentTime.plus(Duration.ofDays(1)); LocalDateTime reminderDateTime =
		 * deadline.plus(Duration.ofDays(1));
		 * 
		 * DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 * DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		 * 
		 * String currentDateStr = currentTime.format(dateFormatter); String
		 * currentTimeStr = currentTime.format(timeFormatter); String nextDateStr =
		 * deadline.format(dateFormatter); String nextTimeStr =
		 * deadline.format(timeFormatter); String reminderDateStr =
		 * reminderDateTime.format(dateFormatter); String reminderTimeStr =
		 * reminderDateTime.format(timeFormatter);
		 * 
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromdate').value='"
		 * + currentDateStr + "';"); System.out.println("Submission from date-> " +
		 * currentDateStr);
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtsubfromtime').value='"
		 * + currentTimeStr + "';"); System.out.println("Submission from time-> " +
		 * currentTimeStr);
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtDueDate').value='" +
		 * nextDateStr + "';"); System.out.println("Due Date-> " + nextDateStr);
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtduetime').value='" +
		 * nextTimeStr + "';"); System.out.println("Due time-> " + nextTimeStr);
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtRdate').value='" +
		 * reminderDateStr + "';"); System.out.println("Remainder Date-> " +
		 * reminderDateStr);
		 * 
		 * Thread.sleep(2000); js.executeScript(
		 * "document.getElementById('ctl00_ContentPlaceHolder1_txtRtime').value='" +
		 * reminderTimeStr + "';"); System.out.println("Remainder Time-> " +
		 * reminderTimeStr);
		 */
        
       
		Thread.sleep(2000);
		WebElement marks = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAMarks"));
		// marks.click();
		marks.sendKeys("20");
		System.out.println("Assignment Marks->20");
	
			
		Thread.sleep(4000);	
		WebElement chkbox =driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_cbHead"));
		chkbox.click();
		System.out.println("click Checkbox");

		Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(4000);
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		System.out.println("Click submit");
				
		Alert alert = driver.switchTo().alert();
		
//		String Expected_Msg = "Assignment Modified Successfully";
//		String Actual_Msg = alert.getText();
//		System.out.println("Actual Messege - " + Actual_Msg+ "\n"+ "Expected Messege - " + Expected_Msg);
//		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
		acceptAlert();

		
	}

}
