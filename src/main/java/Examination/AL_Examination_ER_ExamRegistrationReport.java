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

public class AL_Examination_ER_ExamRegistrationReport extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;

	
	public AL_Examination_ER_ExamRegistrationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_ER_ExamRegistrationReport EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport EXAMINATION_REPORT() {
		System.out.println("Admin Examination menu selected > Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_SchoolInstituteName() {
		System.out.println("Select School Institute Name ==> Crescent School of Architecture");
		WebElement sch=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select select = new Select(sch);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_Session() {
		System.out.println("Select Session ==> May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_Degree() {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegree"));
		Select select = new Select(session);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_Branch() {
		System.out.println("Select Branch ==> Architecture");
		WebElement branch=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranch"));
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_SchemePath() {
		System.out.println("Select Scheme/Path ==> B. Arch-Architecture-2021-22-Crescent School of Architecture (New Scheme)");
		WebElement sch_path=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlScheme"));
		Select select = new Select(sch_path);
		select.selectByVisibleText("B. Arch-Architecture-2021-22-Crescent School of Architecture (New Scheme)");
		return this; 
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_Semister() {
		System.out.println("Select Semister ==> II");
		WebElement sem=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select select = new Select(sem);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Select_OrderBy() {
		System.out.println("Select Order By ==> Rollno");
		WebElement odrby=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlOrderBy"));
		Select select = new Select(odrby);
		select.selectByVisibleText("Rollno");
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport Click_Show_btn() {
		System.out.println("Click on Show btn");
		WebElement shwbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnShow"));
		click(shwbtn);
		return this;
	}
	
	public AL_Examination_ER_ExamRegistrationReport ScrollToBottom() throws Exception {
		System.out.println("Scroll To Bottom to show report");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement dn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl10_chkSelect"));
		js.executeScript("arguments[0].scrollIntoView();", dn);
		return this; 
	}
}
