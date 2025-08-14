package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Stores_Rpt_SearchRequisition extends BaseClass{
	@FindBy(id = "ctl00_repLinks_ctl16_lbLink") private WebElement searchRequisition ;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement todate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDepartment_ctrl174_btnEditPartyCategory") private WebElement printreport;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	public AL_Stores_Rpt_SearchRequisition(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Stores_Rpt_SearchRequisition click_SearchRequisition() throws InterruptedException {
		System.out.println("Select Search Requisition");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",searchRequisition);
		click(searchRequisition);
		return this;
	}
	public AL_Stores_Rpt_SearchRequisition Select_FromDate() {
		System.out.println("Enter From Date"); 
		sendKeys(fromdate,"01/01/2021");
		return this;
	}
	public AL_Stores_Rpt_SearchRequisition Select_ToDate() {
		System.out.println("Enter To Date");
		sendKeys(todate,"19/12/2024");
		return this;
	}
	
	public AL_Stores_Rpt_SearchRequisition Click_ShowBtn() {
		System.out.println("Click Show Button");
		click(showbtn);
		return this;
	}
	public AL_Stores_Rpt_SearchRequisition Click_PrintReport() {
		System.out.println("Click print Report Button");
		click(printreport);
		return this;
	}
	

}
