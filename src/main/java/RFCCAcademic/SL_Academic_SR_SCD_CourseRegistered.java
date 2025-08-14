package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class SL_Academic_SR_SCD_CourseRegistered extends BaseClass
{
	public SL_Academic_SR_SCD_CourseRegistered(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Student Complete Detail")
	private WebElement Student_Complete_Detail_Link;
	
	@FindBy(linkText = "Course Registered")
	private WebElement courseRegistered;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")   
	private WebElement session;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourseReg_ctrl1_lnkCcodepup")
	private WebElement ccode;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvcoursemodelpop_ctrl0_lblTeacher")
	private WebElement teacher;
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public SL_Academic_SR_SCD_CourseRegistered loginPage() throws InterruptedException {

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
	
	public SL_Academic_SR_SCD_CourseRegistered Click_StudentCompleteDetail_Link() throws InterruptedException {
		js.executeScript("arguments[0].click();", Student_Complete_Detail_Link);
		System.out.println("Click on Student Complete Detail");
		return this;
	}

	public SL_Academic_SR_SCD_CourseRegistered Click_CourseRegistered() {
		js.executeScript("arguments[0].click();", courseRegistered);
		js.executeScript("arguments[0].scrollIntoView();",session);

		System.out.println("Click on Course Registered");
		return this;
	}
	
	public SL_Academic_SR_SCD_CourseRegistered Select_Session() {
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");

		System.out.println("Select Session >  May 2022");
		return this;
	}
	
	public SL_Academic_SR_SCD_CourseRegistered Click_CCode() {
		ccode.click();
		System.out.println("Click on CCode > MAD 1281");
		return this;
	}
	

	public String Alert_Msg() {
		
		String msg = teacher.getText();
		System.out.println("Verify_msg > "+msg);
		return msg;
	}
}
