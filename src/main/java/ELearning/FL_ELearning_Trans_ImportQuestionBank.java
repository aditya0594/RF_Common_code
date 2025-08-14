package ELearning;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_ImportQuestionBank extends BaseClass {

	public FL_ELearning_Trans_ImportQuestionBank(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Import Question Bank")
	private WebElement ImportQuestionBank_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlfileformate")
	private WebElement fileFormat_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuRFIDFILE")
	private WebElement fileUpload_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
	private WebElement show_button;
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lvBooksInLib\"]/tbody/tr[3]/td[2]")
	private WebElement text;

	public FL_ELearning_Trans_ImportQuestionBank click_ImportQuestionBank_link() {
		System.out.println("Click Redo Course Regestration List Report Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", menuScroll, ImportQuestionBank_link);

		// Optionally, interact with the target element
		click(ImportQuestionBank_link);
		// attendanceEmailTrigger_link.click();

		return this;
	}

	public FL_ELearning_Trans_ImportQuestionBank select_fileFormat() {
		Select opt = new Select(fileFormat_dropdown);
		opt.selectByVisibleText("Excel"); 
		return this;
	}

	public FL_ELearning_Trans_ImportQuestionBank upload_file() {

		// Thread.sleep(2000);
		Path relativePath = Paths.get(".\\src\\test\\resources\\documentsForTesting\\QUESTION.xls");
		String absolutePath = relativePath.toAbsolutePath().toString();
		sendKeys(fileUpload_btn, absolutePath);
		// .sendKeys(".\\RF_Common_Code_LIVE\\tessdata\\QUESTION.xls");
		return this;
	}

	public FL_ELearning_Trans_ImportQuestionBank click_show_button() {
		show_button.click();
		return this;
	}

	public String getTextFromElement() {
		return text.getText(); // Retrieves the text from the located element
	}
	
	public FL_ELearning_Trans_ImportQuestionBank login() {
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
