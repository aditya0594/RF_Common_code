package ELearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

public class FL_ELearning_Trans_CreateSyllabusFlow02_1 extends BaseClass{

	public FL_ELearning_Trans_CreateSyllabusFlow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement selectCourse_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_link;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_button;
	@FindBy(linkText = "Create Syllabus") private WebElement createSyllabus_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtUnit") private WebElement unit_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTopic") private WebElement topic_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuSyllabus") private WebElement chooseFile_btn;
	@FindBy(className = "CSS1Compat") private WebElement description_inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_btn;
	
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_selectCourse_Link() {
		System.out.println("Click on Select Course from submenu");
		Actions action = new Actions(driver);
		action.moveToElement(selectCourse_Link);
		action.click().build().perform();
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 select_Session() {
		System.out.println("Select Session -> May 2022 - School of Social Sciences and Humanities");
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_Course() {
		System.out.println("Select Course");
		click(course_link);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_ok_Btn() {
		System.out.println("Click OK Button");
		click(ok_button);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_createSyllabus_Link() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("Create Syllabus submenu selected");
		js.executeScript("arguments[0].scrollIntoView();",createSyllabus_Link);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createSyllabus_Link);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 select_Unit() {
		unit_dropdown.sendKeys("Unit 1");
		System.out.println("Enter Unit-> Unit1");
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 select_topic() {
		topic_dropdown.sendKeys("Income Tax Law");
		System.out.println("Enter topic -> Income Tax Law");
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_chooseFile_btn() throws FileNotFoundException {
		System.out.println("Upload File");
		String filename = "bcom-syllabus.pdf";
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"documentsForTesting"+File.separator+filename;
		//FileInputStream file=new FileInputStream(path);
		chooseFile_btn.sendKeys(path);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 enter_description() {
		System.out.println("Enter the description");
		description_inputbox.sendKeys("Income Tax Law Syllabus");
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabusFlow02_1 click_submit_button() {
		System.out.println("click submit button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submit_btn);
		submit_btn.click();
			return this;
		}

}
