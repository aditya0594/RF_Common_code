package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_FeesHead extends BaseClass
{
	public AL_Academic_FR_FeesHead(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement FeesHead;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucFeeshead_ddlRecType") private WebElement receipttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucFeeshead_btnSave") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucFeeshead_lvFeesHead_ctrl4_chkIsScholarship") private WebElement chkbox;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_FeesHead Click_FeesHead() throws InterruptedException {
		System.out.println("Click on Fees Head");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",FeesHead);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", FeesHead);
		return this;
	}
	
	public AL_Academic_FR_FeesHead Select_SelectReceiptType() throws InterruptedException {
		System.out.println("Select Select Receipt Type ==> Admission Fee");
		Select select = new Select(receipttype);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_FR_FeesHead Click_CheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		click(chkbox);
		return this;
	}
	
	public AL_Academic_FR_FeesHead Click_Submitbtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		return this;
	}
}
