package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AdminElearning_Transaction extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}

	@Test
	public void ELearning_Transaction() throws Exception {
		test = reports.createTest("ELearning_Transaction");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[6]/a"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:88\"]/li[1]/a"));
		System.out.println("Transaction submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		System.out.println("select sesssion");
		WebElement sessn = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_pnlCourse\"]/div/div/div/span/span[1]/span"));
		sessn.click();

		// Note: Unable to proceed further no data is present in dropdowns
		// Select sessn_typ = new Select(sessn);
		// sessn_typ.selectByVisibleText("No results found");

		System.out.println("Click on Create Assignment");
		WebElement createAssgn = driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink"));
		createAssgn.click();
		// same session field to most of the pages of sidenav menu so unable to proceed
		// further
		WebElement sessn1 = driver.findElement(
				By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_pnlCourse\"]/div/div/div/span/span[1]/span"));
		sessn1.click();
	}

}
