package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Examination_EU_ExamRuleForPromotion extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Exam Utility") private WebElement exam_utility;
	@FindBy(linkText = "Exam Rule for Promotion") private WebElement exam_rule_promotion;

	
	public AL_Examination_EU_ExamRuleForPromotion(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_EU_ExamRuleForPromotion EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_EU_ExamRuleForPromotion Click_ExamUtility() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(exam_utility).click().build().perform();
		return this;
	}
	 
	public AL_Examination_EU_ExamRuleForPromotion Click_ExamRuleForPromotion() {
		System.out.println("Click on Exam Rule for Promotion ");
		Actions action = new Actions(driver);
		action.moveToElement(exam_rule_promotion).click().build().perform();
		return this;
	}
	
	public AL_Examination_EU_ExamRuleForPromotion Click_EditIcon_btn() {
		System.out.println("Click on Edit Icon In Action Field");
		WebElement edit_icon=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvDetails_ctrl0_btnEdit"));
		click(edit_icon);
		return this;
	}
	
	public AL_Examination_EU_ExamRuleForPromotion Enter_MinEarnedCredits() {
		System.out.println("Enter Min Earned Credits ==> 8");
		WebElement minErn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMinEarnedCreditsPer"));
		clearText(minErn);
		sendKeys(minErn, "8");
		return this;
	}
	
	public AL_Examination_EU_ExamRuleForPromotion Enter_PrevSemCourseCleared() {
		System.out.println("Enter Prev Sem Course Cleared ==> 9");
		WebElement Corse=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPrevSemCourseCleared"));
		clearText(Corse);
		sendKeys(Corse, "9");
		return this;
	}
	
	public AL_Examination_EU_ExamRuleForPromotion Click_Submit_btn() {
		System.out.println("Click on Submit btn");
		WebElement sub=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		click(sub);
		return this;
	}
}
