package RFCC_Extra;

import java.io.File;
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
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AdminAdministration_ServiceMangService extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n");
	}

	@Test
	public void Administration_ServiceManagement_ServiceRegistration() throws Exception {
		test = reports.createTest("Administration_ServiceManagement");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		
		System.out.println("Admin Logged in Successfully");
		

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		WebElement adminTrans = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[10]/a"));
//		System.out.println("Administration menu selected");
//		Actions action = new Actions(driver);
//		action.moveToElement(adminTrans).perform();

//		Thread.sleep(2000);
//		// Locating the element from Sub Menu
//		WebElement Admin_ServiceRequestSubMenu = driver
//				.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:122\"]/li[10]/a"));
//		System.out.println("Administration Service Request Management submenu selected");
//		action.moveToElement(Admin_ServiceRequestSubMenu).perform();
//		Thread.sleep(2000);
//
//		WebElement ServiceRequest_TransSubMenu = driver
//				.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:158\"]/li[2]/a"));
//		System.out.println("Service Request Management Transaction submenu selected");
//		action.moveToElement(ServiceRequest_TransSubMenu);
//		action.click().build().perform();

//		System.out.println("Administration -> Service Request Management -> TRANSACTION -> Service Registration");
//		driver.get(
//				"https://rfcautomationuat.mastersofterp.in/Complaints/TRANSACTION/iitmsLkiJClZO9zAHUm2GD0I3ItpyxHre1IPOGmRjKO042ic=?enc=J/hOimnKXjYzzJYY1c51QoU4FXzBlFu73fUSKZCxfYs=");

		Thread.sleep(2000);
		//Click on administration menu
		WebElement ele = driver.findElement(By.linkText("ADMINISTRATION"));
		System.out.println("Click on Administration");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		
		Thread.sleep(2000);
		//Click on Service Request Management
		WebElement ele1 = driver.findElement(By.linkText("Service Request Management"));
		System.out.println("Click on Service Request Management");;
		action.moveToElement(ele1).perform();
		
		Thread.sleep(2000);
		//Click on Transaction
		WebElement link_trans = driver.findElement(By.linkText("Transaction"));
		link_trans.click();
		System.out.println("Click on Transaction");
	    
		Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //Enter From Date
	    js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtComplaintDate")), "22/12/2023");
	    System.out.println("Selected Date is:22/12/2023");		

		Thread.sleep(2000);
		//select service Department
		System.out.println("Select service Department");
		WebElement service_depart = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRMDept"));
		Select service_departmnt = new Select(service_depart);
		service_departmnt.selectByVisibleText("Crescent School of Pharmacy");
		System.out.println("Crescent school of Pharmacy is selected");
		
		Thread.sleep(3000);
		//select serive request type
		System.out.println("Select service Request Type");
		WebElement service_ReqType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCompNature"));
		Select ser_RequestType = new Select(service_ReqType);
		ser_RequestType.selectByValue("2");
		System.out.println("test is selected");

		Thread.sleep(2000);
		//Request Request Details
		System.out.println("Enter Service Request Details");
		WebElement txt_details = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDetails"));
		txt_details.sendKeys("Shortage of Medicine");
		System.out.println("Service request details are:Shortage of Medicine");

		Thread.sleep(2000);
		//Select Location
		System.out.println("Select Location");
		WebElement Location = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlArea"));
		Select typ_loc = new Select(Location);
		typ_loc.selectByVisibleText("Admin block");
		System.out.println("Admin block is selected");
		
		Thread.sleep(3000);
		//Select Location 
		System.out.println("Select Location/site of service");
		WebElement txt_location = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLocation"));
		txt_location.sendKeys("Rest Room");
		System.out.println("Rest Room is Entered");

		Thread.sleep(2000);
		//Enter Comntact No.
		System.out.println("Enter Contact no");
		WebElement txt_no = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactNo"));
		txt_no.sendKeys("7596123658");
		System.out.println("Contact no. is: 7596123658");

		Thread.sleep(2000);
		// upload file
		System.out.println("Click on Attach File -> File size should not exceed 100 Kb.");
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\SampleJPGImage_50kbmb.jpg");
		WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_FileUpload1"));
		fileInput.sendKeys(uploadFile1.getAbsolutePath());
		
		Thread.sleep(2000);
		System.out.println("Click on Add Button");
		WebElement btn_add = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd"));
		btn_add.click();
		System.out.println("File selected");

		Thread.sleep(2000);
		System.out.println("scroll down");
		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);
		System.out.println("Click on Submit button");
		Element.click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "Service Requested Successfully.";
		
		 if (Exp_Msg.equals(Act_Msg)) {
             System.out.println("Assertion passed" + alert.getText());
             alert.accept();
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");
             // Handle the alert (if any)
             try {
                 System.out.println("Alert found: " + alert.getText());
                 //Thread.sleep(2000);
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }
		Thread.sleep(4000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());
	}
}
