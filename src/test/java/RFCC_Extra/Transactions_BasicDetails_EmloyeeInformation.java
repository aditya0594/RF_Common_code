package RFCC_Extra;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Transactions_BasicDetails_EmloyeeInformation extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
	
  @Test
  public void EmloyeeInformation() throws InterruptedException, AWTException, IOException 
  {
	    test = reports.createTest("EmloyeeInformation");
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    
		Thread.sleep(2000);

		//Login to website
		RF_AdminLoginPage.loginPage(); 
		
		Thread.sleep(2000);
		//Move Main Payroll Menu 
		WebElement exam = driver.findElement(By.linkText("PAYROLL"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(exam).perform();
		System.out.println("Hover on Payroll in Navigation Bar");
		
		Thread.sleep(2000);
		//Move on Transactions 
		WebElement transaction = driver.findElement(By.linkText("Transactions"));		
		action1.moveToElement(transaction).perform();
		System.out.println("Hover on Transactions in drop down");
		
		Thread.sleep(3000);
		//Click on Basic Details
		WebElement basicdetails = driver.findElement(By.linkText("Basic Details"));
		click(basicdetails);
		System.out.println("Click on Basic Details option");
		
		
		/*
		 * //Click on Employee Information in sub Menu WebElement sub_option =
		 * driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink")); JavascriptExecutor
		 * js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();",sub_option);
		 * System.out.println("Click on Employee Information from sub menu");
		 * Thread.sleep(2000);
		 */
		
//-------------------Personal Details------------------------
		Thread.sleep(2000);
		//Click on Personal Details
	//	WebElement Pdetails = driver.findElement(By.xpath("//h5[normalize-space()='Personal Details']"));
	//	click(Pdetails);
	//	System.out.println("Click on Personal Details");
		
	//	Thread.sleep(2000);
		//Select Title
	
		
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTitle"));   
		js.executeScript("arguments[0].scrollIntoView();", title);
		Select typ_title = new Select(title);
		typ_title.selectByVisibleText("Miss"); 
		System.out.println("Select Title");
		
		Thread.sleep(2000);
		//Enter First Name
		WebElement firstname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName"));
		sendKeys(firstname,"Niharika");
		System.out.println("Enter First Name");
		
		Thread.sleep(2000);
		//Select Gender
		WebElement gender = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdbFemale"));
		click(gender);
		System.out.println("Select Gender");
		
		Thread.sleep(2000);
		//Enter Mobile Number
		WebElement mobile = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNumber"));
		sendKeys(mobile,"9511863898");
		System.out.println("Enter Mobile Number");
		
		
	
//-------------------Service Type Details-------------------------
		Thread.sleep(2000);
		//Click on Service Type Details
		WebElement Sdetails = driver.findElement(By.xpath("//h5[normalize-space()='Service Type Details']"));
		js.executeScript("arguments[0].scrollIntoView();", Sdetails);
		click(Sdetails);
		System.out.println("Click on Service Type Details");
		
		Thread.sleep(2000);
		//Select College
		WebElement clg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select college = new Select(clg);
		college.selectByVisibleText("Crescent School of Architecture");
		System.out.println("Select College ->Crescent School of Architecture");
		
		/*
		 * Thread.sleep(2000); //Click on Personal Details WebElement Sdetails2 =
		 * driver.findElement(By.
		 * cssSelector("#ctl00_ContentPlaceHolder1_divServiceDetails > div.col-12.colapse-heading > div > div"
		 * )); click(Sdetails2); System.out.println("Click on Service Type Details");
		 *  
		 */
		
		Thread.sleep(2000);
		//Click on Service Type Details
		WebElement Sdetailss = driver.findElement(By.xpath("//h5[normalize-space()='Service Type Details']"));
		js.executeScript("arguments[0].scrollIntoView();", Sdetailss);
		click(Sdetailss);
		System.out.println("Click on Service Type Details");
		
		Thread.sleep(3000);	
	     driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStaff-container")).click();
			Thread.sleep(1000);	

		driver.findElement(By.className("select2-search__field")).sendKeys("Non-Teaching");
		 Robot robot2 = new Robot();
		 robot2.keyPress(KeyEvent.VK_ENTER);
		 	
		
		//Select topic_typ = new Select(topic);
		//topic_typ.selectByVisibleText("Non-Teaching");
	    
	   	Thread.sleep(2000);	
		//Select Job Status
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAppointment-container")).click();
		//Select job_status = new Select(status);
		//job_status.selectByVisibleText("Probation");
		
		Thread.sleep(1000);	

		driver.findElement(By.className("select2-search__field")).sendKeys("Probation");
		// Robot robot2 = new Robot();
		 robot2.keyPress(KeyEvent.VK_ENTER);
		 System.out.println("Job Status ->Probation ");
		 
			/*
			 * driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("Probation"
			 * ); System.out.println("Job Status ->Probation ");
			 */
		
//-------------------Service Date Details-------------------------		
		Thread.sleep(2000);
		//Click on Service Date Details
		WebElement SDdetail = driver.findElement(By.xpath("//h5[normalize-space()='Service Date Details']"));
		click(SDdetail);
		System.out.println("Click on Service Date Details");
		
		Thread.sleep(2000);
		//Click on Joinning date Details
		
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtJoinDate")), "05/10/2024");
		System.out.println("Select date ->05/10/2024 ");

//-------------------Employee Other Information-------------------------
		Thread.sleep(2000);
		//Click on Employee Other Information
		Thread.sleep(2000);
		WebElement EmpInfo = driver.findElement(By.xpath("//h5[normalize-space()='Employee Other Information']"));
		click(EmpInfo);
		System.out.println("Click on Employee Other Information");
		
//-------------------Basic Details Details-------------------------
		Thread.sleep(2000);
		//Click Basic Details
		WebElement Bdetail = driver.findElement(By.xpath("//h5[normalize-space()='Basic Details']"));
		click(Bdetail);
		System.out.println("Click on Basic Details");
		
//-------------------Bank Details-------------------------
		Thread.sleep(2000);
		//Click on Bank Details
		WebElement Bankdetail = driver.findElement(By.xpath("//h5[normalize-space()='Bank Details']"));
		click(Bankdetail);
		System.out.println("Click on Bank Details");
		
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); 
		
//-------------------Pay Scale Details-------------------------
		Thread.sleep(2000);
		//Click on Pay Scale Details
		WebElement PScale = driver.findElement(By.xpath("//h5[normalize-space()='Pay-Scale Details']"));
		click(PScale);
		System.out.println("Click on Pay Scale Detail");
		
		Thread.sleep(3000);
		//Click on Present Basic
		/*
		 * WebElement PBasic = driver.findElement(By.xpath(
		 * "/html/body/form/div[6]/div[2]/div/section/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[9]/div[2]/div/div/div[2]/input"
		 * ));
		 * 
		 * //WebElement textbox = driver.findElement("id","textbox_id");
		 * //driver.execute_script("arguments[0].focus();", PBasic);
		 * js.executeScript("arguments[0].scrollIntoView();", PBasic);
		 * 
		 * Thread.sleep(2000); PBasic.clear(); Thread.sleep(1000);
		 * PBasic.sendKeys("1500");
		 */
		
		WebElement pbasic = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBasic"));
		Thread.sleep(3000);
		//pbasic.clear();
		//pbasic.sendKeys("4521");
		
		
		js.executeScript("arguments[0].value='4521';", pbasic);
		
		//driver.findElement(By.xpath("/html/body/form/div[6]/div[2]/div/section/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[9]/div[2]/div/div/div[2]/input")).sendKeys("1000");
		
		//System.out.println("Click on Pay Scale Detail");
		
		Thread.sleep(4000);
		//Click submit Button
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); 
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrint")).click();
		Thread.sleep(3000);
		
		//Thread.sleep(3000);
		switchToNextWindow();
		
		Thread.sleep(2000);
		Screenshot.takesScreenshotReports(getCurrentTime());
		
		Thread.sleep(1000);
		switchToFrameOrDefault();
			
		
  }

}
