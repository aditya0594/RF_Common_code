package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_FeesReceiptDetails extends BaseClass
{
	public AL_Academic_FR_FeesReceiptDetails(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl17_lbLink") private WebElement FeesReceiptDetails;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceipt") private WebElement ReceiptType;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_FeesReceiptDetails Click_FeesReceiptDetails() throws InterruptedException {
		System.out.println("Click on Fees Receipt Details");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",FeesReceiptDetails);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", FeesReceiptDetails);
		return this;
	}
	
	public AL_Academic_FR_FeesReceiptDetails Select_ReceiptType() throws InterruptedException {
		System.out.println("Select  Receipt Type ==> Admission Fee");
		Select select = new Select(ReceiptType);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
}
