package CDC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_CDC_Reports_TPOStudentDetailReport extends BaseClass
{
	public AL_CDC_Reports_TPOStudentDetailReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "TPO Student Detail Report")
	private WebElement tpoStudentDetailReport;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") 
	private WebElement collegeDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") 
	private WebElement sessionDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") 
	private WebElement degreeDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnDetailedExcelReport") 
	private WebElement excelReportBtn;
	
	public AL_CDC_Reports_TPOStudentDetailReport clickTPOStudentDetailReport() {
		System.out.println("Click on TPO Student Detail Report");
		click(tpoStudentDetailReport);		
		return this;
	}
	
	public AL_CDC_Reports_TPOStudentDetailReport selectCollege() {
		System.out.println("Select College => Crescent School of Architecture");
		Select college = new Select(collegeDropdown);
		college.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_CDC_Reports_TPOStudentDetailReport selectSession() {
		System.out.println("Select Session => May 2022");
		Select session = new Select(sessionDropdown);
		session.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_CDC_Reports_TPOStudentDetailReport selectDegree() {
		System.out.println("Select Degree => Bachelor of Architecture");
		Select degree = new Select(degreeDropdown);
		degree.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_CDC_Reports_TPOStudentDetailReport clickExcelReportBtn() {
		System.out.println("Click on Excel Report btn");
		click(excelReportBtn);
		return this;
	}
}
