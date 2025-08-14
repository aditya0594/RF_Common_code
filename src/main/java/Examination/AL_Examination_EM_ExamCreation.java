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

public class AL_Examination_EM_ExamCreation extends BaseClass
{
	@FindBy(linkText = "Exam Creation") private WebElement examcreaton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamPattern") private WebElement exampattern;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvExamHead_ctrl0_txtExamName") private WebElement examname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvExamHead_ctrl0_ddlExamType") private WebElement examtype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;
	
	public AL_Examination_EM_ExamCreation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public AL_Examination_EM_ExamCreation Click_ExamCreation() {
		System.out.println("Click on Exam Creation ");
		Actions action = new Actions(driver);
		action.moveToElement(examcreaton).click().build().perform();
		return this;
	}
	
	public AL_Examination_EM_ExamCreation Select_ExamPattern() {
		System.out.println("Select Exam Pattern  => CAT I CAT II");
		Select select = new Select(exampattern);
		select.selectByVisibleText("CAT I CAT II");
		return this;
	}
	
	public AL_Examination_EM_ExamCreation Set_ExamName() {
		System.out.println("Set Exam Name => CAT I");
		clearText(examname);
		sendKeys(examname, "CAT I");
		return this;
	}
	
	public AL_Examination_EM_ExamCreation Select_ExamType() {
		System.out.println("Select Exam Type => Internal");
		Select select = new Select(examtype);
		select.selectByVisibleText("Internal");
		return this;
	}
	
	public AL_Examination_EM_ExamCreation Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit Btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);

		return this;
	}
}
