package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AR_StudentAdmissionReports extends BaseClass{
	
	public AL_Academic_AR_StudentAdmissionReports(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(linkText = "Student Admission Reports")
	private WebElement Academic_AR_StudentAdmissionReport_Link;
	

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlReport-container")
	private WebElement Report_Dropdown;
	

	@FindBy(className = "select2-search__field")
	private WebElement Searchfield;
	

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAcdYear")
	private WebElement AcademicYear_Dropdown;
	

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAllYearView")
	private WebElement View_Button;
	

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAllYearExcel")
	private WebElement ExportInExcel_Button;
	

	public AL_Academic_AR_StudentAdmissionReports Click_Student_AdmissionReports_Link() {
		System.out.println("Student Admission Reports");

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", Academic_AR_StudentAdmissionReport_Link);
		js2.executeScript("arguments[0].click();",Academic_AR_StudentAdmissionReport_Link);
		return this;
	}
	
	public AL_Academic_AR_StudentAdmissionReports Select_Report() throws InterruptedException {
		Report_Dropdown.click();
		Searchfield.sendKeys("All Year Semester Admitted Student List");
		Thread.sleep(1000);
		Searchfield.sendKeys(Keys.ENTER);
		System.out.println("Select Report : All Year Semester Admitted Student List");
		return this;
	}
	
	public AL_Academic_AR_StudentAdmissionReports Select_AcademicYear() {
		Select year = new Select(AcademicYear_Dropdown);
		year.selectByVisibleText("2023-2024");
		System.out.println("Select Academic Year -> 2023-2024");
		return this;
	}
	
	public AL_Academic_AR_StudentAdmissionReports Click_View_Button() {
		View_Button.click();
		System.out.println("Click on View Button");
		return this;
	}
	
	public AL_Academic_AR_StudentAdmissionReports Click_ExportInExcel_Button() {
		ExportInExcel_Button.click();
		return this;
	}
	
	
}
