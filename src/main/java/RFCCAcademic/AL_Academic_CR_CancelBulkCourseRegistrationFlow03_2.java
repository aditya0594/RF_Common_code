package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 extends BaseClass
{
	@FindBy(linkText = "Cancel Course Registration") private WebElement CancelCourseRegistration;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoMultiple") private WebElement cancelBulkstudentregi;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container") private WebElement session;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement sessionsearchbox;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDepartment-container") private WebElement department;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement departmentsearchbox;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container") private WebElement collegescheme;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement collegeschemesearchbo;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container") private WebElement semister;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement semistersearchbox;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSubject-container") private WebElement course;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement coursesearchbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbar;
	@FindBy(xpath = "//div[@class='table-responsive']//td//input") private WebElement chkboxsel;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;


	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;


	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Click_CancelCourseRegistration() throws Exception {
		System.out.println("Click on Cancel Course Registration");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();",CancelCourseRegistration);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CancelCourseRegistration);
		return this;
	}

	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Click_CancelBulkStudentCourseRegistration() {
		System.out.println("Click on Cancel Bulk Student Course Registration");
		click(cancelBulkstudentregi);
		return this; 
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Select_Session() throws InterruptedException {
		System.out.println("Session -> DEC 2021");
		session.click();
		sendKeys(sessionsearchbox, "DEC 2021");
		sessionsearchbox.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Select_CollegeAndScheme() throws Exception {
		System.out.println("Select College and Scheme => SCIMS - B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		collegescheme.click();
		collegeschemesearchbo.sendKeys(
				"SCIMS - B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		collegeschemesearchbo.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Select_Department() {
		System.out.println("Select Department => Department of Computer Science and Engineering");
		department.click();
		departmentsearchbox.sendKeys("Department of Computer Science and Engineering");
		departmentsearchbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Select_Semester() {
		System.out.println("Select semister => VII");
		semister.click();
		semistersearchbox.sendKeys("VII");
		semistersearchbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Select_Course() {
		System.out.println("Select Course => CSC 4102 - Compiler Design");
		course.click();
		coursesearchbox.sendKeys("CSC 4102 - Compiler Design");
		coursesearchbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Click_ShowBtn() {
		System.out.println("Click on Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Search_Student_Click_Chkbox() throws InterruptedException {
		System.out.println("Search Student => 190071601003 and  Click Chkbox");
		sendKeys(searchbar, "190071601003");
		threadWait1();
		click(chkboxsel);
		return this;
	}
	
	public AL_Academic_CR_CancelBulkCourseRegistrationFlow03_2 Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit Btn");
		click(submitbtn);
		return this;
	}
}
