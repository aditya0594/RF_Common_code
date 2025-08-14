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

public class FL_ELearning_Trans_SizeConfigurationOfAttachments extends BaseClass {

	public FL_ELearning_Trans_SizeConfigurationOfAttachments(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Size Configuration of Attachments")
	private WebElement sizeConfigOfAttachments_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlUserType")
	private WebElement userType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvPageList_ctrl0_btnEdit")
	private WebElement edit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFileSize")
	private WebElement fileSize_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement submit_button;

	public FL_ELearning_Trans_SizeConfigurationOfAttachments click_sizeConfigOfAttachments_link() {
		System.out.println("Click on Size Config Of Attachments link");

		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", menuScroll, sizeConfigOfAttachments_link);

		// Optionally, interact with the target element
		click(sizeConfigOfAttachments_link);
		return this;
	}

	public FL_ELearning_Trans_SizeConfigurationOfAttachments select_userType() {
		Select options = new Select(userType_dropdown);
		options.selectByVisibleText("Faculty");
		return this;
	}

	public FL_ELearning_Trans_SizeConfigurationOfAttachments click_edit_btn() {
		edit_btn.click();
		return this;
	}

	public FL_ELearning_Trans_SizeConfigurationOfAttachments enter_fileSize() {
		fileSize_inputfield.clear();
		fileSize_inputfield.sendKeys("3");
		return this;
	}

	public FL_ELearning_Trans_SizeConfigurationOfAttachments click_submit_btn() {
		submit_button.click();
		return this;
	}

	public FL_ELearning_Trans_SizeConfigurationOfAttachments login() {
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008");

	//	Thread.sleep(1000);
		System.out.println("Enter Password Live -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
	//	Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

	//	Thread.sleep(1000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

	//	Thread.sleep(1000);
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
			Thread.sleep(2000);
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"notice\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed()) {
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			} else {
				System.out.println("Notice Modal close button is not prescent");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		}

		return this;
	}

}
