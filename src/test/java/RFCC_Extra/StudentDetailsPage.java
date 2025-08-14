package RFCC_Extra;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentDetailsPage {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rfcautomationuat.mastersofterp.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void login() throws InterruptedException {
		WebElement user = driver.findElement(By.id("txt_username"));
		user.sendKeys("admin");
		WebElement pass = driver.findElement(By.id("txt_password"));
		pass.sendKeys("test@2023");
		WebElement capcha = driver.findElement(By.id("txtcaptcha"));
		capcha.sendKeys("RFC@123");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		System.out.println(" Login Successfull ");

	}

	@Test
	public void studentdetail() throws Exception {
		/*WebElement aca = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a"));
		System.out.println("Click on academic module ");
		Actions action = new Actions(driver);
		action.moveToElement(aca).perform();
		WebElement stu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:25\"]/li[10]/a"));
		System.out.println(" Click on Student Related sub-module ");
		action.moveToElement(stu);
		action.click().build().perform();
		System.out.println("Online payment page display"); */
		driver.get("https://rfcautomationuat.mastersofterp.in/Academic/iitmsPFkXjz+EbtRodaXHXaPVt3dlW3oTGB+3i1YZ7alodHeRzGm9eTr2C53AU6tMBXuOXVbvNfePRUcHp4rLz3edhg==?enc=3Q2Y1k5BriJsFcxTY7ebQh0hExMANhAKSl1CmxvOF+Y=");
		System.out.println(" Student Complete Detail page display ");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSearch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("BRANCH",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDropdown-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Business Administration",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_Button1")).click();
		System.out.println("Branch wise Student list display");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")).click();
		System.out.println(" click on student name ");
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Fees Details")).click();
		Thread.sleep(2000);
		System.out.println("Student Fees Details display");
		driver.findElement(By.linkText("Course Registered")).click();
		Thread.sleep(2000);
		System.out.println("Student Course Registered display");
		driver.findElement(By.linkText("Attendance Details")).click();
		Thread.sleep(2000);
		System.out.println("Student Attendance Details display");
		driver.findElement(By.linkText("Result Details")).click();
		Thread.sleep(2000);
		System.out.println("Student Information display");
		driver.findElement(By.linkText("Revaluation Result Details")).click();
		Thread.sleep(2000);
		System.out.println("Student Result display");
		driver.findElement(By.xpath("//a[@onclick='return Checktabid(this)']")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
