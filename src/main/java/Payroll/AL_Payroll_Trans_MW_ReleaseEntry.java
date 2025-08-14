package Payroll;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_ReleaseEntry extends BaseClass
{
	JavascriptExecutor js = (JavascriptExecutor)driver;

	@FindBy(linkText = "Release Entry")
	private WebElement releaseEntryLink;
	
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'][normalize-space()='None selected'])[1]")
	private WebElement collegeField;
	
	@FindBy(xpath = "(//input[@value='multiselect-all'])[1]")
	private WebElement selectAllCollege;
	
	@FindBy(xpath = "(//span[normalize-space()='None selected'])[1]")
	private WebElement staffField;
	
	@FindBy(xpath = "(//input[@value='multiselect-all'])[2]")
	private WebElement selectAllStaff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement showBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvWithheldWithdrawn_ctrl0_txtWithdrawnRemark")
	private WebElement remarkField;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement saveBtn;

	public AL_Payroll_Trans_MW_ReleaseEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/**
	 * Click on Release Entry link
	 * 
	 * @return instance of AL_Payroll_Trans_MW_ReleaseEntry
	 * @throws Exception
	 */
	public AL_Payroll_Trans_MW_ReleaseEntry Click_ReleaseEntry() throws Exception {
		System.out.println("Click Release Entry");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", releaseEntryLink);
		threadWait1();
		js.executeScript("arguments[0].click();", releaseEntryLink);
		return this;
	}
	
	/**
	 * Click on College dropdown field and select all colleges
	 * 
	 * @return instance of AL_Payroll_Trans_MW_ReleaseEntry
	 * @throws Exception
	 */
	public AL_Payroll_Trans_MW_ReleaseEntry Select_AllColleges() throws Exception {
		System.out.println("Select All Colleges");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", collegeField);
		threadWait1();
		js.executeScript("arguments[0].click();", collegeField);
		threadWait1();
		js.executeScript("arguments[0].click();", selectAllCollege);
		return this;
	}
	
	
	public AL_Payroll_Trans_MW_ReleaseEntry Select_AllStaff() throws Exception {
		System.out.println("Select All Staff");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", staffField);
		threadWait1();
		js.executeScript("arguments[0].click();", staffField);
		threadWait1();
		js.executeScript("arguments[0].click();", selectAllStaff);
		return this;
	}
	
	
	public AL_Payroll_Trans_MW_ReleaseEntry Click_ShowButton() throws Exception {
		System.out.println("Click on Show button");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", showBtn);
		threadWait1();
		js.executeScript("arguments[0].click();", showBtn);
		return this;
	}
	

	public AL_Payroll_Trans_MW_ReleaseEntry Enter_WithdrawRemark() throws Exception {
		System.out.println("Enter Release in Withdraw Remark field");
		threadWait1();
//		js.executeScript("arguments[0].scrollIntoView();", remarkField);
		threadWait1();
		clearText(remarkField);
		sendKeys(remarkField, "Release");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ReleaseEntry Click_SaveButton() throws Exception {
		System.out.println("Click on Save button");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		threadWait1();
		js.executeScript("arguments[0].click();", saveBtn);
		return this;
	}
}
