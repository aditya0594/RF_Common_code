package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_AM_FacultyAttendanceStatus extends BaseClass{

	public AL_Academic_AM_FacultyAttendanceStatus(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Faculty Attendance Status") private WebElement facultyAttendanceStatus_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchoolInstitute") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubject") private WebElement course_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlFaculty-container") private WebElement faculty_dropdown;
	@FindBy(className = "select2-search__field") private WebElement searchField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAttReport") private WebElement facultywiseAttendanceStatus_btn;
	@FindBy(xpath = "//*[@id=\"trCurRow\"][1]/td[6]") private WebElement verifyrecord;
	
	

	JavascriptExecutor js = (JavascriptExecutor)driver;

	public AL_Academic_AM_FacultyAttendanceStatus click_facultyAttendanceStatus_Link() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", facultyAttendanceStatus_Link);
		Thread.sleep(2000);	
		js.executeScript("arguments[0].click();",facultyAttendanceStatus_Link );	
		System.out.println("Click on Faculty Attendance Status from sub menu");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_College() {
		Select clg = new Select(college_dropdown);
		clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("Select College&Scheme");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_Session() {
		Select sesn = new Select(session_dropdown);
		sesn.selectByVisibleText("Dec 2022");
		System.out.println("Select Session");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_Department() {
		Select dpt = new Select(department_dropdown);
		dpt.selectByVisibleText("Department of Civil Engineering");
		System.out.println("Select Department");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_Semester() {
		Select sem = new Select(semester_dropdown);
		sem.selectByVisibleText("VIII");
		System.out.println("Select Semester");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_section() {
		Select sectn = new Select(section_dropdown);
		sectn.selectByVisibleText("A");
		System.out.println("select section");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_course() {
		Select crs = new Select(course_dropdown);
		crs.selectByVisibleText("CEC 1211 - Engineering Geology");
		System.out.println("Select Course");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus select_faculty() {
		faculty_dropdown.click();
		searchField.sendKeys(Keys.DOWN, Keys.ENTER);
		System.out.println("Select Faculty");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus click_facultywiseAttendanceStatus_button() {
		click(facultywiseAttendanceStatus_btn);
		System.out.println("Click on Faculty Attendance status button");
		return this;
	}
	public AL_Academic_AM_FacultyAttendanceStatus VerifySearchedRecords() {
		String Expected_Msg = "Mr. IBRAHIM Y"; 
		String Actual_Msg = verifyrecord.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		return this;
	}}
