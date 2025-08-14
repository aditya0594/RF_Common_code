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

public class FL_ELearning_Trans_CreateQuestionBankFlow04_1 extends BaseClass {

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1(WebDriver driver) {
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

	@FindBy(id = "ctl00_ContentPlaceHolder1_rbnObjectiveDescriptive_0")
	private WebElement QuestionTypeRadio;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtNewTopic")
	private WebElement TopicName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;

	@FindBy(linkText = "Create Question Bank")
	private WebElement CreateQuestionBnak;

	/*
	 * @FindBy(className = "cke_show_borders") private WebElement InsideFrame;
	 */
	@FindBy(xpath = "//*[@id=\"cke_contents_ctl00_ContentPlaceHolder1_txtQuestion\"]/iframe")
	private WebElement InsideFrame;
	
	@FindBy(xpath = "//*[@id=\"cke_contents_ctl00_ContentPlaceHolder1_txtAnswer1\"]/iframe")
	private WebElement InsideFrame1;
	
	@FindBy(xpath = "//*[@id=\"cke_contents_ctl00_ContentPlaceHolder1_txtAnswer2\"]/iframe")
	private WebElement InsideFrame2;
	
	@FindBy(xpath = "//*[@id=\"cke_contents_ctl00_ContentPlaceHolder1_txtAnswer3\"]/iframe")
	private WebElement InsideFrame3;
	
	@FindBy(xpath = "//*[@id=\"cke_contents_ctl00_ContentPlaceHolder1_txtAnswer4\"]/iframe")
	private WebElement InsideFrame4;
	

	@FindBy(xpath = "/html/body/p")
	private WebElement QuestionBnak;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit;

	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 switchtoiframe() {
		System.out.println("Switch to iframe");
		driver.switchTo().frame(InsideFrame);
		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 HoverELearningTest() {
		System.out.println("Hover to E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 SelectCourseTest() throws Exception {
		System.out.println("Select Course");

		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("DEC 2018 - Crescent School of Architecture");

		Thread.sleep(2000);
		Course.click();

		Thread.sleep(2000);
		SelectCourseClickOk.click();

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 ClickCreateQuestionBankPageTest() throws Throwable {
		System.out.println("Click on Create Question Bank Page");

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", CreateQuestionBnak);
		Thread.sleep(2000);
		// CreateAssignment.click();
		js.executeScript("arguments[0].click();", CreateQuestionBnak);

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 ClickQuestionTypeRadioTest() throws Throwable {
		System.out.println("Click Question Type Radio Button");
		Thread.sleep(2000);
		QuestionTypeRadio.click();

		if (QuestionTypeRadio.isSelected()) {
			System.out.println("Radio button is selected.");
		} else {
			System.out.println("Radio button is not selected.");
		}
		System.out.println("Text radio selected");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterTopicNameTest() {
		System.out.println("Enter Topic Name");

		TopicName.clear();
		TopicName.sendKeys("Designing");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterQuestionTest() throws Throwable {
		System.out.println("Enter Question");

		Thread.sleep(2000);
		/* switchToFrame(2); */
		System.out.println("Inside Frame");

		WebElement body = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		//body.clear(); // Clear any existing text
		body.sendKeys("Which of these are the content for SAD?");

		// QuestionBnak.sendKeys("Which of these are the content for SAD?");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Assignment Description -> Which of these are the content for SAD?");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterAnswerOption1Test() throws Throwable {
		System.out.println("Enter Anser  Option 1 ");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		//switchToFrame(4);
		driver.switchTo().frame(InsideFrame1);
		System.out.println("Inside Frame");
		WebElement body = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		body.sendKeys("Product Overview");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 1 ->Product Overview ");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterAnswerOption2Test() throws Throwable {
		System.out.println("Enter Anser  Option 2 ");

		//switchToFrame(5);
		driver.switchTo().frame(InsideFrame2);
		System.out.println("Inside Frame");
		WebElement body = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		body.sendKeys("Architectural Models");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 2 ->Architectural Models ");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterAnswerOption3Test() throws Throwable {
		System.out.println("Enter Anser  Option 3 ");

		//switchToFrame(6);
		driver.switchTo().frame(InsideFrame3);
		System.out.println("Inside Frame");
		WebElement body = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		body.sendKeys("Architectural design rationale");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 3 ->Architectural design rationale");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 EnterAnswerOption4Test() throws Throwable {
		System.out.println("Enter Anser  Option 4 ");

		//switchToFrame(7);
		driver.switchTo().frame(InsideFrame4);
		System.out.println("Inside Frame");
		WebElement body = driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		body.sendKeys(" All of the mentioned");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Test Ans Option 4 ->  All of the mentioned");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 SelectCorrectAnswerTest() {
		System.out.println("Select Correct Answer");

		WebElement ans = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCorrectAns"));
		Select ans_typ = new Select(ans);
		ans_typ.selectByVisibleText("Answer 4");

		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 SubmitButtonTest() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Submit);
		Thread.sleep(2000);
		Submit.click();
		return this;
	}

	public FL_ELearning_Trans_CreateQuestionBankFlow04_1 login() {
		// Thread.sleep(1000);
		System.out.println("Enter UserName -> 2021008");
		driver.findElement(By.id("txt_username")).sendKeys("2021008");

		// Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");

		///// captchaHandle();
//	Thread.sleep(2000);
		System.out.println("Enter Master Captcha -> UAT - >4321 || Live -> 4321");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

//	Thread.sleep(2000);
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
			/*
			 * Thread.sleep(1000); WebElement closeButton = driver
			 * .findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"))
			 * ; if (closeButton != null && closeButton.isDisplayed()) {
			 * closeButton.click();
			 * System.out.println("Click on close button of, Notice Modal"); } else {
			 * System.out.println("Notice Modal close button is not prescent"); }
			 */
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("Element not found : " e.getMessage());
			System.out.println("Something went wrong");
		}

		System.out.println("Faculty Logged in Successfully.");
		return this;
	}
}
