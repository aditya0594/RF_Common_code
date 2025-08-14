package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseClass;

public class RF_AdminLoginPage extends BaseClass{

	public static void loginPage() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Enter UserName -> admin");
		driver.findElement(By.id("txt_username")).sendKeys("admin");

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345"); 

		///// production captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("5321");
		//clickOnSignIn(); 
		
		
		  Thread.sleep(3000); System.out.println("Click on Login Button");
		  driver.findElement(By.id("btnLogin")).click();
		 
		
		  Thread.sleep(1000);
		  Thread.sleep(1000);
			try {
				// check if the skip button is present
				WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
				if (skipButton != null && skipButton.isDisplayed()) {
					skipButton.click();
					System.out.println("Click on Skip Notice / News");
				} else {
					System.out.println("Skip Button is not Prescent");
				}

				// check weather the Notice Modal is present or not
				Thread.sleep(1000);
				WebElement closeButton = driver
						.findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"));
				if (closeButton != null && closeButton.isDisplayed()) {
					closeButton.click();
					System.out.println("Click on close button of, Notice Modal");
				} else {
					System.out.println("Notice Modal close button is not prescent");
				}
			} catch (Exception e) {
				// TODO: handle exception
				// System.out.println("Element not found : " e.getMessage());
				System.out.println("Something went wrong");
			}
	}

//	    public static void captchaHandle() {
//	        try 
//	        {
//	        	int n = 0;
//	            while (n < 4) 
//	            {
//	                
//	            	getCaptchaText();
//	            	boolean success = false;
//	            	//boolean success = true;
//					try 
//					{
//						success = isloginsuccess();
//					} 
//					catch (Exception e) 
//					{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	            	if(success)//login Successfull
//	            	{
//	            		
//	            		break;
//	            		
//	            	}	
//	            }
//	        } 
//	        catch (Exception e) 
//	        {
//	            e.printStackTrace();
//	        }
//	    }
//	    
//	    
//	    private static void getCaptchaText() throws IOException, TesseractException, InterruptedException
//	    {
////	    	System.out.println("Click on Refresh CaptchImage Button");
////	     	driver.findElement(By.id("ImageButton1")).click();
////	     	Thread.sleep(2000);
//	    	
//	        WebElement captchaImage = driver.findElement(By.xpath("//*[@id=\"UpdatePanel1\"]/div/div[1]/img")); // Change the XPath accordingly
//	        File screenshot = captchaImage.getScreenshotAs(OutputType.FILE);
//	        
//	        Thread.sleep(2000);
//
//	        // Save screenshot to a file
//	        String imagePath = System.getProperty("user.dir") + "/target/captcha.png";
//	        FileHandler.copy(screenshot, new File(imagePath));
//
//	        Thread.sleep(2000);
//	        // Perform OCR on the captcha image
//	        ITesseract tesseract = new Tesseract();
//	        String tessDataPath = System.getProperty("user.dir") + "/tessdata";
//	        tesseract.setDatapath(tessDataPath);
//	        Thread.sleep(2000);
//	        BufferedImage image = ImageIO.read(new File(imagePath));
//	        String captchaText = tesseract.doOCR(image);
//	        Thread.sleep(2000);
//
//	        // Clean up and return the captcha text
//	        String finalText= captchaText.replaceAll("[^a-zA-Z0-9]", "");
//	        Thread.sleep(2000);
//
//	        
//	        System.out.println("Final Captcha is "+finalText);
//	        driver.findElement(By.id("txtcaptcha")).clear();
//			driver.findElement(By.id("txtcaptcha")).sendKeys(finalText);
//			
//			driver.findElement(By.id("btnLogin")).click();
//			
//	    }  //get captcha end
//	    
	    public static boolean isloginsuccess()
	    {
	    	if(driver.getCurrentUrl().equals("https://rfcautomationuat.mastersofterp.in/iitmsv4eGq0RuNHb0G5WbhLmTKLmTO7YBcJ4RHuXxCNPvuIw=?enc=EGbCGWnlHNJ/WdgJnKH8DA=="))//login
	    	{
	    		
	    		 return true;
	    	}
	    	else
	    	{
	    		 return false;
	    	}
	    }// isloginsuccess

		/*
		 * public static void clickOnSignIn() throws TesseractException, IOException,
		 * InterruptedException {
		 * 
		 * 
		 * WebElement captchaIMG = null; try { captchaIMG =
		 * driver.findElement(By.id("captchaCanvas"));
		 * 
		 * } catch (Exception e) { // CAPTCHA image not found, proceed directly to sign
		 * in captchaIMG = null; }
		 * 
		 * if (captchaIMG != null) {
		 * 
		 * 
		 * WebElement captchaTextBox = driver.findElement(By.id("txtcaptcha"));
		 * 
		 * File src = captchaIMG.getScreenshotAs(OutputType.FILE);
		 * 
		 * String path =
		 * "D:\\Automation\\testing-automation\\RF_Common_Code_LIVE\\CaptchaImages\\captcha.png";
		 * 
		 * FileUtils.copyFile(src, new File(path)); // Wait Thread.sleep(3000);
		 * //Tesseract Class assign ITesseract image = new Tesseract();
		 * image.setDatapath(
		 * "D:\\Automation\\testing-automation\\RF_Common_Code_LIVE\\tessdata");
		 * 
		 * String str = image.doOCR(new File(path));
		 * 
		 * System.out.println("image OCR done"); System.out.println(str);
		 * 
		 * // Enter captcha in box
		 * 
		 * //captchaTextBox.clear(); Thread.sleep(5000); captchaTextBox.sendKeys(str);
		 * Thread.sleep(5000);
		 * 
		 * // Thread.sleep(1000); // WebElement signIN = driver.findElement(signIn);
		 * 
		 * // signIN.click();
		 * 
		 * } else { // CAPTCHA is not present WebElement signI =
		 * driver.findElement(By.id("btnLogin")); // Replace with the actual ID or
		 * selector
		 * 
		 * // Click the sign-in button signI.click(); }
		 * 
		 * }
		 */
	    
}// base class end
