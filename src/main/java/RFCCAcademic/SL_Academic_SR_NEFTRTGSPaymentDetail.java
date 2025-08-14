package RFCCAcademic;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

/**
 * SL_Academic_SR_NEFTRTGSPaymentDetail class handles operations related to NEFT/RTGS payment details
 */
public class SL_Academic_SR_NEFTRTGSPaymentDetail extends BaseClass {

	public SL_Academic_SR_NEFTRTGSPaymentDetail(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement neftRtgsPaymentDetailsLink;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceipt")
	private WebElement receiptTypeDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester")
	private WebElement semesterDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTransaction")
	private WebElement transactionIdInputbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDate")
	private WebElement dateTextbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtBankName")
	private WebElement bankNameInputbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAmount")
	private WebElement amountInputbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuUpload")
	private WebElement fileUploadInput;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement submitButton;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/**
	 * Clicks on the NEFT/RTGS Payment Details link
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Click_NEFTRTGSDetails_Link() throws InterruptedException {
		System.out.println("Click on NEFT/RTGS Payment Details");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", neftRtgsPaymentDetailsLink);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", neftRtgsPaymentDetailsLink);
		return this;
	}
	
	/**
	 * Selects the Receipt Type as "Admission Fee"
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Select_ReceiptType() throws InterruptedException {
		System.out.println("Select Receipt Type ==> Admission Fee");
		Thread.sleep(1000);
		Select receiptType = new Select(receiptTypeDropdown);
		receiptType.selectByVisibleText("Admission Fee");
		return this;
	}
	
	/**
	 * Selects the Semester as "I"
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Select_Semester() throws InterruptedException {
		System.out.println("Select Semester ==> I");
		Thread.sleep(1000);
		Select semester = new Select(semesterDropdown);
		semester.selectByVisibleText("I");
		return this;
	}
	
	/**
	 * Enters the Transaction ID
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Enter_Transaction_ID() throws InterruptedException {
		System.out.println("Enter Transaction ID ==> 5441212");
		Thread.sleep(1000);
		transactionIdInputbox.clear();
		transactionIdInputbox.sendKeys("5441212");
		return this;
	}
	
	/**
	 * Selects the date
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Select_Date() throws InterruptedException {
		System.out.println("Select Date ==> 14/12/2023");
		Thread.sleep(1000);
		dateTextbox.clear();
		dateTextbox.sendKeys("14/12/2023");
		return this;
	}
	
	/**
	 * Enters the Bank Name
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Enter_Bank_Name() throws InterruptedException {
		System.out.println("Enter Bank Name ==> HDFC Bank");
		Thread.sleep(1000);
		bankNameInputbox.clear();
		bankNameInputbox.sendKeys("HDFC Bank");
		return this;
	}
	
	/**
	 * Enters the Amount
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Enter_Amount() throws InterruptedException {
		System.out.println("Enter Amount ==> 1");
		Thread.sleep(1000);
		amountInputbox.clear();
		amountInputbox.sendKeys("1");
		return this;
	}
	
	/**
	 * Uploads the required file
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Upload_File() throws InterruptedException {
		System.out.println("Uploading Signature file");
		Thread.sleep(1000);
		File uploadFile = new File(".\\src\\test\\resources\\documentsForTesting\\Signature.png");
		fileUploadInput.sendKeys(uploadFile.getAbsolutePath());
		return this;
	}
	
	/**
	 * Scrolls to the Submit button
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Scroll_To_Submit_Button() throws InterruptedException {
		System.out.println("Scrolling to Submit button");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", submitButton);
		return this;
	}

	/**
	 * Clicks the Submit button
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Click_Submit_Button() throws InterruptedException {
		System.out.println("Click on Submit button");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", submitButton);
		return this;
	}
	
	/**
	 * Handles the alert that appears after submitting
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public SL_Academic_SR_NEFTRTGSPaymentDetail Handle_Alert() throws InterruptedException {
		System.out.println("Handling alert");
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		/*
		 * String Expected_Msg = ""; //Payment Details Is Already Exists.
		 * String Actual_Msg = alert.getText();
		 * Thread.sleep(2000);
		 * Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		 */
		
		String alertText = alert.getText();
		System.out.println("Alert message: " + alertText);
		alert.accept();
		
		return this;
	}
}
