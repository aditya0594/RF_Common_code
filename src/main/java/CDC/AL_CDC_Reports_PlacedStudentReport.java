package CDC;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.ExcelFileValidator;
import utility.SearchExcelFile;

public class AL_CDC_Reports_PlacedStudentReport extends BaseClass{

	public AL_CDC_Reports_PlacedStudentReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "CDC")
	private WebElement CDC;
	
	@FindBy(linkText = "Reports")
	private WebElement Reports;
	
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink")
	private WebElement PlacedStudentReport;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ReportButton;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel")
	private WebElement ExcelReport;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	
	
	public AL_CDC_Reports_PlacedStudentReport ClickReportsTest() {
		System.out.println("Click on Reports");
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_CDC_Reports_PlacedStudentReport ClickPlacedStudentReportTest() {
		System.out.println("Click on Placed Student Reports");
		click(PlacedStudentReport);		
		return this;
	}
	
	public AL_CDC_Reports_PlacedStudentReport ClickReportButtonTest() {
		System.out.println("Click on Reports");
		click(ReportButton);		
		return this;
	}
	//PLACED_STUDENT_Report
	public AL_CDC_Reports_PlacedStudentReport ClickExcelReportTest() {
		System.out.println("Click on Excel Report");
		click(ExcelReport);		
		return this;
	}
	
	
}
