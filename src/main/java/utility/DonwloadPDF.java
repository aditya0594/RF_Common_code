package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class DonwloadPDF{
	public WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	DonwloadPDF test1;
	// TODO Auto-generated constructor stub
	
	public DonwloadPDF(WebDriver driver) 
	{
		this.driver= driver;
	//	PageFactory.initElements(rdriver, this);

	}
	
	
	public void ExamAdmitCardGeneration() throws InterruptedException {
	//	DonwloadPDF test1 = new DonwloadPDF(driver);
		System.out.println("Exam Admit Card Generation"); 
		 test = reports.createTest("AdminExamination_MarkEntry");//waha problem aa raha  okk wo mnday ko dekhteok thank you
		 
		Thread.sleep(2000);

		// Login to website
		Thread.sleep(1000);
		System.out.println("Enter UserName -> admin");
		driver.findElement(By.id("txt_username")).sendKeys("admin");

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// production captchaHandle();
		Thread.sleep(4000);
		System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");
		
		Thread.sleep(2000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(1000);
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
		Thread.sleep(2000);

		// Move to Examination
		WebElement exam = driver.findElement(By.partialLinkText("EXAMINATION")); 
		Actions action = new Actions(driver); 
		action.moveToElement(exam).perform();
		System.out.println("Hover on Examination in Navigation Bar"); 
		Thread.sleep(2000);

		// Click on Examination Reports Option
		driver.findElement(By.partialLinkText("Pre Examination Activities")).click();
		System.out.println("Click on Pre Examination Activities option");
		Thread.sleep(2000);

		// Click on Grade Card/Tabulation Reports in sub Menu
		WebElement sub_option = driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sub_option);
		System.out.println("Click on Exam Admit Card Generation from sub menu");
		Thread.sleep(2000);

		// Select College & Institute
		Select clg = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlColg")));
		clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("Select College & Scheme Name");
		Thread.sleep(2000);

		// Select Session
		Select sesn = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		sesn.selectByVisibleText("May 2022");
		System.out.println("Select Session");
		Thread.sleep(2000);

		// Select Semester
		Select sem = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester")));
		sem.selectByVisibleText("VIII");
		System.out.println("Select Semester");
		Thread.sleep(2000);

		// Enter Convocation Date
		driver.findElement(By.id("imgExamDate1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceExamDate_today")).click(); 
		System.out.println("Enter Convocation date");
		Thread.sleep(2000);

		// Select Exam Name
		Select exmname = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExamname")));
		exmname.selectByVisibleText("CAT-1");
		System.out.println("Select Exam name"); 
		Thread.sleep(2000);

		// Click on Show Students Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("Click on Show Students Button");
		Thread.sleep(2000); 

		// Select Student
		WebElement SelectStd = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport"));
		js.executeScript("arguments[0].click();", SelectStd);
		System.out.println("Select Student");
		Thread.sleep(2000);

		// Click on Admit Card Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintReport")).click();
		System.out.println("Click on Admit Card Button");
		Thread.sleep(2000);
	}
	
public void clickBeforePDF() throws InterruptedException
{
	Thread.sleep (7000);
	Set<String>id=driver.getWindowHandles();
	Iterator<String> ids=id.iterator();
	String Parent=ids.next();
	String Child=ids.next();
	driver.switchTo().window(Child);
	Thread.sleep(7000);
	System.out.println("Files download successfully"); 
	Thread.sleep(1000); 
	driver.close() ;
	driver.switchTo().window(Parent);
	Thread.sleep (1000);

}}
