package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_BundleAllotment extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Conduction of Examination") private WebElement conductionOfExamin;
	@FindBy(id = "ctl00_repLinks_ctl07_lbLink") private WebElement bundle_alot;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement course;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBundle") private WebElement unknown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlValuer") private WebElement facultyname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDate") private WebElement dateOfExam;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;

	public AL_Examination_COE_BundleAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_COE_BundleAllotment EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Click_BundleAllotment() {
		System.out.println(" Click On > Bundle Allotment");
		Actions action = new Actions(driver);
		action.moveToElement(bundle_alot).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Select_Session() {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Select_CourseCode() {
		System.out.println("Select Course code ==> Theory and Design of Structures - I");
		Select select = new Select(course);
		select.selectByVisibleText("Theory and Design of Structures - I");
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Select_Unknown() {
		System.out.println("Select Unknown  ==> 10");
		Select select = new Select(unknown);
		select.selectByVisibleText("10");
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Select_FacultyName() {
		System.out.println("Select Faculty Name  ==> MADHUMATHI  TM");
		Select select = new Select(facultyname);
		select.selectByValue("524");
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Click_submitBtn() {
		System.out.println("Click Submit btn");
		click(submitbtn);
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Select_DateOfExam() {
		System.out.println("Select Date Of Exam ==> 01/12/2023");
		Select select = new Select(dateOfExam);
		select.selectByVisibleText("01/12/2023");
		return this;
	}
	
	public AL_Examination_COE_BundleAllotment Click_ReportBtn() {
		System.out.println("Click Report btn");
		click(reportbtn);
		return this;
	}
}
