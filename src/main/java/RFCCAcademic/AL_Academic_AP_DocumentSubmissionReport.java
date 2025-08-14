package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AP_DocumentSubmissionReport extends BaseClass
{
	public AL_Academic_AP_DocumentSubmissionReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Document Submission Report") private WebElement documentSubmissionReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchool") private WebElement schoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement Degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBatch") private WebElement admissionbatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPrintReport") private WebElement documentsubmissionreportbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_DocumentSubmissionReport Click_DocumentSubmissionReport() throws InterruptedException {
		System.out.println("Click on Document Submission Report");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",documentSubmissionReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", documentSubmissionReport);
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmissionReport Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School/Institute ==> ");
		Select select = new Select(schoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture - Chennai");
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmissionReport Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(Degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmissionReport Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Degree ==> 2023-24");
		Select select = new Select(admissionbatch);
		select.selectByVisibleText("2023-24");
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmissionReport Click_DocumentSubmissionReportBtn() throws InterruptedException {
		System.out.println("Click on Document Submission Report btn");
		click(documentsubmissionreportbtn);
		return this;
	}
}
