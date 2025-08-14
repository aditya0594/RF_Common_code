package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_CR_BulkCourseRegistrationFlow03_1 extends BaseClass {

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container")
	private WebElement CollegeAndScheme;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container")
	private WebElement Semester;
	@FindBy(className = "multiselect-selected-text")
	private WebElement Section;
	@FindBy(className = "checkbox")
	private WebElement SectionCheckbox;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnShow")
	private WebElement ShowStudent;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl2_cbRow")
	private WebElement StudentListCheckBox;

	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnSubmit'])[1]")
	private WebElement SubmitButton;

	@FindBy(name = "ctl00$ContentPlaceHolder1$btnReport")
	private WebElement RegistrationSlipReport;

	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	@FindBy(xpath = "//input[@aria-controls='tblHeadstdlist']")
	private WebElement SearchStudent;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl3_cbRow")
	private WebElement SelectCheckBoxStudent;

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 ACADEMIC() {
		System.out.println("Click on Academic");
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 CoordinatorRelated() {
		System.out.println("Click on Coordinator Related");
		WebElement subMenu = driver.findElement(By.linkText("Coordinator Related"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", subMenu);
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		// action.moveToElement(subMenu).click();
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 BulkCourseRegistration() {
		System.out.println("Click on Bulk Course Registration");
		WebElement optn = driver.findElement(By.linkText("Bulk Course Registration"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", optn);
		js2.executeScript("arguments[0].click;", optn);
		optn.click();
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 CollegeAndScheme() throws Exception {
		System.out.println(
				"CollegeAndScheme -> B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		CollegeAndScheme.click();
		SearchBoxOfDropDown.sendKeys(
				"B.Tech.-Computer Science and Engineering-2017-18-Department of Computer Science and Engineering (Old Scheme)");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 Session() throws InterruptedException {
		System.out.println("Session -> DEC 2021");
		Session.click();
		sendKeys(SearchBoxOfDropDown, "DEC 2021");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 Semester() {
		System.out.println("Semester -> VII");
		click(Semester);
		sendKeys(SearchBoxOfDropDown, "VII");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 Section() {
		System.out.println("Section -> A");
		click(Section);
		click(SectionCheckbox);
//		Select chkbox = new Select(CheckBox);
//		chkbox.selectByValue("1");
		// sendKeys(SearchBoxOfDropDown, "A");
		// SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 ShowButton() {
		System.out.println("Click on Show Button");
		click(ShowStudent);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 SearchStudent() {
		System.out.println("click the search button Select Student => 190071601003");
		sendKeys(SearchStudent, "190071601003");
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 SelectCheckBoxStudent() {
		System.out.println("Click on CheckBox -> Student Name -> 190071601003	ALAN JEROME. E.F");
		click(SelectCheckBoxStudent);
		return this;
	}


	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 RegistrationSlipReport() {
		System.out.println("click on RegistrationSlipReport");
		click(RegistrationSlipReport);
		return this;
	}

	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 SubmitButton() {
		System.out.println("click on Submit");
		click(SubmitButton);
		return this;
	}
	
	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 Select_DeselctChkBox() throws InterruptedException {
		System.out.println("Select Deselct Chk Box");
		WebElement selectall = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvCourse_cbHead"));
		selectall.click();
		threadWait1();
		selectall.click();
		
		return this;
	}
	
	public AL_Academic_CR_BulkCourseRegistrationFlow03_1 Search_Select_Course() throws InterruptedException {
		System.out.println("Search => 4102 and Select Course => ");
		WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[3]"));
		sendKeys(search, "4102");
		threadWait1();
		WebElement chkbox = driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_lvCourse_ctrl1_cbRow'])[1]"));
		click(chkbox);
		return this;
	}

}