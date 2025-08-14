package Hostel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

/**
 * AL_Hostel_FR_CreateStandardFee class handles operations related to Hostel Standard Fee creation
 */
public class AL_Hostel_FR_CreateStandardFee extends BaseClass {

	public AL_Hostel_FR_CreateStandardFee(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement createStandardFeeLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlHostelSessionNo") private WebElement sessionDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlHostel") private WebElement hostelDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType") private WebElement receiptTypeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRoomType") private WebElement roomTypeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lstFeesItems") private WebElement feeItemByNameSearch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lstPaymentType") private WebElement paymentTypeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lv_ctrl0_txtSem1") private WebElement feesOne;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lv_ctrl1_txtSem1") private WebElement feesTwo;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lv_ctrl2_txtSem1") private WebElement feesThree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;


	/**
	 * Click on Create Standard Fee link
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee clickCreateStandardFeeLink() throws InterruptedException {
		System.out.println("Click on Standard Fee");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", createStandardFeeLink);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createStandardFeeLink);
		return this;
	}
	
	/**
	 * Select Session from dropdown
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee selectSession() throws InterruptedException {
		System.out.println("Select Session ==> 2023-2024");
		Thread.sleep(1000);
		Select select = new Select(sessionDropdown);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	/**
	 * Select Hostel from dropdown
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee selectHostel() throws InterruptedException {
		System.out.println("Select Hostel ==> ABC GIRLS HOSTEL");
		Thread.sleep(1000);
		Select select = new Select(hostelDropdown);
		select.selectByVisibleText("ABC GIRLS HOSTEL");
		return this;
	}
	
	/**
	 * Select Receipt Type from dropdown
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee selectReceiptType() throws InterruptedException {
		System.out.println("Select Receipt Type ==> Hostel Fees");
		Thread.sleep(1000);
		Select select = new Select(receiptTypeDropdown);
		select.selectByVisibleText("Hostel Fees");
		return this;
	}
	
	/**
	 * Select Room Type from dropdown
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee selectRoomType() throws InterruptedException {
		System.out.println("Select Room Type ==> REST ROOM");
		Thread.sleep(1000);
		Select select = new Select(roomTypeDropdown);
		select.selectByVisibleText("REST ROOM");
		return this;
	}
	
	/**
	 * Search Fee Item by Name
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee searchFeeItemByName() throws InterruptedException {
		System.out.println("Search Fee Item By Name ==> 443");
		Thread.sleep(1000);
		Select select = new Select(feeItemByNameSearch);
		select.selectByValue("443");
		return this;
	}
	
	/**
	 * Select Payment Type from dropdown
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee selectPaymentType() throws InterruptedException {
		System.out.println("Select Payment Type ==> General");
		Thread.sleep(1000);
		Select select = new Select(paymentTypeDropdown);
		select.selectByVisibleText(" General");
		return this;
	}
	
	/**
	 * Click Show Fee Definition button
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee clickShowFeeDefinitionButton() throws InterruptedException {
		System.out.println("Click on Show Fee Definition button");
		Thread.sleep(1000);
		click(showBtn);
		return this;
	}
	
	/**
	 * Enter Fees for first item
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee enterFeesOne() throws InterruptedException {
		System.out.println("Enter Fees One ==> 500");
		Thread.sleep(1000);
		feesOne.clear();
		feesOne.sendKeys("500");
		return this;
	}
	
	/**
	 * Enter Fees for second item
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee enterFeesTwo() throws InterruptedException {
		System.out.println("Enter Fees Two ==> 200");
		Thread.sleep(1000);
		feesTwo.clear();
		feesTwo.sendKeys("200");
		return this;
	}
	
	/**
	 * Enter Fees for third item
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee enterFeesThree() throws InterruptedException {
		System.out.println("Enter Fees Three ==> 150");
		Thread.sleep(1000);
		feesThree.clear();
		feesThree.sendKeys("150");
		return this;
	}
	
	/**
	 * Click Submit button to save the fees
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee clickSubmitButton() throws InterruptedException {
		System.out.println("Click on Submit button");
		Thread.sleep(1000);
		click(submitButton);
		return this;
	}
	
	/**
	 * Handle alert after form submission
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread is interrupted
	 */
	public AL_Hostel_FR_CreateStandardFee handleAlert() throws InterruptedException {
		System.out.println("Handling alert message");
		Thread.sleep(2000);
		try {
			org.openqa.selenium.Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert message: " + alertText);
			alert.accept();
		} catch (Exception e) {
			System.out.println("No alert present or error handling alert: " + e.getMessage());
		}
		return this;
	}
	
}
