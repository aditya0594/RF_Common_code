
package Stores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_CDWR_College_SummeryReport extends BaseClass {
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement ClgOrDeptWiseItemReport;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblItemType_1")
	private WebElement College; 
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
	private WebElement CollegeDropdown; 
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment")
	private WebElement DeptDropdown; 
	
	
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSummaryRpt")
	private WebElement SummeryReport;
	
	

	public  AL_Stores_Rpt_CDWR_College_SummeryReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	public AL_Stores_Rpt_CDWR_College_SummeryReport ClickOn_ClgOrDeptWiseItemReport1() {
		System.out.println(" College Or Department Wise Item Report ");
		ClgOrDeptWiseItemReport.click();
		return this;
	}
	
	public AL_Stores_Rpt_CDWR_College_SummeryReport ClickOn_ClgOrDeptWiseItemReportCollege() {
		System.out.println(" College Or Department Wise Item Report College Radio Button ");
		College.click();
		return this;
	}
	
	public AL_Stores_Rpt_CDWR_College_SummeryReport Select_ClgDropdown() {
		System.out.println(" Select Report Type select college");
		Select select = new Select(CollegeDropdown);
		select.selectByVisibleText("Crescent Institute");
		return this;
	}    
	  
	
public AL_Stores_Rpt_CDWR_College_SummeryReport Select_DeptDropdown() {
		System.out.println("Admin Examination menu selected > Select Report Type");
		Select select = new Select(DeptDropdown);
		select.selectByVisibleText("Administrative Office");
		return this;
	}    
	  
	public AL_Stores_Rpt_CDWR_College_SummeryReport ClickOn_ClgOrDeptWiseItemReportSummmery() {
		System.out.println(" Click ClgOrDeptWiseItemReport summary Report ");
		SummeryReport.click();
		return this;
	}
	


}
