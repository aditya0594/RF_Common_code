package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_ItemMovementReport extends BaseClass
{
	public AL_Stores_Rpt_ItemMovementReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Item Movement Report") private WebElement itemMovementReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCategory") private WebElement categoryDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSubCategory") private WebElement subCategoryDropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItem-container") private WebElement itemDropdown;
	@FindBy(xpath = "//input[@class='select2-search__field']") private WebElement searchitem;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnRpt") private WebElement showReportBtn;

	public AL_Stores_Rpt_ItemMovementReport Click_ItemMovementReport() throws Exception {
		System.out.println("Click on Item Movement Report");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", itemMovementReport);

		threadWait1();
		js.executeScript("arguments[0].click();", itemMovementReport);
		
		return this;
	}
	
	public AL_Stores_Rpt_ItemMovementReport Select_Category() throws Exception {
		System.out.println("Select Category ==> CONSUMABLE");
		threadWait1();
		Select select = new Select(categoryDropdown);
		select.selectByVisibleText("CONSUMABLE");
		return this;
	}
	
	public AL_Stores_Rpt_ItemMovementReport Select_SubCategory() throws Exception {
		System.out.println("Select Sub Category ==> STATIONARY");
		threadWait1();
		Select select = new Select(subCategoryDropdown);
		select.selectByVisibleText("STATIONARY");
		return this;
	}
	
	public AL_Stores_Rpt_ItemMovementReport Select_Item() throws Exception {
		System.out.println("Select Item ==> PEN");
		threadWait1();
		itemDropdown.click();
		threadWait1();
		searchitem.sendKeys("PEN ( PEN ) [CONSUMABLE]");
		searchitem.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Stores_Rpt_ItemMovementReport Click_ShowReportButton() throws Exception {
		System.out.println("Click on Show Report Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", showReportBtn);

		threadWait1();
		js.executeScript("arguments[0].click();", showReportBtn);
		
		return this;
	}
}
