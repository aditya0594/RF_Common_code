package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_IIR_RequisitionWiseReport extends BaseClass {

	public AL_Stores_Rpt_IIR_RequisitionWiseReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement IssueItemReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbRequisition")
	private WebElement RequisitionWiseReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRequisitionNo")
	private WebElement RequisitionNo;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_btnRpt']")
	private WebElement Show;

	public AL_Stores_Rpt_IIR_RequisitionWiseReport Select_IssueItemReport() {
		System.out.println("Click IssueItemReport");
		IssueItemReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_RequisitionWiseReport Select_RequisitionWiseReport() {
		System.out.println("Click RequisitionWiseReport");
		RequisitionWiseReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_RequisitionWiseReport Select_RequisitionNo() {
		System.out.println(" Select RequisitionNo");
		Select select = new Select(RequisitionNo);
		select.selectByVisibleText("CRESCENT/COE/2022/10/ISSUE/REQ27");
		return this;
	}

	public AL_Stores_Rpt_IIR_RequisitionWiseReport Select_Show() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Show);
		System.out.println("Click Show");
		Show.click();
		return this;
	}

}
