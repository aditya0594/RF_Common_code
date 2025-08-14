package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_CR_OfferedCoursesTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception { 
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_CR_OfferedCoursesTest() throws Exception {
		
		test = reports.createTest("coordinateRelated_OfferedCoursesTest");

		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Coordinator Related->Offered Courses");
		
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC")); 
		System.out.println("Admin Academic menu selected"); 
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		Thread.sleep(3000);
		
		WebElement subMenu = driver.findElement(By.linkText("Coordinator Related"));
		System.out.println("Coordinator Related submenu selected");
		action.moveToElement(subMenu);
		// build()- used to compile all the actions into a single step
		action.click().build().perform();
		
		//Click on Offered Courses from Sub Menu
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		System.out.println("Offered Courses selected from sub Menu ");
		

//		driver.get("https://rfcautomationuat.mastersofterp.in/ACADEMIC/iitmsiAnDO727QUSoxACk1kr6xKma6kpjZhMasRyjpkuc36fOEKXP1eMIyMVA1BKUNfbH?enc=M1EsHDAeRhaekcwzmtddkmgHCd8i5gCnBpfThLjYHVk=");

		WebElement college = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select cl = new Select(college);
		System.out.println("College & Scheme -> CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		cl.selectByVisibleText("CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");

		Thread.sleep(2000);
		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sn = new Select(session);
		System.out.println("Session -> 2023-2024");
		sn.selectByVisibleText("2023-2024");

		Thread.sleep(2000);
		System.out.println("Semester - III");
		driver.findElement(By.className("multiselect-selected-text")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_updpnl']/div/div/div[6]/span/div/ul/li[4]/a/label")).click();

		Thread.sleep(2000);
		System.out.println("Show Course");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		
//		Thread.sleep(2000);
//		System.out.println("Course List - Check box 1st");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_ctrl0_chkoffered")).click();
//		
//		Thread.sleep(2000);
//		System.out.println("Semester - > III");
//		driver.findElement(By.className("multiselect-selected-text")).click();
//		driver.findElement(By.xpath("//*[@id=\"tblCourseLst\"]/tbody/tr[1]/td[9]/span/div/ul/li[2]/a/label/input")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();

		Thread.sleep(2000);
		WebElement text = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_pnlCourse\"]/div/h5"));
		Assert.assertEquals(text.getText(), "Course List");

		Thread.sleep(2000);
		Screenshot.takesScreenshot(getCurrentDate());
	}

	@AfterMethod
	public void getTestResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else if (result .getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}
	}

	@AfterTest
	public void publishResult() {
		reports.flush();
	}

}
