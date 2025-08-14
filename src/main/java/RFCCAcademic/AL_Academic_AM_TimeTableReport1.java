package RFCCAcademic;

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

public class AL_Academic_AM_TimeTableReport1 extends BaseClass{

	public AL_Academic_AM_TimeTableReport1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Time Table Report") private WebElement timeTableReport_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchoolInstitute") private WebElement college_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSlotType") private WebElement slotType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnTimeTableReport") private WebElement timeTableReportFormatI_Btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCourseWise") private WebElement timeTableReportFormatII_Btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodate") private WebElement toDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement masterTimeTable_Btn;
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public AL_Academic_AM_TimeTableReport1 click_TimeTableReport_Link() {
		js.executeScript("arguments[0].click();",timeTableReport_Link );
		System.out.println("Time Table Report click");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 select_College() {
		Select typ_clg = new Select(college_Dropdown);
		typ_clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("select college and scheme: SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme) ");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 select_Session() {
		Select typ_sessn = new Select(session_Dropdown);
		typ_sessn.selectByVisibleText("May 2022");
		System.out.println("select session : May 2022");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 select_Semester() {
		Select typ_sem = new Select(semester_Dropdown);
		typ_sem.selectByVisibleText("IV");
		System.out.println("select Semester : IV");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 select_Section() {
		Select typ_sec = new Select(section_Dropdown);
		typ_sec.selectByVisibleText("A");
		System.out.println("select Section -> A");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 select_SlotType() {
		Select typ_slot = new Select(slotType_Dropdown);
		typ_slot.selectByVisibleText("Regular");
		System.out.println("select Slot-Type -> Regular");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 click_TimeTableReportFormatI_Btn() {
		click(timeTableReportFormatI_Btn);
		System.out.println("Click on Time Table Report Format-I");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 click_TimeTableReportFormatII_Btn() {
		click(timeTableReportFormatII_Btn);
		System.out.println("Click on Time Table Report Format-II");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 enter_FromDate() {
		js.executeScript("arguments[0].value = arguments[1]",fromDate, "01/12/2023");
		System.out.println("From Date -> 01/12/2023");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 enter_ToDate() {
		js.executeScript("arguments[0].value = arguments[1]",toDate, "19/01/2024");
		System.out.println("To Date -> 19/01/2024");
		return this;
	}
	public AL_Academic_AM_TimeTableReport1 click_MasterTimeTable_Button() {
		click(masterTimeTable_Btn);
		System.out.println("Click Master Time Table");
		return this;
	}
}
