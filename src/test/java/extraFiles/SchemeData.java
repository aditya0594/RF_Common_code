package extraFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SchemeData {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private JavascriptExecutor js;
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://rfctest.mastersofterp.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    js = (JavascriptExecutor) driver;
	  }
        @Test
        public void login() throws InterruptedException {
        	WebElement user = driver.findElement(By.id("txt_username"));
		    user.sendKeys("admin");
		    
		    WebElement pass = driver.findElement(By.id("txt_password"));
		    pass.sendKeys("rfctest@dev"); 
		    Thread.sleep(5000);
		    WebElement login = driver.findElement(By.id("btnLogin"));
		    login.click();
		    System.out.println("Login Successfull");
        } 
		  @Test
		  public void scheme1() throws Exception {
		   driver.get("https://rfctest.mastersofterp.in/academic/iitmsVm7APjlVCdtt3V6WQ42nbvMCn90P3DofVTHJpZSIfhKULXOdDMmAngAvbOfnkFh6?enc=NX6ksWYoKz8LyeoRDPuA+V/90fAjPz3AR3jOuh3Yd3U=");
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvSchemeType_ctrl0_btnEditSchemeType")).click();
			    System.out.println("Edit the scheme type");
			    Thread.sleep(2000);
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmitSchemeType")).click();
			    System.out.println("Submit the scheme type");
			    Thread.sleep(2000);
			     //switch focus to alert
			      Alert a = driver.switchTo().alert();
			      //get alert text
			      String s= driver.switchTo().alert().getText();
			      System.out.println("Alert text is: " + s);
			      //accepting alert
			      a.accept();
			      
//			    assertEquals(closeAlertAndGetItsText(), "Record Updated Successfully!");
//			    System.out.println("Scheme Type Record update successfully");
			    } 
		  			
		  @Test
		  public void scheme2() throws Exception {
			       Thread.sleep(1000);
			  	driver.findElement(By.linkText("Scheme Creation")).click();
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegreeNo-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Pharmacy");
			    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select degree for scheme creation");
			       Thread.sleep(1000);
			       
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDept-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Pharmacy");
			    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select department for scheme creation");
			       Thread.sleep(1000);
			       
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("B.Pharm.");
				driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select branch for scheme creation");
			       Thread.sleep(1000);
			       
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBatchNo-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("2022-23");
				driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select batchno for scheme creation");
			       Thread.sleep(1000);
			       
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSchemeType-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("Scheme");
				driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select schemetype for scheme creation");
			       Thread.sleep(1000);
			    
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlgrademarks-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("Grade");
				driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select grademarks for scheme creation");
			       Thread.sleep(1000);
   
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPatternName-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("B.Pham Pattern");
				driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			       System.out.println("select study pattern for scheme creation");
			       Thread.sleep(1000); 
			       
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
			       Thread.sleep(1000);
			  assertEquals(closeAlertAndGetItsText(), "Already Exists!!");
			    System.out.println("Scheme creation Record update successfully");
		  }
		  @Test
		  public void scheme3() throws Exception {
			       Thread.sleep(1000);
			    driver.findElement(By.linkText("College Scheme Configuration")).click();
			    acceptNextAlert = true;
			    
			    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege1-container")).click();
			    driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Pharmacy");
			    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			      System.out.println("select school for scheme configuration");
			      Thread.sleep(1000);
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit1")).click();
			      System.out.println("Submit the school for scheme configuration");
			    Thread.sleep(1000);
			    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to Submit[\\s\\S]$"));
			    Thread.sleep(1000);
			    assertEquals(closeAlertAndGetItsText(), "Record Saved Successfully!!");
			    System.out.println("Scheme configuration Record update successfully");
		  }
	  @Test
	  public void scheme4() throws Exception {
		        Thread.sleep(1000);
		    driver.findElement(By.linkText("Scheme Allotment")).click();
		    
			driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Pharmacy - Chennai");
		    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			    System.out.println("select institute for scheme allotment");
			    Thread.sleep(1000);
			    
			driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Pharmacy");
			driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			    System.out.println("select degree for scheme allotment");
			    Thread.sleep(1000);
			    
			driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch1-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("B.Pharm.");
			driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			    System.out.println("select branch for scheme allotment");
			    Thread.sleep(1000);
			    
			driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("2021-22");
		    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			    System.out.println("select admission batch for scheme allotment");
			    Thread.sleep(1000);
			    
			driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester1-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("IV");
		    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
			    System.out.println("select semester for scheme allotment");
			    Thread.sleep(1000);
			    
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowStudent")).click();
			    System.out.println("Click on show button");
			    Thread.sleep(2000);
			    
			 
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tblStudentList_filter\"]/label/input"));

			    	//This will scroll the page Horizontally till the element is found		
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		        
			    Thread.sleep(2000);
			    System.out.println("Select Check box");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl0_cbRow")).click();
			    System.out.println("Select checkbox of student");
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrintAllotment")).click();
			//assertEquals(closeAlertAndGetItsText(), "No Students for selected criteria");
			    Thread.sleep(1000);
			    System.out.println("Scheme allotment Record update successfully"); 
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