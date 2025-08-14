package RFCCAcademic;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelUtility;

public class AL_Academic_AP_NewAdmissionConsolidateReport extends BaseClass
{
	ExcelUtility excelutilitytest = new ExcelUtility(driver);
	public AL_Academic_AP_NewAdmissionConsolidateReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='New Admission Consolidate Report']") private WebElement newAdmissionConsolidateReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement admissiontype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoAdmission_0") private WebElement generatereportbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoOverall") private WebElement OverallAdmissionStatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoInfoPending") private WebElement informationFillUpStatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoApprovalPending") private WebElement ApprovalStatusbyHOD ;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoApprovalByFinance") private WebElement ApprovalStatusbyFinancedept;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoPaymentPending") private WebElement PaymentStatusByStudent;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_NewAdmissionConsolidateReport() throws InterruptedException {
		System.out.println("Click on New Admission Consolidate Report");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",newAdmissionConsolidateReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", newAdmissionConsolidateReport);
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Select_AdmissionType() throws InterruptedException {
		System.out.println("Select Admission Type");
		Select select = new Select(admissiontype);
		select.selectByVisibleText("2023-24");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_GenerateReportBtn() throws IOException, Throwable {
		System.out.println("Click Generate Report Btn");
		click(generatereportbtn);
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_OverallAdmissionStatusBtn() throws IOException, Throwable {
		System.out.println("Click on Overall Admission Status btn");
		click(OverallAdmissionStatus);
		Thread.sleep(2000);
		click(reportbtn);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AJAY PAREKH","Overall_Admission_Status");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_InformationFillUpStatusBtn() throws IOException, Throwable {
		System.out.println("Click on Information Fill Up Status btn");
		click(informationFillUpStatus);
		Thread.sleep(2000);
		click(reportbtn);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AJAY PAREKH","Info_FillUp_Pending");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_ApprovalStatusbyHOD() throws IOException, Throwable {
		System.out.println("Click on Approval Status by HOD btn");
		click(ApprovalStatusbyHOD);
		Thread.sleep(2000);
		click(reportbtn);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AJAY PAREKH","Approval_Pending By_HOD");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_ApprovalStatusbyFinancedept() throws IOException, Throwable {
		System.out.println("Click on Approval Status By Finance Dept btn");
		click(ApprovalStatusbyFinancedept);
		Thread.sleep(2000);
		click(reportbtn);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AJAY PAREKH","Approval_Pending By_FinanceDept");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport Click_PaymentStatusByStudent() throws IOException, Throwable {
		System.out.println("Click on Payment Status By Student btn");
		click(PaymentStatusByStudent);
		Thread.sleep(2000);
		click(reportbtn);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AJAY PAREKH","Payment_Pending_by_Student");
		return this;
	}
}
