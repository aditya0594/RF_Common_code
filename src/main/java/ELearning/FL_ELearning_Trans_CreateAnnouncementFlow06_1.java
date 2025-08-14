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

public class FL_ELearning_Trans_CreateAnnouncementFlow06_1 extends BaseClass{

	public FL_ELearning_Trans_CreateAnnouncementFlow06_1(WebDriver driver) {
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
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject")
	private WebElement announcementTitle;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;	
	
	@FindBy(linkText  = "Create Announcement")
	private WebElement CreateAnnouncement;
	
	@FindBy(className = "cke_show_borders")
	private WebElement Description;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnViewAnnouncement")
	private WebElement AnnouncementReport;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 SelectCourseTest() throws Exception {
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
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 ClickCreateAnnouncementPageTest() throws Throwable {
		System.out.println("Click on Create Announcement Page");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", CreateAnnouncement);
		Thread.sleep(2000);
		//CreateAssignment.click();
		js.executeScript("arguments[0].click();", CreateAnnouncement);
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1  Enter_AnnouncementTitle() throws Throwable {
		System.out.println("Enter Announcement Title => Automation Announcement");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", announcementTitle);
		
		announcementTitle.sendKeys("Automation Announcement");
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 Select_ExpiryDate() throws Throwable {
		System.out.println("Select Expiry Date => 05-12-2030");
		WebElement date = driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_txtExpDate'])[1]"));
		
		Thread.sleep(2000);
	    String date1 = "05-12-2030"; 
	    date.sendKeys(date1);
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 EnterDescriptionTest() throws Throwable {
		System.out.println("Enter Description");
		
		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		Description.clear();
		Description.sendKeys("Income Tax Announcement Description");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("outside Frame");
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 SubmitButtonTest() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Submit);	
		Thread.sleep(2000);
		Submit.click();
		return this;
	}
	
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 AnnouncementReportButtonTest() throws Throwable {
		System.out.println("Click On Announcement Report Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", AnnouncementReport);	
		Thread.sleep(2000);
		AnnouncementReport.click();
		return this;
	}
	public FL_ELearning_Trans_CreateAnnouncementFlow06_1 login()  {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
//	Thread.sleep(2000);
	System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

//	Thread.sleep(2000);
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
