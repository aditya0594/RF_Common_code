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

public class SL_ELearning_View_ViewSyllabusFlow02_5 extends BaseClass{

	public SL_ELearning_View_ViewSyllabusFlow02_5(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_link;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_button;
	@FindBy(linkText = "View Syllabus") private WebElement viewSyllabus_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnViewSyllabus") private WebElement viewSyllabus_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSyllabus_ctrl0_imgbtnPreview") private WebElement download_button;
	@FindBy(linkText = "Create Syllabus") private WebElement createSyllabus_Link;
	
	public SL_ELearning_View_ViewSyllabusFlow02_5 click_createSyllabus_Link() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("Create Syllabus submenu selected");
		js.executeScript("arguments[0].scrollIntoView();",createSyllabus_Link);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createSyllabus_Link);
		return this;
	}


	public SL_ELearning_View_ViewSyllabusFlow02_5 select_Session() {
		System.out.println("Select Course");
		WebElement sesn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select sesn_typ = new Select(sesn);
		sesn_typ.selectByValue("214");
		System.out.println("select Session ->May 2022 - School of Social Sciences and Humanities  (Sem - VI)");
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 select_Course() {
		click(course_link);
		System.out.println("Select Course");
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 clicl_ok_button() {
		click(ok_button);
		System.out.println("Click OK");
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 click_viewSyllabus_Link() {
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(viewSyllabus_Link).click().perform();
		System.out.println("View Syllabus submenu selected");
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 click_viewSyllabus_button() {
		/*
		 * System.out.println("Click on view syllabus button"); JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", viewSyllabus_button);
		 */
		scrollIntoElement(viewSyllabus_button);
		click(viewSyllabus_button);
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 click_download_button() {
		System.out.println("Click on download button");
		click(download_button);
		return this;
	}
	public SL_ELearning_View_ViewSyllabusFlow02_5 login() {	
	//Thread.sleep(2000);
	System.out.println("Enter UserName ->  191291601067"); //100 -> Student
	driver.findElement(By.id("txt_username")).sendKeys("191291601067");
	//191291601067
	//Thread.sleep(2000);
	System.out.println("Enter Password ->Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");
	// Thread.sleep(2000);
	//Thread.sleep(2000);
	// captchaHandle();
	System.out.println("Enter Master Captcha -> 4321");
	driver.findElement(By.id("txtcaptcha")).sendKeys("4321");
	
	//Thread.sleep(2000);
	System.out.println("Press Login Button");
	driver.findElement(By.id("btnLogin")).click();
	
//	Thread.sleep(1000);
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
