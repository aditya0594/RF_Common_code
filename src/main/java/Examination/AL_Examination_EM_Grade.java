package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_EM_Grade extends BaseClass
{
	@FindBy(linkText = "Grade") private WebElement grade;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlcollege") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlGradeType") private WebElement gradetype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement programtype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubType") private WebElement subtype;
	@FindBy(id = "btnSave") private WebElement showbtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrade_ctrl0_txtGradePoint") private WebElement gradepoint;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrade_ctrl0_txtMaxMark") private WebElement maxmarks;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrade_ctrl0_txtMinMark") private WebElement minmarks;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrade_ctrl0_txtGradeDesc") private WebElement gradedescription;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrade_ctrl0_ddlResult") private WebElement resultdeopdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submirbtn;


	public AL_Examination_EM_Grade(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public AL_Examination_EM_Grade Click_Grade() {
		System.out.println("Click on Grade ");
		Actions action = new Actions(driver);
		action.moveToElement(grade).click().build().perform();
		return this;
	}
	
	public AL_Examination_EM_Grade Select_College() {
		System.out.println("Select College  => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Examination_EM_Grade Select_GradeType() {
		System.out.println("Select Grade Type  => A");
		Select select = new Select(gradetype);
		select.selectByVisibleText("A");
		return this;
	}
	
	public AL_Examination_EM_Grade Select_ProgrammeType() {
		System.out.println("Select  Programme Type  => UG");
		Select select = new Select(programtype);
		select.selectByVisibleText("UG");
		return this;
	}
	
	public AL_Examination_EM_Grade Select_SubjectType() {
		System.out.println("Select Subject Type  => Theory with Tutorial");
		Select select = new Select(subtype);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_EM_Grade Click_ShowBtn() {
		System.out.println("Click on Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Examination_EM_Grade Enter_GradePoint() {
		System.out.println("Enter Grade Point => 10");
		clearText(gradepoint);
		sendKeys(gradepoint, "10");
		return this;
	}
	
	public AL_Examination_EM_Grade Enter_MaxMarks() {
		System.out.println("Enter Max Marks => 100");
		clearText(maxmarks);
		sendKeys(maxmarks, "100");
		return this;
	}
	
	public AL_Examination_EM_Grade Enter_MinMark() {
		System.out.println("Enter Min Mark => 40");
		clearText(minmarks);
		sendKeys(minmarks, "40");
		return this;
	}
	
	public AL_Examination_EM_Grade Enter_GradeDescription() {
		System.out.println("Enter Grade Description => Automation Test");
		clearText(gradedescription);
		sendKeys(gradedescription, "Automation Test");
		return this;
	}
	
	public AL_Examination_EM_Grade Select_Result() {
		System.out.println("Select Result => Pass");
		Select select = new Select(resultdeopdown);
		select.selectByVisibleText("Pass");
		return this;
	}
	
	public AL_Examination_EM_Grade Click_Submitbtn() {
		System.out.println("Click on Submit Btn");
		click(submirbtn);
		return this;
	}
}
