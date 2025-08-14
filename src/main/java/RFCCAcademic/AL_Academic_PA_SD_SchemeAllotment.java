package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_PA_SD_SchemeAllotment extends BaseClass{

	public AL_Academic_PA_SD_SchemeAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='Scheme Data']")private WebElement schemeData_Link;
	@FindBy(linkText = "Scheme Allotment")private WebElement schemeAllotment_tab;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")private WebElement school_dropdown;
	@FindBy(className = "select2-search__field")private WebElement searchField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")private WebElement degree_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch1-container")private WebElement branch_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")private WebElement admissionBatch_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester1-container")private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowStudent")private WebElement show_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAssignSch")private WebElement scrollToView;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctrl0_cbRow")private WebElement checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPrintAllotment")private WebElement schemeAllotment_btn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_PA_SD_SchemeAllotment click_SchemeData() throws InterruptedException {
		System.out.println("Scheme Data");
		js.executeScript("arguments[0].scrollIntoView();",schemeData_Link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", schemeData_Link);
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment click_SchemeAllotment_Tab() {
		System.out.println("Scheme Allotment");
		click(schemeAllotment_tab);
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment select_school() {
		click(school_dropdown);
		searchField.sendKeys("Crescent School of Pharmacy - Chennai");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select institute for scheme allotment");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment select_degree() {
		click(degree_dropdown);
		searchField.sendKeys("Bachelor of Pharmacy");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select degree for scheme allotment");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment select_branch() {
		click(branch_dropdown);
		searchField.sendKeys("B.Pharm.");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select branch for scheme allotment");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment select_admissionBatch() {
		click(admissionBatch_dropdown);
		searchField.sendKeys("2021-22");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select admission batch for scheme allotment");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment select_semester() {
		click(semester_dropdown);
		searchField.sendKeys("II");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select semester for scheme allotment");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment click_show_button() {
		click(show_btn);
		System.out.println("Click on show button");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment scrollToView() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToView);
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment click_checkbox() {
		System.out.println("Select Check box");
		click(checkbox);
		System.out.println("Select checkbox of student");
		return this;
	}
	public AL_Academic_PA_SD_SchemeAllotment click_schemeAllotment_btn() {
		JavascriptExecutor jsA = (JavascriptExecutor) driver;
		WebElement ElementA = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblDYlvDegree"));
		jsA.executeScript("arguments[0].scrollIntoView(true);", ElementA);
		click(schemeAllotment_btn);
		return this;
	}
	
}
