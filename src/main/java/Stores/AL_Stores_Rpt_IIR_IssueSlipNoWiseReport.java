package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_IIR_IssueSlipNoWiseReport extends BaseClass {

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement IssueItemReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbDirectIssue")
	private WebElement IssueSlipNoWiseReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlIssueNo")
	private WebElement IssueSlipNo;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_btnRpt']")
	private WebElement Show;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel")
	private WebElement ExcelReport;

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport Select_IssueItemReport() {
		System.out.println("Click IssueItemReport");
		IssueItemReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport Select_IssueSlipNoWiseReport() {
		System.out.println("Click IssueSlipNoWiseReport");
		IssueSlipNoWiseReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport Select_IssueSlipNo() {
		System.out.println(" Select IssueSlipNo");
		Select select = new Select(IssueSlipNo);
		select.selectByVisibleText("Issue2023091373");
		return this;
	}

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport Select_Show() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Show);
		System.out.println("Click Show");
		Show.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_IssueSlipNoWiseReport Select_ExcelReport() {
		System.out.println("Click ExcelReport");
		ExcelReport.click();
		return this;
	}

}
