package extraFiles;

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

public class Examination_Registration_report extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception
	{
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void Exam_registration_report() throws Exception {

		RF_AdminLoginPage.loginPage();
		
		Thread.sleep(2000);;
		WebElement ele = driver.findElement(By.xpath("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:59\"]/li[10]/a"));
		System.out.println("Examination Report submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		Thread.sleep(2000);

		System.out.println("click on Exam Registration Report");
		WebElement exm_reg = driver.findElement(By.id("ctl00_repLinks_ctl00_lbLink"));
		exm_reg.click();
		Thread.sleep(1000);

		System.out.println("Select School/Institute Name");
		Select school = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege")));
		school.selectByVisibleText("Crescent School of Architecture");
		WebElement school_opt = school.getFirstSelectedOption();
		String school_opt_name = school_opt.getText();
		System.out.println(school_opt_name);
		Thread.sleep(2000);

		System.out.println("Select Session");
		Select session = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		session.selectByVisibleText("May 2022");
		WebElement sessn_opt = session.getFirstSelectedOption();
		String sessn_opt_name = sessn_opt.getText();
		System.out.println(sessn_opt_name);
		Thread.sleep(2000);

		System.out.println("Select Degree");
		Select degree = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree")));
		degree.selectByVisibleText("Bachelor of Architecture");
		WebElement degree_opt = degree.getFirstSelectedOption();
		String degree_opt_name = degree_opt.getText();
		System.out.println(degree_opt_name);
		Thread.sleep(2000);

		System.out.println("Select Programme/Branch");
		Select program = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch")));
		program.selectByVisibleText("Architecture");
		WebElement program_opt = program.getFirstSelectedOption();
		String program_opt_name = program_opt.getText();
		System.out.println(program_opt_name);
		Thread.sleep(2000);

		System.out.println("Click on Show button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnShow")).click();
		Thread.sleep(3000);

		System.out.println("Select students from displayed student list");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_chkAll")).click();
		Thread.sleep(2000);

		System.out.println("Click on Excel Report button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExcel")).click();

	}

}
