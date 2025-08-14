package RFCC_Extra;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import pom.RF_StudentLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class SL_Academic_SR_OnlinePaymentTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport(); 
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void sL_Academic_SR_OnlinePaymentTest() throws Exception {
		test = reports.createTest("sL_Academic_SR_OnlinePaymentTest");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();

		System.out.println("Student Logged in Successfully");
//		Thread.sleep(1000);
//		String s = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" + s);
		
		System.out.println("Academic->Student Related->Online Payment");
		

		Thread.sleep(2000);
		//Click main Academic Menu
		WebElement link_acad = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Main Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(link_acad).perform();

		Thread.sleep(3000);
		//Click Student Related Submenu
		WebElement subMenu = driver.findElement(By.linkText("Student Related"));
		System.out.println("Student Related submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(2000);
		//Click Online Payment
		WebElement opt = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		opt.click();
		System.out.println("Online Payment option selected");
		
		Thread.sleep(2000);
		WebElement search_RRN = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch"));
		search_RRN.sendKeys("232AT017");
		System.out.println(" Search -> 232AT017");
		
		Thread.sleep(2000);
		WebElement click_Search = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch"));
		click_Search.click();
		System.out.println("Click on Search ");
		
		Thread.sleep(2000);
		WebElement click_name = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId"));
		click_name.click();
		System.out.println("Click on Name");
		

		Thread.sleep(2000);
		//Select Receipt Type
		WebElement drpdwn = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container"));
		drpdwn.click();
		System.out.println("Receipt Type -> Admission Fee");
		
		Thread.sleep(2000);
		//Select Semester
		WebElement semester = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		System.out.println("Semester -> II");
		semester.sendKeys("II");

		Thread.sleep(2000);
		semester.sendKeys(Keys.ENTER);
		System.out.println("Fourth Semester Selected");
		
		Thread.sleep(2000);
		//Click Payment Button
		WebElement btn_payment = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPayment"));
		btn_payment.click();
		System.out.println("Click on Payment Button"); 
		
		
		Thread.sleep(2000);
		//Click Payment Button
		WebElement payment_mode = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlDualPayment"));
		
	//	WebElement school = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlschool"));
		Select typ_scl = new Select (payment_mode);
		typ_scl.selectByVisibleText("RAZOR PAY");
		System.out.println("RAZOR PAY UI");
		
		Thread.sleep(2000);
		//Click Pay Button
		WebElement btn_pay = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnDualPayment"));
		btn_pay.click();
		System.out.println("Click on Pay Button");
		
		
		Thread.sleep(2000);
		//Click Pay Button
		WebElement btn_pay1 = driver.findElement(By.id("btnPay"));
		btn_pay1.click();
		System.out.println("Click on Pay Button");
		
		
		Thread.sleep(3000);
		//Click Pay Button
		driver.switchTo().frame(0);
		
		WebElement show_QR = driver.findElement(By.xpath("//div[@class='btn svelte-1gbiq6q']"));  
		show_QR.click();
		System.out.println("Click on show QA"); 
		
		Thread.sleep(3000);
		//Click Pay Button
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		//Click Pay Button
		WebElement receipt = driver.findElement(By.id("btnPrint"));
		receipt.click();
		System.out.println("Click on Receipt");
		

		
		Thread.sleep(2000);
		//Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "online Fee Payment Screenshot");
	

	}

}
