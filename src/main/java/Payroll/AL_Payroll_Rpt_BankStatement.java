package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Payroll_Rpt_BankStatement extends BaseClass {

	public AL_Payroll_Rpt_BankStatement(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;

	@FindBy(linkText = "Bank Statement")
	private WebElement BankStatement;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlMonthYear-container")
	private WebElement MonthAndYear;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_pnl\"]/div/div/div[4]/span/div/button/span")
	private WebElement BankName;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_pnl\"]/div/div/div[4]/span/div/ul/li[2]/a/label/input")
	private WebElement checkboxBankName;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnShow")
	private WebElement BankStatementReport;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Rpt_BankStatement PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Rpt_BankStatement Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}

	public AL_Payroll_Rpt_BankStatement BankStatement() {
		System.out.println(" Report > Click On BankStatement");
		click(BankStatement);
		return this;
	}

	public AL_Payroll_Rpt_BankStatement MonthAndYear() {
		System.out.println("MonthAndYear - Aug2022");
		MonthAndYear.click();
		ddlSearchBox.sendKeys("Aug2022", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Rpt_BankStatement BankName() throws InterruptedException {
		System.out.println("BankName");
		BankName.click();
		Thread.sleep(Wait);
		checkboxBankName.click();
		return this;
	}

	public AL_Payroll_Rpt_BankStatement BankStatementReport() {
		System.out.println("Click On BankStatementReport");
		click(BankStatementReport);
		return this;
	}

}
