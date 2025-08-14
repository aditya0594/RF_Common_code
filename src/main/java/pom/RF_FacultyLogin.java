package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseClass;

public class RF_FacultyLogin extends BaseClass {

	public static void loginPage() throws InterruptedException {
 
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 2019152");
		driver.findElement(By.id("txt_username")).sendKeys("2019152"); 

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> 4321"); 
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		Thread.sleep(1000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		try 
		{
			//check if the skip button is present
			WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
			if(skipButton != null && skipButton.isDisplayed())
			{
				skipButton.click();System.out.println("Click on Skip Notice / News");
			}
			else
			{
				System.out.println("Skip Button is not Prescent");
			}
			//check weather the Notice Modal is present or not
			Thread.sleep(2000);
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"notice\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed())
			{
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			}
			else
			{
				System.out.println("Notice Modal close button is not prescent");
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("Something went wrong");
		}
	}
}
