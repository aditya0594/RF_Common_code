package extraFiles;

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

public class BulkCourseRegistration {
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
		System.out.println(" Login Successfull ");
	}
  @Test
  public void Test2() throws Exception {
	  WebElement aca = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[2]/a"));
		System.out.println("Click on Academic module ");
		Actions action = new Actions(driver);
		action.moveToElement(aca).perform();
		WebElement aca_cor = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:25\"]/li[8]/a"));
		System.out.println(" Click on Coordinator Related sub-module ");
		Thread.sleep(1000);
		action.moveToElement(aca_cor);
		action.click().build().perform();
		System.out.println(" Course Creation page display ");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_repLinks_ctl02_lbLink")).click();
		System.out.println(" Bulk Course Registration page display ");
  }
  @Test
  public void Test3() throws Exception {
	  driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClgname-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)", Keys.ENTER);
		System.out.println("Select college and scheme ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("May 2022", Keys.ENTER);
		System.out.println("Select session");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("IV", Keys.ENTER);
		System.out.println("Select semester");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSection-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.DOWN, Keys.ENTER);
		System.out.println("Select section");
		Thread.sleep(1000);
		WebElement report = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		report.click();
		System.out.println("Click on Registration slip report button ");
		Thread.sleep(1000);
		String currentwindowhandle = driver.getWindowHandle();
		driver.switchTo().window(currentwindowhandle);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkPrintRegReport")).click();
		System.out.println("Single student report generate");
		Thread.sleep(3000);
		driver.switchTo().window(currentwindowhandle);
		driver.close();
		}	
  }

