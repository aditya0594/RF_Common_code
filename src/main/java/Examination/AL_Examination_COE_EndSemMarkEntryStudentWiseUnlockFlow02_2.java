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

public class AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
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
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlFac-container") private WebElement Selectfaculty;
	@FindBy(xpath="//input[@class='select2-search__field']") private WebElement searchFaculty;

	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Click_StudentWiseUnlock() {
		System.out.println(" Click On > Student Wise Unlock");
		Actions action = new Actions(driver);
		action.moveToElement(student_wise_unlock).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_College_scheme() {
		System.out.println("Select College and Scheme = SMS - B.Tech.-Mechanical Engineering-2021-22-Department of Mechanical Engineering (New Scheme)");
		Select select = new Select(collegeScheme);
		select.selectByVisibleText("SMS - B.Tech.-Mechanical Engineering-2021-22-Department of Mechanical Engineering (New Scheme)");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_Session() {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_Semister() {
		System.out.println("Select Semister => II");
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_CourseType() {
		System.out.println("Select Course Type => Theory with Tutorial");
		Select select = new Select(course_type);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_ExamType() {
		System.out.println("Select Exam Type => EXTERNAL");
		Select select = new Select(exam_type);
		select.selectByVisibleText("EXTERNAL");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_SubExamType() {
		System.out.println("Select Sub Exam Type => END SEM");
		Select select = new Select(subexam_type);
		select.selectByVisibleText("END SEM");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_Course() {
		System.out.println("Select Course => END 1281 - English for Engineers");
		Select select = new Select(course);
		select.selectByVisibleText("END 1281 - English for Engineers");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_StudentType() {
		System.out.println("Select Student Type => Regular");
		Select select = new Select(student_type);
		select.selectByVisibleText("Regular");
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Select_Faculty() throws InterruptedException {
		System.out.println("Select Faculty => Mr. SAIBULLA  A");
		
		Selectfaculty.click();
		Thread.sleep(2000);
		searchFaculty.sendKeys("SAI");
		searchFaculty.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Click_Show_btn() {
		System.out.println("Click on Show btn");
		WebElement show_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(show_btn);
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Click_Student_chkBox() {
		System.out.println("Click on Student chkBox");
		WebElement chk_box = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudList_ctrl43_chklckStud"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", chk_box);
		return this;
	}
	
	public AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 Click_Unlock_btn() {
		System.out.println("Click on Unlock btn");
		WebElement unlock_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(unlock_btn);
		return this;
	}
}
