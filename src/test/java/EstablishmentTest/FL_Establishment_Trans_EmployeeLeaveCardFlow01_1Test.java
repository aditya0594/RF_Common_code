package EstablishmentTest;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.FL_Establishment_Trans_EmployeeLeaveCardFlow01_1;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;
public class FL_Establishment_Trans_EmployeeLeaveCardFlow01_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	FL_Establishment_Trans_EmployeeLeaveCardFlow01_1 EmployeeLeaveCard;
	HomePageAdmin HP;

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
	public void fL_Establishment_Trans_EmployeeLeaveCardFlow01_1Test() throws Exception {

		EmployeeLeaveCard = new FL_Establishment_Trans_EmployeeLeaveCardFlow01_1(driver);
		HP = new HomePageAdmin(driver);
		
		test = reports.createTest("fL_Establishment_Trans_EmployeeLeaveCardFlow01_1Test"); 

	
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		Thread.sleep(4000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(5000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

		//Thread.sleep(1000);
		try {
			// check if the skip button is present
			WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
			if (skipButton != null && skipButton.isDisplayed()) {
				skipButton.click();
				System.out.println("Click on Skip Notice / News");
			} else {
				System.out.println("Skip Button is not Prescent");
			}

			// check weather the Notice Modal is present or not
			Thread.sleep(1000);
			WebElement closeButton = driver
					.findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed()) {
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			} else {
				System.out.println("Notice Modal close button is not prescent"); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("Element not found : " e.getMessage());
			System.out.println("Something went wrong");
		}
		
		
		System.out.println("ESTBALISHMENT > Transactions  > Employee Leave card >  ");

		Thread.sleep(2000);
		HP.ESTABLISHMENT();
		Thread.sleep(2000);

		Thread.sleep(4000);
		EmployeeLeaveCard.Transaction();

		Thread.sleep(2000);
		EmployeeLeaveCard.LeaveAlloment();

		Thread.sleep(2000);
		EmployeeLeaveCard.ApplyLeave();

		Thread.sleep(2000);
		EmployeeLeaveCard.LeaveType(); 
		
		Thread.sleep(2000);
		EmployeeLeaveCard.FromDate();
		
		Thread.sleep(2000);
		EmployeeLeaveCard.Todate();
		
		Thread.sleep(4000);
		EmployeeLeaveCard.Reason();

		Thread.sleep(2000);
		EmployeeLeaveCard.AlternateArran();
		
		Thread.sleep(2000);
		EmployeeLeaveCard.SubmitButton();
		
		//Record Saved Successfully
		
//		String alertMessage = driver.switchTo().alert().getText();
//		System.out.println(alertMessage);
//		Thread.sleep(5000);
//		acceptAlert();
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String actualConfiramationTxt = alert.getText();
		String expectedConfiramationTxt = "Record Saved Successfully";
		System.out.println("Actual Confirmation Text - " + actualConfiramationTxt + "\n"+ "Expected Confiramtion Text - " + expectedConfiramationTxt);
		Assert.assertEquals(actualConfiramationTxt, expectedConfiramationTxt);
		Thread.sleep(1000);
		alert.accept();
		
		//Screenshot.takesScreenshot(getCurrentTime());
		
		//Cancellation alert  handle
		//Student Course Registration Cancelled Successfully
	}
		
}
