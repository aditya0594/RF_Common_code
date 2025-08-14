package CDC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport extends BaseClass
{
	public AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//span[@class='multiselect-selected-text']") private WebElement notselecttab;
	@FindBy(xpath = "//label[normalize-space()='Placement']") private WebElement placement;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnTPreport") private WebElement reportbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcelReport") private WebElement excelreportbtn;

	public AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport Select_ApplicationCategoryType() {
		System.out.println("Select Application Category Type => Placement");
		click(notselecttab);
		waitUntilElementIsClickable(placement);
		click(placement);
		return this;
	}
	
	public AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport Click_ExcelReportBtn() {
		System.out.println("Click on Excel Report btn");
		click(excelreportbtn);
		return this;
	}
	
	public AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport Click_ReportBtn() {
		System.out.println("Click on Report btn");
		click(reportbtn);
		return this;
	}
}
