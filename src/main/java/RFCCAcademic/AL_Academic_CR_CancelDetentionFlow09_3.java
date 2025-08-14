package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_CancelDetentionFlow09_3 extends BaseClass
{
	public AL_Academic_CR_CancelDetentionFlow09_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@id='ctl00_repLinks_ctl16_lbLink'])[1]") private WebElement CancelDetention;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement SchoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudent") private WebElement RRNO;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Click_CancelDetention() throws InterruptedException {
		System.out.println("Click on Cancel Detention");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",CancelDetention);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CancelDetention);
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School/Institute ==> Crescent School of Architecture - Chennai");
		Select select = new Select(SchoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture - Chennai");
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> DEC 2021");
		Select select = new Select(session);
		select.selectByVisibleText("DEC 2021");
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Select_Semister() throws InterruptedException {
		System.out.println("Select Semister ==> I");
		Select select = new Select(semister);
		select.selectByVisibleText("I");
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Enter_RRNO() throws InterruptedException {
		System.out.println("Enter RRNO => 2013");
		sendKeys(RRNO, "2013");
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Click_ShowBtn() throws InterruptedException {
		System.out.println("Click on Show Btn");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit Btn");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",submitBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public AL_Academic_CR_CancelDetentionFlow09_3 Click_ReportBtn() throws InterruptedException {
		System.out.println("Click on Report Btn");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",reportbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", reportbtn);
		return this;
	}
}
