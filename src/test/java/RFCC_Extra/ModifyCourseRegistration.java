package RFCC_Extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModifyCourseRegistration {
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
	public void Test1() throws InterruptedException {
		WebElement user = driver.findElement(By.id("txt_username"));
		user.sendKeys("admin");
		WebElement pass = driver.findElement(By.id("txt_password"));
		pass.sendKeys("test@2023");
		WebElement capcha = driver.findElement(By.id("txtcaptcha"));
		capcha.sendKeys("RFC@123");
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		System.out.println("Login Successfull");
	}

	@Test
	public void Test2() throws Exception {
		WebElement aca = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a"));
		System.out.println("Click on Academic module ");
		Actions action = new Actions(driver);
		action.moveToElement(aca).perform();
		WebElement aca_cor = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:25\"]/li[8]/a"));
		System.out.println("Click on Coordinator Related sub-module ");
		Thread.sleep(1000);
		action.moveToElement(aca_cor);
		action.click().build().perform();
		System.out.println("Course Creation page display ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl04_lbLink\"]")).click();
		System.out.println("Modify Course Registration page - single student display");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Architecture-May 2022");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Institute and session selected");
		Thread.sleep(1000);

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSearch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("RRN NO.");
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select search criteria by RR no");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch")).sendKeys("210101601001");
		System.out.println("Enter RR no for student");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchCriteria")).click();
		System.out.println("Student name in list display");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId\"]")).click();
		System.out.println("Student Information display");
		Thread.sleep(1000);
	}

	@Test
	public void Test3() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_divCourses\"]/div[3]/div/ul/li[2]/a")).click();
		System.out.println("Modify Course Registration - In Bulk ");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClgname-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(
				"CSB - MBA-Business Administration-2018-19-Department of Management Studies (Old Scheme).", Keys.ENTER);
		System.out.println("Select college and scheme");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBulkSession-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("May 2022", Keys.ENTER);
		System.out.println("Select session");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("2021-22", Keys.ENTER);
		System.out.println("Select batch");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("III", Keys.ENTER);
		System.out.println("Select semester");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSection-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("C", Keys.ENTER);
		System.out.println("Select section");
		Thread.sleep(1000);
		System.out.println("Student List should display");
		driver.close();
	}
}
