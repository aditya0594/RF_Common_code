package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_ItemSaleReport extends BaseClass{
	
	@FindBy(id = "ctl00_repLinks_ctl08_rptLi") private WebElement iteamsalerpt;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement todate;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSubCategory-container") private WebElement subcategory;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt") private WebElement submitbtn;

	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Stores_Rpt_ItemSaleReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Stores_Rpt_ItemSaleReport Click_IteamSaleReport() throws InterruptedException {
		System.out.println("Iteam Sale Report Selected");
			
		click(iteamsalerpt);
		return this;
	}
	
	public AL_Stores_Rpt_ItemSaleReport Select_FromDate() {
		System.out.println("Enter From Date"); 
		js.executeScript("arguments[0].value = arguments[1]",fromdate, "01/03/2021");
		sendKeys(fromdate,"01/03/2021");
		return this;
	}
	public AL_Stores_Rpt_ItemSaleReport Select_ToDate() {
		System.out.println("Enter To Date");
		js.executeScript("arguments[0].value = arguments[1]",todate, "01/03/2023");
		return this;
	}
	
	public AL_Stores_Rpt_ItemSaleReport Select_SubCategory() {
		System.out.println("Select Sub Category");
		Select select = new Select(subcategory);
		select.selectByVisibleText("MOBILE PHONE"); 
		return this;
	}
	
	public AL_Stores_Rpt_ItemSaleReport Click_SubmitBtn() {
		System.out.println("Select Sub Category");
		click(submitbtn);
		return this;
	}
	
}
