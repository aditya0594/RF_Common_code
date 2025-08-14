package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;

public class ELearning_ViewStudTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void eLearning_ViewStudTest() throws Throwable {
		test = reports.createTest("ELearning_ViewStudTest");

		Thread.sleep(2000);
		RF_StudentLoginPage.loginPage();
		System.out.println("Student logged in succeessfully");

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(3000);
		WebElement subMenu = driver.findElement(By.linkText("Transactions"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(subMenu).click().perform();
		System.out.println(" Transactions submenu selected");

		Thread.sleep(2000);
		System.out.println("Select Course");
		WebElement sesn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sesn_typ = new Select(sesn);
		sesn_typ.selectByValue("214");
		System.out.println("select Session ->May 2022 - School of Social Sciences and Humanities  (Sem - VI)");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")).click();
		System.out.println("Select Course");
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		System.out.println("Click OK");

		WebElement menu = driver.findElement(By.linkText("E- LEARNING"));
		System.out.println("Main E-Learning menu selected");
		Actions ac = new Actions(driver);
		ac.moveToElement(menu).perform();

		Thread.sleep(2000);
		WebElement view = driver.findElement(By.linkText("View"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(view).click().perform();
		System.out.println(" View submenu selected");

		Thread.sleep(2000);
		WebElement viewassgn = driver.findElement(By.linkText("View Student Test"));
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(viewassgn).click().perform();
		System.out.println("View Student Test submenu selected");

		Thread.sleep(2000);
		WebElement test_type = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTestType"));
		Select testtype = new Select(test_type);
		testtype.selectByVisibleText("Objective");
		System.out.println("Test Type -> Objective");

		Thread.sleep(2000);
		WebElement test_list = driver.findElement(By.linkText("TestScript")); 
		test_list.click();

		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Record Save Successfully";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

		Thread.sleep(2000);
		System.out.println("entering to next window ");
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(currentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		Thread.sleep(2000);
		System.out.println("Enter the frame");
		WebElement radio_Btn = driver.findElement(By.id("rdBtnQuesList_4"));
		radio_Btn.click();

		if (radio_Btn.isSelected()) {
			System.out.println("Radio button is selected.");
		} else {
			System.out.println("Radio button is not selected.");
		}
		System.out.println("Text radio selected");
		// Optionally switch back to the original window

		WebElement btn_save = driver.findElement(By.id("btnSave"));
		btn_save.click();

		Thread.sleep(2000);
		WebElement btn_finish = driver.findElement(By.id("btnSubmit"));
		btn_finish.click();

		Thread.sleep(2000);
		driver.switchTo().window(currentWindowHandle);
		System.out.println("back to original window");
		
	}
}
