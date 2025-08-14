package Examination;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 extends BaseClass
{
	@FindBy(linkText = "Examination Reports") private WebElement Examination_Reports;
	@FindBy(linkText = "Transcript/Consolidated Grade Card Report") private WebElement transcriptConsolidateGrade;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEnrollmentSearch") private WebElement regi_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement search_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnTranscriptWithFormat") private WebElement rpt2_btn;

	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 EXAMINATION_REPORT() {
		System.out.println("Click on Examiantion Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Examination_Reports).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 Click_TranscriptConsolidatedGradeCardReport() {
		System.out.println("Click on Transcript/Consolidated Grade Card Report ");
		Actions action = new Actions(driver);
		action.moveToElement(transcriptConsolidateGrade).click().build().perform();
		return this;
	}
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 Click_RRN_RegNo() {
		System.out.println("Click on  RRN/Reg.No. field==> 190071601123");
		sendKeys(regi_btn, "190071601123");
		return this;
	}
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 Click_Search_btn() {
		System.out.println("Click on Search btn");
		click(search_btn);
		return this;
	}
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 Select_Session() {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Examination_ER_TranscriptConsolidatedGradeCardRpt_Format2 Click_TranscriptReportFormat2_btn() {
		System.out.println("Click on Transcript Report Format 2 btn");
		click(rpt2_btn);
		return this;
	}
	

}
