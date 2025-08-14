package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class Demandcreation extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting : " + m.getName() + "\n");
	}

	@Test
	public void DemandCreation() throws Exception {

		RF_AdminLoginPage.loginPage();

		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		WebElement subMenu = driver.findElement(By.partialLinkText("Fee Related"));
		System.out.println("Fee Related submenu selected");
		action.moveToElement(subMenu); 
		action.click().build().perform();

		Thread.sleep(2000);
		System.out.println("click Demand Creation");
		driver.findElement(By.id("ctl00_repLinks_ctl12_lbLink")).click();
		Thread.sleep(2000);
		
		WebElement Session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select Sessi = new Select(Session);
		Sessi.selectByVisibleText("Mar 2023");
		Thread.sleep(2000);
		
		WebElement clg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSchool"));
		Select clgdd = new Select(clg);
		clgdd.selectByVisibleText("School of Infrastructure");
		Thread.sleep(2000);
		
		System.out.println("Select -> Admission Fee");
		WebElement ReceiptType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Thread.sleep(1000);
		Select Receipt = new Select(ReceiptType);
		Receipt.selectByVisibleText("Admission Fee");
		Thread.sleep(2000);
		
		WebElement Degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Thread.sleep(1000);
		Select Deg = new Select(Degree);
		Deg.selectByVisibleText("Bachelor of Technology");
		Thread.sleep(2000);
		
		WebElement ProgrammeBranch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Thread.sleep(1000);
		Select Progr = new Select(ProgrammeBranch);
		Progr.selectByVisibleText("Civil Engineering");

		Thread.sleep(1000);
		WebElement StudentsSemester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSelectSemester"));
		Thread.sleep(1000);
		Select Semester = new Select(StudentsSemester);
		Semester.selectByVisibleText("I");
		Thread.sleep(2000);
		
		WebElement DemandSemester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlForSemester"));
		Thread.sleep(1000);
		Select Demand = new Select(DemandSemester);
		Demand.selectByVisibleText("I");
		Thread.sleep(2000);
		
		WebElement PaymentType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPaymentType"));
		Thread.sleep(1000);
		Select Payment = new Select(PaymentType);
		Payment.selectByVisibleText("General");
		Thread.sleep(2000);
		
		System.out.println("click Show students under selected criteria");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowStudents")).click();
		Thread.sleep(3000);
		
		Screenshot.takesScreenshot(getCurrentDateAndTime());

		// Thread.sleep(1000);
		// driver.navigate().back();
		// driver.get("https://rfcautomationuat.mastersofterp.in/Academic/iitmsR0pIcTqVJvW1cNhr5mmi/JYd02JBggMNyaHmzO6mJX7h6asC81NFYSzyNYSC6yUK?enc=J/hOimnKXjYzzJYY1c51Qh7pfuNF/0C9ccXlfpjWw0s=");

//		Thread.sleep(2000);
//		System.out.println("click Show Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport")).click();

////		  //Call take screenshot function
////		    this.takeSnapShot(driver, "c://test.png") ;
////		    //Convert web driver object to TakeScreenshot
////		    TakesScreenshot scrShot =((TakesScreenshot)driver);
////		    //Call getScreenshotAs method to create image file
////		    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
////		    //Move image file to new destination
////		    File DestFile=new File(".\\target\\screenshots");
////		    //Copy file at destination
////		    FileUtils.copyFile(SrcFile, DestFile);
//	
////		    Thread.sleep(2000);
////		    System.out.println( "click on cancel");
////		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCancel")).click();

	}

}
