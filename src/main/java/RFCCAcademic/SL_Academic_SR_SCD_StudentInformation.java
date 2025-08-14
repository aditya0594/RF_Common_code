package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class SL_Academic_SR_SCD_StudentInformation extends BaseClass{

	public SL_Academic_SR_SCD_StudentInformation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink")
	private WebElement Student_Complete_Detail_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement Session_Dropdown;
	
	@FindBy(xpath = "//a[@href='#PersonalDetails']")
	private WebElement Fees_Details;
	
	@FindBy(xpath = "//a[@href='#tab_5']")
	private WebElement Course_Registered;
	
	@FindBy(linkText = "Attendance Details")
	private WebElement Attendance_Details;
	
	@FindBy(linkText = "Result Details")
	private WebElement Result_Details;
	
	@FindBy(linkText = "Revaluation Result Details")
	private WebElement Revaluation_Result_Details;
	
	@FindBy(xpath = "//div[@class='row shadow-sm border border-light py-3 bg-white rounded']//span[text()='School of Infrastructure']")
	private WebElement schemename;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public SL_Academic_SR_SCD_StudentInformation loginPage() throws InterruptedException {

		System.out.println("Enter UserName ->  210011601001"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("210011601001");  
		//191291601067

		System.out.println("Enter Password  -> Admin@12345");
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
	
	public SL_Academic_SR_SCD_StudentInformation Click_StudentCompleteDetail_Link() throws InterruptedException {
		WebElement link_SCD = driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink"));
		link_SCD.click();
		System.out.println("Click on Student Complete Detail");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Session_Dropdown);
		return this;
	}

	public SL_Academic_SR_SCD_StudentInformation Click_Student_Fees_Details() {
		js.executeScript("arguments[0].scrollIntoView();",Fees_Details);
		js.executeScript("arguments[0].click();", Fees_Details);
		System.out.println("Click on Student Fees Details_ display");
		
		return this;
	}

	public String Alert_Msg() {
		
		String msg = schemename.getText();
		System.out.println("Verify_msg > "+msg);
		return msg;
	}
	
//	public SL_Academic_SR_StudentCompleteDetail Click_Attendance_Details() {
//		WebElement atte_details = driver.findElement(By.linkText("Attendance Details"));
//		js.executeScript("arguments[0].scrollIntoView();",atte_details);
//		atte_details.click();
//		System.out.println("Click on Student Attendance Details display");
//		return this;
//	}
//	
//	public SL_Academic_SR_StudentCompleteDetail Click_Result_Details() {
//		WebElement result_details = driver.findElement(By.linkText("Result Details"));
//		js.executeScript("arguments[0].click();", result_details);
//		System.out.println("Click on Result Details display");
//		return this;
//	}
//	
//	public SL_Academic_SR_StudentCompleteDetail Click_Revaluation_Result() {
//		WebElement revaluation_result = driver.findElement(By.linkText("Revaluation Result Details"));
//		js.executeScript("arguments[0].click();", revaluation_result);
//		System.out.println("Click on Revaluation Result Details");
//		return this;
//	}
//	
//	public SL_Academic_SR_StudentCompleteDetail Click_Internal_Mark() {
//		WebElement internal_marks = driver.findElement(By.linkText("Internal Marks"));
//		js.executeScript("arguments[0].click();", internal_marks);
//		System.out.println("Click on Internal Marks");
//		return this;
//	}

}
