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

public class SL_ELearning_View_ViewStudAssignmentFlow03_2 extends BaseClass{

	public SL_ELearning_View_ViewStudAssignmentFlow03_2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "E- Learning")
	private WebElement ELearning;
	
	@FindBy(linkText = "Transactions")
	private WebElement Transactions;
	
	@FindBy(linkText = "View")
	private WebElement View;
	
	@FindBy(linkText = "View Student Assignment")
	private WebElement ViewStudentAssignment;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement SelectCourseClickOk;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssignment_ctrl0_btnEdit")
	private WebElement EditIcon;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement ReplyButton;
	
	@FindBy(id = "cke_show_borders")
	private WebElement ReplyText;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnBackPage")
	private WebElement Back;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 HoverElearningTest() {
		System.out.println("Hover on E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 ClickTransactionsTest() {
		System.out.println("click on Transactions");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 SelectCourseTest() throws Throwable {
		System.out.println("Select Course");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022 - School of Social Sciences and Humanities (Sem - VI)");
		
		Thread.sleep(2000);
		Course.click();
		System.out.println("click on course");
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		System.out.println("click on Ok");
		
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 ClickViewTest() {
		System.out.println("click on View");
		action.moveToElement(View).click().perform();
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 ClickViewStudentAssignmentTest() {
		System.out.println("click on View Student Assignment");
		click(ViewStudentAssignment);
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 SearchButtonTest() throws Throwable {
		System.out.println("Enter in Search ");
		Thread.sleep(2000);
		WebElement Search = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		Search.clear();
		Search.sendKeys("Automation");
		
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 EditButtonTest() {
		System.out.println("click on Edit Button");
		click(EditIcon);
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 ClickReplyTest() throws Throwable {
		System.out.println("click on Reply");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", ReplyButton);
		Thread.sleep(2000);
		click(ReplyButton);
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 EnterReplyTest() throws Throwable {
		System.out.println("Enter Reply");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", ReplyText);
		switchToFrame(2);
		System.out.println("Inside Frame");
		ReplyText.clear();
		ReplyText.sendKeys("AssignmenT Done");	
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");
		return this;
	}
	
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 BackButtonTest() throws Throwable {
		System.out.println("click on View");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", Back);
		Thread.sleep(2000);
		click(Back);
		return this;
	}
	public SL_ELearning_View_ViewStudAssignmentFlow03_2 login() {
	//Thread.sleep(1000);
	System.out.println("Enter UserName -> 191291601067");
	driver.findElement(By.id("txt_username")).sendKeys("191291601067"); 

	//Thread.sleep(1000);
	System.out.println("Enter Password -> Admin@12345");
	driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

	///// captchaHandle();
	//Thread.sleep(2000);
	System.out.println("Enter Master Captcha ->4321");
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
