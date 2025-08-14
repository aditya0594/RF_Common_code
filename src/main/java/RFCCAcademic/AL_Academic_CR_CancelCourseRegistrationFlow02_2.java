package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_CancelCourseRegistrationFlow02_2 extends BaseClass {

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl18_lbLink") private WebElement CancelCourseRegistration;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_rdoSingle'])[1]") private WebElement cancelsinglestudentregi;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionSingle") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemesterSingle") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRegNo") private WebElement RRNO;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowSingle") private WebElement showbtn;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbox;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//input[@type='checkbox']") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitSingle") private WebElement submitbtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;


	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Click_CancelCourseRegistration() throws Exception {
		System.out.println("Click on Cancel Course Registration");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();",CancelCourseRegistration);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CancelCourseRegistration);
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Click_CancelSingleStudentCourseRegistration() {
		System.out.println("Click on Cancel Single Student Course Registration");
		click(cancelsinglestudentregi);
		return this; 
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Select_Session() throws InterruptedException {
		System.out.println("Select Session -> May 2022");
		Select select = new Select(session);
		select.selectByValue("10");
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Select_Semester() {
		System.out.println("Select Semester => IV");
		Select select = new Select(semister);
		select.selectByVisibleText("IV");
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Enter_RRNO() {
		System.out.println("Enter RRNO => 200101601017");
		RRNO.sendKeys("200101601017");
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 ShowButton() {
		System.out.println("Click on Show Button");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Search_Subject() {
		System.out.println("Search Subject => ARC 2205");
		searchbox.sendKeys("ARC 2205");
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Click_ChechBox() {
		System.out.println("Click on Select ChechBox");
		click(chkbox);
		return this;
	}

	public AL_Academic_CR_CancelCourseRegistrationFlow02_2 Click_SubmitButton() {
		System.out.println("Click on Submit Button");
		click(submitbtn);
		return this;
	}

}