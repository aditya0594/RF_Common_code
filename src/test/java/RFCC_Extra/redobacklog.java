package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class redobacklog extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void redo_Course_Registration() throws Exception {

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic -> Student Related -> Redo Course Registration");
//		driver.navigate().to("https://rfcautomationuat.mastersofterp.in/ACADEMIC/iitmslJ3nwdYaWfcYXZWPq7SXo55cup0+qwhmYsiFvKOb+WM002XHOsrZz9jPszVoJD4Q8/xYfyxzGEkER+/fBbeEIw11GuL9f5WPtbSLZlxuexE=?enc=1knKW3XZHwATyOna1+p93w0XhNjI4tcKMbmt51+Arnw=");

		// System.setProperty("webdriver.chrome.driver","C:\\Chromedriver//chromedriver-win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		   driver.get("https://rfcautomationuat.mastersofterp.in/");
//		    driver.findElement(By.id("txt_username")).sendKeys("admin");
//		    driver.findElement(By.id("txt_password")).sendKeys("test@2023");
//		    driver.findElement(By.id("txtcaptcha")).sendKeys("RFC@123");
//		    driver.findElement(By.id("btnLogin")).click();
//		    driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a"));
		System.out.println("Main academic menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Student Related"));
		System.out.println("academic submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();

		Thread.sleep(2000);
		System.out.println("click on Redo Course Registration");
		driver.findElement(By.linkText("Redo Course Registration")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		System.out.println("enter prn no");
		WebElement prn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEnrollno"));
		prn.sendKeys("188021601006");

		Thread.sleep(2000);
		System.out.println("click on show button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch")).click();

//		    Thread.sleep(2000);
//		    System.out.println( "click on select all");
//		    WebElement ch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFailCourse_chkAll"));
//		    ch.clear();
//		    ch.click();
		Thread.sleep(3000);
		WebElement Element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnStudSubmit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);
		System.out.println("click on registeration slip");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintRegSlip")).click();

		Thread.sleep(2000);
		System.out.println("select Degree");
		WebElement Degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Select Degrr = new Select(Degree);
		Degrr.selectByVisibleText("Bachelor of Commerce");
		System.out.println("Bachelor of Commerce selected");

		Thread.sleep(2000);
		System.out.println("select branch");
		WebElement branch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Select branchh = new Select(branch);
		branchh.selectByVisibleText("Accounts and Finance");
		System.out.println("Accounts and Finance selected");

//		    Thread.sleep(2000);
//		    System.out.println("select Branch");
//		    WebElement Branch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch-container"));
//		    Select Bran = new Select(Branch);
//		    Bran.selectByVisibleText("Accounts and Finance");
//		    System.out.println("Accounts and Finance selected");

		Thread.sleep(2000);
		System.out.println("select Semester");
		WebElement Semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select Sem = new Select(Semester);
		Sem.selectByVisibleText("III");
		System.out.println("III");

		Thread.sleep(2000);
		System.out.println("click show student list");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();

		Thread.sleep(2000);
		System.out.println("click approve all");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_tblInfo")).click();

		Thread.sleep(2000);
		System.out.println("click check box");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvApproveCourse_cbApproveAll")).click();

		Thread.sleep(2000);
		System.out.println("click submit");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();

		Thread.sleep(2000);
		System.out.println("click on selct all ");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFailCourse_chkAll")).click();

		Thread.sleep(2000);
		System.out.println("click on registeratio slip");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintRegSlip")).click();

	}

}
