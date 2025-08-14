package RFCC_Extra;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class StudentRelated_OnlinePayment extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void onlinePayment() throws Exception {
		test = reports.createTest("Online Payment");
		Thread.sleep(2000);

		System.out.println("Enter UserName ->  232AT017"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("180101601002");
		//191291601067

		System.out.println("Enter Password UAT -> admin@123 || Live -> Samsung@50 ");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");
		// Thread.sleep(2000);

		// captchaHandle();
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		//Thread.sleep(2000);
		System.out.println("Press Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		try
		{
			WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
			if (skipButton != null && skipButton.isDisplayed())
			{
				skipButton.click();
				System.out.println("Click on Skip Notice / News");
			}
			else
			{
				System.out.println("Skip Button is not Prescent");
			}
			
			//check weather the Notice Modal is present or not
			Thread.sleep(1000);
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed())
			{
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			}
			else
			{
				System.out.println("Notice Modal close button is not prescent");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		}

		System.out.println("Student Logged in Successfully");
//		Thread.sleep(1000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		Thread.sleep(2000);
		//Click main Academic Menu
		WebElement link_acad = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_acad).perform();

		Thread.sleep(2000);
		//Click Student Related Submenu
		WebElement subMenu = driver.findElement(By.linkText("Student Related"));
		System.out.println("Student Related submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(2000);
		//Click Online Payment
		WebElement opt = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		opt.click();
		System.out.println("Online Payment option selected");

		Thread.sleep(2000);
		//Select Receipt Type
		WebElement drpdwn = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container"));
		drpdwn.click();
		System.out.println("Receipt Type -> Admission Fee");
		
		Thread.sleep(2000);
		//Select Semester
		WebElement semester = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		System.out.println("Semester -> IV");
		semester.sendKeys("IV");

		Thread.sleep(2000);
		semester.sendKeys(Keys.ENTER);
		System.out.println("Fourth Semester Selected");
		
		Thread.sleep(2000);
		//Click Payment Button
		WebElement btn_payment = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPayment"));
		btn_payment.click();
		System.out.println("Click on Payment Button");
		
		Thread.sleep(2000);
		//Click Pay Button
		WebElement btn_pay = driver.findElement(By.id("btnPay"));
		btn_pay.click();
		System.out.println("Click on Pay Button");
		
		
		
		Thread.sleep(2000);
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\TutionFeePaymentScreenshot.png");
			FileUtils.copyFile(SrcFile, DestFile.getAbsoluteFile());
			System.out.println("Screenshot captured: " + DestFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}

		// ====== shows message===//
//        WebElement message = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblmsg"));
//     System.out.println("Message for selected semester: " + message.getText());

		// driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);

		// =======================Unable to proceed further because it showing following
		// error====================
		{
			/*
			 * Oops ! Sorry, Something went wrong ! Error has been occured during process.
			 * Please contact us and we will solve this issue ASAP.8
			 */}

		// Note: For this student the credentials are username:100 Password:admin@123

	}

}
