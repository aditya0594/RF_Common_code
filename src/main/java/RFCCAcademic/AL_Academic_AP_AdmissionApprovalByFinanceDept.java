package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelUtility;

public class AL_Academic_AP_AdmissionApprovalByFinanceDept extends BaseClass
{
	ExcelUtility excelutilitytest = new ExcelUtility(driver);
	public AL_Academic_AP_AdmissionApprovalByFinanceDept(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Admission Approval By Finance Dept.") private WebElement admissionApprovalByFinanceDept;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement admissionBatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClg") private WebElement SchoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement branch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn ;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Click_AdmissionApprovalByFinanceDept() throws InterruptedException {
		System.out.println("Click on Student Information Verification");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",admissionApprovalByFinanceDept);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", admissionApprovalByFinanceDept);
		return this;
	}
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch => 2021-22");
		Select select = new Select(admissionBatch);
		select.selectByVisibleText("2021-22");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School/Institute ==> Crescent School of Architecture - Chennai");
		Select select = new Select(SchoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture - Chennai");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Select_ProgrammeBranch() throws InterruptedException {
		System.out.println("Select Programme/Branch ==> Architecture");
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApprovalByFinanceDept Click_Reportbn() throws InterruptedException {
		System.out.println("Click on Report btn");
		click(reportbtn);
		return this;
	}
}
