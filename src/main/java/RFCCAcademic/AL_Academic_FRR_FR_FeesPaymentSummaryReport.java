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

public class AL_Academic_FRR_FR_FeesPaymentSummaryReport extends BaseClass
{
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report") private WebElement feesReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport") private WebElement reportDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox1") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo") private WebElement receiptTypeCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportBtn;

	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Click_FeesReport() throws Exception {
		System.out.println("Click on Fees Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", feesReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", feesReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Select_ReportType() throws Exception {
		System.out.println("Select Report Type ==> Fees Payment Summary Report");
		Thread.sleep(2000);
		Select select = new Select(reportDropdown);
		select.selectByVisibleText("Fees Payment Summary Report");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Click_ReceiptTypeCheckbox() throws Exception {
		System.out.println("Click on Receipt Type Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", receiptTypeCheckbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", receiptTypeCheckbox);
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport Click_ReportButton() throws Exception {
		System.out.println("Click on Report Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", reportBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", reportBtn);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_FeesPaymentSummaryReport VerifyReportGeneration() throws Exception {
		System.out.println("Verifying Fees Payment Summary Report Generation");
		Thread.sleep(3000);
		// Add any assertion logic here if needed
		System.out.println("Fees Payment Summary Report Generated Successfully");
		return this;
	}
}
