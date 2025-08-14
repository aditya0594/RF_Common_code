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

public class ClassAdvisorAllotment {
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
  public void Test1() throws Exception {
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
		driver.findElement(By.id("ctl00_repLinks_ctl03_lbLink")).click();
		System.out.println(" Class Advisor Allotment page display ");
  }
  public void Test3() throws Exception {
	  driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollegeNameClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Law - Chennai", Keys.ENTER);
		System.out.println(" Select School and Institute");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAssignDept-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.DOWN , Keys.ENTER);
		System.out.println(" Select Department ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegreeClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("B.A. LL.B. (Hons.)", Keys.ENTER);
		System.out.println(" Select Degree ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranchClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.DOWN , Keys.ENTER);
		System.out.println(" Select Branch ");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemesterClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("III", Keys.ENTER);
		System.out.println(" Select Semester ");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowClass")).click();
		System.out.println(" Click on show button ");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvClassAdv_cbHead")).click();
		System.out.println(" Click on check box ");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDeptNameClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Law" , Keys.ENTER);
		System.out.println(" Select Department of Class Advisor ");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdvisorClass-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys(" PRIYANKA E-2019094 " , Keys.ENTER);
		System.out.println(" Select Class Advisor ");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnClassAdvisor")).click();
		System.out.println(" Click on class advisor button ");
		driver.close();
  }
}
