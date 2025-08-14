package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.BaseClass;

public class AL_Stores_Rpt_ItemExpiryWarrantyReport extends BaseClass {
	@FindBy(id = "ctl00_repLinks_ctl17_lbLink") private WebElement itemExpiryWarrantyReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement todate;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItem-container") private WebElement item;
	@FindBy(xpath = "//*[@class=\"select2-search__field\"]") private WebElement searchitem;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblGroup_1") private WebElement itemWarrantyExpiredReport;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Click_ItemExpiryWarrantyReport() throws InterruptedException {
		System.out.println("Select Item Expiry Warranty Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",itemExpiryWarrantyReport);
		
		click(itemExpiryWarrantyReport);
		return this;
	}
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Select_FromDate() {
		System.out.println("Enter From Date"); 
		sendKeys(fromdate,"01/03/2021");
		return this;
	}
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Select_ToDate() {
		System.out.println("Enter To Date");
		sendKeys(todate,"01/03/2024");
		return this;
	}
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Select_Item() {
		System.out.println("Select Item");
		click(item);
		searchitem.sendKeys("ALMIRAH",Keys.ENTER);
		return this;
	}
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Click_SubmitBtn() {
		System.out.println("Click Submit");
		click(submitbtn);
		return this;
	}
	
	public AL_Stores_Rpt_ItemExpiryWarrantyReport Click_ItemWarrantyExpiredReport() {
		System.out.println("Click Item Warranty Expired Report");
		click(itemWarrantyExpiredReport);
		return this;
	}
	
	
}
