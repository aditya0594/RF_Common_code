package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AR_AttendancePendingDashboard extends BaseClass{

	public AL_Academic_AR_AttendancePendingDashboard(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Attendance Pending Dashboard") private WebElement attendancePendingDashboard_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdblBulkEmail_0") private WebElement singleEmailSending_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement toDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvParent_ctl05_btnSendDeptMail") private WebElement sendEmail_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSubject") private WebElement subject_textarea;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtBody") private WebElement body_textarea;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSent") private WebElement sent_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdblBulkEmail_1") private WebElement bulkEmailSending_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionBulk") private WebElement sessionBulk_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtbulkFDate") private WebElement fromDateBulk_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnbulkShow") private WebElement showBulk_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_gvBulkEmail_ctl02_chkSelect") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSendEmail") private WebElement sendEmailBulk_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtbulkTDate") private WebElement toDateBulk_inputfield;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AR_AttendancePendingDashboard click_attendancePendingDashboard_link() throws InterruptedException 
	{
		System.out.println("Academic Reports menu selected > Attendance Pending Dashboard ");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",attendancePendingDashboard_link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", attendancePendingDashboard_link);

		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_singleEmailSending_radioBtn() 
	{
		singleEmailSending_radioBtn.click();
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard select_session() 
	{
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("Crescent School of Law-Dec - 2023");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_fromDate() 
	{
		fromDate_inputfield.sendKeys("01/01/2021");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_toDate() 
	{
		toDate_inputfield.sendKeys("31/01/2025");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_show_btn() 
	{
		show_btn.click();
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_sendEmail_btn() 
	{
		sendEmail_btn.click();
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_subject() 
	{
		subject_textarea.sendKeys("test");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_body() 
	{
		body_textarea.sendKeys("test");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_sent_btn() 
	{
		sent_button.click();
		return this;
	}
	
	//"Email Sent Successfully"
	
	public AL_Academic_AR_AttendancePendingDashboard click_bulkEmailSending_radioBtn() 
	{
		bulkEmailSending_radioBtn.click();
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard select_BulkSession() 
	{
		Select options = new Select(sessionBulk_dropdown);
		options.selectByVisibleText("Crescent School of Law-Dec - 2023");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_fromDateBulk() 
	{
		fromDateBulk_inputfield.sendKeys("01/12/2021");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard enter_toDateBulk() 
	{
		toDateBulk_inputfield.sendKeys("01/01/2025");
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_showBulk_button() 
	{
		click(showBulk_btn);
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_checkbox() 
	{
		checkbox.click();
		return this;
	}
	public AL_Academic_AR_AttendancePendingDashboard click_sendEmailBulk_Btn() 
	{
		sendEmailBulk_btn.click();
		return this;
	}
	
	//Email Sent Successfully
	
}
