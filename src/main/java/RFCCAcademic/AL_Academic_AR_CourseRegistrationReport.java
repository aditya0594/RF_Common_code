package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AR_CourseRegistrationReport extends BaseClass{
	
	public AL_Academic_AR_CourseRegistrationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Course Registration Report") private WebElement CourseRegistrationReport_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReportType") private WebElement Report_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlReportType-container") private WebElement Course_Dropdown;
	@FindBy(className = "select2-search__field") private WebElement Searchfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel") private WebElement ExcelReport_Button;
	
	
	
	public AL_Academic_AR_CourseRegistrationReport Click_CourseRegReport() {
		CourseRegistrationReport_Link.click(); 
		System.out.println("Course Registration Report");
		System.out.println("Course Registration Report page display");
		return this;
	}
	
	public AL_Academic_AR_CourseRegistrationReport Select_Session() {
		Select typ_sessn = new Select(Session_Dropdown);
		typ_sessn.selectByVisibleText("Dec - 2023");
		System.out.println("Select Session : Dec - 2023");
		return this;
	}
	
	public AL_Academic_AR_CourseRegistrationReport Select_College() {
		Select typ_clg = new Select(College_Dropdown);
		typ_clg.selectByVisibleText("Crescent School of Law");
		System.out.println("Select College : Crescent School of Law");
		return this;
	}
	
	public AL_Academic_AR_CourseRegistrationReport Select_Report() {
		Select typ_report = new Select(Report_Dropdown);
		typ_report.selectByVisibleText("All Courses");
		System.out.println("Select Report Type : All Courses");
		return this;
	}
	
	public AL_Academic_AR_CourseRegistrationReport Select_Course() {
		System.out.println("Select Course : All Courses");
		Course_Dropdown.click();
		Searchfield.sendKeys("All Courses", Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_CourseRegistrationReport Click_ExcelReport_Button() {
		System.out.println("Click on Excel Report Button");
		ExcelReport_Button.click();
		return this;
	}
	
	

}
