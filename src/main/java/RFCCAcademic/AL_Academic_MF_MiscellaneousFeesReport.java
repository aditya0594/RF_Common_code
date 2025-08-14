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

public class AL_Academic_MF_MiscellaneousFeesReport extends BaseClass{

	public AL_Academic_MF_MiscellaneousFeesReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[text()='Miscellaneous Fees Report']") private WebElement MiscellaneousFeesReport_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCashbook") private WebElement Cashbook_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPaytype") private WebElement Paytype_Dropdown;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtFromDate") private WebElement FromDate_Inputbox;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtTodate") private WebElement ToDate_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSummaryReport") private WebElement summaryReport_Button;
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	public AL_Academic_MF_MiscellaneousFeesReport click_MiscellaneousFeesReport() throws InterruptedException {
		System.out.println("click Miscellaneous fees Report");
		js.executeScript("arguments[0].scrollIntoView();",MiscellaneousFeesReport_Link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", MiscellaneousFeesReport_Link);

		return this;
	}
	
	public AL_Academic_MF_MiscellaneousFeesReport select_Cashbook() {
		Select cashbook = new Select(Cashbook_Dropdown);
		cashbook.selectByVisibleText("Miscellaneous Fees");
		System.out.println("Select Cash Book -> Miscellaneous Fees");
		return this;
	}
	
	public AL_Academic_MF_MiscellaneousFeesReport select_TransactionType() {
		Select transcationtype = new Select(Paytype_Dropdown);
		transcationtype .selectByVisibleText("Payment");
		System.out.println("Select Transaction Type -> Payment");
		return this;
	}
	
	public AL_Academic_MF_MiscellaneousFeesReport enter_FromDate() {
		FromDate_Inputbox.sendKeys("01/05/2023", Keys.ENTER);
		System.out.println("Enter From Date -> 01/05/2023");
		return this;
	}
	
	public AL_Academic_MF_MiscellaneousFeesReport enter_ToDate() {
		ToDate_Inputbox.sendKeys("05/05/2024", Keys.ENTER);
		System.out.println("Enter To Date -> 05/05/2024");
		return this;
	}
	
	public AL_Academic_MF_MiscellaneousFeesReport click_FeeCollectionSummaryReport() {
		summaryReport_Button.click();
		System.out.println("Click on Fee Collection Summary Report");
		return this;
	}
	
	
	
}
