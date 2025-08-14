package Stores;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Trans_GenerateItemSerialNumber extends BaseClass
{
	public AL_Stores_Trans_GenerateItemSerialNumber(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Generate Item Serial Number") private WebElement generateItemSerialNumber;
	@FindBy(id = "ctl00_ContentPlaceHolder1_radlTransfer_1") private WebElement modifyButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCategory") private WebElement categoryDropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSubCategory-container") private WebElement subCategoryDropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlItems-container") private WebElement selectitems;
	@FindBy(xpath = "//input[@class='select2-search__field']") private WebElement searchitem;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvitems_ctrl0_txtSpecification") private WebElement specificationField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitButton;

	public AL_Stores_Trans_GenerateItemSerialNumber Click_GenerateItemSerialNumber() throws Exception {
		System.out.println("Click on Generate Item Serial Number");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", generateItemSerialNumber);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", generateItemSerialNumber);
		
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Click_ModifyButton() throws Exception {
		System.out.println("Click on Modify Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", modifyButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", modifyButton);
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Select_Category() throws Exception {
		System.out.println("Select Category ==> NON CONSUMABLE");
		Thread.sleep(2000);
		Select select = new Select(categoryDropdown);
		select.selectByVisibleText("NON CONSUMABLE");
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Select_SubCategory() throws Exception {
		System.out.println("Select Sub Category ==> Oxygen Mask");
		
		subCategoryDropdown.click();
		Thread.sleep(2000);
		searchitem.sendKeys("OXYGEN");
		searchitem.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Select_SelectItems() throws Exception {
		System.out.println("Select Items ==> Oxygen Mask");
		selectitems.click();
		Thread.sleep(2000);
		searchitem.sendKeys("OXYGEN");
		searchitem.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Enter_Specification() throws Exception {
		System.out.println("Enter Specification ==> Bajaj");
		Thread.sleep(2000);
		clearText(specificationField);
		sendKeys(specificationField, "Bajaj");
		return this;
	}
	
	public AL_Stores_Trans_GenerateItemSerialNumber Click_SubmitButton() throws Exception {
		System.out.println("Click on Submit Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", submitButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitButton);
		
		return this;
	}
	
}
