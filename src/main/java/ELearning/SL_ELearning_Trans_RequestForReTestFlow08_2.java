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

public class SL_ELearning_Trans_RequestForReTestFlow08_2 extends BaseClass{

	public SL_ELearning_Trans_RequestForReTestFlow08_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Request For ReTest") private WebElement requestForRetest_link;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container") private WebElement mainsession;
	@FindBy(xpath = "//input[@class='select2-search__field']") private WebElement mainsessionsearch;
	@FindBy(xpath = "//span[contains(text(),'AR AY 107 - Landscape Architecture -')]") private WebElement selectcourse;

	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")private WebElement Course;
	@FindBy(xpath = "(//tr[@class='odd']/td/span)[1]")private WebElement checkbox;
	@FindBy(xpath = "//button[normalize-space()='OK']")private WebElement SelectCourseClickOk;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourse_ctrl4_ddlTest")private WebElement test_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")private WebElement submit_btn;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")private WebElement sessionselect;
	@FindBy(xpath = "//input[@class='select2-search__field']")private WebElement sessionsearch;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")private WebElement searchcourse;

	
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 Login_Student() throws InterruptedException {
		System.out.println("Student Login");
		System.out.println("Enter UserName ->  210030101001  (Bhavani S)"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("210030101001");  
		//191291601067

		System.out.println("Enter Password UAT -> admin@123 || Live -> Samsung@50 ");
		driver.findElement(By.id("txt_password")).sendKeys("admin@123");
		// threadWait1();

		// captchaHandle();
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		//threadWait1();
		System.out.println("Press Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
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
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 SelectCourseTest() throws Exception {
		System.out.println("Select Course => May 2022 - Crescent School of Architecture  (Sem - II)");
		click(mainsession);
		sendKeys(mainsessionsearch, "May 2022 - Crescent School of Architecture  (Sem - II)");
		mainsessionsearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		click(selectcourse);
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 click_requestForRetest_link() throws InterruptedException {
		System.out.println("Click on Request For Retest");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",requestForRetest_link);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", requestForRetest_link);


		return this;
	}
	
	
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 select_session() throws Exception {
		System.out.println("Select Session");
		click(sessionselect);
		sendKeys(sessionsearch, "May 2022 - Crescent School of Architecture");
		sessionsearch.sendKeys(Keys.ENTER);
		return this;
	}
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 Search_Course() throws Exception {
		System.out.println("Search Course => 107");
		sendKeys(searchcourse, "107");
		
		return this;
	}
	
	public SL_ELearning_Trans_RequestForReTestFlow08_2 click_checkbox() throws Exception {
		System.out.println("Click checkbox");
		checkbox.click();
		return this;
	}
	public SL_ELearning_Trans_RequestForReTestFlow08_2 select_test() throws Exception {
		System.out.println("Select Test");
		Select typ_sessn = new Select(test_dropdown);
		typ_sessn.selectByVisibleText("Selenium Automation Test");
		return this;
	}
	public SL_ELearning_Trans_RequestForReTestFlow08_2 click_submit_btn() throws Exception {
		System.out.println("Click Submit Button");
		submit_btn.click();
		return this;
	}
}
