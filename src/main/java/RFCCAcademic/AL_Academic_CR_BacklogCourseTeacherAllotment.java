package RFCCAcademic;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_BacklogCourseTeacherAllotment extends BaseClass{

	public AL_Academic_CR_BacklogCourseTeacherAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl21_lbLink") private WebElement backlogCourseTeacherAllotment_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoSelect_0") private WebElement backlogCourseTeacherAllotment_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBacklogCourse_ctrl0_chkCourseno") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBacklogCourse_ctrl0_ddlTeacher") private WebElement teacher_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBacklogCourse_ctrl3_chkCourseno") private WebElement scrollCheckbox;
	
	
	public AL_Academic_CR_BacklogCourseTeacherAllotment click_backlogCourseTeacherAllotment_link() 
	{
		System.out.println("Click on Backlog Course Teacher Allotment Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				backlogCourseTeacherAllotment_link
				);

		// Optionally, interact with the target element
		click(backlogCourseTeacherAllotment_link);

		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment click_backlogCourseTeacherAllotment_radioBtn() 
	{
		backlogCourseTeacherAllotment_radioBtn.click();
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment select_college() 
	{
		System.out.println("Select College");
		Select opt = new Select(college_dropdown);
		opt.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment select_session() 
	{
		System.out.println("Select Session");
		Select opt = new Select(session_dropdown);
		opt.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment click_show_button() 
	{
		System.out.println("Click on Show Button");
		show_button.click();
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment check_checkbox() 
	{
		System.out.println("Click on Course checkbox");
		checkbox.click();
		return this;
	}
	
	public AL_Academic_CR_BacklogCourseTeacherAllotment select_teacher() 
	{
		System.out.println("Select Teacher");
		Select opt = new Select(teacher_dropdown);
		if(opt.getFirstSelectedOption().getText().equals("2017029 - Mr. SHEIK FARID A"))
		{
			//opt.selectByVisibleText("NISHA - Dr NISHA  KHANAM");
			opt.selectByValue("11");
		}
		else {
			//opt.selectByVisibleText("2017029 - Mr. SHEIK FARID  A");
			opt.selectByValue("662");
		}
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment click_submit_btn() 
	{
		System.out.println("Click on Submit Button");
		submit_button.click();
		return this;
	}
	public AL_Academic_CR_BacklogCourseTeacherAllotment scroll_to_checkbox() 
	{
	//	System.out.println("Click on Admission Cancellation link");
		scrollCheckbox.click();
		return this;
	}
	
	
}
