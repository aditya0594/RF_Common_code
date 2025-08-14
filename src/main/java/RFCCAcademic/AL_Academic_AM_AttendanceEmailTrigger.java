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

public class AL_Academic_AM_AttendanceEmailTrigger extends BaseClass{

	public AL_Academic_AM_AttendanceEmailTrigger(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl14_lbLink") private WebElement attendanceEmailTrigger_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchoolInstitute") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodate") private WebElement toDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendEmailtostudent") private WebElement sendEmailToStudent_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttStatus_ctrl1_chkRows") private WebElement chekcbox;

	
	public AL_Academic_AM_AttendanceEmailTrigger click_attendanceEmailTrigger_link() 
	{
		System.out.println("Click Redo Course Regestration List Report Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				attendanceEmailTrigger_link
				);

		// Optionally, interact with the target element
		click(attendanceEmailTrigger_link);
		//attendanceEmailTrigger_link.click();
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger select_session() 
	{
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger select_college() 
	{
		Select options = new Select(college_dropdown);
		options.selectByVisibleText("Crescent School of Law");
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger select_semester() 
	{
		Select options = new Select(semester_dropdown);
		options.selectByValue("2");
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger enter_fromDate() 
	{
		System.out.println("Enter From Date");
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].value = arguments[1]",fromDate_inputfield, "01/05/2021");
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger enter_toDate() 
	{
		System.out.println("Enter From Date");
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].value = arguments[1]",toDate_inputfield, "31/12/2022");
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger click_show_button() 
	{
		click(show_button);
		return this;
	}public AL_Academic_AM_AttendanceEmailTrigger click_checkbox() 
	{
		click(chekcbox);
		return this;
	}
	public AL_Academic_AM_AttendanceEmailTrigger click_sendEmailToStudent_button() 
	{
		click(sendEmailToStudent_button);
		return this;
	}
}
