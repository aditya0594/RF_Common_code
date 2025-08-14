package extraFiles;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPassword {
private WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://rfcautomationuat.mastersofterp.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}	    
  @Test
  public void Test1() throws Exception {
	  driver.findElement(By.xpath("//*[@id=\"lbtForgePass\"]/span")).click();
	  System.out.println(" Click on forgot password button ");
	  driver.findElement(By.id("rdoUsername")).click();
	  System.out.println("Click on username checkbox ");
	  driver.findElement(By.id("rdoEmail")).click();
	  System.out.println("Click on email address checkbox");
	  driver.findElement(By.id("txtEmail")).sendKeys("pratikshadeshmukh0314@gmail.com");
	  System.out.println("Registered email id enter");
	  driver.findElement(By.xpath("//*[@id=\"benotop2\"]")).click();
	  System.out.println("Click on send OTP button ");
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  @Test
  public void Test2() throws Exception {
	  driver.findElement(By.id("rdoMobile")).click();
	  System.out.println("Click on mobile no checkbox");
	  driver.findElement(By.id("txtMobile")).sendKeys("9404885025");
	  System.out.println("Registered mobile number enter");
	  driver.findElement(By.id("btnSendotp")).click();
	  System.out.println(" Click on send OTP button ");
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
}}
