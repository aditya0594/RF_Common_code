package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_IGradeEntry_BulkIGradeEntry extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Conduction of Examination") private WebElement conductionOfExamin;
	@FindBy(linkText = "I Grade Entry") private WebElement I_gradeEntry;
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry CONDUCTION_OF_EXAMINATION() {
		System.out.println("Admin Examination menu selected > CONDUCTION_OF_EXAMINATION ");
		Actions action = new Actions(driver);
		action.moveToElement(conductionOfExamin).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Click_I_Grade_Entry() {
		System.out.println(" Click On > I_Grade_Entry");
		Actions action = new Actions(driver);
		action.moveToElement(I_gradeEntry).click().build().perform();
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Click_Bulk_I_Grade_Entry() {
		System.out.println("Click Bulk I Grade Entry radiobtn");
		WebElement bulk_entry=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoMultiple"));
		click(bulk_entry);
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Select_College_scheme() {
		System.out.println("Select College and Scheme = CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlClgname']"));
		Select select = new Select(clg);
		select.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Select_Session() {
		System.out.println("Select Session");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSession']"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Select_Semister() {
		System.out.println("Select Semister");
		WebElement session=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSemester']"));
		Select select = new Select(session);
		select.selectByVisibleText("IV");
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Select_Subject() {
		System.out.println("Select Subject");
		WebElement sub=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlSubject']"));
		Select select = new Select(sub);
		select.selectByVisibleText("ARC 2202 - Building Services - I");
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Click_showBtn() {
		System.out.println("Click Show btn");
		WebElement show_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(show_btn);
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Click_checkBox() {
		System.out.println("Click check box");
		WebElement check_box=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkSelect"));
		click(check_box);
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_BulkIGradeEntry Click_submitBtn() {
		System.out.println("Click Submit btn");
		WebElement submit_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		click(submit_btn);
		return this;
	}
}
