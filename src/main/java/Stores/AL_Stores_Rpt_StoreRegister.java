package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Stores_Rpt_StoreRegister extends BaseClass
{
	public AL_Stores_Rpt_StoreRegister(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Store Register") private WebElement storeRegister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnStrReg") private WebElement storeregisterbtn;

	public AL_Stores_Rpt_StoreRegister Click_StoreRegister() throws Exception {
		System.out.println("Click on Store Register");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", storeRegister);

		threadWait1();
		js.executeScript("arguments[0].click();", storeRegister);
		
		return this;
	}
	
	public AL_Stores_Rpt_StoreRegister Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Stores_Rpt_StoreRegister Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		threadWait1();
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Stores_Rpt_StoreRegister Click_GoodsReceiptRegisterButton() throws Exception {
		System.out.println("Click on Goods Receipt Register Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", storeregisterbtn);

		threadWait1();
		js.executeScript("arguments[0].click();", storeregisterbtn);
		
		return this;
	}
}
