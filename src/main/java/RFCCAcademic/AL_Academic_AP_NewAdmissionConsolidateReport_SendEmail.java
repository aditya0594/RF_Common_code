package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;
import utility.ExcelUtility;

public class AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail extends BaseClass
{
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='New Admission Consolidate Report']") private WebElement newAdmissionConsolidateReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement admissiontype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoAdmission_1") private WebElement sendemailbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_BtnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoInfoIncomplete") private WebElement StudentInformationIncomplete;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_cbHead") private WebElement selectallchkbox1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject") private WebElement sub1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMatter") private WebElement msg1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendSMS") private WebElement sendemail1;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoNotApproveHOD") private WebElement HODNotApproved;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvHOD_cbHeadHod") private WebElement selectallchkbox2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject") private WebElement sub2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMatter") private WebElement msg2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendSMS") private WebElement sendemail2;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoStudPaymentPending") private WebElement PaymentNotDonebyStudent ;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvHOD_cbHeadHod") private WebElement selectallchkbox3;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject") private WebElement sub3;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMatter") private WebElement msg3;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendSMS") private WebElement sendemail3;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Click_NewAdmissionConsolidateReport() throws InterruptedException {
		System.out.println("Click on New Admission Consolidate Report");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",newAdmissionConsolidateReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", newAdmissionConsolidateReport);
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Select_AdmissionType() throws InterruptedException {
		System.out.println("Select Admission Type");
		Select select = new Select(admissiontype);
		select.selectByVisibleText("2023-24");
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Click_SendEmailBtn() throws InterruptedException {
		System.out.println("Click on Send Email Btn");
		click(sendemailbtn);
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Click_StudentInformationIncompleteBtn() throws InterruptedException {
		System.out.println("Click on Student Information Incomplete Btn");
		click(StudentInformationIncomplete);
		Thread.sleep(2000);
		click(showbtn);
		Thread.sleep(2000);
		click(selectallchkbox1);
		sendKeys(sub1, "Automation");
		sendKeys(msg1, "Check report");
		js.executeScript("arguments[0].scrollIntoView();",sendemail1);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sendemail1);
		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Mail Sent Successfully!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Click_HODNotApprovedbtn() throws InterruptedException {
		System.out.println("Click on HOD Not Approved Btn");
		click(HODNotApproved);
		Thread.sleep(2000);
		click(showbtn);
		Thread.sleep(2000);
		click(selectallchkbox2);
		sendKeys(sub1, "Automation");
		sendKeys(msg1, "Check report");
		js.executeScript("arguments[0].scrollIntoView();",sendemail2);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sendemail2);
		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Mail Sent Successfully!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		return this;
	}
	
	public AL_Academic_AP_NewAdmissionConsolidateReport_SendEmail Click_PaymentNotDonebyStudentbtn() throws InterruptedException {
		System.out.println("Click on HOD Not Approved Btn");
		click(PaymentNotDonebyStudent);
		Thread.sleep(2000);
		click(showbtn);
		Thread.sleep(2000);
		click(selectallchkbox3);
		sendKeys(sub1, "Automation");
		sendKeys(msg1, "Check report");
		js.executeScript("arguments[0].scrollIntoView();",sendemail3);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sendemail3);
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Mail Sent Successfully!!";
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		return this;
	}
}
