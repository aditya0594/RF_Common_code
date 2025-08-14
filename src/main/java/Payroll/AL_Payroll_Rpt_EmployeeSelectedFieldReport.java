package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Payroll_Rpt_EmployeeSelectedFieldReport extends BaseClass {

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement EmployeeIDCard;

	@FindBy(id = "ctl00_ContentPlaceHolder1_imgNextSelectedFields")
	private WebElement RightArrow2nd;

	@FindBy(id = "ctl00_ContentPlaceHolder1_imgbutExporttoWord")
	private WebElement ExporttoWord;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstFieldsToSelect\"]/option[2]")
	private WebElement FieldsToSelect;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstSelectedFields\"]/option")
	private WebElement SelectedFields;

	@FindBy(id = "ctl00_ContentPlaceHolder1_imgNextFieldsToSelect")
	private WebElement RightArrow;

	@FindBy(id = "ctl00_ContentPlaceHolder1_butShowReport")
	private WebElement ShowButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport EmployeeSelectedFieldReport() throws Exception {
		System.out.println("Report > Click On EmployeeSelectedFieldReport");
		Thread.sleep(2000);
		WebElement EmployeeSelectedFieldReport = driver.findElement(By.id("ctl00_repLinks_ctl10_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", EmployeeSelectedFieldReport);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		click(EmployeeSelectedFieldReport);
		//EmployeeSelectedFieldReport.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport RightArrow2nd() throws InterruptedException {
		System.out.println("EmployeeName");
		RightArrow2nd.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport ExporttoWord() throws InterruptedException {
		System.out.println("ExporttoWord");
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", ExporttoWord);
        Thread.sleep(1000);
        ExporttoWord.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport FieldsToSelect() {
		System.out.println("FieldsToSelect");
		FieldsToSelect.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport SelectedFields() {
		System.out.println("ID Card Type");
		SelectedFields.click();
		return this;

	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport RightArrow() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		RightArrow.click();
		return this;

	}

	public AL_Payroll_Rpt_EmployeeSelectedFieldReport ShowButton() {
		System.out.println("Click On Show Report Button");
		click(ShowButton);
		return this;
	}

}
