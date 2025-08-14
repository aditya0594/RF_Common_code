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

public class AL_Academic_PA_BBYA_AcademicYearAllotment extends BaseClass {

	public AL_Academic_PA_BBYA_AcademicYearAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")
	private WebElement AdmissionBatch;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	private WebElement SchoolInstitute;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAcdBatch-container")
	private WebElement AcademicBatch;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmType-container")
	private WebElement AdmissionType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAcdBatchAllotment_ctrl0_chkRegister")
	private WebElement CheckBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitButton;

	@FindBy(className = "select2-search__field")
	private WebElement SearchBoxOfDropDown;

	public AL_Academic_PA_BBYA_AcademicYearAllotment PostAdmission() {
		WebElement subMenu = driver.findElement(By.linkText("Post Admission"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", subMenu);
		System.out.println("Admin Academic Reports submenu selected");
		return this;
	}
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	public AL_Academic_PA_BBYA_AcademicYearAllotment BulkBatchYearAllotment() {
		WebElement optn = driver.findElement(By.linkText("Bulk Batch & Year Allotment"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", optn);
		js2.executeScript("arguments[0].click();", optn);
		System.out.println("Bulk Batch & Year Allotment");
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment AdmissionBatch() throws Exception {
		System.out.println("Admission Batch -> 2024-25");
		AdmissionBatch.click();
		SearchBoxOfDropDown.sendKeys("2024-25");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment SchoolInstitute() throws InterruptedException {
		System.out.println("SchoolInstitute -> Crescent School of Architecture");
		SchoolInstitute.click();
		sendKeys(SearchBoxOfDropDown, "Crescent School of Architecture");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment AdmissionType() {
		System.out.println("AdmissionType -> REGULAR");
		click(AdmissionType);
		sendKeys(SearchBoxOfDropDown, "REGULAR");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment AcademicBatch() {
		System.out.println("AcademicBatch -> 2023-24");
		click(AcademicBatch);
		sendKeys(SearchBoxOfDropDown, "2023-24");
		SearchBoxOfDropDown.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment ShowButton() {
		System.out.println("Click on Show Button");
		click(ShowButton);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment CheckBox() {
		System.out.println("Click on CheckBox -> Student Name -> RITU JI");
		js2.executeScript("arguments[0].scrollIntoView();", AcademicBatch);
		click(CheckBox);
		return this;
	}

	public AL_Academic_PA_BBYA_AcademicYearAllotment SubmitButton() {
		System.out.println("click on Submit");
		js2.executeScript("arguments[0].scrollIntoView();", AdmissionBatch);

		click(SubmitButton);
		return this;
	}
}
