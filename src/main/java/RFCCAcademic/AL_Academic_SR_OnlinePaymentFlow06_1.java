package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_SR_OnlinePaymentFlow06_1 extends BaseClass{

	public AL_Academic_SR_OnlinePaymentFlow06_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement onlinePaymentOption_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch") private WebElement search_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement search_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement name;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container") private WebElement semester;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPayment") private WebElement paymentBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDualPayment") private WebElement paymentgateway;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnDualPayment") private WebElement pay_btn;
	@FindBy(id = "btnPay") private WebElement btn_pay;

	@FindBy(xpath = "//article[text()='NetBanking']") private WebElement hdfcnetBankingIcon;
	@FindBy(xpath = "//button[text()='Success']") private WebElement succesbtn;

	@FindBy(xpath = "//article[normalize-space()='Avenue Test']") private WebElement avenuetest;
	@FindBy(xpath = "(//article[@role='none'][normalize-space()='proceed to pay'])[2]") private WebElement proceedtoplay;
	@FindBy(xpath = "(//button[normalize-space()='Send Response'])[1]") private WebElement sendResponse;
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_onlinePaymentOption_link() {
		click(onlinePaymentOption_link);
		System.out.println("Online Payment option selected");
		return this;
	}
	public AL_Academic_SR_OnlinePaymentFlow06_1 enter_RRN() {
		search_inputfield.sendKeys("200292601031");
		System.out.println(" Search -> 200292601031");
		return this;
	}
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_search_btn() {
		click(search_btn);
		System.out.println("Click on Search ");
		return this;
	}
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_name() {
		click(name);
		System.out.println("Click on Name");
		return this;
	}
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_semester() {
		click(semester);
		System.out.println("Receipt Type -> Admission Fee");
		return this;
	}
	public AL_Academic_SR_OnlinePaymentFlow06_1 select_semester() throws InterruptedException {
		WebElement semester = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		System.out.println("Semester -> II");
		semester.sendKeys("II");
		Thread.sleep(2000);
		semester.sendKeys(Keys.ENTER);
		System.out.println("second Semester Selected");
		return this;
	}
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_PaymentBtn() {
		click(paymentBtn);
		System.out.println("Click on Payment btn");
		return this;
	}
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 Select_PaymentGateway() throws InterruptedException {
		System.out.println("Select Payment Gateway ");  
		Select select = new Select(paymentgateway);
		select.selectByVisibleText("RAZOR PAY");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",pay_btn);
		pay_btn.click();
		return this;
	}
		
	public AL_Academic_SR_OnlinePaymentFlow06_1 Click_Btn_Pay() {
		System.out.println("Click on btn Pay");
		click(btn_pay);	
		return this;
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Academic_SR_OnlinePaymentFlow06_1 Click_InternetBanking() {
		js.executeScript("arguments[0].click();", hdfcnetBankingIcon);
//		click(hdfcnetBankingIcon);
		System.out.println("Click on HDFC  Bank Net Banking Icon ");
		return this;
	}
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 Click_SuccesBtn() {
		js.executeScript("arguments[0].click();", succesbtn);
//		click(succesbtn);
		System.out.println("Click on Succes Btn");
		return this;
	}
	
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 Click_AvenueTestBtn() throws InterruptedException {
		click(avenuetest);
		System.out.println("Click on Avenue Test btn");
		threadWait1();
		proceedtoplay.click();
		return this;
	}
	
	
	public AL_Academic_SR_OnlinePaymentFlow06_1 click_SendResponseBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",sendResponse);
		click(sendResponse);
		System.out.println("Click on Send Response Btn"); 
		return this;
	}
	
}
