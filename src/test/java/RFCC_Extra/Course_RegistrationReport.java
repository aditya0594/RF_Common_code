package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import utility.Screenshot;

public class Course_RegistrationReport extends BaseClass {

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
	public void course_Registration_Reports() throws Exception {
		test = reports.createTest("Course_Reg_Report");
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);

		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		System.out.println("Admin Academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		Thread.sleep(3000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Academic Reports"));
		System.out.println("Admin Academic Reports submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(Wait);
		System.out.println("Course Registration Report");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click(); //ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");
		
		Thread.sleep(2000);
		System.out.println("Select Session : Dec - 2023");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Dec - 2023", Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Semester : Crescent School of Law");
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_dvCollege\"]/span[1]/div/button/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_dvCollege\"]/span[1]/div/ul/li[3]/a/label/input")).click();
		
		Thread.sleep(2000);
		System.out.println("Select Course : All Courses");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlReportType-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("All Courses", Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Click on Excel Report Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExcel")).click();
		
		Thread.sleep(4000);
		Screenshot.takesScreenshot(getCurrentDateAndTime());
		
//		Thread.sleep(2000);
//		String parent= driver.getWindowHandle();
//		Set<String>s=driver.getWindowHandles();
//		Iterator<String> I1= s.iterator();
//		while(I1.hasNext())
//		{
//
//		String child_window=I1.next();
//		if(!parent.equals(child_window))
//		{
//		driver.switchTo().window(child_window);
//
//		System.out.println(driver.switchTo().window(child_window).getTitle());
//		Thread.sleep(4000);
//		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
//        Thread.sleep(3000);
//		driver.close();
//		}
//		}
//		//switch to the parent window
//		driver.switchTo().window(parent);
	}
}
