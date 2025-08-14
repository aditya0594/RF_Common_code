package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_FR_CancelFeesRefund extends BaseClass{

	public AL_Academic_FR_CancelFeesRefund(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Fee Related")
	private WebElement FeeRelated;

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement FeesRefund;
	
	@FindBy(xpath = "(//a[normalize-space()='Refund Cancel'])[1]")
	private WebElement RefundCancelTab;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch2")
	private WebElement SearchRRN;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsearche2")
	private WebElement SearchButton;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent2_ctrl0_lnkId2")
	private WebElement StudentName;
	
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]")
	private WebElement SearchAmount;
	
	@FindBy(xpath = "//span[text()='Not Cancelled']/../../td[1]/span/input")
	private WebElement CheckBox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCancelRefund")
	private WebElement RefundCancelButton;
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academic_FR_CancelFeesRefund ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academic_FR_CancelFeesRefund ClickFeeRelatedTest() {
		System.out.println("Click Fee Related submenu");
		action.moveToElement(FeeRelated).click().build().perform();
		return this;
	}

	public AL_Academic_FR_CancelFeesRefund ClickFeesRefundTest() {
		System.out.println("Click on Fees Refund");
		FeesRefund.click();
		return this;
	}

	public AL_Academic_FR_CancelFeesRefund ClickRefundCancelTabTest() {
		System.out.println("Click on Refund Cancel Tab");
		RefundCancelTab.click();
		return this;
	}
	
	public AL_Academic_FR_CancelFeesRefund SearchRRNTest() {
		System.out.println("Search RRN NO");
		SearchRRN.clear();
		SearchRRN.sendKeys("201431601001");
		return this;
	}
	
	public AL_Academic_FR_CancelFeesRefund SearchButtonTest() {
		System.out.println("Search Button");
		SearchButton.click();
		return this;
	}
	
	public AL_Academic_FR_CancelFeesRefund ClickStudentNameTest() {
		System.out.println("Click on Student Name");
		StudentName.click();
		return this;
	}
	
	public AL_Academic_FR_CancelFeesRefund SearchNotCancelledAmountTest() {
		System.out.println("Search Not Cancelled Amount");
		SearchAmount.clear();
		SearchAmount.sendKeys("Not Cancel");
		return this;
	}
	
	public AL_Academic_FR_CancelFeesRefund ClickStudentCheckboxTest() throws Throwable {
		System.out.println("Click on Student Checkbox");
		js.executeScript("arguments[0].scrollIntoView();", CheckBox);
		
		Thread.sleep(2000);
		CheckBox.click();

		return this;
	}

	public AL_Academic_FR_CancelFeesRefund ClickRefundCancelButtonTest() {
		System.out.println("Click on Refund Cancel Button");
		//click(RefundCancelButton);
		js.executeScript("arguments[0].click();", RefundCancelButton);
		return this;
	}
}
