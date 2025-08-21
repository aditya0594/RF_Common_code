package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Stores_Rpt_DepartmentwiseIssueReport extends BaseClass {
	
	@FindBy(id = "ctl00_repLinks_ctl14_lbLink") private WebElement departmentwiseIssuereport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement todate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt") private WebElement submitbtn;
	//@FindBy(id = "ctl00_ContentPlaceHolder1_rblGroup_1") private WebElement itemWarrantyExpiredReport;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Stores_Rpt_DepartmentwiseIssueReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Stores_Rpt_DepartmentwiseIssueReport click_departmentwiseIssuereport() throws InterruptedException {
		System.out.println("Select Department Wise Issue Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",departmentwiseIssuereport);
		
		click(departmentwiseIssuereport);
		return this;
	}
	public AL_Stores_Rpt_DepartmentwiseIssueReport Select_FromDate() {
		System.out.println("Enter From Date");
		waitForVisibility(fromdate);
		sendKeys(fromdate,"01/01/2021");
		return this;
	}
	public AL_Stores_Rpt_DepartmentwiseIssueReport Select_ToDate() {
		System.out.println("Enter To Date");
		waitForVisibility(todate);
		sendKeys(todate,"19/12/2024");
		return this;
	}
	
	public AL_Stores_Rpt_DepartmentwiseIssueReport Click_SubmitBtn() {
		System.out.println("Click Submit");
		click(submitbtn);
		return this;
	}
	
}