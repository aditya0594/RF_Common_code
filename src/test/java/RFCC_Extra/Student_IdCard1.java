package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Screenshot;

public class Student_IdCard1 extends BaseClass {

	@BeforeClass
	public void configuration() {

	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test : " + m.getName() + "******* " + "\n");
	}

	@Test
	public void identity_Card() throws Exception {

		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
//		driver.findElement(By.className("introjs-skipbutton")).click();
//		Thread.sleep(2000);

		//Hover on Academic from navigation bar
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		System.out.println("Hover on Academic from navigation bar");
		Thread.sleep(2000);

		//Click on Academic Reports option
		driver.findElement(By.linkText("Academic Reports")).click();
		System.out.println("Click on Academic Reports option");
		Thread.sleep(2000);
		
		//Click on Identity Card from sub menu
		System.out.println("Click on Identity Card");
		driver.findElement(By.id("ctl00_repLinks_ctl04_lbLink")).click();
		System.out.println("Click on Identity Card from sub menu");
		Thread.sleep(2000);

		//Select Batch
		Select batch = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAdmbatch")));
		batch.selectByVisibleText("2021-22");
		System.out.println("Select Admission Batch -> 2021-22");
		Thread.sleep(2000);

		//Select Institute
		Select schl = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClg")));
		schl.selectByVisibleText("Crescent School of Law - Chennai");
		System.out.println("Select School/ Institute -> Crescent School of Law - Chennai");
		Thread.sleep(2000);

		//Click on Show Student Button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
		System.out.println("Click on Show Student Button");
		Thread.sleep(2000);

		//Select student
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport")).click();
		System.out.println("Select students from list");
		Thread.sleep(2000);

		//Click on Print front Back ID card Button 
		System.out.println("Click on Print front Back ID card Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFrontBackIdentityCard")).click();
		Thread.sleep(2000);
		
		//Take ScreenShot
		//switchToNextWindow();
//		Thread.sleep(5000);
//		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
	//	Thread.sleep(5000);
		
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement download = (WebElement) jse.executeScript("return document.querySelector(\"#viewer\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#downloads\")");
//        Thread.sleep(2000);
//        jse.executeScript("arguments[0].click();",download);
//        Thread.sleep(2000);

	
////        WebElement sh = driver.findElement(By.cssSelector("#icon > cr-icon"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement sr = (WebElement) jse.executeScript("return arguments[0].sr",download);
//        Thread.sleep(2000);
//        WebElement svge = sr.findElement(By.cssSelector("svg"));
//        Thread.sleep(2000);
//        Actions act = new Actions(driver);
//        act.moveToElement(svge).click().perform();
//        Thread.sleep(2000);
//        
		 Thread.sleep(5000);  
		    String parent1= driver.getWindowHandle();
		    Set<String>ss=driver.getWindowHandles();
		    Iterator<String> I2= ss.iterator();
		    while(I2.hasNext())
		    {
		    String child_window1=I2.next();
			    if(!parent1.equals(child_window1))
				    {
					    driver.switchTo().window(child_window1);
					    System.out.println(driver.switchTo().window(child_window1).getTitle());
					    Thread.sleep(2000);
						System.out.println("Inside child window");
					    Screenshot.takesScreenshot(getCurrentDateAndTime());
					    
						
						  Thread.sleep(2000); 
						  /*WebElement element =driver.findElement(By.cssSelector("pdf-viewer#viewer")).getShadowRoot().
						  findElement(By.cssSelector("viewer-toolbar#toolbar")).
						  findElement(By.cssSelector("viewer-download-controls#downloads")).getShadowRoot().
						  findElement(By.cssSelector("cr-icon-button#download"));
						  
						  Thread.sleep(2000);
						  element.click();*/
						 
						// Access the Shadow DOM element
				          
						// Access the first shadow host element
						 JavascriptExecutor js = (JavascriptExecutor) driver;   
						 
						 Thread.sleep(5000);
						 					 
						 
						  WebElement shadowHost1 = driver.findElement(By.cssSelector("pdf-viewer#viewer"));
						  WebElement shadowRoot1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost1);
						  System.out.println("inside shadow host");
						  
						  Thread.sleep(2000);
						  // Access the next shadow host within the first shadow root
						  WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("#toolbar"));
						  WebElement shadowRoot2 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost2);
						  
						  Thread.sleep(2000);
						  // Access the next shadow host within the first shadow root
						  WebElement shadowHost3 = shadowRoot2.findElement(By.cssSelector("#downloads"));
						  WebElement shadowRoot3 = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost3);
						  
						  Thread.sleep(2000);
						  // Finally, locate and interact with the element within the nested shadow DOM
						  WebElement targetElement = shadowRoot3.findElement(By.cssSelector("#download"));
						  
						  Thread.sleep(2000);
						  targetElement.click();
						
				    }
			  
		    }
		    
		   
		       
		  /*  JavascriptExecutor js = (JavascriptExecutor) driver; 
			  
			  
			Thread.sleep(8000);
	         String str = "return document.querySelector('#viewer').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#downloads').shadowRoot.querySelector('#download').shadowRoot.querySelector('#icon > cr-icon')";  
	         WebElement download =(WebElement)js.executeScript(str,"str");
	    
		 Thread.sleep(1000);
		 download.click();
		 System.out.println("click on download icon");*/
		    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         //   WebElement shadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#viewer")));


            // Retrieve the shadow root
         //   WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

            // Locate the element inside the Shadow DOM
           // WebElement downloadButton = shadowRoot.findElement(By.cssSelector("#icon"));
            
           // downloadButton.click();
	    

		/*
       JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement search =  (WebElement) jse.executeScript("return document.querySelector(\"#viewer\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#zoom-controls > input[type=text]\")");
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", search);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].value='50';",search);
        Thread.sleep(2000);
		*/

            Thread.sleep(2000);
		    driver.switchTo().window(parent1);
		    System.out.println("Inside main browser");
        
        
//		try {
//			TakesScreenshot scrShot = ((TakesScreenshot) driver);
//			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\CresentScreenshot.png");
//			FileUtils.copyFile(SrcFile, DestFile.getAbsoluteFile());
//			// Screenshot.takesScreenshot(getCurrentDate());
//			System.out.println("Screenshot captured: " + DestFile.getAbsolutePath());
//		} catch (Exception e) {
//			System.out.println("Exception while taking screenshot: " + e.getMessage());
//		}
//
//		driver.switchTo().parentFrame();

	}
}
