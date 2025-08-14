package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import RFCCAcademic.AL_Academic_AR_BulkUpdateOfPhoto;
import utility.BaseClass;

public class AL_Academic_PA_BulkYearAllotment extends BaseClass{

	public AL_Academic_PA_BulkYearAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Bulk Batch & Year Allotment") private WebElement bulkBatchYearAllotment;
	@FindBy(linkText = "Academic Year Allotment") private WebElement academicyearallotment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmBatchAcdYear") private WebElement admissionBatch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchool") private WebElement school_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowAcdYear") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAcdYearAllotment_ctrl0_chkRegisterAcdYear") private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAcdYear") private WebElement academicYear_dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitAcdYear") private WebElement submit_button;
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Academic_PA_BulkYearAllotment click_BulkYearAllotment() throws InterruptedException 
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",bulkBatchYearAllotment);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", bulkBatchYearAllotment);

		return this;
	}
	
	public AL_Academic_PA_BulkYearAllotment click_academicYearAllotment_tab() 
	{
		academicyearallotment.click();
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment select_admissionBatch() 
	{
		Select opt = new Select(admissionBatch_dropdown);
		opt.selectByVisibleText("2021-22");
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment select_school() 
	{
		Select opt = new Select(school_dropdown);
		opt.selectByVisibleText("Crescent School of Pharmacy");
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment click_show_button() 
	{
		show_button.click();
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment check_checkbox() 
	{
		checkbox.click();
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment select_academicYear() 
	{
		Select opt = new Select(academicYear_dropdown);
		opt.selectByVisibleText("2022-2023");
		return this;
	}
	public AL_Academic_PA_BulkYearAllotment click_submit_button() 
	{
		submit_button.click();
		return this;
	}
	
	
	
}
