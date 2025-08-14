package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_FRR_FeesReport extends BaseClass{

	public AL_Academic_FRR_FeesReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(linkText = "Fees Report")
	private WebElement Fees_Report;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport")
	private WebElement Report_Type;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAcdYear")
	private WebElement Acedemic_Year;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox1")
	private WebElement From_Date;

	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2")
	private WebElement To_Date;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree")
	private WebElement Degree_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch")
	private WebElement Branch_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo")
	private WebElement Receipt_Type_Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowData_Button;

	@FindBy(xpath="//div[@class='sub-heading']/h5[text()='Fees Details']")
	private WebElement Fee_Details;

	@FindBy(className="dataTables_scrollHeadInner")
	private WebElement footer;
	@FindBy(id = "tblSemFees")
	private WebElement Scroll_till_report;
	
	/*
	 * @FindBy(xpath = "//*[@id=\"tblSemFees\"]//td[1]") private WebElement
	 * verifysearch;
	 */
	
	


	JavascriptExecutor js = (JavascriptExecutor) driver;


	public AL_Academic_FRR_FeesReport Select_Fees_Report() {
		Fees_Report.click();
		return this;
	}

	public AL_Academic_FRR_FeesReport Select_Report_Type() {
		Select typ_report = new Select(Report_Type);
		typ_report.selectByVisibleText("Show Data");
		System.out.println("Report - Show Data");
		return this;
	}

	public AL_Academic_FRR_FeesReport Select_Academic_Year() {
		Select typ_AcademicYear = new Select(Acedemic_Year);
		typ_AcademicYear.selectByVisibleText("2023-2024");
		System.out.println("Academic Year -> 2023-2024");
		return this;

	}

	public AL_Academic_FRR_FeesReport Enter_From_Date(String fromdate) {
		System.out.println("From Date -> 05/12/2023");
		//js.executeScript("arguments[0].value = arguments[1]",From_Date);
		sendKeys(From_Date,fromdate);
		return this;
	}

	public AL_Academic_FRR_FeesReport Enter_To_Date(String todate) {
		System.out.println("To Date -> 22/01/2024");
	//	js.executeScript("arguments[0].value = arguments[1]",To_Date);
		sendKeys(To_Date,todate);
		return this;
	}

	public AL_Academic_FRR_FeesReport Select_Degree() {
		Select typ_degree = new Select (Degree_Dropdown);
		typ_degree.selectByVisibleText("Bachelor of Architecture");
		System.out.println("Degree - Bachelor of Architecture");
		return this;

	}

	public AL_Academic_FRR_FeesReport Select_Branch() {
		Select typ_branch = new Select (Branch_Dropdown);
		typ_branch.selectByVisibleText("Architecture");
		System.out.println("Select Program/Branch -> Architecture");
		return this;

	}

	public AL_Academic_FRR_FeesReport Check_Receipt_Type() {
		Receipt_Type_Checkbox.click();
		System.out.println("Receipt Type CheckBox -> Admission Fee");
		return this;
	}

	public AL_Academic_FRR_FeesReport Click_ShowData_Button() throws InterruptedException {
		ShowData_Button.click();
		System.out.println("Click on Show Data button");
		Thread.sleep(3000);
		System.out.println("scroll till element ");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",Scroll_till_report);
		return this;
	}
	public AL_Academic_FRR_FeesReport Verify_SearchedData()   {
		WebElement verifysearch = driver.findElement(By.xpath("(//td[normalize-space()='VARSHA YADAV'])[1]"));
		String Expected_Msg = "VARSHA YADAV";
		String Actual_Msg = verifysearch.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		System.out.println("Name is present in list");
		return this;
		
	}
	
	


}
