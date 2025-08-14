package RFCC_Extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BulkStudentCreation {
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
	     Thread.sleep(3000);
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
	  WebElement con_usermanage = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:2\"]/li[1]/a"));  // user management
	  System.out.println("Configuratoin-user management submenu selected");
	  action.moveToElement(con_usermanage);
	  action.click().build().perform();
	  
	  driver.findElement(By.xpath("//*[@id=\"ctl00_repLinks_ctl05_lbLink\"]")).click();  // bulk student user creation
	  System.out.println("Bulk student user creation page selected");
	  driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlStudAdmBatch-container")).click();
	  	  
		driver.findElement(By.className("select2-search__field")).sendKeys("2023-24",Keys.ENTER);
		System.out.println("select Admission Batch");
		Thread.sleep(1000);	
			  
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_FileUpload2\"]"));	
		  System.out.println("Select file to upload");
		  upload_file.sendKeys("C:\\Users\\USER\\Desktop\\pratiksha\\SCREENSHOT\\(Rfctest).xlsx");
		  System.out.println("File uploaded successfully");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnUpload\"]")).click();
		  System.out.println("Record submitted successfully");
		  driver.switchTo().alert().accept();
		  driver.close();
  }
}

