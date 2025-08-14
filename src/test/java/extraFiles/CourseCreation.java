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

public class CourseCreation {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rfcautomationuat.mastersofterp.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void Test1() throws InterruptedException {
		WebElement user = driver.findElement(By.id("txt_username"));
		user.sendKeys("admin");

		WebElement pass = driver.findElement(By.id("txt_password"));
		pass.sendKeys("test@2023");
		WebElement capcha = driver.findElement(By.id("txtcaptcha"));
		capcha.sendKeys("RFC@123");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		System.out.println("Login Successfull");
	}

	@Test
	public void Test2() throws InterruptedException {
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
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Master of Business Administration",
				Keys.ENTER);
		System.out.println(" Degree - Master of Business Administration select ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDept-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Department of Management Studies",
				Keys.ENTER);
		System.out.println(" Department - Department of Management Studies select  ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Business Administration", Keys.ENTER);
		System.out.println(" Branch - Business Administration select ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlScheme-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(
				"MBA-Business Administration-2018-19-Department of Management Studies (Old Scheme)", Keys.ENTER);
		System.out.println(" Scheme type select ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSem-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("IV", Keys.ENTER);
		System.out.println(" Semester - IV select ");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCCode")).sendKeys("MBA101");
		System.out.println(" Course-code display ");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCourseName")).sendKeys("Account");
		System.out.println(" Course - Name display  ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlTP-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Theory Cum Studio", Keys.ENTER);
		System.out.println(" Course - Type select ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlParentDept-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Department of Management Studies",
				Keys.ENTER);
		System.out.println("Academic Council select ");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTheory")).sendKeys("5");
		System.out.println(" Credits - select ");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		System.out.println("Click on Submit button ");
		driver.close();
	}

}
