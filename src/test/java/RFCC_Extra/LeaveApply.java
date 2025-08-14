package RFCC_Extra;

import org.openqa.selenium.By;
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

import java.lang.reflect.Method;

public class LeaveApply extends BaseClass {

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
	public void Leave_Apply() throws InterruptedException {
		// TODO Auto-generated method stub

		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ESTABLISHMENT"));
		System.out.println("Main ESTABLISHMENT menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		System.out.println("Transactions submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		Thread.sleep(2000);
		// WebElement EmployeeLeave =
		// driver.findElement(By.id("ctl00_repLinks_ctl08_lbLink"));
		// EmployeeLeave.click();
		
		WebElement Link_leave = driver.findElement(By.linkText("Employee Leave Card"));
		System.out.println("Employee Leave Card submenu selected");
		action.moveToElement(Link_leave);
		action.click().build().perform();
		
		Thread.sleep(2000);
		WebElement Apply = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvLeaveinfo_ctrl0_btnApply"));
		Apply.click();
		
		Thread.sleep(2000);
		WebElement FromDate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromdt"));
		FromDate.click();
		FromDate.sendKeys("04/02/2024");
		// FromDate.sendKeys("14");
		// FromDate.sendKeys("/");
		// FromDate.sendKeys("02");
		// FromDate.sendKeys("/");
		// FromDate.sendKeys("2024");

		System.out.println("From date selected");
		WebElement ToDate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTodt"));
		ToDate.click();
		
		Thread.sleep(3000);
		ToDate.sendKeys("04/02/2024");
		
		Thread.sleep(4000);
		System.out.println("To date selected");
		WebElement Reason = driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtReason"));
		Reason.sendKeys("Some urgent work");
		
		Thread.sleep(2000);
		System.out.println("Resone entered");
		
		WebElement Address = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtadd"));
		Address.sendKeys("nagpur Mihan");
		
		Thread.sleep(2000);
		System.out.println("Address Entered");
		WebElement Alternate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtcharge"));
		Alternate.sendKeys("Prof.XYZ");
		
		Thread.sleep(2000);
		System.out.println("Alernate Arrangement Entered");
		
		Thread.sleep(2000);
		WebElement Submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		Submit.click();
		System.out.println("Leave Application Submitted");

	}

}
