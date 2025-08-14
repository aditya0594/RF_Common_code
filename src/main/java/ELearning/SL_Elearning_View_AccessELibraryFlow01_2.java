package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class SL_Elearning_View_AccessELibraryFlow01_2 extends BaseClass{

	public SL_Elearning_View_AccessELibraryFlow01_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement courseSelection;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_btn;
	@FindBy(linkText = "Access e-Library") private WebElement accessELibrary_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvLibrary_ctrl0_btnEdit") private WebElement edit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttachments_ctrl0_UpdatePanel2") private WebElement download_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lblBookName") private WebElement bookName;
	
	
	public String getTextFromElement() {
		return bookName.getText(); // Retrieves the text from the located element
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 select_Session() {
		System.out.println("Select Course");
		Select sesn_typ = new Select(session_dropdown);
		sesn_typ.selectByValue("214");
		System.out.println("select Session ->May 2022 - School of Social Sciences and Humanities  (Sem - VI)");
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 select_Course() {
		click(courseSelection);
		System.out.println("Select Course");
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 click_OK_button() {
		click(ok_btn);
		System.out.println("Click OK");
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 click_accessELibrary() {
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(accessELibrary_Link).click().perform();
		System.out.println("Access e-Library submenu selected");
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 click_edit_btn() {
		click(edit_button);
		System.out.println("Click edit button");
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 click_download_arrow() {
		click(download_button);
		return this;
	}
	public SL_Elearning_View_AccessELibraryFlow01_2 login() {
	//Thread.sleep(2000);
	System.out.println("Enter UserName ->  191291601067"); //100 -> Student
	driver.findElement(By.id("txt_username")).sendKeys("191291601067");
	//191291601067

	System.out.println("Enter Password UAT -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");
	// Thread.sleep(2000);

	// captchaHandle();
	System.out.println("Enter Master Captcha ->4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321"); 

	//Thread.sleep(2000);
	System.out.println("Press Login Button");
	driver.findElement(By.id("btnLogin")).click();
	
	//Thread.sleep(1000);
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

	
	System.out.println("Student logged in succeessfully");
	return this;
	}
}
