package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_DetentionReports extends BaseClass
{
	public AL_Academic_CR_DetentionReports(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@id='ctl00_repLinks_ctl17_lbLink'])[1]") private WebElement DetentionReports;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCancelDetention") private WebElement canceldetainreportbtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_DetentionReports Click_DetentionReports() throws InterruptedException {
		System.out.println("Click on Detention Reports");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DetentionReports);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DetentionReports);
		return this;
	}
	
	public AL_Academic_CR_DetentionReports Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> DEC 2021 - CSA");
		Select select = new Select(session);
		select.selectByVisibleText("DEC 2021 - CSA");
		return this;
	}
	
	public AL_Academic_CR_DetentionReports Click_CancelDetentionReportBtn() throws InterruptedException {
		System.out.println("Click on Cancel Detention Report Btn");
		click(canceldetainreportbtn);
		return this;
	}
}
