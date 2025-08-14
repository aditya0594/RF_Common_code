package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

public class ELearning_TestCreation extends BaseClass {

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
	public void eLearning_TestCreation() throws Throwable {
		test = reports.createTest("ELearning_TestCreation");

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		//Select Course page 
		Thread.sleep(2000);
		WebElement link_Elearn = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_Elearn).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement link_transac = driver.findElement(By.linkText("Transactions"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(link_transac).click().perform();
		System.out.println(" Transactions submenu selected");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		//Click on Select Course
		WebElement link_SC = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		js.executeScript("arguments[0].scrollIntoView(true);", link_SC);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", link_SC);	
		System.out.println("click on select course");
		
		Thread.sleep(2000);
		//Select Session
		WebElement sess = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sess_typ = new Select(sess);
		sess_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		System.out.println("select Session");

		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");
		
		//Create Question Bank page
		
		Thread.sleep(2000);
		//Click Create Question Bnak
		WebElement element = driver.findElement(By.id("ctl00_repLinks_ctl31_lbLink"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", element);		
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
		WebElement topic_name = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNewTopic"));
		topic_name.sendKeys("Selenium");
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
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		js.executeScript("arguments[0].scrollIntoView(true);", btn_submit);
		Thread.sleep(1000);
		btn_submit.click();
		
		System.out.println("Click OK");
			
		Thread.sleep(2000);
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Question Saved Successfully.....";
		String Actual_Msg =alert.getText();

		if (Expected_Msg.equals(Actual_Msg)) 
		{
			System.out.println("Assertion passed");
			System.out.println(Actual_Msg + " " + Expected_Msg);
			Thread.sleep(2000);
			alert.accept();
		} 
		else 
		{
			System.out.println("Assertion failed: Expected '" + Expected_Msg + "' but got '" + Actual_Msg + "'.");// Handle the alert (if any)
			try 
			{
				System.out.println("Alert found: " + alert.getText());
				System.out.println(Actual_Msg + " " + Expected_Msg);
				alert.accept(); 
				System.out.println("Alert accepted.");
			}
			catch (NoAlertPresentException e) 
			{
				System.out.println("No alert present.");
			}
		}
		
		
		//new page Test Creation
		Thread.sleep(2000);
		//Click on Test Creation Page
		WebElement link_TC = driver.findElement(By.linkText("Test Creation"));
		js.executeScript("arguments[0].scrollIntoView(true);", link_TC);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", link_TC);		
		System.out.println("click Test Creation");
		
		Thread.sleep(2000);
		WebElement obj = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnObjectiveTest"));
		obj.click();
		System.out.println("Click on Objective Type Test");
		
		Thread.sleep(2000);
		WebElement test_name =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTestName"));
		test_name.sendKeys("Selenium test");
		System.out.println("Test Name->Selenium Test");
		
		/*Thread.sleep(2000);
		LocalDateTime currentTime = LocalDateTime.now();
	    LocalDateTime testStartTime = currentTime.plus(Duration.ofHours(1));
	    LocalDateTime testEndTime = testStartTime.plus(Duration.ofHours(1));

	    Duration testDuration = Duration.between(testStartTime, testEndTime);
	    
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String currentDateStr = currentTime.format(dateFormatter);
        String testStartTimeStr = testStartTime.format(timeFormatter);
        String testEndTimeStr = testEndTime.format(timeFormatter);
        String testDurationStr = String.format("%02d:%02d:%02d",
                                               testDuration.toHours(),
                                               testDuration.toMinutesPart(),
                                               testDuration.toSecondsPart());
        
       
		Thread.sleep(2000);
		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtStartDt').value='" + currentDateStr + "';");
		System.out.println("Start Date ->" + currentDateStr);

		Thread.sleep(2000);
		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_TxtExamStartTime').value='"+ testStartTimeStr + "';");
		System.out.println("Test Start Time ->" + testStartTimeStr);

		Thread.sleep(2000);
		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtEndDt').value='" + currentDateStr + "';");
		System.out.println("End Date ->" + currentDateStr);

		Thread.sleep(2000);
		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_TxtExamEndTime').value='" + testEndTimeStr + "';");
		System.out.println("Test End time ->" + testEndTimeStr);

		Thread.sleep(2000);
	    js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtTestDuration').value='" + testDurationStr + "';");
        System.out.println("Test Duration ->" + testDurationStr);*/
		
		 LocalDateTime currentTime = LocalDateTime.now();

	        // Calculate test start and end times
	        LocalDateTime testStartTime = currentTime.plus(Duration.ofHours(1));
	        LocalDateTime testEndTime = testStartTime.plus(Duration.ofHours(1));

	        // Format date and time for use in JavaScript
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	        String currentDateStr = currentTime.format(dateFormatter);
	        String testStartTimeStr = testStartTime.format(timeFormatter);
	        String testEndTimeStr = testEndTime.format(timeFormatter);

	        // Calculate duration (assuming it's always 1 hour here)
	        Duration testDuration = Duration.between(testStartTime, testEndTime);
	    /*    String testDurationStr = String.format("%02d:%02d:%02d",
	                                               testDuration.toHours(),
	                                               testDuration.toMinutesPart(),
	                                               testDuration.toSecondsPart());*/

		long hours = testDuration.toHours();
		long minutes = testDuration.toMinutes() % 60;
		long seconds = testDuration.getSeconds() % 60;
		String testDurationStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);

	        // Use JavaScript to set the values in the form
	        // Assuming you need to wait between actions to allow for UI updates
	        Thread.sleep(2000);

	        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtStartDt').value='" + currentDateStr + "';");
	        System.out.println("Start Date -> " + currentDateStr);

	        Thread.sleep(2000);

	        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_TxtExamStartTime').value='" + testStartTimeStr + "';");
	        System.out.println("Test Start Time -> " + testStartTimeStr);

	        Thread.sleep(2000);

	        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtEndDt').value='" + currentDateStr + "';");
	        System.out.println("End Date -> " + currentDateStr);

	        Thread.sleep(2000);

	        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_TxtExamEndTime').value='" + testEndTimeStr + "';");
	        System.out.println("Test End Time -> " + testEndTimeStr);

	        Thread.sleep(2000);

	        js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtTestDuration').value='" + testDurationStr + "';");
	        System.out.println("Test Duration -> " + testDurationStr);
               
				
		Thread.sleep(2000);
		WebElement attempt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAttempts"));
		attempt.sendKeys("0");
		System.out.println("No of Attempts ->0");
		
		Thread.sleep(2000);
		WebElement chk_show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cbShowResult"));
		chk_show.click();
		System.out.println("checked show result after test");
		
		Thread.sleep(2000);
		WebElement ratio = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lsvbindquestion_ctrl0_txtSelectQ"));
		ratio.clear();
		ratio.sendKeys("1");
		System.out.println("Ratio ->1");
		
		Thread.sleep(2000);
		WebElement arrow = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgAddQuestions"));
		arrow.click();
		
		Thread.sleep(2000);
		WebElement btn_submit1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		js.executeScript("arguments[0].click();", element);	
		btn_submit1.click();
		System.out.println("Click submit");
		

	}

}


