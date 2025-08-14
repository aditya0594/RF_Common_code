package ManualIssue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class BundleAllotment extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser() throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
	}

	@Test
	public void Bundle_Allotment() throws InterruptedException {

		test = reports.createTest("BundleAllotment");
		RF_AdminLoginPage.loginPage();

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(
				"https://rfcautomationuat.mastersofterp.in/ACADEMIC/EXAMINATION/iitmsCPBlbdjne9iaK/fZ4cJwEKRgmVkyJN1OJXy5nq3IuMYNBnDmiiB+GzQcQT0ZjnGsISfSPnPkbBih99MBNdbeHA==?enc=J/hOimnKXjYzzJYY1c51Qpv95B1AeR55Klgfz6RMnlM=");

		WebElement Session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select Sess = new Select(Session);
		Sess.selectByVisibleText("May 2022");
		Thread.sleep(2000);

		WebElement CourseCode = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCourse"));
		Select CC = new Select(CourseCode);
		CC.selectByVisibleText("History of Built Environment - II");
		Thread.sleep(2000);
		// ctl00_ContentPlaceHolder1_ddlBundle
		WebElement Bundle = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBundle"));
		Select Bun = new Select(Bundle);
		Bun.selectByVisibleText("4");
		Thread.sleep(2000);

		WebElement FacultyName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlValuer"));
		Select fac = new Select(FacultyName);
		fac.selectByVisibleText("A R ABDUR RAHMAN RABBANI");
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click(); 
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDate-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();
		Thread.sleep(2000);

		driver.quit();
	}

}
