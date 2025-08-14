package RFCC_Extra;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Certificate_TC extends BaseClass {

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
	public void certificate_TC() throws Exception {
		test = reports.createTest("TimeTable_Report");
		RF_AdminLoginPage.loginPage();

		// Thread.sleep(2000);
//		driver.findElement(By.className("introjs-skipbutton")).click();
//		Thread.sleep(2000);

		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Admin Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		Thread.sleep(3000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Academic Reports"));
		System.out.println("Admin Academic Reports submenu selected");
		action.moveToElement(subMenu);
		// build()- used to compile all the actions into a single step
		action.click().build().perform();

		Thread.sleep(Wait);
		System.out.println("Click on Certificate");
		driver.findElement(By.id("ctl00_repLinks_ctl05_lbLink")).click();
		System.out.println("Certificate page display");
		Thread.sleep(4000);

		System.out.println("Select Degree : Bachelor of Architecture");
		Select degree = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree")));
		degree.selectByVisibleText("Bachelor of Architecture");
		Thread.sleep(2000);

		System.out.println("Select Branch/Programme : Architecture");
		Select brnch = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch")));
		brnch.selectByVisibleText("Architecture");
		Thread.sleep(2000);

		System.out.println("Select Certificate Name : Transfer Certificate");
		Select certificate_name = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCert")));
		certificate_name.selectByVisibleText("Transfer Certificate");
		Thread.sleep(2000);

		System.out.println("Select Certificate Type: TC Certificate Full Time");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdotcpartfull_0")).click();
		Thread.sleep(2000);

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("select2-ctl00_ContentPlaceHolder1_ddlCert-container")));

		System.out.println("Select Date of Issue: 20/06/2024");
		driver.findElement(By.xpath("//*[@id=\"imgissuedate\"]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceissuedate_today")).click();
		Thread.sleep(3000);

		System.out.println("Select Semester: X");
		Select semester = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester")));
		semester.selectByVisibleText("X"); //// VIII
		Thread.sleep(2000);

		System.out.println("Scroll down the Page");
//		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport"));
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		// Scrolling down till the bottom of page
//		js1.executeScript("arguments[0].scrollIntoView();", Element);
//		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);

		System.out.println("Click on Show student button");

		WebElement wb = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowData"));
		js.executeScript("arguments[0].click();", wb);
		Thread.sleep(2000);

		System.out.println("Select Student from list");
		WebElement wb1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport"));
		js.executeScript("arguments[0].click();", wb1);
		Thread.sleep(2000);

		System.out.println("Click on confirm Button");
		WebElement wb2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConfirm_BC"));
		js.executeScript("arguments[0].click();", wb2);
		Thread.sleep(2000);

		String s1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert text is : " + s1);

		Thread.sleep(4000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());

//		System.out.println("Click on Print report button");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();
//		Thread.sleep(2000);
//		
//		String parent= driver.getWindowHandle();
//		Set<String>s=driver.getWindowHandles();
//		Iterator<String> I1= s.iterator();
//		while(I1.hasNext())
//		{
//
//		String child_window=I1.next();
//		if(!parent.equals(child_window))
//		{
//		driver.switchTo().window(child_window);
//
//		System.out.println(driver.switchTo().window(child_window).getTitle());
//		Thread.sleep(4000);
//		Screenshot.takesScreenshot(getCurrentDateAndTime());
//        Thread.sleep(3000);
//		driver.close();
//		}
//		}
//		//switch to the parent window
//		driver.switchTo().window(parent);

	}

}
