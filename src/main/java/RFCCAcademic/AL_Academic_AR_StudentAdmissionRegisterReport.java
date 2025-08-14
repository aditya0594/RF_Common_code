package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Examination.AL_Examination_PEA_ExamAdmitCardGeneration;
import utility.BaseClass;

public class AL_Academic_AR_StudentAdmissionRegisterReport extends BaseClass{

	public AL_Academic_AR_StudentAdmissionRegisterReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(id = "ctl00_repLinks_ctl03_lbLink") private WebElement StudentAdmissionRegReport_Link;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClg-container") private WebElement School_Dropdown;
	@FindBy(className ="select2-search__field") private WebElement Searchfield;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAcdYear-container") private WebElement AcademicYear_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDepartment-container") private WebElement Department_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container") private WebElement Degree_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRegReport") private WebElement AdmissionRollList_Button;



	public AL_Academic_AR_StudentAdmissionRegisterReport Click_StudentAdmissionRegReport() {
		System.out.println("Student Admission Register Report");
		StudentAdmissionRegReport_Link.click();
		return this;
	}

	public AL_Academic_AR_StudentAdmissionRegisterReport Select_AcademicYear() {
		System.out.println("Select Academic Year");
		AcademicYear_Dropdown.click();
		Searchfield.sendKeys("2021-2022",Keys.ENTER); 
		return this;
	}

	public AL_Academic_AR_StudentAdmissionRegisterReport Select_School() {
		System.out.println("School/Institute -> Crescent School of Architecture - Chennai");
		School_Dropdown.click();
		Searchfield.sendKeys("Crescent School of Architecture - Chennai",Keys.ENTER);
		return this;
	}

	public AL_Academic_AR_StudentAdmissionRegisterReport Select_Department() {
		System.out.println("School/Institute -> Crescent School of Architecture");
		Department_Dropdown.click();
		Searchfield.sendKeys("Crescent School of Architecture",Keys.ENTER);
		return this;
	}

	public AL_Academic_AR_StudentAdmissionRegisterReport Select_Degree() {
		System.out.println("School/Institute -> Bachelor of Architecture");
		Degree_Dropdown.click();
		Searchfield.sendKeys("Bachelor of Architecture", Keys.ENTER);
		return this;
	}

	public AL_Academic_AR_StudentAdmissionRegisterReport Click_AdmissionRollist_Button() {
		System.out.println("Click on Admission Roll List");
		AdmissionRollList_Button.click();
		return this;
	}

}
