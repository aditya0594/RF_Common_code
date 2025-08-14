package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_PA_SD_SchemeType extends BaseClass{

	public AL_Academic_PA_SD_SchemeType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='Scheme Data']")private WebElement schemeData_Link;
	@FindBy(linkText = "Scheme Type")private WebElement schemeType;
	@FindBy(xpath = "//input[@title='Edit Record']")private WebElement editschemeType_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitSchemeType")private WebElement submit_button;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Academic_PA_SD_SchemeType click_SchemeData() throws InterruptedException {
		System.out.println("Scheme Data");
		js.executeScript("arguments[0].scrollIntoView();",schemeData_Link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", schemeData_Link);
		return this;
	}
	public AL_Academic_PA_SD_SchemeType click_schemeType() {
		System.out.println("Scheme Type");
		click(schemeType);
		return this;
	}
	public AL_Academic_PA_SD_SchemeType click_editSchemeType() {
		click(editschemeType_button);
		System.out.println("Edit the scheme type");
		return this;
	}
	public AL_Academic_PA_SD_SchemeType click_submit_btn() {
		js.executeScript("arguments[0].click();", submit_button);
		System.out.println("Submit the scheme type");
		return this;
	}
	
}
