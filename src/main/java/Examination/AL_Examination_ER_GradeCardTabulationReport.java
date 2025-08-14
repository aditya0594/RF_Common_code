package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Examination_ER_GradeCardTabulationReport extends BaseClass{

	public AL_Examination_ER_GradeCardTabulationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "ctl00_repLinks_ctl07_lbLink") private WebElement GradeCardReport_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStuType") private WebElement StudentType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDateOfIssue") private WebElement DateOfIssue_Input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDateOfPublish") private WebElement DateOfPublish_Input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_showstudents") private WebElement Show_Student_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_chkStudent") private WebElement Student_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnGradeCard") private WebElement GradeCard_Button;
	
	
	public AL_Examination_ER_GradeCardTabulationReport Click_GradeCardReport_Link() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",GradeCardReport_Link);
		System.out.println("Click on Grade Card/Tabulation Reports from sub menu");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Select_College() {
		Select clg = new Select(College_Dropdown);
		clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		System.out.println("Select College & Scheme Name");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Select_Session() {
		Select sesn = new Select(Session_Dropdown);
		sesn.selectByVisibleText("May 2022");
		System.out.println("Select Session");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Select_Semester() {
		Select sem = new Select(Semester_Dropdown);
		sem.selectByVisibleText("VIII");
		System.out.println("Select Semester");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Select_StudentType() {
		Select stdnt = new Select(StudentType_Dropdown);
		stdnt.selectByVisibleText("Regular");
		System.out.println("Select Student Type");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Enter_DateOfPublish() {
		DateOfPublish_Input.sendKeys("30/07/2024");
		System.out.println("Enter Date of Publish");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Enter_DateOfIssue() {
		DateOfIssue_Input.sendKeys("30/07/2024");
		System.out.println("Enter Date of Issue");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Click_ShowStudent_Button() {
		Show_Student_Button.click();
		System.out.println("Click on Show Students Button");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Select_Student() {
		js.executeScript("arguments[0].click();",Student_Checkbox);
		System.out.println("Select Student");
		return this;
	}
	
	public AL_Examination_ER_GradeCardTabulationReport Click_GradeCard_Button() {
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGradeCard")).click();
		System.out.println("Click on Grade Card Button"); 
		return this;
	}
	
}
