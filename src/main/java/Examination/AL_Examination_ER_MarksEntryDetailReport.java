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

public class AL_Examination_ER_MarksEntryDetailReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Marks Entry Detail Report") private WebElement Mark_entry_details;
	
	Actions action = new Actions(driver); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public AL_Examination_ER_MarksEntryDetailReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_MarksEntryDetailReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport MarksEntryDetailReport() throws InterruptedException {
		System.out.println(" Click On > Marks Entry Detail Report");

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Mark_entry_details);
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Select_SchoolInstituteName() {
		System.out.println("Select School/Institute Name => SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		WebElement sch=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSchoolInstitite"));
		Select select = new Select(sch);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Select_Session() {
		System.out.println("Select Session => May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Select_Semister() {
		System.out.println("Select Semister");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsemester"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Select_SubjectType() {
		System.out.println("Select Subject Type => Theory with Tutorial");
		WebElement sub = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCourseType"));
		Select select = new Select(sub);
		select.selectByVisibleText("Theory with Tutorial");
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Select_Course() {
		System.out.println("Select Course => END 1281-English for Engineers-  (CE)");
		WebElement course = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlcourse"));
		Select select = new Select(course);
		select.selectByVisibleText("END 1281-English for Engineers- (CE)");
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Click_ShowBtn() {
		System.out.println("Click Show btn");
		WebElement showbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(showbtn);
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Click_SubjectWiseMarkEntryReportBtn() {
		System.out.println("Click Subject Wise Mark Entry Report btn");
		WebElement mark_entry_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnreport"));
		click(mark_entry_btn);
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Click_DownArrow() {
		System.out.println("Click on Down Arrow ");
		WebElement arrow=driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvParentGrid1_ctl02_CLOSE"));
		click(arrow);
		return this;
	}
	
	public AL_Examination_ER_MarksEntryDetailReport Click_BlankMarkReportBtn() {
		System.out.println("Click Blank Mark Report btn");
		WebElement blank_repo=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnblankmarkreport"));
		click(blank_repo);
		return this;
	}
}
