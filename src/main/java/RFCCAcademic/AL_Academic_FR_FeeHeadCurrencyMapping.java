package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_FeeHeadCurrencyMapping extends BaseClass
{
	public AL_Academic_FR_FeeHeadCurrencyMapping(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl04_lbLink") private WebElement feeHeadMapping;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucCurrencyhead_ddlRecType") private WebElement receipttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucCurrencyhead_ddlPayType") private WebElement paymenttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucCurrencyhead_ddlCurrency") private WebElement currencytype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucCurrencyhead_btnSave") private WebElement submitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Click_FeeHeadCurrencyMapping() throws InterruptedException {
		System.out.println("Click on FEE HEAD CURRENCY MAPPING");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",feeHeadMapping);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", feeHeadMapping);
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Select_SelectReceiptType() throws InterruptedException {
		System.out.println("Select Select Receipt Type ==> Admission Fee");
		Select select = new Select(receipttype);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Select_PaymentType() throws InterruptedException {
		System.out.println("Select Select Payment Type ==> General");
		Select select = new Select(paymenttype);
		select.selectByVisibleText("General");
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Select_CurrencyType() throws InterruptedException {
		System.out.println("Select Currency  Type ==> USD");
		Select select = new Select(currencytype);
		select.selectByVisibleText("USD");
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Enter_LongName() throws InterruptedException {
		System.out.println("Enter Long Name ==> Admission Fee");
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCurrencyhead_lvFeesHead_ctrl5_txtLName"));
		js.executeScript("arguments[0].scrollIntoView();",edit);

		Thread.sleep(2000);
		edit.sendKeys("Admission Fee");
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Enter_ShortName() throws InterruptedException {
		System.out.println("Enter Short Name ==> Fee");
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucCurrencyhead_lvFeesHead_ctrl5_txtSName"));
		js.executeScript("arguments[0].scrollIntoView();",edit);

		Thread.sleep(2000);
		edit.sendKeys("Fees");
		return this;
	}
	
	public AL_Academic_FR_FeeHeadCurrencyMapping Click_Submitbtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		submitbtn.click();
		return this;
	}
}
