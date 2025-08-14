package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 extends BaseClass
{
	@FindBy(linkText = "Conduction of Examination") private WebElement conductionOfExamin;
	@FindBy(linkText = "Student Wise Unlock") private WebElement student_wise_unlock;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlClgname") private WebElement collegeScheme;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semister;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlsub") private WebElement course_type;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlExamType") private WebElement exam_type;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlSubExam1") private WebElement subexam_type;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlCourse") private WebElement course;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlStuType") private WebElement student_type;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlFac") private WebElement faculty;
	@FindBy(id="ctl00_ContentPlaceHolder1_lvStudList_ctrl0_chklckStud") private WebElement stud_chkbox;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave") private WebElement unlockbtn;

	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Click_StudentWiseUnlock() {
		System.out.println(" Click On > Student Wise Unlock");
		Actions action = new Actions(driver);
		action.moveToElement(student_wise_unlock).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_College_scheme() {
		System.out.println("Select College and Scheme = SMS - B.Tech.-Mechanical Engineering-2017-18-Department of Mechanical Engineering (Old Scheme)");
		Select select = new Select(collegeScheme);
		select.selectByVisibleText("SMS - B.Tech.-Mechanical Engineering-2017-18-Department of Mechanical Engineering (Old Scheme)");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_Session() {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_Semister() {
		System.out.println("Select Semister => VI");
		Select select = new Select(semister);
		select.selectByVisibleText("VI");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_CourseType() {
		System.out.println("Select Course Type => Theory with Tutorial");
		Select select = new Select(course_type);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_ExamType() {
		System.out.println("Select Exam Type => EXTERNAL");
		Select select = new Select(exam_type);
		select.selectByVisibleText("EXTERNAL");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_SubExamType() {
		System.out.println("Select Sub Exam Type => END SEM");
		Select select = new Select(subexam_type);
		select.selectByVisibleText("END SEM");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_Course() {
		System.out.println("Select Course => MACX 06 - Statistical Methods for Data Analysis");
		Select select = new Select(course);
		select.selectByVisibleText("MACX 06 - Statistical Methods for Data Analysis");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_StudentType() {
		System.out.println("Select Student Type => Revaluation");
		Select select = new Select(student_type);
		select.selectByVisibleText("Revaluation");
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Select_Faculty() {
		System.out.println("Select Faculty => Dr. BERNICK RAJ A");
		WebElement facult = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlFac-container"));
		facult.click();
		WebElement facultysearch = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		facultysearch.sendKeys("Dr. BERNICK RAJ A");
		facultysearch.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Click_Show_btn() {
		System.out.println("Click on Show btn");
		WebElement show_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(show_btn);
		return this;
	}
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Click_Student_chkBox() {
		System.out.println("Click on Student chkBox");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",stud_chkbox);
		click(stud_chkbox);
		return this;
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 Click_Unlock_btn() {
		System.out.println("Click on Unlock btn");
		js.executeScript("arguments[0].click();", unlockbtn);
		
		return this;
	}
}
