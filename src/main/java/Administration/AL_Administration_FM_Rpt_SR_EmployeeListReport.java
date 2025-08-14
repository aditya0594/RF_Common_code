package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_FM_Rpt_SR_EmployeeListReport  extends BaseClass {
	
	
	
	public AL_Administration_FM_Rpt_SR_EmployeeListReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(id="ctl00_repLinks_ctl01_lbLink")
	private WebElement StatusReports;
	
	
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlFile")
	private WebElement SelectFile;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowReport;
	
	
	
	
	public AL_Administration_FM_Rpt_SR_EmployeeListReport ClickOn_StatusReports() {
		System.out.println("Click on Status Reports ");
	    click(StatusReports);
		return this;
	}
	
	
	public AL_Administration_FM_Rpt_SR_EmployeeListReport Select_SelectFilesDropdown() {
		System.out.println("Select Select File Dropdown");
		Select select = new Select(SelectFile);
		select.selectByVisibleText("Employee List");
		return this;
	}
	
	public AL_Administration_FM_Rpt_SR_EmployeeListReport ClickOn_ShowReport() {
		System.out.println("Click on Show Report ");
	    click(ShowReport);
		return this;
	}

}
