package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Examination_Rsult_Proccessing  extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("\n" + "*****Starting :" + m.getName() + "*****" + "\n");
	}
	
	@Test
	public void examination_Rsult_Proccessing() throws Exception {
		test=reports.createTest("AdminExamination_ResultProccessing");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.partialLinkText("Results"));
		System.out.println("Examination Result submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		
		driver.findElement(By.linkText("Result Processing")).click();
		System.out.println("Click on Result Processing");
		
		
		System.out.println("select college & Scheme");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("SLS - BTech-School of Life Sciences-Biotechnology-2021-22 (New Scheme)");
		System.out.println("College is: SLS - BTech-School of Life Sciences-Biotechnology-2021-22 (New Scheme)");
		
		Thread.sleep(2000);
		System.out.println("select Session");
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessn_typ = new Select(sessn);
		sessn_typ.selectByVisibleText("May 2022");
		System.out.println("Session is: May 2022");
		Thread.sleep(3000);
		
		System.out.println("select Semester");
		WebElement sem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select sem_typ = new Select(sem);
		sem_typ.selectByVisibleText("I");
		System.out.println("Semester is:I");
		
		Thread.sleep(3000);
		System.out.println("select Student Type");
		WebElement student = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStudentType"));
		Select student_typ = new Select(student);
		student_typ.selectByVisibleText("Backlog");
		System.out.println("Student Type is: Backlog");
		Thread.sleep(3000);
		
		System.out.println("Click on Show Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		Thread.sleep(5000);
		
		//String s1= driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		//System.out.println("Alert Text is:" +s1);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.alertIsPresent());
		
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_chkheader")).click();
		System.out.println("Check Checkbox");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnProcessResult")).click();
		System.out.println("Click on Proccess Result");
		
		acceptAlert();
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_chkheader")).click();
		System.out.println("Check Checkbox");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLock")).click();
		System.out.println("Click on lock ");
		
		String alrt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alrt);
		
		acceptAlert();
		
		
		
		
	}
}
