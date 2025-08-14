package RFCCAcademic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelFileValidator;
import utility.SearchExcelFile;

public class AL_Academic_AR_TeacherNotAlloted extends BaseClass{

	public AL_Academic_AR_TeacherNotAlloted(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement teacherNotAlloted_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport") private WebElement report_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport1") private WebElement excelReport_button;


	public AL_Academic_AR_TeacherNotAlloted click_teacherNotAlloted_link() 
	{
		click(teacherNotAlloted_link);
		return this;
	}
	public AL_Academic_AR_TeacherNotAlloted select_report() 
	{
		System.out.println("Select Report => Course-Teacher Not Allotted");
		Select opt = new Select(report_dropdown);
		opt.selectByVisibleText("Course-Teacher Not Allotted");
		return this;
	}
	public AL_Academic_AR_TeacherNotAlloted select_session() 
	{
		System.out.println("Select Session => 2021-2022");
		Select opt = new Select(session_dropdown);
		opt.selectByVisibleText("2021-2022");
		return this;
	}
	public AL_Academic_AR_TeacherNotAlloted click_excelReportBtn() throws Exception 
	{
		click(excelReport_button);
		return this;
	}


}
