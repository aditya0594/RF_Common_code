package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_SendSMSToStudents extends BaseClass{

	public FL_ELearning_Trans_SendSMSToStudents(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//@FindBy(id = "ctl00_repLinks_ctl19_lbLink")private WebElement sendSMSToStudents_link;
	@FindBy(linkText = "Send SMS To Sudents")private WebElement sendSMSToStudents_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")private WebElement session_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCourse-container")private WebElement course_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkSelectMail")private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDesiTemp")private WebElement textarea;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendSms")private WebElement sendSms_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement Course;
	@FindBy(xpath = "//button[normalize-space()='OK']")private WebElement SelectCourseClickOk;
	
	@FindBy(className = "select2-search__field")private WebElement searchcourse;
	
	
	
	public FL_ELearning_Trans_SendSMSToStudents click_sendSMSToStudents_link() throws InterruptedException {
		System.out.println("Click Send SMS to Students link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				sendSMSToStudents_link
				);

		// Optionally, interact with the target element
		click(sendSMSToStudents_link);
		
		return this;
	}
	
	public FL_ELearning_Trans_SendSMSToStudents SelectCourseTest() throws Exception {
		System.out.println("Select Course > 2023-2024 - Crescent School of Architecture ");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		//typ_sessn.selectByVisibleText("2023-2024 - Crescent School of Architecture");
		typ_sessn.selectByValue("215");
		Thread.sleep(2000);
		Course.click();
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	public FL_ELearning_Trans_SendSMSToStudents select_session() {
		System.out.println("Select Session > May 2022 - Crescent School of Architecture ");
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("May 2022 - Crescent School of Architecture");
		return this;
	}

	public FL_ELearning_Trans_SendSMSToStudents select_course() {
		System.out.println("Select Course > AR AY 107 - Landscape Architecture - [M.Arch.]");
		click(course_dropdown);
		sendKeys(searchcourse,"AR AY 107 - Landscape Architecture - [M.Arch.]");
		searchcourse.sendKeys(Keys.ENTER);
		return this;
	}

	public FL_ELearning_Trans_SendSMSToStudents click_checkbox() {
		System.out.println("Click checkbox");
		checkbox.click();
		return this;
	}

	public FL_ELearning_Trans_SendSMSToStudents enter_templateToSend() {
		System.out.println("Enter Template to Send > Testing");
		textarea.sendKeys("Testing");
		return this;
	}

	public FL_ELearning_Trans_SendSMSToStudents click_sendSms_btn() {
		System.out.println("Click Send SMS button");
		sendSms_btn.click();
		return this;
	}
	public FL_ELearning_Trans_SendSMSToStudents login() {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	//Thread.sleep(3000);
	System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");
	//Thread.sleep(3000);	System.out.println("Click on Login Button");
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
	return this;
	}	
}
