package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseClass;

public class RF_StudentLoginPage extends BaseClass { 

	
	public static void loginPage() throws InterruptedException {

		System.out.println("Enter UserName ->  232AT017"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("232AT017");  
		//191291601067

		System.out.println("Enter Password UAT -> admin@123 || Live -> Samsung@50 ");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");
		// Thread.sleep(2000);

		// captchaHandle();
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		//Thread.sleep(2000);
		System.out.println("Press Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		try
		{
			WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
			if (skipButton != null && skipButton.isDisplayed())
			{
				skipButton.click();
				System.out.println("Click on Skip Notice / News");
			}
			else
			{
				System.out.println("Skip Button is not Prescent");
			}
			
			//check weather the Notice Modal is present or not
			Thread.sleep(1000);
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed())
			{
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			}
			else
			{
				System.out.println("Notice Modal close button is not prescent");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		}

	}

}
