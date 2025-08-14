package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelUtility;

public class AL_Academic_AP_StudentInformationVerification extends BaseClass
{
	ExcelUtility excelutilitytest = new ExcelUtility(driver);
	public AL_Academic_AP_StudentInformationVerification(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Student Information Verification") private WebElement StudentInformationVerification;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement admissionBatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClg") private WebElement SchoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement branch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStatus") private WebElement status ;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showstudentbtn;
	@FindBy(linkText = "ABIRAMI. R") private WebElement studentname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;
	@FindBy(xpath = "//a[text()='Verify Information']") private WebElement verifyinfo;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitstatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnreport") private WebElement printapplicationbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_StudentInformationVerification Click_StudentInformationVerification() throws InterruptedException {
		System.out.println("Click on Student Information Verification");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",StudentInformationVerification);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", StudentInformationVerification);
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch => 2021-22");
		Select select = new Select(admissionBatch);
		select.selectByVisibleText("2021-22");
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School/Institute ==> Crescent School of Architecture");
		Select select = new Select(SchoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
//	public AL_Academic_AP_StudentInformationVerification Select_Department() throws InterruptedException {
//		System.out.println("Select Department");
//		
//		WebElement searchfield = driver.findElement(By.xpath("//span[@class='multiselect-selected-text']"));
//		searchfield.click();
//		Thread.sleep(2000);
//		Actions action = new Actions(driver);
//		action.moveToElement(depatrment);
//		return this;
//	}
	
	public AL_Academic_AP_StudentInformationVerification Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Select_ProgrammeBranch() throws InterruptedException {
		System.out.println("Select Programme/Branch ==> Architecture");
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Select_Status() throws InterruptedException {
		System.out.println("Select Status ==> Approved");
		Select select = new Select(status);
		select.selectByVisibleText("Approved");
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Click_ShowBtn() throws InterruptedException {
		System.out.println("Click on Show button");
		click(showstudentbtn);
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Click_StudentName() throws InterruptedException {
		System.out.println("Click on Student Name");
		click(studentname);
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Click_VerifyInformationTab() throws InterruptedException {
		System.out.println("Click on Verify Information Tab");
		switchToNextWindow();
		click(verifyinfo);
		Thread.sleep(1000);
		click(submitstatus);
		return this;
	}
	
	public AL_Academic_AP_StudentInformationVerification Click_PrintApplication() throws InterruptedException {
		System.out.println("Click on Print Application");
		click(printapplicationbtn);
		return this;
	}
}
