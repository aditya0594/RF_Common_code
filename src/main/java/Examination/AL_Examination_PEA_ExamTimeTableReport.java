package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_PEA_ExamTimeTableReport extends BaseClass{

	public AL_Examination_PEA_ExamTimeTableReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Exam Time Table Report") private WebElement examTimeTableReport_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionReport") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement institute_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegreeReport") private WebElement degree_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranchReport") private WebElement branchName_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme") private WebElement scheme_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamName") private WebElement examName_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodate") private WebElement toDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement examTimeTableReport_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnTimeTable") private WebElement datawiseTimeTable_button;

	JavascriptExecutor js = (JavascriptExecutor)driver;
	public AL_Examination_PEA_ExamTimeTableReport click_examTimeTableReport_link() {
		click(examTimeTableReport_link);
		System.out.println("Click on Exam time Table Report");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_session() {
		Select sessn = new Select(session_dropdown);
		sessn.selectByVisibleText("CSA-DEC 2018");
		System.out.println("Session ->CSA-DEC 2018");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_institute() {
		WebElement institute = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select Inst = new Select(institute);
		Inst.selectByVisibleText("Crescent School of Architecture - Chennai");
		System.out.println("Institute -> Crescent School of Architecture - Chennai");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_degree() {
		Select degr = new Select(degree_dropdown);
		degr.selectByVisibleText("Bachelor of Architecture");
		System.out.println("Degree ->Bachelor of Architecture");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_branchName() {
		Select typ_branch = new Select(branchName_dropdown);
		typ_branch.selectByVisibleText("Architecture");
		System.out.println("Branch ->Architecture");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_scheme() {
		Select schme = new Select(scheme_dropdown);
		schme.selectByVisibleText("B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		System.out.println("Scheme ->B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_semester() {
		Select sem = new Select(semester_dropdown);
		sem.selectByVisibleText("V");
		System.out.println("Semester -> V");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport select_examName() {
		Select exam_name = new Select(examName_dropdown);
		exam_name.selectByVisibleText("END SEM");
		System.out.println("Exam Name-> END SEM");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport enter_fromDate() {
		js.executeScript("arguments[0].value = arguments[1]",fromDate_inputfield, "01/01/2020");
		System.out.println("Selected Date is: 01/01/2020");	
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport enter_toDate() {
		js.executeScript("arguments[0].value = arguments[1]",toDate_inputfield, "22/02/2024");
		System.out.println("Selected Date is: 22/02/2024");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport click_examTimeTableReport_button() {
		click(examTimeTableReport_button);
		System.out.println("Click on Exam Time Table Report");
		return this;
	}
	public AL_Examination_PEA_ExamTimeTableReport click_datawiseTimeTable_button() {
		click(datawiseTimeTable_button);
		System.out.println("Click Date wise Timetable Access ");
		return this;
	}

}
