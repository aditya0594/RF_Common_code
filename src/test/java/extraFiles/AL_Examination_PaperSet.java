package ExaminationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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

public class AL_Examination_PaperSet extends BaseClass {
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
	public void aL_Examination_PaperSet() throws Exception {
		
		test = reports.createTest("AdminExamination_PaperSet");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		
		Thread.sleep(2000);
		//click on Paper Set submenu
		WebElement subMenu = driver.findElement(By.linkText("Paper Set"));
		System.out.println("Examination Paper Set submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(2000);
		//Select College
		System.out.println("select college/scheme");
		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select colg_typ = new Select(colg);
		colg_typ.selectByVisibleText("CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		System.out.println("College is: CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");


		Thread.sleep(2000);
		//Select Session
		System.out.println("select Session");
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sessn_typ = new Select(sessn);
		sessn_typ.selectByVisibleText("2023-2024");
		System.out.println("Session is: 2023-2024");

		Thread.sleep(2000);
		//Select Semester
		System.out.println("select Semester");
		WebElement sem = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select sem_typ = new Select(sem);
		sem_typ.selectByVisibleText("III");
		System.out.println("semester is: III");

		Thread.sleep(2000);
		//Click Show Button
		WebElement btn_show = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		btn_show.click();
		System.out.println("click on show button");
		
		Thread.sleep(1000);
		//Click save button
		WebElement btn_save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		btn_save.click();
		System.out.println("Click on save button");

		Thread.sleep(2000);
		//alert
		Alert alert = driver.switchTo().alert();
		
		String Act_Msg = alert.getText();
		String Exp_Msg = "Available and required quantity saved for 2 courses!";
		
		 if (Exp_Msg.equals(Act_Msg)) {
			 System.out.println("Assertion passed" +alert.getText());
             alert.accept();
         } else {
             System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");
             // Handle the alert (if any)
             try {
                 System.out.println("Alert found: " + alert.getText());
                 //Thread.sleep(2000);
                 alert.accept(); // Accept the alert
                 System.out.println("Alert accepted.");
             } catch (NoAlertPresentException e) {
                 System.out.println("No alert present.");
             }
         }
	}
}
