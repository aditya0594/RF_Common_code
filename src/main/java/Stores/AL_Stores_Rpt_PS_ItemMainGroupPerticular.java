package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Stores_Rpt_PS_ItemMainGroupPerticular extends BaseClass {
	@FindBy(id = "ctl00_repLinks_ctl12_lbLink")
	private WebElement purchaseSummary;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt")
	private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt")
	private WebElement todate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnreport")
	private WebElement btnreport;
		
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblSelectAllItem_0")
	private WebElement perticular;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItem-container")
	private WebElement item;
	
	@FindBy(xpath = "//*[@class=\"select2-search__field\"]")
	private WebElement itemname;
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Stores_Rpt_PS_ItemMainGroupPerticular(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public AL_Stores_Rpt_PS_ItemMainGroupPerticular click_PurchaseSummary() throws InterruptedException {
		System.out.println("Click Purchase Summary");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", purchaseSummary);
		click(purchaseSummary);
		return this;
	}

	public AL_Stores_Rpt_PS_ItemMainGroupPerticular Select_FromDate() {
		System.out.println("Enter From Date");
		js.executeScript("arguments[0].value='01/01/2021';", fromdate); 
		return this;
	}

	public AL_Stores_Rpt_PS_ItemMainGroupPerticular Select_ToDate() {
		System.out.println("Enter To Date");
		js.executeScript("arguments[0].value='19/12/2024';", todate); 
		return this;
	}
	
	public AL_Stores_Rpt_PS_ItemMainGroupPerticular Click_PerticularRadioBtn() {
		System.out.println("Click perticular Radio Button");
		click(perticular);
		return this;
	}
	
	public AL_Stores_Rpt_PS_ItemMainGroupPerticular Select_Item() {
		System.out.println("Select Item");
		click(item);
		itemname.sendKeys("CONSUMABLE",Keys.ENTER);
		return this;
	}
	
	public AL_Stores_Rpt_PS_ItemMainGroupPerticular Click_ReportBtn() {
		System.out.println("Click Report Button");
		click(btnreport);
		return this;
	}

}
