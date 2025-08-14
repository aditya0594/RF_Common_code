package Stores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Trans_DepartmentUserRequisitonReport extends BaseClass{

	public AL_Stores_Trans_DepartmentUserRequisitonReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText = "STORES") private WebElement stores;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbReqFor_0") private WebElement purchase;
	@FindBy(id = "ctl00_ContentPlaceHolder1_butReport") private WebElement showReport_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReportIndentSlipNo") private WebElement reportIndentSlipno;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement report_Button;
	

	public AL_Stores_Trans_DepartmentUserRequisitonReport click_Purchase() {
		click(purchase);
		System.out.println("Click on purchase");
		return this;
	}
	public AL_Stores_Trans_DepartmentUserRequisitonReport click_ShowReport_Button() {
		click(showReport_Button);
		System.out.println("Click on Show Report");
		return this;
	}
	public AL_Stores_Trans_DepartmentUserRequisitonReport click_reportIndentSlipno() {
		Select Req_slipNo = new Select(reportIndentSlipno);
		Req_slipNo.selectByVisibleText("BSACIST/MAIN STORE/2023/07/PUR/REQ22");
		System.out.println("Select Requisition slip no. is: BSACIST/MAIN STORE/2023/07/PUR/REQ22 is selected");
		return this;
	}
	public AL_Stores_Trans_DepartmentUserRequisitonReport click_Report_Button() {
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport")).click();
		click(report_Button);
		System.out.println("Click on Report Button");
		return this;
	}
	
}
