package ELearning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_PersonalCalendar extends BaseClass{

	public FL_ELearning_Trans_PersonalCalendar(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Personal Calendar") private WebElement personalCalendar_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtHeader") private WebElement header_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDesc") private WebElement description_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssetAllotment_ctrl0_btnEdit") private WebElement edit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssetAllotment_ctrl0_btnDeleteQualDetail") private WebElement delete_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement okDel_btn;
	
	public FL_ELearning_Trans_PersonalCalendar click_personalCalendar_link() {
		System.out.println("Click on Personal Calendar Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				personalCalendar_link
				);

		// Optionally, interact with the target element
		click(personalCalendar_link);
		//attendanceEmailTrigger_link.click();
		
		return this;
	}

	public FL_ELearning_Trans_PersonalCalendar select_date() {
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM");
        String formattedDate = currentDate.format(formatter);
        driver.findElement(By.xpath("//td/a[@title='"+formattedDate+"']")).click();
		return this;
	}
	
	public FL_ELearning_Trans_PersonalCalendar enter_header() {
		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;
		String randomText = "Test" + randomNumber;
		header_inputfield.sendKeys(randomText);
		return this;
	}
	
	public FL_ELearning_Trans_PersonalCalendar enter_description() {
		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;
		String randomText = "Test" + randomNumber;
		description_inputfield.sendKeys(randomText);
		return this;
	}
	
	public FL_ELearning_Trans_PersonalCalendar click_submit_btn() {
		submit_btn.click();
		return this;
	}
	//Record Saved successfully!!
	public FL_ELearning_Trans_PersonalCalendar edit_calendar() {
		edit_btn.click();
		description_inputfield.clear();
		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;
		String randomText = "Test" + randomNumber;
		description_inputfield.sendKeys(randomText);
		return this;
	}
	
	public FL_ELearning_Trans_PersonalCalendar click_deleteCalendar() {
		delete_btn.click();
		okDel_btn.click();
		return this;
	}
	public FL_ELearning_Trans_PersonalCalendar login() {
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
