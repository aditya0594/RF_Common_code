package DashboardTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class AL_Dashboard_Analytics_DashboardTest extends BaseClass{
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
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Dashboard_Analytics_DashboardTest() throws Exception {
		test = reports.createTest("Dashboard_Analytics_and_dashboard");
		HP = new HomePageAdmin(driver);
		

		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");
		Thread.sleep(2000);

		System.out.println("Dashboard menu selected");
		Thread.sleep(2000);
		HP.DASHBOARD();
		Thread.sleep(2000);
		// Locating the element from Sub Menu   
		WebElement analyticDashboard_SubMenu = driver.findElement(By.partialLinkText("Analytics and Dashboards"));
		analyticDashboard_SubMenu.click();
		System.out.println("Analyatic and Dashboard submenu selected");
	    Thread.sleep(2000);  

		Thread.sleep(2000);
		System.out.println("Click on Module Dropdown");
		WebElement module = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlWorkspace"));
		Select Module1 = new Select(module);
		Module1.selectByVisibleText("Hostel");
		System.out.println("Module -> Hostel");

		Thread.sleep(2000);
		System.out.println("Click on Dashboard Dropdown");
		WebElement Dashboard = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubWorkspace"));
		Select DashboardSelect = new Select(Dashboard);
		DashboardSelect.selectByVisibleText("Hostel Analysis");
		System.out.println("Dashboard -> Hostel Analysis");

		Thread.sleep(10000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());

	}

}
