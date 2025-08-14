package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class SL_Academic_SR_SCD_QualificationDetails extends BaseClass
{
	public SL_Academic_SR_SCD_QualificationDetails(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Student Complete Detail")
	private WebElement Student_Complete_Detail_Link;
	
	@FindBy(linkText = "Qualification Details")
	private WebElement qualificationdetails;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lblDYSecondaryMarks_QD")
	private WebElement secondary10;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRegNo")
	private WebElement regino;
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public SL_Academic_SR_SCD_QualificationDetails loginPage() throws InterruptedException {

		System.out.println("Enter UserName ->  210011601001"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("210011601001");  
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
		return this;

	}
	
	public SL_Academic_SR_SCD_QualificationDetails Click_StudentCompleteDetail_Link() throws InterruptedException {
		js.executeScript("arguments[0].click();", Student_Complete_Detail_Link);
		System.out.println("Click on Student Complete Detail");
		return this;
	}

	public SL_Academic_SR_SCD_QualificationDetails Click_QualificationDetails() {
		js.executeScript("arguments[0].click();", qualificationdetails);
		js.executeScript("arguments[0].scrollIntoView();",secondary10);

		System.out.println("Click on Qualification Details");
		return this;
	}

	public String Alert_Msg() {
		
		String msg = secondary10.getText();
		System.out.println("Verify_msg > "+msg);
		return msg;
	}
}
