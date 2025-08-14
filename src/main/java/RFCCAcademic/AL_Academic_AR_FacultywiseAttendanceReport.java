package RFCCAcademic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AR_FacultywiseAttendanceReport extends BaseClass{

	public AL_Academic_AR_FacultywiseAttendanceReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl09_lbLink") private WebElement facultywiseAttendanceReport_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement depatment_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlFaculty") private WebElement faculty_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement toDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel") private WebElement facultywiseAttendanceReport;
	
	
	public AL_Academic_AR_FacultywiseAttendanceReport click_facultywiseAttendanceReport_link() 
	{
		click(facultywiseAttendanceReport_link);
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport select_session() 
	{
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("2023-2024");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport select_school() 
	{
		Select options = new Select(college_dropdown);
		options.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport select_department() 
	{
		Select options = new Select(depatment_dropdown);
		options.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport select_faculty() 
	{
		Select options = new Select(faculty_dropdown);
	//	options.selectByVisibleText("FATHIMA  A ( 2019152 )");
		options.selectByValue("1036");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport enter_fromDate() 
	{
		fromDate_inputfield.sendKeys("01/01/2019");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport enter_toDate() 
	{
		toDate_inputfield.sendKeys("01/01/2025");
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport click_show_button() 
	{
		click(show_button);
		return this;
	}
	public AL_Academic_AR_FacultywiseAttendanceReport click_facultywiseAttendanceReport_button() 
	{
		click(facultywiseAttendanceReport);
		return this;
	}
	
}
