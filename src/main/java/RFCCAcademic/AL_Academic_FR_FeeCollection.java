package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_FeeCollection extends BaseClass{

	public AL_Academic_FR_FeeCollection(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Fee Collection")
	private WebElement Fee_Collection_Link;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearchPanel")
	private WebElement Search_Criteria;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearchPanel")
	private WebElement Search_String;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchPanel")
	private WebElement Search_Button;

	@FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_lvStudentPanel_ctrl0_lnkIdPanel']")
	private WebElement first_Name;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlMode-container")
	private WebElement mode_dropdown;

	@FindBy(className = "select2-search__field")
	private WebElement mode_searchfield;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtTotalAmountShow']")
	private WebElement input_totalAmountShow;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTotalAmount")
	private WebElement totalAmount;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRemark")
	private WebElement remark_textbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit_Button;

	public AL_Academic_FR_FeeCollection Click_Fee_Collection_Link() {
		Fee_Collection_Link.click();
		return this;
	}
	
	//Search Criteria Select tab
	public AL_Academic_FR_FeeCollection Select_Search_Criteria() {
		//WebElement criteria = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSearchPanel"));
		Select typ_criteria = new Select(Search_Criteria);
		typ_criteria.selectByVisibleText("RRN NO.");
		System.out.println("Search Criteria -> RRN NO.");
		return this;
	}

	public AL_Academic_FR_FeeCollection Enter_Search_String() {
		Search_String.click();
		Search_String.clear();
		System.out.println("Search String - 210071601003");
		Search_String.sendKeys("210071601003");
		return this;
	}

	public AL_Academic_FR_FeeCollection Click_Search_Button() {
		System.out.println("Click on Search Button");
		Search_Button.click();
		return this;
	}

	public AL_Academic_FR_FeeCollection Click_First_Name() {
		first_Name.click();
		return this;
	}

	public AL_Academic_FR_FeeCollection Select_Fee_Collection_Mode() {
		mode_dropdown.click();
		mode_searchfield.clear();
		mode_searchfield.sendKeys("Counter Collection", Keys.ENTER);
		return this;
	}

	public AL_Academic_FR_FeeCollection Enter_Total_Amount() {
		input_totalAmountShow.click();
		System.out.println("Amount to be Paid -> 1 Rs");
		totalAmount.clear();
		totalAmount.sendKeys("1");
		return this;
	}
	
	public AL_Academic_FR_FeeCollection Click_Submit_Button() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", remark_textbox);
		System.out.println("Scroll down till submit button visible");
		Thread.sleep(2000);
		System.out.println("Click on submit button");
		Submit_Button.click();
		return this;
	}
}

