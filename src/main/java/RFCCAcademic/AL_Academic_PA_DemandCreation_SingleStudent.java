package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_PA_DemandCreation_SingleStudent extends BaseClass
{
	public AL_Academic_PA_DemandCreation_SingleStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Demand Creation") private WebElement DemandCreation;
	@FindBy(xpath = "(//a[normalize-space()='Single Student Demand Creation'])[1]") private WebElement singlestudentdemandcreation;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch") private WebElement searchcriteria;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDropdown") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement searchbtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchtab ;
	@FindBy(xpath = "//a[text()='Vishal Dhande']") private WebElement studentvishal ;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionSingle") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlForSemesterN") private WebElement semisterdemand;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRecType") private WebElement receipttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCreateDemand") private WebElement createstudentdataBtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_PA_DemandCreation_SingleStudent Click_DemandCreation() throws InterruptedException {
		System.out.println("Click on Student Information Verification");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DemandCreation);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DemandCreation);
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Click_SingleStudent() throws InterruptedException {
		System.out.println("Click on Single Student btn");
		click(singlestudentdemandcreation);
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Select_SearchCriteria() throws InterruptedException {
		System.out.println("Select Search Criteria => DEGREE");
		Select select = new Select(searchcriteria);
		select.selectByVisibleText("DEGREE");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Master of Business Administration");
		Select select = new Select(degree);
		select.selectByVisibleText("Master of Business Administration");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Click_SearchBtn() throws InterruptedException {
		System.out.println("Click on Search btn");
		click(searchbtn);
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Search_Student() throws InterruptedException {
		System.out.println("Search Student Name => Vishal Dhande");
		sendKeys(searchtab, "Vishal Dhande");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Click_Student() throws InterruptedException {
		System.out.println("Click on Student Name => Vishal Dhande");
		click(studentvishal);
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Select_Session() throws InterruptedException {
		System.out.println("Select session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Select_SemisterForDemand() throws InterruptedException {
		System.out.println("Select Semister For Demand => II");
		Select select = new Select(semisterdemand);
		select.selectByVisibleText("II");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Select_ReceiptType() throws InterruptedException {
		System.out.println("Select Receipt Type => Admission Fee");
		Select select = new Select(receipttype);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_PA_DemandCreation_SingleStudent Click_CreateStudentDemandBtn() throws InterruptedException {
		System.out.println("Click on Create Student Demand Btn");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",createstudentdataBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createstudentdataBtn);
		return this;
	}
}
