package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FRR_FR_OverallOutstandingReport extends BaseClass{

	public AL_Academic_FRR_FR_OverallOutstandingReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report")
	private WebElement Fees_Report;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport")
	private WebElement overall_Outstanding_Report;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo")
	private WebElement Receipt_Type_Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox1")
	private WebElement From_Date;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2")
	private WebElement To_Date;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement submit_button;

	public AL_Academic_FRR_FR_OverallOutstandingReport Select_Fees_Report() {
		System.out.println("click fees Report");
		Fees_Report.click();
		return this;
	}
	
	public AL_Academic_FRR_FR_OverallOutstandingReport Select_Overall_Outstanding_Report() {
		System.out.println("Report - Overall Outstanding Report(EXCEL)");	
		Select typ_report = new Select(overall_Outstanding_Report);
		typ_report.selectByVisibleText("Overall Outstanding Report (Excel)");
		return this;
	}
	
	public AL_Academic_FRR_FR_OverallOutstandingReport Enter_From_Date() {
		System.out.println("From Date -> 12/08/2023");
		js.executeScript("arguments[0].value = arguments[1]",From_Date, "12/08/2023");
		return this;
	}

	public AL_Academic_FRR_FR_OverallOutstandingReport Enter_To_Date() {
		   System.out.println("Selected Date is: 21/08/2024");
		js.executeScript("arguments[0].value = arguments[1]",To_Date, "21/08/2024");
		return this;
	}
	
	public AL_Academic_FRR_FR_OverallOutstandingReport Check_Receipt_Type() {
		System.out.println("Receipt Type CheckBox -> Admission Fee");
		Receipt_Type_Checkbox.click();
		System.out.println("Receipt Type CheckBox -> Admission Fee");
		return this;
	}
	
	public AL_Academic_FRR_FR_OverallOutstandingReport Click_Submit_Button() {
		System.out.println("Click on submit button ");
		submit_button.click();
		return this;
		
	}
	

}
