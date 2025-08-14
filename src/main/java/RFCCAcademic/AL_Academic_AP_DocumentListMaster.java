package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_AP_DocumentListMaster extends BaseClass
{
	public AL_Academic_AP_DocumentListMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement documentListMaster;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDoc_ctrl0_btnEdit_tab1") private WebElement edit10std;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit_tab1") private WebElement submitbtn;
	@FindBy(xpath = "(//a[@class='nav-link'])[1]") private WebElement DocumentMapping;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBatchName_ctrl0_btnEdit") private WebElement editbtn10;
	@FindBy(xpath = "(//label[@for='rdMandatory'])[1]") private WebElement mandatorybtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement submitbtn2;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_DocumentListMaster Click_DocumentListMaster() throws InterruptedException {
		System.out.println("Click on Document List Master");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",documentListMaster);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", documentListMaster);
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_EditBtn() throws InterruptedException {
		System.out.println("Click on Edit btn 10th std Mark Sheet");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",edit10std);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", edit10std);
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_DocumentMapping() throws InterruptedException {
		System.out.println("Click on Document Mapping");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DocumentMapping);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DocumentMapping);
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_Edit10Btn() throws InterruptedException {
		System.out.println("Click 12th std Mark Sheet btn");
		click(editbtn10);
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_MandatoryStausBtn() throws InterruptedException {
		System.out.println("Click on Mandatory Staus btn");
		click(mandatorybtn);
		return this;
	}
	
	public AL_Academic_AP_DocumentListMaster Click_Submit2btn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		Thread.sleep(2000);
		click(submitbtn2);
		return this;
	}
}
