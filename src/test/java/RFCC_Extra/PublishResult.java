
package RFCC_Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class PublishResult extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser() throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
	}

	@Test
	public void Publish_Result() throws InterruptedException {

		test = reports.createTest("PublishResult");
		RF_AdminLoginPage.loginPage();

		System.out.println("Examination -> Results -> Publish Result");

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(
				"https://rfcautomationuat.mastersofterp.in/ACADEMIC/EXAMINATION/iitmsz0ZfzYO4LN0CE3ESaWGcfLaVFUbUrckwOi9b6JLdM9Rs0RKSSCWCy7g1IyA4Ye18?enc=M1EsHDAeRhaekcwzmtddkiUBFxdLN+5zq6hSgO2qXdw=https://rfcautomationuat.mastersofterp.in/ACADEMIC/EXAMINATION/iitmsz0ZfzYO4LN0CE3ESaWGcfLaVFUbUrckwOi9b6JLdM9Rs0RKSSCWCy7g1IyA4Ye18?enc=M1EsHDAeRhaekcwzmtddkiUBFxdLN+5zq6hSgO2qXdw=");

		// ----------Select dropdown values
		WebElement College = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select Clg = new Select(College);
		System.out.println("College -> Crescent School of Pharmacy");
		Clg.selectByVisibleText("Crescent School of Pharmacy");
		Thread.sleep(2000);

		WebElement Session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select Sess = new Select(Session);
		System.out.println("Session -> May 2022");
		Sess.selectByVisibleText("May 2022");
		Thread.sleep(2000);

		WebElement Semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select Sem = new Select(Semester);
		System.out.println("Semester -> IV");
		Sem.selectByVisibleText("IV");
		Thread.sleep(2000);

		WebElement StudentType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExamType"));
		Select ST = new Select(StudentType);
		System.out.println("StudentType -> Regular");
		ST.selectByVisibleText("Regular");

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfPublish")).click();

		Thread.sleep(2000);
		System.out.println("Publish Date -> 27/02/2024");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfPublish")).sendKeys("27/02/2024");

		Thread.sleep(2000);
		System.out.println("click on Show Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_cbRows")).click();
		Thread.sleep(2000);

		System.out.println("Click on Publish");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPublish")).click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_cbRows")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnUnpublish")).click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}

}
