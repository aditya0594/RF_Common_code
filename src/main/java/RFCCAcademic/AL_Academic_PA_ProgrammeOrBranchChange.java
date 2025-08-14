package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import RFCCAcademic.AL_Academic_AR_BulkUpdateOfPhoto;
import utility.BaseClass;

public class AL_Academic_PA_ProgrammeOrBranchChange extends BaseClass{

	public AL_Academic_PA_ProgrammeOrBranchChange(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl05_lbLink") private WebElement programmeOrBranchChange_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudent") private WebElement searchString_input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement show_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkDemand") private WebElement donotcreartdemand;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement student;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchClg") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement branch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRemark") private WebElement remark_textbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlRecieptype") private WebElement receiptType_dropdown;
	@FindBy(id="select2-ctl00_ContentPlaceHolder1_ddlCollege-container") private WebElement collegeClick;
	@FindBy(xpath="//input[@class='select2-search__field']") private WebElement collegeSearch;
	@FindBy(xpath="(//span[@id='select2-ctl00_ContentPlaceHolder1_ddlDegree-container'])[1]") private WebElement newdegreeselect;
	@FindBy(xpath="(//span[@id='select2-ctl00_ContentPlaceHolder1_ddlBranch-container'])[1]") private WebElement newBranchselect;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_PA_ProgrammeOrBranchChange click_programmeOrBranchChange_link() 
	{
		programmeOrBranchChange_link.click();
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange enter_searchString() 
	{
		searchString_input.sendKeys("08934874378734");
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange click_show_button() 
	{
		show_button.click();   
		return this;
	}
	
	public AL_Academic_PA_ProgrammeOrBranchChange Click_Student() {
		student.click();
		return this;
	}
	

	public AL_Academic_PA_ProgrammeOrBranchChange select_college() throws InterruptedException 
	{
		js.executeScript("arguments[0].scrollIntoView();",show_button);

		System.out.println("Slect college => Crescent School of Architecture");
		click(collegeClick);
		Thread.sleep(1000);
		collegeSearch.sendKeys("Crescent School of Architecture");
		collegeSearch.sendKeys(Keys.ENTER);
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange select_session() 
	{
		Select opt = new Select(session_dropdown);
		opt.selectByVisibleText("2023-2024");
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange select_receiptType() 
	{
		Select opt = new Select(receiptType_dropdown);
		opt.selectByVisibleText("Admission Fee");
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange select_newDegree() throws InterruptedException 
	{
		System.out.println("Select college => search by entring a");
		click(newdegreeselect);
		Thread.sleep(1000);
		collegeSearch.sendKeys("a");
		Thread.sleep(1000);
		collegeSearch.sendKeys(Keys.ARROW_DOWN);
		collegeSearch.sendKeys(Keys.ENTER);
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange select_newBranch() throws InterruptedException 
	{
		System.out.println("Select college => search by a");
		click(newBranchselect);
		Thread.sleep(1000);
		collegeSearch.sendKeys("a");
		Thread.sleep(1000);
		collegeSearch.sendKeys(Keys.ARROW_DOWN);
		collegeSearch.sendKeys(Keys.ENTER);
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange enter_remark() 
	{
		remark_textbox.sendKeys("ABC");
		return this;
	}
	public AL_Academic_PA_ProgrammeOrBranchChange click_submit_button() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",submit_button);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit_button);
		//submit_button.click();
		return this;
	}
	
	
	
	
}
