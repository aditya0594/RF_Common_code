package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Invigilator_Entry extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeMethod
	public void configuration() throws Exception {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}
	
	@Test
	public void PreExamination_Invigilator_Entry() throws IOException, Exception {

		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Main Examination menu selected");

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Pre Examination Activities"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		System.out.println("Pre Examination Activities submenu selected");

		System.out.println("click on Invigilator Entry");
		WebElement invigila_etry = driver.findElement(By.linkText("Invigilator Entry"));
		Thread.sleep(2000);
		invigila_etry.click();
		Thread.sleep(1000);

		System.out.println("select Invigilator and enter No.of Duties");
		WebElement slct = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl6_cbRow"));
		if (slct.isSelected()) {
			slct.click();
			System.out.println("VENKATESAN MURTHY Invigilator deselected");
		}
		slct.click();
		System.out.println("VENKATESAN MURTHY Invigilator again selected");
		Thread.sleep(1000);
		WebElement no_duties = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl6_txtDuties"));
		no_duties.click();
		Thread.sleep(1000);
		no_duties.clear();
		no_duties.sendKeys("1");

		WebElement slct1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl7_cbRow"));
		if (slct1.isSelected()) {
			slct1.click();
			System.out.println("Miss JAYALAKSHMI G Invigilator deselected");
		}
		slct1.click();
		System.out.println("Miss JAYALAKSHMI G Invigilator again selected");
		Thread.sleep(1000);
		WebElement no_duties1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl7_txtDuties"));
		no_duties1.click();
		Thread.sleep(1000);
		no_duties1.clear();
		no_duties1.sendKeys("2");

		WebElement slct2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl8_cbRow"));
		if (slct2.isSelected()) {
			slct2.click();
			System.out.println("Mrs. S.DIWARI SUDANDIRAN Invigilator deselected");
		}
		slct2.click();
		System.out.println("Mrs. S.DIWARI SUDANDIRAN Invigilator again selected");
		Thread.sleep(1000);
		WebElement no_duties2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvInvigilator_ctrl8_txtDuties"));
		no_duties2.click();
		Thread.sleep(1000);
		no_duties2.clear();
		no_duties2.sendKeys("2");
		Thread.sleep(2000);

		System.out.println("Scroll down");
		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);

		System.out.println("Click on Submit button");
		WebElement btn_submit =driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Invigilator Entry Done ...!!";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		alert.accept();

	}
}
