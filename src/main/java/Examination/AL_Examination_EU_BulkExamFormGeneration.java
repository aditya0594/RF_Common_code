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

public class AL_Examination_EU_BulkExamFormGeneration extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Exam Utility") private WebElement exam_utility;
	@FindBy(linkText = "Bulk Exam Form Generation") private WebElement bulkExamformgen;

	
	public AL_Examination_EU_BulkExamFormGeneration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_EU_BulkExamFormGeneration EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_ExamUtility() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(exam_utility).click().build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_BulkExamFormGeneration() {
		System.out.println("Click on Bulk Exam Form Generation ");
		Actions action = new Actions(driver);
		action.moveToElement(bulkExamformgen).click().build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Select_College_Scheme() {
		System.out.println("Select College and Scheme => SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		WebElement clg=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname"));
		Select select = new Select(clg);
		select.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2021-22 (New Scheme)");
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Select_Session() {
		System.out.println("Select Session => May 2022");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Select_Semister() {
		System.out.println("Select Semister => II");
		WebElement semister=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSem"));
		Select select = new Select(semister);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_TypeAll_radio_btn() {
		System.out.println("Click Type => All radio btn");
		WebElement all_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdlist_2"));
		click(all_btn);
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_ChkBox() {
		System.out.println("Click All Check Box");
		WebElement chkBox=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_chkIdentityCard"));
		click(chkBox);
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_ShowStudent_btn() {
		System.out.println("Click Show Student btn");
		WebElement stu_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(stu_btn);
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration Click_GenerateExamForm() {
		System.out.println("Click Generate Exam Form btn");
		WebElement gen_ex_form=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGenerateExamForm"));
		click(gen_ex_form);
		return this;
	}
	
	public AL_Examination_EU_BulkExamFormGeneration MoveToBottm() {
		System.out.println("Move To Bottm");
		WebElement down=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl9_chkreport"));
		js.executeScript("arguments[0].scrollIntoView();", down);
		return this;
	}
}
