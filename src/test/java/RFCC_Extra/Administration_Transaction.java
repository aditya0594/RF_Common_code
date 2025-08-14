package RFCC_Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Administration_Transaction extends BaseClass {
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
	public void Student_Adminstratn_Transaction() throws Exception {
		test = reports.createTest("Student_Adminstratn_Transaction");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Student Logged in Successfully");
		Thread.sleep(2000);

//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);

		WebElement adminTrans = driver.findElement(By.linkText("ADMINISTRATION"));
		System.out.println("Administration menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(adminTrans).perform();
		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Admin_TransSubMenu = driver.findElement(By.linkText("Transaction"));
		System.out.println("Administration Transaction submenu selected");
		action.moveToElement(Admin_TransSubMenu);
		action.click().build().perform();
		Thread.sleep(2000);

		System.out.println("Click on please select Route");
		WebElement Route_select = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ddlRoute\"]"));
		Thread.sleep(1000);

		Select Rou_select = new Select(Route_select);
		Thread.sleep(2000);
		Rou_select.selectByValue("2");
		System.out.println("Main office to Mihan Route selected");

//		 List<WebElement> alloptions = Rou_select.getOptions(); 
//		 for(WebElement option:alloptions)
//		 {
//			 if(option.getText().equals("RV"))
//			 {
//				 option.click();
//			 }
//		 }
		Thread.sleep(2000);
		WebElement stop_select1 = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStop-container"));
		System.out.println("Click on Stop Menu");
		stop_select1.click();
		WebElement search_stop = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		search_stop.sendKeys("South Airport", Keys.ENTER);
		System.out.println("South Airport stop selected");
		Thread.sleep(2000);
//		 System.out.println(stop_select1);
//		 Select stop_sel = new Select(stop_select1);
//		 Thread.sleep(2000);
//		 stop_sel.selectByValue("5");
//		 System.out.println("South Airpot Stop selected");
		System.out.println("click on show structure");
		WebElement shw_structure = driver
				.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnShowStrbtnShowStr\"]"));
		shw_structure.click();
	}

}
