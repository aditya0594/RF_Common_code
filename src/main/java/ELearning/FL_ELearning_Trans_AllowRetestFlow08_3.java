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

public class FL_ELearning_Trans_AllowRetestFlow08_3 extends BaseClass {

	public FL_ELearning_Trans_AllowRetestFlow08_3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "E- LEARNING")
	private WebElement ELearning;
	
	@FindBy(linkText = "Transactions")
	private WebElement Transactions;
	
	@FindBy(linkText = "Select Course")
	private WebElement SelectCourse;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement SelectCourseClickOk;
	
	@FindBy(xpath = "(//span[contains(text(),'AR AY 107 - Landscape Architecture - [M.Arch.] -')])[1]")
	private WebElement Course;
	
	@FindBy(linkText = "Allow Retest")
	private WebElement AllowRetest;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_Ddlsession")
	private WebElement session;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree")
	private WebElement degree;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch")
	private WebElement branch;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme")
	private WebElement scheme;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem")
	private WebElement semister;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse")
	private WebElement course;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlTest-container")
	private WebElement selecttest;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement selecttestsearch;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchstudent;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvretest_ctrl0_chkstatus")
	private WebElement studentchkbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;
	
	
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Login_Faculty() throws InterruptedException {
		System.out.println("Login by Faculty");
		Thread.sleep(1000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008"); 

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		threadWait1();
		System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		threadWait1();
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
		
		System.out.println("Faculty Logged in Successfully.");
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 SelectCourseTest() throws Exception {
		System.out.println("Select Course => May 2022 - Crescent School of Architecture");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022 - Crescent School of Architecture");
		
		Thread.sleep(2000);
		Course.click();
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Click_AllowRetest() throws Throwable {
		System.out.println("Click on Allow Retest");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", AllowRetest);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AllowRetest);

		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Session() throws Throwable {
		System.out.println("Select Session => May 2022 - Crescent School of Architecture");
		
		Thread.sleep(2000);
		Select sessionSelect = new Select(session);
		sessionSelect.selectByVisibleText("May 2022 - Crescent School of Architecture");
		
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Degree() throws Throwable {
		System.out.println("Select Degree => Master of Architecture");
		
		Thread.sleep(2000);
		Select degreeSelect = new Select(degree);
		degreeSelect.selectByVisibleText("Master of Architecture");
		
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Branch() throws Throwable {
		System.out.println("Select Branch => Architecture");
		Thread.sleep(2000);
		Select branchSelect = new Select(branch);
		branchSelect.selectByVisibleText("Architecture");
		
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Scheme() throws Throwable {
		System.out.println("Select Scheme => M.Arch.-Architecture-2018-19-Crescent School of Architecture (Old Scheme)");
		
		Thread.sleep(2000);
		Select schemeSelect = new Select(scheme);
		schemeSelect.selectByVisibleText("M.Arch.-Architecture-2018-19-Crescent School of Architecture (Old Scheme)");
		
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Semester() throws Throwable {
		System.out.println("Select Semester => II");
		Thread.sleep(2000);
		Select semesterSelect = new Select(semister);
		semesterSelect.selectByVisibleText("II");
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Course() throws Throwable {
		System.out.println("Select Course => AR AY 107 - Landscape Architecture");
		Thread.sleep(2000);
		Select courseSelect = new Select(course);
		courseSelect.selectByVisibleText("AR AY 107 - Landscape Architecture");
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Select_Test() throws Throwable {
		System.out.println("Select Test => Automation Selenium Test      (OBJECTIVE)");		
		Thread.sleep(2000);
		click(selecttest);
		sendKeys(selecttestsearch, "Selenium Automation Test");
		selecttestsearch.sendKeys(Keys.ENTER);	
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 Search_SelectStudent() throws Throwable {
		System.out.println("Search student => 210030101001 and Click on check box");		
		sendKeys(searchstudent, "210030101001");
		Thread.sleep(2000);
		click(studentchkbox);
		return this;
	}
	
	public FL_ELearning_Trans_AllowRetestFlow08_3 SubmitButtonTest() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Submit);	
		Thread.sleep(2000);
		Submit.click();
		return this;
	}
}
