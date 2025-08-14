package Stores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Stores_Rpt_IIR_IndentSlipReport extends BaseClass {

	public AL_Stores_Rpt_IIR_IndentSlipReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement IssueItemReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbIndentSlip")
	private WebElement IndentSlipReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt")
	private WebElement ShowReport;

	public AL_Stores_Rpt_IIR_IndentSlipReport Select_IssueItemReport() {
		System.out.println("Click IssueItemReport");
		IssueItemReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_IndentSlipReport Select_IndentSlipReport() {
		System.out.println("Click IndentSlipReport");
		IndentSlipReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_IndentSlipReport Select_ShowReport() {
		System.out.println("Click ShowReport");
		ShowReport.click();
		return this;
	}

}
