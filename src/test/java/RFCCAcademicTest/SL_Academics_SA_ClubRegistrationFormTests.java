package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.HomePageAdmin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import RFCCAcademic.SL_Academics_SA_ClubRegistrationForm;
import pojo.Browser;
//import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;


public class SL_Academics_SA_ClubRegistrationFormTests extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	SL_Academics_SA_ClubRegistrationForm ClubRegistrationForm;
	HomePageAdmin HP;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void sL_Academics_SA_ClubRegistrationFormTests() throws Throwable {
		
		test = reports.createTest("sL_Academics_SA_ClubRegistrationFormTests"); 
		
		ClubRegistrationForm = new SL_Academics_SA_ClubRegistrationForm(driver);
		//RF_AdminLoginPage.loginPage(); 
		HP = new HomePageAdmin(driver);
		
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 211351601006");
		driver.findElement(By.id("txt_username")).sendKeys("211351601006"); 

		Thread.sleep(1000);
		System.out.println("Enter Password -> admin@123");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");

		///// captchaHandle();
		Thread.sleep(2000);
		System.out.println("Enter Master Captcha -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(2000);
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
		
		System.out.println("Academic -> Student Achievement -> Club Registration Form"); 
		
		Thread.sleep(2000);
		HP.Academic();
		
		Thread.sleep(2000);
		ClubRegistrationForm.ClickStudentAchievementTest();
		
		Thread.sleep(2000);
		ClubRegistrationForm.ClickClubRegistrationFormTest();
		
		Thread.sleep(2000);
		ClubRegistrationForm.SelectClubTest();
		
		Thread.sleep(2000);
		ClubRegistrationForm.ClickSubmitButtonTest();
	
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
		String Expected_Msg = "Record Saved Successfully!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept();
		
}
}
