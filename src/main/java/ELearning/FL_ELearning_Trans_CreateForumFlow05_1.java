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

public class FL_ELearning_Trans_CreateForumFlow05_1 extends BaseClass{

	public FL_ELearning_Trans_CreateForumFlow05_1(WebDriver driver) {
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
	
	@FindBy(linkText = "Create Forum")
	private WebElement createforum;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssignment_ctrl0_btnEdit")
	private WebElement EditIcon;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;	
	
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_txtForum'])[1]")
	private WebElement forumname;
	
	@FindBy(className = "cke_show_borders")
	private WebElement Description;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
	private WebElement Submit;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnViewForum")
	private WebElement ForumReport;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	public FL_ELearning_Trans_CreateForumFlow05_1 HoverELearningTest() {
		System.out.println("Hover to E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 SelectCourseTest() throws Exception {
		System.out.println("Select Course =>DEC 2018 - Crescent School of Architecture");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("DEC 2018 - Crescent School of Architecture");
		
		Thread.sleep(2000);
		Course.click();
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 Click_CreateForum() throws Throwable {
		System.out.println("Click on Create Forum");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", createforum);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createforum);

		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 Enter_ForumName() throws Throwable {
		System.out.println("Enter Forum => Selenium Forum");
		
		/*
		 * Thread.sleep(2000); js.executeScript("arguments[0].scrollIntoView();",
		 * forumname);
		 */
		Thread.sleep(2000);
		sendKeys(forumname, "Selenium Forum");
		
		return this;
	}
	
	
	public FL_ELearning_Trans_CreateForumFlow05_1 Select_StartDate() throws Throwable {
		System.out.println("Select Start Date => 05-03-2025");
	//	WebElement date = driver.findElement(By.xpath("//input[@id=\"ctl00_ContentPlaceHolder1_txtFromDate\"]"));
		
		/*
		 * Thread.sleep(2000); String date1 = "05-03-2025"; date.sendKeys(date1);
		 */
	//	WebElement enddatelable = driver.findElement(By.xpath("//label[normalize-space()='End Date']"));
		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder1_txtFromDate').value='05/03/2025';");	
		
		Thread.sleep(2000);
	//	enddatelable.click();	    
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 Select_EndDate() throws Throwable {
		System.out.println("Select End Date => 08-03-2025");
		driver.findElement(By.xpath("//input[@id=\"txtToDate\"]")).clear(); // Clear the second input if needed.
		Thread.sleep(500);
		js.executeScript("document.getElementById('txtToDate').value='05/07/2026';");
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 EnterDescriptionTest() throws Throwable {
		System.out.println("Enter Description");
		
		Thread.sleep(2000);
		switchToFrame(2);
		System.out.println("Inside Frame");
		Description.clear();
		Description.sendKeys("Forum 01 Description Test");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("outside Frame");
		
		return this;
	}
	
	
	public FL_ELearning_Trans_CreateForumFlow05_1 SubmitButtonTest() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Submit);	
		Thread.sleep(2000);
		Submit.click();
		return this;
	}
	
	public FL_ELearning_Trans_CreateForumFlow05_1 ForumReportButtonTest() throws Throwable {
		System.out.println("Click On Forum Report Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", ForumReport);	
		Thread.sleep(2000);
		ForumReport.click();
		return this;
	}
	public FL_ELearning_Trans_CreateForumFlow05_1 login() {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
	//Thread.sleep(2000);
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
	} catch (Exception e) {
		// TODO: handle exception
		// System.out.println("Element not found : " e.getMessage());
		System.out.println("Something went wrong");
	}
	
	System.out.println("Faculty Logged in Successfully.");
	
	return this;
	}
}
