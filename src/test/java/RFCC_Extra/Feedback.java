package RFCC_Extra;
//Feedback Type master

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Feedback extends BaseClass {

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
	public void FeedBack() throws Exception {

		RF_AdminLoginPage.loginPage();

		WebElement automatic = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a")); // academic
		System.out.println("Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(automatic).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/form/div[3]/header/nav/div[1]/div/div/div[1]/ul/li[2]/ul/li[15]/a"))
				.click();
		Thread.sleep(2000);
		System.out.println("Feedback submenu has been selected");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFeedbackName")).sendKeys("Feedback Level II");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlfeedbackmode-container")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Normal/Induction", Keys.ENTER);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoTheory")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoStudent")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();

	}

}
