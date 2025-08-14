package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_FRR_StudentLedgerReport extends BaseClass {
	
	public AL_Academic_FRR_StudentLedgerReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl03_lbLink")
	private WebElement StudentLedgerReport_Link;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSearch-container")
	private WebElement SearchCriteria_Dropdown;
	
	@FindBy(className = "select2-search__field")
	private WebElement SearchCriteria_Option;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch")
	private WebElement SearchString_Input;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchCriteria")
	private WebElement search_button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")
	private WebElement name;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement ledger_report;
	
	public AL_Academic_FRR_StudentLedgerReport Click_Student_Ledger_Report()
	{
		StudentLedgerReport_Link.click();
		System.out.println("Click on Student ledger report");
		return this;
	}
	
	public AL_Academic_FRR_StudentLedgerReport Enter_Search_Criteria()
	{
		System.out.println("Search Criteria -> RRN NO.");
		SearchCriteria_Dropdown.click();
		SearchCriteria_Option.sendKeys("RRN NO.", Keys.ENTER);
		return this;
	}
	
	public AL_Academic_FRR_StudentLedgerReport Enter_Search_String()
	{
		System.out.println("Search String -> 170101601014");
		SearchString_Input.click();
		SearchString_Input.clear();
		SearchString_Input.sendKeys("170101601014");
		return this;
	}
	
	public AL_Academic_FRR_StudentLedgerReport Click_Search_Button() {
		System.out.println("Click on Search Button");
		search_button.click();
		return this;
	}
	
	public AL_Academic_FRR_StudentLedgerReport Select_Name()
	{
		System.out.println("Click on Name -> KEERTHANA PRIYA. R");
		name.click();
		return this;
	}
	
	public AL_Academic_FRR_StudentLedgerReport Click_Ledger_Report() {
	System.out.println("Click on Ledger Report");
	ledger_report.click();
	return this;
	}
	
}
