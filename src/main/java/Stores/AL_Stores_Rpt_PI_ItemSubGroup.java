package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Stores_Rpt_PI_ItemSubGroup extends BaseClass {
	
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement purchaseitem;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt") private WebElement todate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnreport") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblGroup_1") private WebElement itemsubgroup;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Stores_Rpt_PI_ItemSubGroup(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Stores_Rpt_PI_ItemSubGroup click_purchaseitemreport() throws InterruptedException {
		System.out.println("Select Purchase Iteam Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",purchaseitem);
		
		click(purchaseitem);
		return this;
	}
	public AL_Stores_Rpt_PI_ItemSubGroup Select_FromDate() {
		System.out.println("Enter From Date"); 
		clearText(fromdate);
		sendKeys(fromdate,"01/01/2021");
		return this;
	}
	public AL_Stores_Rpt_PI_ItemSubGroup Select_ToDate() {
		System.out.println("Enter To Date");
		clearText(todate);
		sendKeys(todate,"19/12/2025");
		return this;
	}
	
	public AL_Stores_Rpt_PI_ItemSubGroup Select_iteamsubgroupradiobtn() {
		System.out.println("Select Item Sub Group Radio Button");
		click(itemsubgroup);
		return this;
	}
	
	
	public AL_Stores_Rpt_PI_ItemSubGroup Click_ReportBtn() {
		System.out.println("Click Report");
		click(submitbtn);
		return this;
	}
	
}