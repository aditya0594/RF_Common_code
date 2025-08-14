package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.BaseClass;

public class FL_Academic_FR_CreateTeachingPlanFlow01_1 extends BaseClass {

	public FL_Academic_FR_CreateTeachingPlanFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Teaching Plan Entry")
	private WebElement teachingPlanEntry_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme")
	private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester")
	private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection")
	private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlUnitNo")
	private WebElement unitNo_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlLectureNo")
	private WebElement topicNo_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtLectureTopic")
	private WebElement descr_textarea;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSessionReq")
	private WebElement noOfSessionReq_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement submit_btn;
	@FindBy(linkText = "Create Teaching Plan")
	private WebElement createTeachingPlan_link;
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	private WebElement searchbox;
	@FindBy(xpath = "//tr[@class='odd']/td[3]")
	private WebElement text;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl06_btnlncardkSelect")
	private WebElement Course;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement SelectCourseClickOk;

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 click_teachingPlanEntry_link() {
		System.out.println("Click on Teaching Plan Entry Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", menuScroll, teachingPlanEntry_link);

		click(teachingPlanEntry_link);

		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 SelectCourseTest() throws Exception {
		System.out.println("Select Session");
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		// typ_sessn.selectByVisibleText("2023-2024 - Crescent School of Architecture");
		typ_sessn.selectByValue("203");
		Thread.sleep(2000);
		Course.click();

		Thread.sleep(2000);
		SelectCourseClickOk.click();

		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_session() {
		System.out.println("Select Session > May 2022");
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("May 2022");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_college() {
		System.out.println(
				"Select College > CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		Select options = new Select(college_dropdown);
		options.selectByVisibleText("CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_semester() {
		System.out.println("Select Semester > IV - Theory with Tutorial - CSA0AR1 - Engineering Drawing");
		Select options = new Select(semester_dropdown);
		options.selectByVisibleText("IV - Theory with Tutorial - CSA0AR1 - Engineering Drawing");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_section() {
		System.out.println("Select Section");
		Select options = new Select(section_dropdown);
		options.selectByVisibleText("A");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_unitNo() {
		System.out.println("Select Unit No. > 1");
		Select options = new Select(unitNo_dropdown);
		options.selectByVisibleText("1");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 select_topicNo() {
		System.out.println("Select Topic No. > 3");
		Select options = new Select(topicNo_dropdown);
		options.selectByVisibleText("3");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 enter_description() {
		System.out.println("Enter Description > Testing");
		descr_textarea.sendKeys("Testing");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 enter_numOfSessionRequired() {
		System.out.println("Enter number of session required > 1");
		noOfSessionReq_inputfield.sendKeys("1");
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 click_submit_btn() {
		System.out.println("Click submit button");
		submit_btn.click();
		return this;
	}

	public FL_Academic_FR_CreateTeachingPlanFlow01_1 login() {

		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008");

		//Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
		//Thread.sleep(3000);
		System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");
		//Thread.sleep(3000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

		// Thread.sleep(1000);
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
