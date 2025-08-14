package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageFaculty;

import utility.BaseClass;

public class FL_ELearning_Trans_CheckStudentAssignment extends BaseClass{

	public FL_ELearning_Trans_CheckStudentAssignment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement selectCourse_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(xpath = "(//span[contains(text(),'COC 3201 - Income Tax Law & Practice - II - [B.Com')])[1]") private WebElement course_link;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_button;
	@FindBy(linkText = "Check Student Assignment") private WebElement checkStudentAssignment_link;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement search;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssignment_ctrl0_btnStudeReply") private WebElement studentReply_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssignmentReply_ctrl0_btnEdit") private WebElement edit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMarks") private WebElement marks_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkChecked") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkDisplayMarks") private WebElement displayMarks_checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FL_ELearning_Trans_CheckStudentAssignment click_selectCourse_Link() {
		Actions action = new Actions(driver);
		action.moveToElement(selectCourse_Link);
		action.click().build().perform();
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment select_Session() {
		System.out.println("select Session");
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment select_course() {
		click(course_link);
		System.out.println("Select Course");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment click_oK_button() {
		click(ok_button);
		System.out.println("Click OK");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment click_checkStudentAssignment() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", checkStudentAssignment_link);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkStudentAssignment_link);
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment enter_search() {
		search.clear();
		search.sendKeys("Automation");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment click_studentReply() {
		click(studentReply_button);
		System.out.println("click student reply");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment click_edit_button() {
		click(edit_button);
		System.out.println("Click on Edit");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment enter_marks() {
		marks_inputfield.clear();
		marks_inputfield.sendKeys("15");
		System.out.println("Add Marks");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment check_checkbox() {
		js.executeScript("arguments[0].scrollIntoView(true);",checkbox);
		click(checkbox);
		System.out.println("click on checked"); 
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment check_displayMarks_checkbox() {
		click(displayMarks_checkbox);
		System.out.println("click on display result to student");
		return this;
	}
	public FL_ELearning_Trans_CheckStudentAssignment click_submit_button() {
		click(submit_button);
		System.out.println("click submit");
		return this;
	}
}
