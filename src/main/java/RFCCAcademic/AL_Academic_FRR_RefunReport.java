package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
public class AL_Academic_FRR_RefunReport extends BaseClass{
	
	public AL_Academic_FRR_RefunReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submitbtnfr;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlReceiptType-container")
	private WebElement ReceiptType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate")
	private WebElement FromDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement ToDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement Btnreport;
	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	public AL_Academic_FRR_RefunReport Receipttypeddl() 
	{
		System.out.println("Select Receipt Type -> Admission Fee");
		click(ReceiptType);
		sendKeys(SearchBoxOfDropDown, "Admission Fee");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_FRR_RefunReport Reportbutton() 
	{
		System.out.println("Click on Report Button");
		click(Btnreport);
		return this;
	}
	
	public AL_Academic_FRR_RefunReport Fromdate() 
	{
		System.out.println("Select From Date -> 01/10/2024");
		FromDate.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]",FromDate, "01/10/2024");

		//sendKeys(FromDate, "09/10/2024");
		return this;
	}
	
	public AL_Academic_FRR_RefunReport Todate() 
	{
		System.out.println("Select To Date -> 31/12/2024");
		ToDate.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]",ToDate, "31/12/2024");
		//sendKeys(ToDate, "31/10/2024");
		return this;
	}
	
	public AL_Academic_FRR_RefunReport ACADEMIC() 
	{
		System.out.println("Click on Academic");
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}
	
	public AL_Academic_FRR_RefunReport FeesRelatedReports()
	{
		System.out.println("Click on Fees Related Reports");
		WebElement optn = driver.findElement(By.linkText("Fees Related Reports"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", optn);
		js2.executeScript("arguments[0].click;", optn);
		optn.click();
		return this;
	}
	
	public AL_Academic_FRR_RefunReport Refundreport()
	{
		System.out.println("Click on Refund report");
		WebElement optn = driver.findElement(By.linkText("Refund report"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", optn);
		js2.executeScript("arguments[0].click;", optn);
		optn.click();
		return this;
	}
	
}
