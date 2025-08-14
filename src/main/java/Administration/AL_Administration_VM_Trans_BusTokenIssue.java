package Administration;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Administration_VM_Trans_BusTokenIssue extends BaseClass
{
	public AL_Administration_VM_Trans_BusTokenIssue(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "Bus Token Issue") private WebElement busTokenIssueLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToken40") private WebElement token40Field;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToken30") private WebElement token30Field;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowRpt") private WebElement showReportBtn;
	
	// Random number generator for tokens
	private Random random = new Random();
	
	/**
	 * Click on Bus Token Issue link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Click_BusTokenIssueLink() throws Exception {
		System.out.println("Click on Bus Token Issue link");
		js.executeScript("arguments[0].scrollIntoView();", busTokenIssueLink);
		js.executeScript("arguments[0].click();", busTokenIssueLink);
		return this;
	}
	
	/**
	 * Enter random number between 11-99 for Token40
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Enter_Token40() throws Exception {
		int token40Value = random.nextInt(89) + 11; // Random number between 11-99
		System.out.println("Enter Token40 => " + token40Value);
		token40Field.clear();
		token40Field.sendKeys(String.valueOf(token40Value));
		return this;
	}
	
	/**
	 * Enter random number between 11-99 for Token30
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Enter_Token30() throws Exception {
		int token30Value = random.nextInt(89) + 11; // Random number between 11-99
		System.out.println("Enter Token30 => " + token30Value);
		token30Field.clear();
		token30Field.sendKeys(String.valueOf(token30Value));
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	/**
	 * Click on Report Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Click_ReportBtn() throws Exception {
		System.out.println("Click on Report Button");
		js.executeScript("arguments[0].click();", reportBtn);
		return this;
	}
	

	public AL_Administration_VM_Trans_BusTokenIssue Enter_FromDate() throws Exception {
		System.out.println("Enter From Date => 01/01/2020");
		fromDateField.clear();
		js.executeScript("arguments[0].value = arguments[1]",fromDateField, "01/01/2020");
		return this;
	}
	
	/**
	 * Enter To Date for report
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Enter_ToDate() throws Exception {
		System.out.println("Enter To Date => 01/01/2025");
		toDateField.clear();
		js.executeScript("arguments[0].value = arguments[1]",toDateField, "01/01/2025");
		return this;
	}
	
	/**
	 * Click on Show Report Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusTokenIssue Click_ShowReportBtn() throws Exception {
		System.out.println("Click on Show Report Button");
		js.executeScript("arguments[0].click();", showReportBtn);
		return this;
	}
}
