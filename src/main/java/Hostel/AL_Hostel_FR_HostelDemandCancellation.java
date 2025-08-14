package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_FR_HostelDemandCancellation extends BaseClass {
	public AL_Hostel_FR_HostelDemandCancellation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Fee Related")
	private WebElement FeeRelated;

	@FindBy(id = "ctl00_repLinks_ctl18_lbLink")
	private WebElement DemandCancellation;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearchStr")
	private WebElement SearchString;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchStu")
	private WebElement SearchButton;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId")
	private WebElement studentName;

	@FindBy(xpath = "//div[@class='table-responsive']//textarea")
	private WebElement Remark;

	@FindBy(xpath = "//div[@class='table-responsive']//a")
	private WebElement CancelDemandButton;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	Actions action = new Actions(driver);


	// Click on Fee Related
	public AL_Hostel_FR_HostelDemandCancellation ClickFeesRelatedTest() {
		System.out.println("Click on Fee Related");
		click(FeeRelated);
		return this;
	}

	// Click on Demand Cancellation
	public AL_Hostel_FR_HostelDemandCancellation ClickDemandCancellationTest() throws Throwable {
		System.out.println("Click on Demand Cancellation");
		js.executeScript("arguments[0].scrollIntoView();", DemandCancellation);

		Thread.sleep(2000);
		DemandCancellation.click();
		return this;
	}

	// Select Search Criteria
	public AL_Hostel_FR_HostelDemandCancellation SelectSearchCriteriaTest() {
		System.out.println("Select Search Criteria");

		WebElement search = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSearch"));
		Select search_criteria = new Select(search);
		search_criteria.selectByVisibleText("RRN NO.");

		return this;
	}

	// Search Student RRN NO.
	public AL_Hostel_FR_HostelDemandCancellation SearchStringTest() throws Exception {
		System.out.println("Search Student RRN NO.");

		SearchString.clear();
		SearchString.sendKeys("210071601191");

		return this;
	}

	// Click on Search Button
	public AL_Hostel_FR_HostelDemandCancellation ClickSearchButtonTest() {
		System.out.println("Click on search Button");
		click(SearchButton);
		return this;
	}

	// Click on Student Name
	public AL_Hostel_FR_HostelDemandCancellation ClickStudentName() {
		System.out.println("Click on Student Name");
		click(studentName);
		return this;
	}

	public AL_Hostel_FR_HostelDemandCancellation SearchBoxTest() {
		System.out.println("Enter in Search Box");
		
		Search.clear();
		Search.sendKeys("HF");
		
		return this;
	}

	public AL_Hostel_FR_HostelDemandCancellation Amount() {
		System.out.println("Click on Amount");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvFeeItems_ctrl1_txtFeeItemAmount")).sendKeys("1");
		return this;
	}

	// Enter Remark
	public AL_Hostel_FR_HostelDemandCancellation EnterRemarkTest() {
		System.out.println("Enter Remark");
		Remark.sendKeys("Test");
		return this;
	}

	// Click on Cancel Demand Button
	public AL_Hostel_FR_HostelDemandCancellation ClickCancelDemandButton() {
		System.out.println("Click on Cancel Demand Button");
		click(CancelDemandButton);
		return this;
	}
}
