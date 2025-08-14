package Examination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Conduction of Examination") private WebElement conductionOfExamin;
	@FindBy(linkText = "Remove Absent IGrade Entry") private WebElement remove_I_gradeEntry;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement course;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAbIgEntry") private WebElement selectEntry;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamName") private WebElement exam;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubExamName") private WebElement subexam;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAbIGRemove_ctrl0_chk_AbGrade") private WebElement absententryChkBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement savebtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchstudent;

	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Click_RemoveAbsentIGradeEntry() {
		System.out.println(" Click On > Remove Absent IGrade Entry");
		Actions action = new Actions(driver);
		action.moveToElement(remove_I_gradeEntry).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_College_scheme() {
		System.out.println("Select College and Scheme = CSL - B.Com. LL.B. (Hons.)-B.Com. LL.B. (Hons.)-2017-18-Crescent School of Law (Old Scheme)");
		Select select = new Select(college);
		select.selectByVisibleText("CSL - B.Com. LL.B. (Hons.)-B.Com. LL.B. (Hons.)-2017-18-Crescent School of Law (Old Scheme)");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_Session() {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_Semister() {
		System.out.println("Select Semister ==> III");
		Select select = new Select(semister);
		select.selectByVisibleText("III");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_Course() {
		System.out.println("Select Course => BLC 2103 - Constitution Law - I");
		Select select = new Select(course);
		select.selectByVisibleText("BLC 2103 - Constitution Law - I");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_Entry() {
		System.out.println("Select Entry => Absent Entry");
		Select select = new Select(selectEntry);
		select.selectByVisibleText("Absent Entry");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_ExamName() {
		System.out.println("Select Exam Name => Absent Entry");
		Select select = new Select(exam);
		select.selectByVisibleText("TEST 1");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Select_SubExamName() {
		System.out.println("Select Sub Exam Name => Absent Entry");
		Select select = new Select(subexam);
		select.selectByVisibleText("TEST 1");
		return this;
	}
	
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Click_Show_btn() {
		System.out.println("Click Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Search_Student() {
		System.out.println("Search Student => 171401601007  KUMARAN. S");
		sendKeys(searchstudent, "171401601007");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Click_IGrade_chkBox() {
		System.out.println("Click I Grade chkBox");
		click(absententryChkBox);
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntry_AbsentEntryFlow05_2 Click_Save_btn() {
		System.out.println("Click Save btn");
		click(savebtn);  
		return this;
	}
}
