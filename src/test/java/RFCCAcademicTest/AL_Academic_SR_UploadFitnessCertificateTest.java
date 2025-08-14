package RFCCAcademicTest; 

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_SR_UploadFitnessCertificateTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_SR_UploadFitnessCertificateTest() throws Exception {
		
		test = reports.createTest("aL_Academic_SR_UploadFitnessCertificateTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		System.out.println("Academic --> Student Related --> Upload Fitness Certificate --> Fitness Certificate Submission");
		// driver.get("https://rfcautomationuat.mastersofterp.in/ACADEMIC/iitms7RGPCPHFckOBohwYxedeMi1oMgDrKw7MrG2+n8NFztMVbmyCir6nTnj93hS2W6vA2vSfzgvJRGbW2JD4SXEu+w==?pageno=2287");

//		Thread.sleep(5000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);

		Actions action = new Actions(driver);

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Student Related"));
		//WebElement subMenu = driver.findElement(By.partialLinkText("Student Related"));
		System.out.println("Student Related submenu selected");
		action.moveToElement(subMenu);

		// build()- used to compile all the actions into a single step
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement opt = driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink"));
		opt.click();
		System.out.println("Click on Upload Fitness Certificate");
		
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSearch"));
		Select typ_search = new Select(search);
		typ_search.selectByVisibleText("RRN NO.");
		System.out.println("Select RRN NO.");
		
		Thread.sleep(2000);
		WebElement RRNNO = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch"));
		RRNNO.sendKeys("232AT017");
		System.out.println("Search RRN NO.");
		
		Thread.sleep(2000);
		WebElement Search_Button = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Button1"));
		Search_Button.click();
		System.out.println("Click on search button");

		Thread.sleep(2000);
		WebElement studentname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId"));
		studentname.click();
		System.out.println("click on student name");
		
		// to upload File
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\physical-fitness-certificate-model.jpg");
		WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_FileUpload1"));
		fileInput.sendKeys(uploadFile1.getAbsolutePath());
		
	
		System.out.println("Click on Upoad button");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsubmit")).click();
		System.out.println("File selected");

		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "File Uploaded Successfully";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();
		
		Thread.sleep(2000);
		WebElement btn_preview =  driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnpreview"));
		btn_preview.click();
		
		
		Thread.sleep(5000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());

//		try {
//			TakesScreenshot scrShot = ((TakesScreenshot) driver);
//			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile = new File(System.getProperty("user.dir")
//					+ "\\ScreenShot\\UploadFitnessCertificate_FitnessCertificateSubmission.png");
//			FileUtils.copyFile(SrcFile, DestFile.getAbsoluteFile());
//			System.out.println("Screenshot captured: " + DestFile.getAbsolutePath());
//		} catch (Exception e) {
//			System.out.println("Exception while taking screenshot: " + e.getMessage());
//		}

//		driver.switchTo().alert().accept();
		// Unable to upload file due to some error from development side
	}
}
