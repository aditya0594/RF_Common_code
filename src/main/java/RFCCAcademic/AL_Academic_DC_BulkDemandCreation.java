package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_DC_BulkDemandCreation extends BaseClass{

	public AL_Academic_DC_BulkDemandCreation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id = "ctl00_repLinks_ctl12_lbLink")
	private WebElement Demand_Creation_Link;

	@FindBy(partialLinkText = "Bulk Demand Creation")
	private WebElement Bulk_Demand_Creation_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType")
	private WebElement Receipt_Type_Option;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement Session;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchool")
	private WebElement School;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree")
	private WebElement degree;
	
	@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_ddlBranch']")
	private WebElement branch;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSelectSemester")
	private WebElement Semester_Option;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlForSemester")
	private WebElement Demand_Semester_Option;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPaymentType")
	private WebElement Payment_Type_Option;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowStudents")
	private WebElement Show_Student_Button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkSelect")
	private WebElement Student_Checkbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCreateDemandForSelStuds")
	private WebElement Create_Demand_Button;
	
	@FindBy(id = "tblSearchResults")
	private WebElement Scroll_Table_View;
	
	@FindBy(xpath = "//span[@id='select2-ctl00_ContentPlaceHolder1_ddlSession-container']")
	private WebElement searchsession;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchsessionDropdown;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_DC_BulkDemandCreation click_Demand_Creation_Link() {
		Demand_Creation_Link.click();
		return this;
	}

	public AL_Academic_DC_BulkDemandCreation click_Bulk_Demand_Creation_Link() {
		System.out.println("click Demand Creation");
		Bulk_Demand_Creation_Link.click();
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation Select_Receipt_Type() throws InterruptedException {
		System.out.println("Receipt type=> Admission Fee");
		Select Receipt = new Select(Receipt_Type_Option);
		Receipt.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_Session() throws InterruptedException {
		System.out.println("Session=> May 2022 (  )");
		click(searchsession);
		Thread.sleep(1000);
		searchsessionDropdown.sendKeys("May 2022");
		searchsessionDropdown.sendKeys(Keys.ENTER);
//		Select Sessi = new Select(Session);
//		Sessi.selectByVisibleText("May 2022 (  )");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_School() {
		System.out.println("School => Crescent School of Law");
		Select clgdd = new Select(School);
		clgdd.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_Degree() throws InterruptedException {
		System.out.println("Degree=> B.A. LL.B. (Hons.)");
		Select Deg = new Select(degree);
		Deg.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_Branch() throws InterruptedException {
		System.out.println("Select Program branch => B.A. LL.B. (Hons.)");
		Select Progr = new Select(branch);
		Progr.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_Semester() throws InterruptedException {
		System.out.println("Select semister=> III");
		Select Semester = new Select(Semester_Option);
		Semester.selectByVisibleText("III");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_DemandSemester() throws InterruptedException {
		System.out.println("Select Demand semister=> III");
		Select Demand = new Select(Demand_Semester_Option);
		Demand.selectByVisibleText("III");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation select_PaymentType() throws InterruptedException {
		System.out.println("Select Payment type=> General");
		Select Payment = new Select(Payment_Type_Option);
		Payment.selectByVisibleText("General");
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation click_ShowStudent_Button() {
		System.out.println("Click on Show btn");
		Show_Student_Button.click();
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation click_Student_Checkbox() {
		System.out.println("Click on Student check box");
		js.executeScript("arguments[0].scrollIntoView();",Show_Student_Button);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Student_Checkbox);
		return this;
		
	}
	
	public AL_Academic_DC_BulkDemandCreation click_CreateDemandForSelStudent() throws InterruptedException {
		System.out.println("Click on Create Demand for Selected Students btn" );
		Create_Demand_Button.click();
		return this;
	}
	
	public AL_Academic_DC_BulkDemandCreation scroll_To_Table() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Scroll_Table_View);
		return this;
	}
	
}
