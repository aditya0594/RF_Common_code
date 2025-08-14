package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class SL_ELearning_Trans_ViewLectureNotesFlow02_3 extends BaseClass{

	public SL_ELearning_Trans_ViewLectureNotesFlow02_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_dropdown;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_button;
	@FindBy(linkText = "View Lecture Notes") private WebElement viewLectureNotes_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvNotes_ctrl0_btnEdit") private WebElement edit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttachments_ctrl0_imgbtnPreview") private WebElement download_button;
	
	
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 select_session() {
		System.out.println("Select Course");
		Select sesn_typ = new Select(session_dropdown);
		sesn_typ.selectByValue("214");
		System.out.println("select Session ->May 2022 - School of Social Sciences and Humanities  (Sem - VI)");
		
		return this;
	}
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 select_course() {
	
		course_dropdown.click();
		System.out.println("Select Course");
		ok_button.click();
		System.out.println("Click OK");
		return this;
	}
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 click_viewLectureNotes_link() {
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(viewLectureNotes_link).click().perform();
		System.out.println("View Lecture Notes submenu selected");
		return this;
	}
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 click_edit_button() {
		edit_button.click();
		System.out.println("click edit button");
		return this;
	}
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 click_download_button() {
		download_button.click();
		System.out.println("Click on download button");
		return this;
	}
	public SL_ELearning_Trans_ViewLectureNotesFlow02_3 login() {
//	Thread.sleep(2000);
	System.out.println("Enter UserName ->  191291601067"); //100 -> Student
	driver.findElement(By.id("txt_username")).sendKeys("191291601067");
	//191291601067

	System.out.println("Enter Password -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");
	// Thread.sleep(2000);

	// captchaHandle();
	System.out.println("Enter Master Captcha -> 4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

	//Thread.sleep(2000);
	System.out.println("Press Login Button");
	driver.findElement(By.id("btnLogin")).click();
	
	System.out.println("Student logged in succeessfully");
	
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
	
}
