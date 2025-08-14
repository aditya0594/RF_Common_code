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

public class FL_ELearning_Trans_ExportQuestionBank extends BaseClass{

	public FL_ELearning_Trans_ExportQuestionBank(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Export Question Bank") private WebElement exportQuestionBank_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement course_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlQuestionType") private WebElement questionType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowGrid") private WebElement showQuestionsToExport_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_imgbutExporttoexcel") private WebElement exportToExcel_btn;
	
	
	public FL_ELearning_Trans_ExportQuestionBank click_exportQuestionBank_link() {
		System.out.println("Click on Export Question Bank Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				exportQuestionBank_link
				);

		// Optionally, interact with the target element
		click(exportQuestionBank_link);
		//attendanceEmailTrigger_link.click();
		
		return this;
	}

	public FL_ELearning_Trans_ExportQuestionBank select_course() {
		Select opt = new Select(course_dropdown);
		opt.selectByVisibleText("IAC 3503 - Workshop - V");
		return this;
	}
	
	public FL_ELearning_Trans_ExportQuestionBank select_questionType() {
		Select opt = new Select(questionType_dropdown);
		opt.selectByVisibleText("Objective Type");
		return this;
	}
	
	public FL_ELearning_Trans_ExportQuestionBank click_showQuestionsToExport() {
		showQuestionsToExport_btn.click();
		return this;
	}
	public FL_ELearning_Trans_ExportQuestionBank click_exportToExcel() {
		exportToExcel_btn.click();
		return this;
	}
	public FL_ELearning_Trans_ExportQuestionBank login() {
	System.out.println("Enter UserName -> 2021008");
	driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
//	Thread.sleep(2000);
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
	
	System.out.println("Elearning-> Transactions-> Export question bank");
	return this;
	}
}
