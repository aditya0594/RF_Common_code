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

public class AL_Academic_AM_RevisedTimeTable extends BaseClass{

	public AL_Academic_AM_RevisedTimeTable(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Revised Time Table") private WebElement revisedTieTable_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchoolInstitute") private WebElement school_Dropdwn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSlotType") private WebElement slotType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExistingDates") private WebElement existingDates_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStartDate") private WebElement startDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDate") private WebElement endDate;
	@FindBy(id = "btnSave") private WebElement save_Button;
	

	JavascriptExecutor jse = (JavascriptExecutor)driver;

	public AL_Academic_AM_RevisedTimeTable click_RevisedTimeTable() {
		jse.executeScript("arguments[0].click();",revisedTieTable_Link );
		System.out.println("Click -> Revised Time Table");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_School() {
		Select typ_clg = new Select(school_Dropdwn);
		typ_clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("select college and scheme-> SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_Session() {
		Select typ_sessn = new Select(session_dropdown);
		typ_sessn.selectByVisibleText("May 2022");
		System.out.println("select session -> May 2022");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_department() {
		Select typ_dept = new Select(department_dropdown);
		typ_dept.selectByVisibleText("Department of Civil Engineering");
		System.out.println("select Department -> Department of Civil Engineering");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_semester() {
		Select typ_sem = new Select(semester_dropdown);
		typ_sem.selectByVisibleText("IV");
		System.out.println("select Semester -> IV");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_section() {
		Select typ_sec = new Select(section_dropdown);
		typ_sec.selectByVisibleText("A");
		System.out.println("Select Section ->A");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_slotType() {
		Select typ_slot = new Select(slotType_dropdown);
		typ_slot.selectByVisibleText("Regular");
		System.out.println("select Slot-Type ->Regular");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable select_existingDates() {
		Select typ_Edate = new Select(existingDates_dropdown);
		typ_Edate.selectByVisibleText("14/03/2022 - 02/07/2022");
		System.out.println("select Existing Dates -> 14/03/2022 - 02/07/2022");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable enter_startDate() {
		jse.executeScript("arguments[0].value = arguments[1]",startDate, "01/12/2023");
		System.out.println("Select Start date ->01/12/2023");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable enter_endDate() {
		jse.executeScript("arguments[0].value = arguments[1]",endDate, "19/01/2024");
		System.out.println("Select End date ->19/01/2024");
		return this;
	}
	public AL_Academic_AM_RevisedTimeTable click_save_Button() {
		click(save_Button);
		System.out.println("Click on Save Button");
		return this;
	}

}
