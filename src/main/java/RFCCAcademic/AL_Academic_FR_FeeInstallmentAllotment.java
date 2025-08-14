package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_FeeInstallmentAllotment extends BaseClass{

	public AL_Academic_FR_FeeInstallmentAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl20_lbLink") private WebElement feeInstallmentAllotment_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblisintallmentconfig_3") private WebElement bulkStudentFeesDiscount_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlschool") private WebElement school_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddldegreedis") private WebElement degree_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlbranchdis") private WebElement branch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlsemesterdis") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlreceiptdis") private WebElement receiptType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlpaymentdis") private WebElement paymentType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnshowdis") private WebElement show_btn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchbar;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdConcessionOption_0") private WebElement amountwise_button;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input[@type='checkbox']") private WebElement checkbox;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//select[@id]") private WebElement discountType_dropdown;
	@FindBy(xpath = "//th[contains(text(),'Discount Fee')]//input[@type='text']") private WebElement discountAmount_input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmitdis") private WebElement submit_btn;
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_FeeInstallmentAllotment click_feeInstallemntAllotment_Link() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();",feeInstallmentAllotment_Link);
		Thread.sleep(2000);	
		js.executeScript("arguments[0].click();",feeInstallmentAllotment_Link);		
		System.out.println("Click on fee Installment Allotment");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment click_bulkStudFeesDiscount(){
		js.executeScript("arguments[0].click();",bulkStudentFeesDiscount_btn);	
		System.out.println("Click on Bulk Student Fees Discount");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_School(){
		Select typ_scl = new Select (school_dropdown);
		typ_scl.selectByVisibleText("Crescent School of Business");
		System.out.println("Select School/Institute -> Crescent School of Business");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_Degree(){
		Select typ_deg = new Select (degree_dropdown);
		typ_deg.selectByVisibleText("Master of Business Administration");
		System.out.println("Select Degree -> Master of Business Administration");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_branch() {
		Select typ_branch = new Select (branch_dropdown);
		typ_branch.selectByVisibleText("Business Administration"); 
		System.out.println("Select Branch ->Business Administration");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_Semester(){
		Select typ_sem = new Select (semester_dropdown);
		typ_sem.selectByVisibleText("I"); 
		System.out.println("Select Semester ->I ");	
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_receiptType(){
		Select typ_receipt = new Select (receiptType_dropdown);
		typ_receipt.selectByVisibleText("Admission Fee");
		System.out.println("Select Receipt Type ->Admission Fee");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_paymentType(){
		Select typ_Payment = new Select (paymentType_dropdown);
		typ_Payment.selectByVisibleText("General");
		System.out.println("Select Payment Type -> General"); 
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment click_show_btn(){
		click(show_btn);
		System.out.println("Click on show button");
		return this;
	}
	
	public AL_Academic_FR_FeeInstallmentAllotment SearchBar(){
		searchbar.sendKeys("Not Utilize");
		System.out.println("Search Bar -> Not Utilize");
		return this;
	}
	
	public AL_Academic_FR_FeeInstallmentAllotment click_amountwise_btn(){
		click(amountwise_button);
		System.out.println("Select Amountwise button");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment click_checkbox() throws InterruptedException{
		js.executeScript("arguments[0].click();", checkbox);
		Thread.sleep(2000);
		System.out.println("click on checkboxes");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment select_discountType(){
		Select dd2 = new Select(discountType_dropdown); 
		dd2.selectByVisibleText("Regular");
		System.out.println("Selected Discount Type");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment enter_discountAmount(){
		discountAmount_input.sendKeys("500");
		System.out.println("Enter Discount Amount");
		return this;
	}
	public AL_Academic_FR_FeeInstallmentAllotment click_Submit_Btn(){
		click(submit_btn);
		System.out.println("Click on submit button");
		return this;
	}
	
}
