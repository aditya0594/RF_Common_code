package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateLectureNotesFlow02_2 extends BaseClass{

	public FL_ELearning_Trans_CreateLectureNotesFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_dropdown;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement Ok_button;
	@FindBy(linkText = "Create LectureNotes") private WebElement createLectureNotes_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlTopic") private WebElement topic_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject") private WebElement subtopic_dropdown;
	@FindBy(css = "#ctl00_ContentPlaceHolder1_fileUploader") private WebElement fileuploader;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAttachFile") private WebElement attachFile_button;
	@FindBy(className = "cke_show_borders") private WebElement description;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	

	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 select_session() {
		System.out.println("select Session");
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 select_course() {
		course_dropdown.click();
		System.out.println("Select Course");
		Ok_button.click();
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 click_CreateLectureNotes_link() {
		Actions action = new Actions(driver);
		System.out.println("Create LectureNotes submenu selected");
		action.moveToElement(createLectureNotes_link);
		action.click().build().perform();
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 select_topic() {
		Select topic_typ = new Select(topic_dropdown);
		topic_typ.selectByVisibleText("Income Tax Law");
		System.out.println("Topic -> Income Tax Law");
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 enter_subTopic() {
		subtopic_dropdown.sendKeys("Income Tax Announcement");
		System.out.println("Sub Topic-> Income Tax Announcement");
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 click_fileUploader() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//WebElement file = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_fileUploader"));
		executor.executeScript("arguments[0].click();", fileuploader);
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 click_attachFile_button() {
		attachFile_button.click();
		System.out.println("Click on Attach");
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 enter_description() {
		description.sendKeys("Income Tax Law Syllabus");
		return this;
	}
	public FL_ELearning_Trans_CreateLectureNotesFlow02_2 click_submit_button() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", submit_button);
		submit_button.click();
		return this;
	}
	

}
