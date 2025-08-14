package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_PA_SD_CollegeSchemeConfiguration extends BaseClass{

	public AL_Academic_PA_SD_CollegeSchemeConfiguration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Scheme Data")private WebElement schemeData_Link;
	@FindBy(linkText = "College Scheme Configuration")private WebElement collegeSchemeConfig_tab;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege1-container")private WebElement school_dropdown;
	@FindBy(className = "select2-search__field")private WebElement searchField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit1")private WebElement submit_button;
	
	public AL_Academic_PA_SD_CollegeSchemeConfiguration click_SchemeData() {
		System.out.println("Scheme Data");
		click(schemeData_Link);
		return this;
	}
	
	public AL_Academic_PA_SD_CollegeSchemeConfiguration click_collegeSchemeConfig_tab() {
		System.out.println("Select College Scheme Configuration");
		click(collegeSchemeConfig_tab);
		return this;
	}
	
	public AL_Academic_PA_SD_CollegeSchemeConfiguration select_school() {
		click(school_dropdown);
		searchField.sendKeys("Crescent School of Pharmacy");
		searchField.sendKeys(Keys.ENTER);
		System.out.println("select school for scheme configuration");
		return this;
	}
	
	public AL_Academic_PA_SD_CollegeSchemeConfiguration click_submit_button() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("Submit the school for scheme configuration");
		js.executeScript("arguments[0].scrollIntoView();",submit_button);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit_button);

		return this;
	}
	
}
