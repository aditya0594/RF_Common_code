package Payroll;

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

public class AL_Payroll_Rpt_AllDeductionHeadReport extends BaseClass {

	public AL_Payroll_Rpt_AllDeductionHeadReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;

	@FindBy(id = "ctl00_repLinks_ctl17_lbLink")
	private WebElement AllDeductionHeadReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDt")
	private WebElement FromDate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt")
	private WebElement ToDate;

	@FindBy(xpath = "//span[@class='multiselect-selected-text']")
	private WebElement College;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlPayHead-container")
	private WebElement PayHead;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaff-container")
	private WebElement SchemeStaff;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement ShowButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Rpt_AllDeductionHeadReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Rpt_AllDeductionHeadReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}
	
	public AL_Payroll_Rpt_AllDeductionHeadReport AllDeductionHeadReport() throws Exception {
		System.out.println("Report > Click On AllDeductionHeadReport");
		//AllDeductionHeadReport.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",AllDeductionHeadReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AllDeductionHeadReport);
		return this;
	}

	public AL_Payroll_Rpt_AllDeductionHeadReport FromDate() throws InterruptedException {
		System.out.println("Select From Date");
		FromDate.sendKeys("01/04/2021");
		return this;
	}

	public AL_Payroll_Rpt_AllDeductionHeadReport ToDate() throws InterruptedException {
		System.out.println("Select To Date");
		ToDate.sendKeys("31/03/2022");
		System.out.println("Click on Excel");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnExcel")).click();
		return this;
	}

	public AL_Payroll_Rpt_AllDeductionHeadReport College() {
		System.out.println("Crescent School of Architecture");
		College.click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		System.out.println("Crescent School of Architecture");
		return this;
	}

	public AL_Payroll_Rpt_AllDeductionHeadReport PayHead() {
		System.out.println("PayHead");
		PayHead.click();
		ddlSearchBox.sendKeys("FES.ADV R", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Rpt_AllDeductionHeadReport SchemeStaff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		SchemeStaff.click();
		ddlSearchBox.sendKeys("Teaching Staff", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Rpt_AllDeductionHeadReport ShowButton() {
		System.out.println("Click On Show Report Button");
		click(ShowButton);
		return this;
	}

}
