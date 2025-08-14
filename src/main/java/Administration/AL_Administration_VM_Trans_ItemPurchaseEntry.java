package Administration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_VM_Trans_ItemPurchaseEntry extends BaseClass
{
	public AL_Administration_VM_Trans_ItemPurchaseEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Item Purchase Entry") private WebElement itemPurchaseEntryLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlItemType") private WebElement itemTypeSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlItemName") private WebElement itemNameSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlVendorName") private WebElement vendorNameSelectTab;
	@FindBy(xpath = "(//i[@class='fa fa-calendar text-blue'])[1]") private WebElement calendericon;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ceDate_today") private WebElement currentdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCRN") private WebElement crnNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPurchaseFor") private WebElement purchaseForSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPurchaseCouponNumber") private WebElement purchaseCouponNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtQuantity") private WebElement quantityField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAmt") private WebElement ammount;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnreport_show") private WebElement showReportBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate") private WebElement toDate;

	

	public AL_Administration_VM_Trans_ItemPurchaseEntry Click_ItemPurchaseEntryLink() throws Exception {
		System.out.println("Click on Item Purchase Entry link");
		js.executeScript("arguments[0].scrollIntoView();", itemPurchaseEntryLink);
		js.executeScript("arguments[0].click();", itemPurchaseEntryLink);
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Select_ItemType() throws Exception {
		System.out.println("Select Item Type => Fuel");
		Select select = new Select(itemTypeSelectTab);
		select.selectByVisibleText("Fuel");
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Select_ItemName() throws Exception {
		System.out.println("Select Item Name => Petrol");
		Select select = new Select(itemNameSelectTab);
		select.selectByVisibleText("Petrol");
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Select_VendorName() throws Exception {
		System.out.println("Select Vendor Name => Anuja Kohale");
		Select select = new Select(vendorNameSelectTab);
		select.selectByVisibleText("Anuja Kohale");
		return this;
	}

	public AL_Administration_VM_Trans_ItemPurchaseEntry Enter_PurchaseDate() throws Exception {
		System.out.println("Enter Purchase date => Current date");
		calendericon.click();
		Thread.sleep(2000);
		currentdate.click();
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Enter_CRNNumber() throws Exception {
		System.out.println("Enter CRN Number => CR123");
//		js.executeScript("arguments[0].scrollIntoView();", crnNumberField);
		crnNumberField.clear();
		crnNumberField.sendKeys("CR123");
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Select_PurchaseFor() throws Exception {
		System.out.println("Select Purchase For => Transport");
		Select select = new Select(purchaseForSelectTab);
		select.selectByVisibleText("Transport");
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Enter_PurchaseCouponNumber() throws Exception {
		System.out.println("Enter Purchase Coupon Number => PC101");
//		js.executeScript("arguments[0].scrollIntoView();", purchaseCouponNumberField);
		purchaseCouponNumberField.clear();
		purchaseCouponNumberField.sendKeys("PC101");
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Enter_Quantity() throws Exception {
		System.out.println("Enter Purchase Quantity => 20");
//		js.executeScript("arguments[0].scrollIntoView();", quantityField);
		quantityField.clear();
		quantityField.sendKeys("20");
		ammount.click();
		return this;
	}
	
	public AL_Administration_VM_Trans_ItemPurchaseEntry Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
//		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public String Get_AlertText() throws Exception {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void Accept_Alert() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	


}
