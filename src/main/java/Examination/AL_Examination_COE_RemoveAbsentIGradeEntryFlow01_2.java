package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 extends BaseClass
{

	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Conduction of Examination") private WebElement conductionOfExamin;
	@FindBy(linkText = "Remove Absent IGrade Entry") private WebElement remove_I_gradeEntry;
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Click_RemoveAbsentIGradeEntry() {
		System.out.println(" Click On > Remove Absent IGrade Entry");
		Actions action = new Actions(driver);
		action.moveToElement(remove_I_gradeEntry).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Select_College_scheme() {
		System.out.println("Select College and Scheme = SCIMS - B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select select = new Select(clg);
		select.selectByVisibleText("SCIMS - B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Select_Session() {
		System.out.println("Select Session => May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Select_Semister() {
		System.out.println("Select Semister ==> VI");
		WebElement sem=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select select = new Select(sem);
		select.selectByVisibleText("VI");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Select_Course() {
		System.out.println("Select Course => CSC 3211 - Big Data Analytics");
		WebElement corse=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCourse"));
		Select select = new Select(corse);
		select.selectByVisibleText("CSC 3211 - Big Data Analytics");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Select_Entry() {
		System.out.println("Select Entry => IGrade Entry");
		WebElement entry=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAbIgEntry"));
		Select select = new Select(entry);
		select.selectByVisibleText("IGrade Entry");
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Click_Show_btn() {
		System.out.println("Click Show btn");
		WebElement show_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(show_btn);
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Click_IGrade_chkBox() {
		System.out.println("Click I Grade chkBox");
		WebElement chkBox=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvAbIGRemove_ctrl0_IGrade"));
		click(chkBox);
		return this;
	}
	
	public AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 Click_Save_btn() {
		System.out.println("Click Save btn");
		WebElement save_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		click(save_btn);  
		return this;
	}
}
