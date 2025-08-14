package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_ProvisionalDetentionFlow09_1 extends BaseClass
{
	public AL_Academic_CR_ProvisionalDetentionFlow09_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Provisional Detention") private WebElement ProvisionalDetention;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ddlSemester") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblSelection_1") private WebElement allSubjectDetention;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement search;

	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Click_ProvisionalDetention() throws InterruptedException {
		System.out.println("Click on Provisional Detention");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",ProvisionalDetention);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ProvisionalDetention);
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Select_CollegeScheme() throws InterruptedException {
		System.out.println("Select College & Scheme ==> CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		Select select = new Select(college);
		select.selectByVisibleText("CSA - B. Arch-Architecture-2022-23-Crescent School of Architecture (New Scheme)");
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> DEC 2021");
		Select select = new Select(session);
		select.selectByVisibleText("DEC 2021");
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Select_Semister() throws InterruptedException {
		System.out.println("Select Semister ==> I");
		Select select = new Select(semister);
		select.selectByVisibleText("I");
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Click_AllSubjectDetentionBtn() throws InterruptedException {
		System.out.println("Click on All Subject Detention Btn");
		click(allSubjectDetention);
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Click_ShowStudentBtn() throws InterruptedException {
		System.out.println("Click on Show Student Btn");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 SearchAnd_ClickChkBox() throws InterruptedException {
		System.out.println("Search => 2013 and Click on Check Box");
		sendKeys(search, "2013");
		threadWait1();
		click(chkbox);
		return this;
	}
	
	public AL_Academic_CR_ProvisionalDetentionFlow09_1 Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitBtn);
		return this;
	}
}
