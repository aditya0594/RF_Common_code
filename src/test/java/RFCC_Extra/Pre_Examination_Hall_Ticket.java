package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;


public class Pre_Examination_Hall_Ticket extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" +"\n");
	}

	@Test
	public void Pre_Examination_Hall_Ticket_Generation() throws IOException, Exception {

		test = reports.createTest("Pre_Examination");
		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);
		//Click on main examination menu
		WebElement link_examination = driver.findElement(By.linkText("EXAMINATION"));
		Actions action = new Actions(driver);
		action.moveToElement(link_examination).perform();
		System.out.println("Main Examination menu selected");

		Thread.sleep(2000);
		//click on pre examination activities
		WebElement link_PreEA = driver.findElement(By.linkText("Pre Examination Activities"));
		action.moveToElement(link_PreEA);
		action.click().build().perform();
		System.out.println("Pre Examination Activities submenu selected");
		
		Thread.sleep(2000);
		//click on Exam Admit card Generation Page
		WebElement exm_admt = driver.findElement(By.linkText("Exam Admit Card Generation"));
		exm_admt.click();
		System.out.println("click on Exam Admit card Generation");
		
		Thread.sleep(2000);
		//Select School
		WebElement schl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlColg"));
		Select typ_schl = new Select(schl);
		typ_schl.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		System.out.println("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme) selected");
		
		Thread.sleep(2000);
		//Select Session
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022");
		System.out.println("session May 2022 selected");
		
		Thread.sleep(2000);
		//Select Semester
		WebElement sem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select typ_sem= new Select(sem);
		typ_sem.selectByVisibleText("IV");
		System.out.println("Semester IV selected");
		
		Thread.sleep(2000);
		//Select Date of issue
		WebElement date_issue = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateofissue"));
		date_issue.sendKeys("26/02/2024");
		System.out.println("Date of issue: 26/02/2024");
		
		Thread.sleep(2000);
		//Select Exam Name
		WebElement exm = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlExamname"));
		Select exam_name = new Select(exm);
		exam_name.selectByVisibleText("END SEM");
		System.out.println("END SEM Exam selected");
	
		Thread.sleep(2000);
		//Select Exam Name
		WebElement btn_show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		btn_show.click();
		System.out.println("Click on show student button");
		
		Thread.sleep(2000);
		//Select students
		WebElement btn_icard = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_chkIdentityCard"));
		btn_icard.click();
		System.out.println("select students from Displayed student list");
		
		Thread.sleep(1000);
		//Click Admit Card Button
		WebElement btn_Admitcard = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintReport"));
		btn_Admitcard.click();
		System.out.println("Click on Admit Card button");
		
		Thread.sleep(5000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());
	}
}
