package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_PA_SD_SchemeCreation extends BaseClass{

	public AL_Academic_PA_SD_SchemeCreation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='Scheme Data']")private WebElement schemeData_Link;
	@FindBy(linkText = "Scheme Creation")private WebElement schemeCreation_tab;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegreeNo-container")private WebElement degree_dropdown;
	@FindBy(className = "select2-search__field")private WebElement searchField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDept-container")private WebElement department_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container")private WebElement branch_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBatchNo-container")private WebElement admissionBatch_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSchemeType-container")private WebElement schemeType_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlgrademarks-container")private WebElement grade_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlresultprocesspattern-container")private WebElement resultProcessPattern_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlPatternName-container")private WebElement patternName_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStudyPattern-container")private WebElement studyPattern_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")private WebElement submitBtn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_PA_SD_SchemeCreation click_SchemeData() throws InterruptedException {
		System.out.println("Scheme Data");
		js.executeScript("arguments[0].scrollIntoView();",schemeData_Link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", schemeData_Link);
		return this;
	}
	
	public AL_Academic_PA_SD_SchemeCreation click_SchemeCreation_Tab() {
		System.out.println("Scheme Creation");
		click(schemeCreation_tab);
		return this;
	}
	
	public AL_Academic_PA_SD_SchemeCreation select_Degree() {
		click(degree_dropdown);
		searchField.sendKeys("Bachelor of Architecture");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select degree for scheme creation - Bachelor of Architecture");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_department() {
		click(department_dropdown);
		searchField.sendKeys("Crescent School of Architecture");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select department for scheme creation - Crescent School of Architecture");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_branch() {
		click(branch_dropdown);
		searchField.sendKeys("Architecture");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select branch for scheme creation - Architecture");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_AdmissionBatch() {
		click(admissionBatch_dropdown);
		searchField.sendKeys("2015-16");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select batchno for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_SchemeType() {
		click(schemeType_dropdown);
		searchField.sendKeys("Old Scheme");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select schemetype for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_grade() {
		click(grade_dropdown);
		searchField.sendKeys("Grade");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select grademarks for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_resultProcessPattern() {
		click(resultProcessPattern_dropdown);
		searchField.sendKeys("Marks Pattern");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select grademarks for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_patternName() {
		click(patternName_dropdown);
		searchField.sendKeys("DCOE");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select study pattern for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation select_studyPattern() {
		click(studyPattern_dropdown);
		searchField.sendKeys("Trimester");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select study pattern for scheme creation");
		return this;
	}
	public AL_Academic_PA_SD_SchemeCreation click_submit_button() {
		click(submitBtn);
		System.out.println("clicked submit button");
		return this;
	}
	
}
