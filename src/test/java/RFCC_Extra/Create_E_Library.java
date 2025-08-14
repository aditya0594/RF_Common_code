package RFCC_Extra;

import org.openqa.selenium.By;
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

import java.lang.reflect.Method;

public class Create_E_Library extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public static void Create_ELibrary() throws InterruptedException {

		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		System.out.println("Click on E-Learning");
		driver.get(
				"https://rfcautomationuat.mastersofterp.in/Itle/iitmsUCA0dMgNNys6MY7o0U5DRLe383ghc8kX82iz8/K2jCk=?enc=M1EsHDAeRhaekcwzmtddki+XI9O3WYERCpzrgDbtdGE=");
		System.out.println("Create Forum");

		System.out.println("Transcation - > SELECT COURSE TO WORK IN ITLE SESSION");
		driver.get(
				"https://rfcautomationuat.mastersofterp.in/Itle/iitmsbkUdL94ZF2DU3VND+qc1jSobLWf2Uj11ApuE90XCWeXPh7lOdPUYq8CqT1ZUSAtS?enc=M1EsHDAeRhaekcwzmtddkgSMXGqH2lTtm+b7iayaI9M=");

		Thread.sleep(2000);

		Select ddl = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlSession"))); // ctl00$ContentPlaceHolder1$ddlSession
		ddl.selectByVisibleText("May 2022 - School of Mechanical Sciences");
		// select Subject
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_pnlCourseList")).click();

		// Click Ok
		Thread.sleep(2000);
		System.out.println("Click on OK");
		driver.findElement(By.className("swal2-actions")).click();
		Thread.sleep(2000);

		System.out.println("Click on Create E-Library");
		driver.findElement(By.id("ctl00_repLinks_ctl05_lbLink")).click();
		Thread.sleep(2000);

		System.out.println("Enter Book Title");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBTitle")).sendKeys("Thermodynamics");
		Thread.sleep(2000);

		System.out.println("Enter Book Author");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAuthor")).sendKeys("G k Nayar");
		Thread.sleep(2000);

		System.out.println("Enter Publisher Name");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPublisher")).sendKeys("Somesh Gupta");
		Thread.sleep(2000);

		System.out.println("Click on Submit Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		Thread.sleep(2000);
		
		
		
	}

}
