package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FRR_FR_FeeCollectionSummaryReport extends BaseClass
{
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report") private WebElement feesReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport") private WebElement reportDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox1") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degreeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo") private WebElement receiptTypeCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportBtn;

	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Click_FeesReport() throws Exception {
		System.out.println("Click on Fees Report");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", feesReport);

		threadWait1();
		js.executeScript("arguments[0].click();", feesReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Select_ReportType() throws Exception {
		System.out.println("Select Report Type ==> Fee Collection Summary Report");
		threadWait1();
		Select select = new Select(reportDropdown);
		select.selectByVisibleText("Fee Collection Summary Report");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Select_Degree() throws Exception {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		threadWait1();
		Select select = new Select(degreeDropdown);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Click_ReceiptTypeCheckbox() throws Exception {
		System.out.println("Click on Receipt Type Checkbox");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", receiptTypeCheckbox);

		threadWait1();
		js.executeScript("arguments[0].click();", receiptTypeCheckbox);
		return this;
	}
	
	public AL_Academic_FRR_FR_FeeCollectionSummaryReport Click_ReportButton() throws Exception {
		System.out.println("Click on Report Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", reportBtn);

		threadWait1();
		js.executeScript("arguments[0].click();", reportBtn);
		
		return this;
	}
}
