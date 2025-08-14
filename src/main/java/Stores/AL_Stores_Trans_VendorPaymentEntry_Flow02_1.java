package Stores;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Trans_VendorPaymentEntry_Flow02_1 extends BaseClass
{
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Vendor Payment Entry") private WebElement vendorPaymentEntryLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAddN") private WebElement addNewButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtVPDate") private WebElement dateselect;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlVendor") private WebElement vendorDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPaymentType") private WebElement paymentTypeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPO") private WebElement poDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvVendorPay_ctrl0_txtPayNowAmt") private WebElement payNowAmountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlModeOfPay") private WebElement modeOfPayDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
	// VP Number element that appears after successful form submission
	@FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_divVPNumber']//input") private WebElement vpNumberElement;
	@FindBy(xpath = "//h5[normalize-space()='Vendor Payment Entry List']") private WebElement venderpaymentLable;

	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Click_VendorPaymentEntry() throws Exception {
		System.out.println("Click on Vendor Payment Entry");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", vendorPaymentEntryLink);

		threadWait1();
		js.executeScript("arguments[0].click();", vendorPaymentEntryLink);
		
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Click_AddNewButton() throws Exception {
		System.out.println("Click on Add New button");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", addNewButton);
		js.executeScript("arguments[0].click();", addNewButton);
		
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Select_Date() throws Exception {
		System.out.println("Select Date => 01-04-2025");
		js.executeScript("arguments[0].value = arguments[1]",dateselect, "01/04/2025");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Select_Vendor() throws Exception {
		System.out.println("Select Vendor ==> VENKYS");
		Select select = new Select(vendorDropdown);
		select.selectByVisibleText("VENKYS");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Select_PaymentType() throws Exception {
		System.out.println("Select Payment Type ==> Against PO");
		Select select = new Select(paymentTypeDropdown);
		select.selectByVisibleText("Against PO");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Select_PO() throws Exception {
		System.out.println("Select PO ==> BSACIST/2023/09/11/PO118");
		Select select = new Select(poDropdown);
		select.selectByVisibleText("BSACIST/2023/09/11/PO118");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Enter_PayNowAmount() throws Exception {
		System.out.println("Enter Pay Now Amount ==> 120");
		clearText(payNowAmountField);
		sendKeys(payNowAmountField, "120");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Select_ModeOfPayment() throws Exception {
		System.out.println("Select Mode of Payment ==> Cash");
		Select select = new Select(modeOfPayDropdown);
		select.selectByVisibleText("Cash");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentEntry_Flow02_1 Click_SubmitButton() throws Exception {
		System.out.println("Click on Submit Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", submitButton);

		threadWait1();
		js.executeScript("arguments[0].click();", submitButton);
		
		return this;
	}
	
	/**
	 * Captures the VP Number generated after form submission
	 * @return The VP Number as a string
	 */
	public String getVPNumber() throws Exception {
		threadWait1(); // Wait for the page to update after alert is handled
		// Wait for VP Number element to be present
		js.executeScript("arguments[0].scrollIntoView();", vpNumberElement);
		waitForVisibility(vpNumberElement);
		
		// Since it's an input element, we need to use getAttribute("value") instead of getText()
		String vpNumber = vpNumberElement.getAttribute("value").trim();
		System.out.println("Captured VP Number: " + vpNumber);
		return vpNumber;
	}
	
}
