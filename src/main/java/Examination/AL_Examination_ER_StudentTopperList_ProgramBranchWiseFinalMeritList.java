package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Student Topper List") private WebElement student_topperList;
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Student_Topper_List() {
		System.out.println(" Click On > Student Topper List");
		Actions action = new Actions(driver);
		action.moveToElement(student_topperList).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_College_Scheme() {
		System.out.println("Select College and Scheme=> SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_Session() {
		System.out.println("Select Session=> May 2022 ");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_Semister() {
		System.out.println("Select Semister");
		WebElement semister=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSem']"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_topperListOnBasis() {
		System.out.println("Select Topper List/Merit List On the Basis Off");
		WebElement basis=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMeritList"));
		Select select = new Select(basis);
		select.selectByVisibleText("CGPA");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_TopRange() {
		System.out.println("Select Top Range=>7");
		WebElement range=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTopcnt"));
		sendKeys(range, "7");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Select_Course() {
		System.out.println("Select Course");
		WebElement course=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCourse"));
		Select select = new Select(course);
		select.selectByVisibleText("English for Engineers");
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Click_Report_btn() {
		System.out.println("Click Report btn");
		WebElement rpt_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(rpt_btn);
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Click_MeritListRadioBtn() {
		System.out.println("Click Merit List radio btn");
		WebElement meritbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoPurpose_1"));
		click(meritbtn);
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Click_programBranchWiseFinalMeritListradioBtn() {
		System.out.println("Click Program/Branch Wise Final Merit List radio btn");
		WebElement branch_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoPurpose_2"));
		click(branch_btn);
		return this;
	}
	
	public AL_Examination_ER_StudentTopperList_ProgramBranchWiseFinalMeritList Click_CourseWiseTopperListRadiobtn() {
		System.out.println("Click Course Wise Topper List radio btn");
		WebElement coursewise=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoPurpose_3"));
		click(coursewise);
		return this;
	}
}
