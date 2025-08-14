package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Administration_SRM_Transaction_Servicstatusreport extends BaseClass{

	public AL_Administration_SRM_Transaction_Servicstatusreport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement serviceStatusReport_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSDate") private WebElement startDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	

	public AL_Administration_SRM_Transaction_Servicstatusreport click_serviceStatusReport() {
		System.out.println("Service Status report");
		Actions action = new Actions(driver);
		action.moveToElement(serviceStatusReport_link);
		action.click().build().perform(); 
		return this;
	}
	public AL_Administration_SRM_Transaction_Servicstatusreport enter_startDate() throws InterruptedException {
		startDate.clear();
		Thread.sleep(2000); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = arguments[1]",startDate, "05/03/2020");
		System.out.println("Select date ->05/03/2020 ");
		return this;
	}
	public AL_Administration_SRM_Transaction_Servicstatusreport click_submit_button() {
		System.out.println("Click on show Report");
		click(submit_button);
		return this;
	}
	
}
