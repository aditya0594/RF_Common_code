package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 extends BaseClass
{
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "E- LEARNING")
	private WebElement ELearning;
	
	@FindBy(linkText = "Transactions")
	private WebElement Transactions;
	
	@FindBy(linkText = "Select Course")
	private WebElement SelectCourse;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement SelectCourseClickOk;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;
	
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]")
	private WebElement Search;	
	
	@FindBy(linkText  = "Create Announcement")
	private WebElement CreateAnnouncement;
	
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_lvAnnounce_ctrl0_btnDelete'])[1]")
	private WebElement deleteicon;
	
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnOkDel'])[1]")
	private WebElement yesBtn;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 SelectCourseTest() throws Exception {
		System.out.println("Select Course");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("DEC 2018 - Crescent School of Architecture");
		
		Thread.sleep(2000);
		Course.click();
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 ClickCreateAnnouncementPageTest() throws Throwable {
		System.out.println("Click on Create Announcement Page");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", CreateAnnouncement);
		Thread.sleep(2000);
		//CreateAssignment.click();
		js.executeScript("arguments[0].click();", CreateAnnouncement);
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 Search_Record() throws Throwable {
		System.out.println("Search Record => Automation Announcement");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", Search);
		Thread.sleep(2000);
		Search.sendKeys("Automation Announcement");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 Click_DeleteIcon() throws Throwable {
		System.out.println("Click on Delete Icon");
		
		deleteicon.click();
		Thread.sleep(2000);
		yesBtn.click();
		return this;
	}
	public FL_ELearning_Trans_CreateAnnouncement_DeleteFlow06_2 login() {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
	//Thread.sleep(2000);
	System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

	//Thread.sleep(2000);
	System.out.println("Click on Login Button");
	driver.findElement(By.id("btnLogin")).click();

	//Thread.sleep(1000);
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
		/*
		 * Thread.sleep(1000); WebElement closeButton = driver
		 * .findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"))
		 * ; if (closeButton != null && closeButton.isDisplayed()) {
		 * closeButton.click();
		 * System.out.println("Click on close button of, Notice Modal"); } else {
		 * System.out.println("Notice Modal close button is not prescent"); }
		 */
	} catch (Exception e) {
		// TODO: handle exception
		// System.out.println("Element not found : " e.getMessage());
		System.out.println("Something went wrong");
	}
	
	System.out.println("Faculty Logged in Successfully.");
	return this;
	}
}
