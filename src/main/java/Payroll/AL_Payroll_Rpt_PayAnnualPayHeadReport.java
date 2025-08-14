package Payroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_PayAnnualPayHeadReport extends BaseClass {

	public AL_Payroll_Rpt_PayAnnualPayHeadReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;

	@FindBy(id = "ctl00_repLinks_ctl18_lbLink")
	private WebElement PayAnnualPayHeadReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate")
	private WebElement FromDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement ToDate;

	//@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege1")
	private WebElement College;
	
	@FindBy(xpath = "//div[@class=\"btn-group\"]/button")
	private WebElement clic;
	

	@FindBy(id = "ctl00_ContentPlaceHolder1_lstParticularColumn")
	private WebElement PayHead;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaffNo-container")
	private WebElement SchemeStaff;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement ShowButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Rpt_PayAnnualPayHeadReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport PayAnnualPayHeadReport() throws Exception { 
		System.out.println("Report > Click On PayAnnualPayHeadReport");
		Thread.sleep(2000);
		WebElement PayAnnualPayHeadReport = driver.findElement(By.id("ctl00_repLinks_ctl18_lbLink"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",PayAnnualPayHeadReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", PayAnnualPayHeadReport);
		//PayAnnualPayHeadReport.click();
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport FromDate() throws InterruptedException {   
		System.out.println("Select From Date - 31/03/2012");
		FromDate.click();
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", 
                driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDate")), "31/03/2012");
		FromDate.click();
		return this; 
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport ToDate() throws InterruptedException {
		System.out.println("Select To Date - 03/11/2024");
		ToDate.click();
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", 
                driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtToDate")), "03/11/2024");
		ToDate.click();
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport College() {
		System.out.println("Crescent School of Architecture");
		clic.click();
		
//		Select s = new Select(College);
//		s.selectByVisibleText("Crescent School of Architecture");
	List<WebElement> ls = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li/a/label"));
	for(WebElement l : ls)
	{
		if(l.getText().trim().equalsIgnoreCase("Crescent School of Architecture"))
		{
			l.click();
		}
	}
			
			
			//ul[contains(@class,'multiselect-container')]/li/a/label/input
		
		
		
		//College.click();
		//ddlSearchBox.sendKeys("Crescent School of Architecture", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport PayHead() {
		System.out.println("PayHead => basic");
		Select select = new Select(PayHead);
		select.selectByVisibleText("BASIC");
		return this;

	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport SchemeStaff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		SchemeStaff.click();
		ddlSearchBox.sendKeys("Teaching Staff", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Rpt_PayAnnualPayHeadReport ShowButton() {
		System.out.println("Click On Show Report Button");
		click(ShowButton);
		return this;
	}

}
