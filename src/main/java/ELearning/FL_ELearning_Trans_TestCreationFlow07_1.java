package ELearning;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_TestCreationFlow07_1 extends BaseClass {

	public FL_ELearning_Trans_TestCreationFlow07_1(WebDriver driver) {
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

	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;

	@FindBy(linkText = "Test Creation")
	private WebElement TestCreation;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnObjectiveTest")
	private WebElement ObjectiveTypeTest;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTestName")
	private WebElement TestName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStartDt")
	private WebElement StartDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_imgCalStartDt")
	private WebElement StartDateCalIcon;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_imgCalEndDt")
	private WebElement EndDateCalIcon;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ceStartDt_today")
	private WebElement CurrentStartDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDt")
	private WebElement EndDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ceEndDt_today")
	private WebElement CurrentEndDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TxtExamStartTime")
	private WebElement TestStartTime;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TxtExamEndTime")
	private WebElement TestEndTime;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTestDuration")
	private WebElement TestDuration;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAttempts")
	private WebElement NoofAttemptsAllowed;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lsvbindquestion_ctrl0_txtSelectQ")
	private WebElement Ratio;

	@FindBy(id = "ctl00_ContentPlaceHolder1_imgAddQuestions")
	private WebElement DownArrowImageAddMarks;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvTest_ctrl0_btnEdit")
	private WebElement EditIcon;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnViewTestReport")
	private WebElement testrpt;
	
	

	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FL_ELearning_Trans_TestCreationFlow07_1 HoverELearningTest() {
		System.out.println("Hover to E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 SelectCourseTest() throws Exception {
		System.out.println("Select Course");
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		Thread.sleep(2000);
		Course.click();
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 ObjectiveTypeTest() throws Throwable {
		System.out.println("Click on ObjectiveTypeTest");
		ObjectiveTypeTest.click();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 TestCreation() throws Throwable {
		System.out.println("Click on TestCreation");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", TestCreation);
		Thread.sleep(2000);
		// CreateAssignment.click();
		js.executeScript("arguments[0].click();", TestCreation);
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 ClickEditButtonTest() throws Throwable {
		System.out.println("Click on Edit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", EditIcon);
		Thread.sleep(2000);
		click(EditIcon);
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 TestName() throws Throwable {
		System.out.println("Test Name");
		 String baseName = "Test";
         String uniqueTestName = baseName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
 
         Thread.sleep(Wait);
         TestName.clear();
         TestName.sendKeys(uniqueTestName);
		
		
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 StartDate() throws Throwable {
		System.out.println("StartDate");
		//StartDate.clear();
		//StartDate.sendKeys("19/11/2024");
		StartDateCalIcon.click();
		
		Thread.sleep(2000);
		CurrentStartDate.click();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 EndDate() throws Throwable {
		System.out.println("EndDate");
		//EndDate.clear();
		//EndDate.sendKeys("20/11/2024");
		EndDateCalIcon.click();
		
		Thread.sleep(2000);
		CurrentEndDate.click();
		
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 TestStartTime() throws Throwable {
		System.out.println("TestStartTime");
		TestStartTime.clear();
		TestStartTime.sendKeys("11:00:00");
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 TestEndTime() throws Throwable {
		System.out.println("TestEndTime");
		TestEndTime.clear();
		TestEndTime.sendKeys("13:00:00");
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 TestDuration() throws Throwable {
		System.out.println("TestDuration");
		TestDuration.clear();
		TestDuration.sendKeys("01:00:00");
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 NoofAttemptsAllowed() throws Throwable {
		System.out.println("Test Name");
		NoofAttemptsAllowed.clear();
		NoofAttemptsAllowed.sendKeys("Test0");
		return this;
	}
	
	public FL_ELearning_Trans_TestCreationFlow07_1 Ratio() throws Throwable {
		System.out.println("Ratio");
		Ratio.clear();
		Ratio.sendKeys("1");
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 DownArrowImageAddMarks() throws Throwable {
		System.out.println("DownArrowImageAddMarks");
		//js.executeScript("arguments[0].scrollIntoView(true);", DownArrowImageAddMarks);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});",DownArrowImageAddMarks);
		Thread.sleep(2000);
		DownArrowImageAddMarks.click();
		return this;
	}

	public FL_ELearning_Trans_TestCreationFlow07_1 SubmitButtonTest() throws Throwable {
		System.out.println("Click On Submit Button");
		Submit.click();
		return this;
	}
	
	public FL_ELearning_Trans_TestCreationFlow07_1 TestReport() throws Throwable {
		System.out.println("Click On Test Report Button");
		click(testrpt);
		return this;
	}
	
	
	

}
