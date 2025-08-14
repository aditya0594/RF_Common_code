package Examination;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_ExamReports_FailStudentList extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Exam Reports") private WebElement Exam_Report;
	
	public AL_Examination_ER_ExamReports_FailStudentList(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList EXAM_REPORT() {
		System.out.println(" Click On > Exam Report");
		Actions action = new Actions(driver);
		action.moveToElement(Exam_Report).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList College_Scheme() {
		System.out.println("Select College and Scheme");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlClgname']"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Session() {
		System.out.println("Select Session");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Semister() {
		System.out.println("Select Semister");
		WebElement semister=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSem']"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Section() {
		System.out.println("Select Section");
		WebElement section=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSection']"));
		Select select = new Select(section);
		select.selectByVisibleText("A");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Exam_Name() {
		System.out.println("Select Exam_Name");
		WebElement exam_name=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlExam']"));
		Select select = new Select(exam_name);
		select.selectByVisibleText("EXTERNAL");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Sub_Exam() {
		System.out.println("Select Sub_Exam");
		WebElement sub_exam=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSubExam']"));
		Select select = new Select(sub_exam);
		select.selectByVisibleText("END SEM-Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList Course() {
		System.out.println("Select Course");
		WebElement course=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcourse']"));
		Select select = new Select(course);
		select.selectByVisibleText("END 1281-English for Engineers");
		return this;
	}
	
	public AL_Examination_ER_ExamReports_FailStudentList fail_student_list_btn() {
		System.out.println("Click Fail Student btn");
		WebElement fail_student=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFailStudentList"));
		click(fail_student);
		return this;
	}

}
