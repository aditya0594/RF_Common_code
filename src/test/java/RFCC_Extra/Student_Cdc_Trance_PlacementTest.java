package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.Student_Cdc_Trance_Placement;
import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class Student_Cdc_Trance_PlacementTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	Student_Cdc_Trance_Placement Student_Cdc_Trance_Placement;

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
	public void Student_Cdc_Trance_PlacementTests() throws Exception {
		

		Student_Cdc_Trance_Placement = new Student_Cdc_Trance_Placement(driver);
		
		test = reports.createTest("student_CDC");
		
		
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("200101601015");

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");
		
		///// captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("RFC123");

		Thread.sleep(1000);
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
		
		System.out.println("CDC > Transactions  > TP Category Update   ");
		
		Thread.sleep(5000);
		Student_Cdc_Trance_Placement.CDCclick();

		Thread.sleep(4000);
		Student_Cdc_Trance_Placement.Transaction();
		
		Thread.sleep(4000);
		Student_Cdc_Trance_Placement.StuPlacement();
		
		Thread.sleep(2000);
		Student_Cdc_Trance_Placement.SubmitButton();
		
		Thread.sleep(2000);
		Student_Cdc_Trance_Placement.CareerProfile();
		
		Thread.sleep(2000);
		Student_Cdc_Trance_Placement.confirmation();
		
		Thread.sleep(2000);
		Student_Cdc_Trance_Placement.ConfirmCheckBox();
		
		Thread.sleep(2000);
		Student_Cdc_Trance_Placement.ProceedButton();
		
		
		
		}	
}	
		

