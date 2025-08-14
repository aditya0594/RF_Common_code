package ELearning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateElibraryFlow01_1 extends BaseClass{

	public FL_ELearning_Trans_CreateElibraryFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_dropdown;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement Ok_Button;
	@FindBy(linkText = "Create E-Library") private WebElement CreateELibrary_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtBTitle") private WebElement bookTitle_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAuthor") private WebElement bookAuthor_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPublisher") private WebElement publisherName_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_fileUploader") private WebElement file_Upload;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAttachFile") private WebElement attach_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_Button;
	
	public FL_ELearning_Trans_CreateElibraryFlow01_1 select_Session() {
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 select_Course() {
		course_dropdown.click();
		System.out.println("Select Course");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 Click_OkButton() {
		Ok_Button.click();
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 click_CreateELibrary() {
		System.out.println("Create E-Library submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(CreateELibrary_Link);
		action.click().build().perform();
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 enter_BookTitle() {
		bookTitle_Inputbox.sendKeys("Income Tax amd Law Practicee");
		System.out.println("Title-> Income Tax amd Law Practices");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 enter_BookAuthor() {
		bookAuthor_Inputbox.sendKeys("Bansal Anshikae");
		System.out.println("Author -> Bansal Anshikae");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 enter_PublisherName() {
		publisherName_Inputbox.sendKeys("Sultan Chand & Sonse");
		System.out.println("Publisher ->Sultan Chand & Sonse");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 upload_File() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", file_Upload);
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 click_Attach_Button() {
		attach_button.click();
		System.out.println("Click on Attach");
		return this;
	}
	public FL_ELearning_Trans_CreateElibraryFlow01_1 click_Submit_Button() {
		submit_Button.click();
		return this;
	}

}
