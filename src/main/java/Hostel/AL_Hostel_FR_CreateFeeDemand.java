package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_FR_CreateFeeDemand extends BaseClass {

	public AL_Hostel_FR_CreateFeeDemand(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	@FindBy(linkText = "HOSTEL")
	private WebElement Hostel;

	@FindBy(linkText = "Fees Related")
	private WebElement FeeRelated;

	@FindBy(linkText = "Create Fee Demand")
	private WebElement CreateFeeDemand;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowStudents")
	private WebElement ShowStudent;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;

	@FindBy(xpath = "//div[@class='table-responsive']//span//input")
	private WebElement Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCreateDemandForSelStuds")
	private WebElement CreateDemandButton;

	Actions action = new Actions(driver);

	// Hover on Hostel
	public AL_Hostel_FR_CreateFeeDemand HoverHostelTest() {
		System.out.println("Hover on Hostel");
		action.moveToElement(Hostel).perform();
		return this;
	}

	// Click on Fee Related
	public AL_Hostel_FR_CreateFeeDemand ClickFeesRelatedTest() throws Throwable {
		System.out.println("Click on Fee Related");
		click(FeeRelated);
		return this;
	}

	// Click on Create Fee Demand
	public AL_Hostel_FR_CreateFeeDemand ClickCreateFeeDemandTest() {
		System.out.println("Click on Create Fee Demand");
		click(CreateFeeDemand);
		return this;
	}

	// Select Session
	public AL_Hostel_FR_CreateFeeDemand SelectSessionTest() {
		System.out.println("Select Session");

		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select_session = new Select(sessn);
		select_session.selectByVisibleText("2023-2024");

		return this;
	}

	// Select Demand of Receipt Type
	public AL_Hostel_FR_CreateFeeDemand SelectDemandOfReceiptTypeTest() throws Exception {
		System.out.println("Select Demand of Receipt Type");

		WebElement receipt = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReceiptType"));
		Select demand_receipt = new Select(receipt);
		demand_receipt.selectByVisibleText("Hostel Fees");

		return this;
	}

	// Select Current Year Semester
	public AL_Hostel_FR_CreateFeeDemand SelectCurrentYearSemesterTest() {
		System.out.println("Select Current Year Semester");

		WebElement year = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsemester"));
		Select current_year_sem = new Select(year);
		current_year_sem.selectByVisibleText("III");

		return this;
	}

	// Select Create Demand for Year Semester
	public AL_Hostel_FR_CreateFeeDemand SelectCreateDemandforYearSemesterTest() {
		System.out.println("Select Create Demand for Year Semester");

		WebElement year = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlForSemester"));
		Select Demand_year_sem = new Select(year);
		Demand_year_sem.selectByVisibleText("IV");

		return this;
	}

	// Click on Show Student Button
	public AL_Hostel_FR_CreateFeeDemand ClickShowStudentButtonTest() {
		System.out.println("Click on Show Student Button");
		click(ShowStudent);
		return this;
	}

	// Enter RRN NO. in SearchBox
	public AL_Hostel_FR_CreateFeeDemand SearchButtonTest() {
		System.out.println("Enter RRN NO. in SearchBox");
		Search.clear();
		Search.sendKeys("210071601191");
		return this;
	}

	// Click on Student Checkbox
	public AL_Hostel_FR_CreateFeeDemand ClickStudentCheckboxTest() {
		System.out.println("Click on Student Checkbox");
		click(Checkbox);
		return this;
	}

	// Click on Create Demand Button
	public AL_Hostel_FR_CreateFeeDemand ClickCreateDemandButtonTest() {
		System.out.println("Click on Create Demand Button");
		click(CreateDemandButton);
		return this;
	}

}
