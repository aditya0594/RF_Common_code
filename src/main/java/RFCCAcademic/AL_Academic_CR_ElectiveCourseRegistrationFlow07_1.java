package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 extends BaseClass{


	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(linkText = "Elective Course Registration") private WebElement electiveCourseRegistration_link;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container") private WebElement college_dropdown;
	@FindBy(className = "select2-search__field") private WebElement searchfield;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container") private WebElement session_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container") private WebElement semester_dropdown;
	@FindBy(xpath = "//button[@title='None selected']") private WebElement section_dropdown;
	@FindBy(xpath = "//label[normalize-space()='A']") private WebElement section_option;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlParentGroup") private WebElement coursesegment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlcourselist") private WebElement electiveCourse_dropdown;
	
	@FindBy(id = "FilterData") private WebElement searchStudent_inputfield;
	@FindBy(xpath = "//div[@class='input-group-addon']") private WebElement searchIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl1_cbRow") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement report_button;
	
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 click_electiveCourseReg_link() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", electiveCourseRegistration_link);
		electiveCourseRegistration_link.click();
		System.out.println("Click on Faculty Advisor Allotment from sub menu");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_college() {
		college_dropdown.click();
		searchfield.sendKeys("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)", Keys.ENTER);
		System.out.println(" Select college and scheme ");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_session() {
		session_dropdown.click();
		searchfield.sendKeys("May 2022", Keys.ENTER);
		System.out.println("Select session");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_semester() {
		semester_dropdown.click();
		searchfield.sendKeys("IV", Keys.ENTER);
		System.out.println("Select semester");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_section() throws InterruptedException {
		section_dropdown.click();
		Thread.sleep(2000);	
		section_option.click();
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 click_show_button() {
		show_button.click();
		//driver.findElement(By.className("select2-search__field")).sendKeys(Keys.DOWN, Keys.ENTER);
		System.out.println("Click show student button");
		return this;
	}
	
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 Select_CourseSegment() {
		System.out.println("Course segment -> Normal Elective");
		Select course = new Select(coursesegment);
		course.selectByVisibleText("Normal Elective");
		return this;
	}
	
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_OfferedCourse() {
		System.out.println("Offered course-> CECX 03-Principles of Architecture - Elective I");
		Select course = new Select(electiveCourse_dropdown);
		course.selectByVisibleText("CECX 03-Principles of Architecture - Elective I");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 search_student() {
		searchStudent_inputfield.sendKeys("200011602008");
		System.out.println("Search student -> 200011602008");
		return this;
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 click_searchIcon() {
		js.executeScript("arguments[0].click();", searchIcon);

		System.out.println("click Search icon");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 select_checkbox() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",checkbox);
	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkbox);
	
		System.out.println("click check box from grid");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 click_submit_button() {
		js.executeScript("arguments[0].click();", submit_button);
		System.out.println("click submit button");
		return this;
	}
	public AL_Academic_CR_ElectiveCourseRegistrationFlow07_1 click_report_button() {
		js.executeScript("arguments[0].click();", report_button);
		System.out.println(" Click on Registration Slip Report button");
		return this;
	}
	

}
