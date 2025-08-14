package RFCC_Extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNotice {
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
	  WebElement user = driver.findElement(By.id("txt_username"));
	    user.sendKeys("admin");
	    
	WebElement pass = driver.findElement(By.id("txt_password"));
	    pass.sendKeys("test@2023"); 
	   
	 driver.findElement(By.id("txtcaptcha")).click();
	 WebElement capcha = driver.findElement(By.id("txtcaptcha")); 
	    capcha.sendKeys("RFC@123");
	     Thread.sleep(1000);
	WebElement login = driver.findElement(By.id("btnLogin"));
	    login.click();
	    System.out.println("Login Successfull");
  }
  @Test
  public void Test2() throws Exception {
	  WebElement con = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[1]/a"));     // configuration
	  System.out.println("Configuration menu selected");
	  Actions action = new Actions(driver);
	  action.moveToElement(con).perform();
	   Thread.sleep(2000);
	  // Locating the element from Sub Menu
	  WebElement con_notice = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:2\"]/li[2]/a"));  // create notice/news
	  System.out.println("Configuratoin-create notice/news submenu selected");
	  action.moveToElement(con_notice);
	  action.click().build().perform();
	  
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd")).click();
		System.out.println("select add-new notice");
		 Thread.sleep(1000);		  
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTitle")).sendKeys("TEST");
		System.out.println("select notice title");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtExpiryDate")).sendKeys("31-01-2024");
		System.out.println("select notice date");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_chklUserType_0")).click();
		System.out.println("select checkbox of user-type");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ftbDesc_designEditor")).sendKeys("Notice for Testing");
		System.out.println("select notice paragraph");
		 Thread.sleep(1000);	
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		System.out.println("Record save successfully");
		driver.switchTo().alert().accept();
		driver.close();
}
}
