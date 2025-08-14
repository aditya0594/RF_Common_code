package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_PA_GenerateRegistrationNo extends BaseClass{

	public AL_Academic_PA_GenerateRegistrationNo(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container") private WebElement admissionBatch_Dropdown;
	@FindBy(className = "select2-search__field") private WebElement searchField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container") private WebElement schoolName_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container") private WebElement degree_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container") private WebElement branch_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlsemester-container") private WebElement semester_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlidtype-container") private WebElement admissionType_Dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlsort-container") private WebElement sortByOption1_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnGenerateRR") private WebElement generateRRNo_Button;

	public AL_Academic_PA_GenerateRegistrationNo select_AdmissionBatch() {
		click(admissionBatch_Dropdown);
		String AdmissionBatchText = "2024-25";
		sendKeys(searchField,AdmissionBatchText);
		System.out.println("Select Admission Batch: " + AdmissionBatchText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_School() {
		click(schoolName_Dropdown);
		String SchoolInstituteText = "School of Computer Information and Mathematical Sciences";
		sendKeys(searchField,SchoolInstituteText);
		System.out.println("Select School Institute: " + SchoolInstituteText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_Degree() {
		click(degree_Dropdown);
		String DegreeText = "Bachelor of Technology";
		sendKeys(searchField,DegreeText);
		System.out.println("Select Degree: " + DegreeText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_Branch() {
		click(branch_Dropdown);
		String BranchText = "Computer Science and Engineering";
		sendKeys(searchField,BranchText);
		System.out.println("Select Branch: " + BranchText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_Semester() {
		click(semester_Dropdown);
		String SemesterText = "I";
		sendKeys(searchField,SemesterText);
		System.out.println("Select Semester: " + SemesterText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_AdmissionType() {
		click(admissionType_Dropdown);
		String AdmissionTypeText = "REGULAR";
		searchField.sendKeys(AdmissionTypeText);
		System.out.println("Select Admission Type: " + AdmissionTypeText);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo select_SortByOption1() {
		click(sortByOption1_Dropdown);
		String SortByoption1Text = "ByStudentName";
		searchField.sendKeys(SortByoption1Text);
		System.out.println("Select Sort By option 1: " + SortByoption1Text);
		searchField.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo click_Show_Button() {
		click(show_Button);
		System.out.println("Click on Show button");
		return this;
	}

	public AL_Academic_PA_GenerateRegistrationNo click_GenerateRRNo_Button() {
		click(generateRRNo_Button);
		System.out.println("Click on Generate RR No.");
		return this;
	}


}
