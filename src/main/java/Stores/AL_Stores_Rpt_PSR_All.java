package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Stores_Rpt_PSR_All extends BaseClass {
	@FindBy(id = "ctl00_repLinks_ctl01_lbLink")
	private WebElement postockreports;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate")
	private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement todate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt")
	private WebElement btnreport;
		
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblSelectAllItem_0")
	private WebElement perticular;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlReport-container")
	private WebElement item;
	
	@FindBy(xpath = "//*[@class=\"select2-search__field\"]")
	private WebElement itemname;
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Stores_Rpt_PSR_All(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public AL_Stores_Rpt_PSR_All click_POStockReports() throws InterruptedException {
		System.out.println("Click PO Storck Reports");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", postockreports);
		click(postockreports);
		return this;
	}

	public AL_Stores_Rpt_PSR_All Select_FromDate() {
		System.out.println("Enter From Date");
		js.executeScript("arguments[0].value='01/01/2021';", fromdate); 
		return this;
	}

	public AL_Stores_Rpt_PSR_All Select_ToDate() {
		System.out.println("Enter To Date");
		js.executeScript("arguments[0].value='19/12/2024';", todate); 
		return this;
	}
	
	public AL_Stores_Rpt_PSR_All Select_POType() {
		System.out.println("Select PO Tyep");
		click(item);
		itemname.sendKeys("All",Keys.ENTER);
		return this;
	}
	
	
	public AL_Stores_Rpt_PSR_All Click_ReportBtn() {
		System.out.println("Click Report Button");
		click(btnreport);
		return this;
	}
}
