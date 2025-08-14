package Stores;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_RequiredTotalItem extends BaseClass
{
	public AL_Stores_Rpt_RequiredTotalItem(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Required Total Item") private WebElement requiredTotalItem;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnGRR") private WebElement requireQtyReportBtn;

	public AL_Stores_Rpt_RequiredTotalItem Click_RequiredTotalItem() throws Exception {
		System.out.println("Click on Required Total Item");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", requiredTotalItem);

		threadWait1();
		js.executeScript("arguments[0].click();", requiredTotalItem);
		
		return this;
	}
	
	public AL_Stores_Rpt_RequiredTotalItem Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Stores_Rpt_RequiredTotalItem Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Stores_Rpt_RequiredTotalItem Click_RequireQtyReportButton() throws Exception {
		System.out.println("Click on Require Qty Report Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", requireQtyReportBtn);

		threadWait1();
		js.executeScript("arguments[0].click();", requireQtyReportBtn);
		
		return this;
	}
}
