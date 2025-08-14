package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_FinalDetentionFlow09_2 extends BaseClass
{
	public AL_Academic_CR_FinalDetentionFlow09_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@id='ctl00_repLinks_ctl15_lbLink'])[1]") private WebElement FinalDetention;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblSelection_1") private WebElement detaintiontoall;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement finaldetainreportbtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement search;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_FinalDetention() throws InterruptedException {
		System.out.println("Click on Final Detention");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",FinalDetention);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", FinalDetention);
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Select_CollegeScheme() throws InterruptedException {
		System.out.println("Select College & Scheme ==> CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		Select select = new Select(college);
		select.selectByVisibleText("CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> DEC 2021");
		Select select = new Select(session);
		select.selectByVisibleText("DEC 2021");
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Select_Semister() throws InterruptedException {
		System.out.println("Select Semister ==> I");
		Select select = new Select(semister);
		select.selectByVisibleText("I");
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_DetentionToAllSubjectsBtn() throws InterruptedException {
		System.out.println("Click on Detention to all Subjects Btn");
		click(detaintiontoall);
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_ShowStudentBtn() throws InterruptedException {
		System.out.println("Click on Show Student Btn");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_CheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		sendKeys(search, "2013");
		threadWait1();
		click(chkbox);
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitBtn);
		return this;
	}
	
	public AL_Academic_CR_FinalDetentionFlow09_2 Click_FinalDetaintionReportBtn() throws InterruptedException {
		System.out.println("Click on Final Detaintion Report btn");
		click(finaldetainreportbtn);
		return this;
	}
}
