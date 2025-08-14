package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class AL_Academic_FR_DefineFeesCounter extends BaseClass
{
	public AL_Academic_FR_DefineFeesCounter(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement DefineFeesCounter;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbox;
	@FindBy(xpath = "//input[@alt='Edit Record']") private WebElement editbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement updateBtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_DefineFeesCounter Click_DefineFeesCounter() throws InterruptedException {
		System.out.println("Click on Define Fees Counter");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DefineFeesCounter);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DefineFeesCounter);
		return this;
	}
	
	public AL_Academic_FR_DefineFeesCounter SearchBoxCounter() throws InterruptedException {
		System.out.println("Search Box Counter ==> C11");
		sendKeys(searchbox, "C11");
		return this;
	}
	
	public AL_Academic_FR_DefineFeesCounter Click_EditIcon() throws InterruptedException {
		System.out.println("Click on Edit Icon");
		click(editbtn);
		return this;
	}
	
	public AL_Academic_FR_DefineFeesCounter Select_PermissionforReceipts() throws InterruptedException {
		System.out.println("Permission for Receipts ==> All");
		WebElement checkall = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkCheckAll"));
		click(checkall);
		return this;
	}
	
	public AL_Academic_FR_DefineFeesCounter Click_UpdateBtn() throws InterruptedException {
		System.out.println("Click on Update btn");
		click(updateBtn);
		return this;
	}
}
