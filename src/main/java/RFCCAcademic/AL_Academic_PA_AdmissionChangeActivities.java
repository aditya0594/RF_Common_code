package RFCCAcademic;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_PA_AdmissionChangeActivities extends BaseClass{

	public AL_Academic_PA_AdmissionChangeActivities(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Admission Change Activities") private WebElement admissionChangeActivities_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch") private WebElement searchCriteria_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch") private WebElement searchString_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearch") private WebElement search_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId") private WebElement name_link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblSelection_0") private WebElement selection_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlNewCollege") private WebElement newClg_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlNewDegree") private WebElement newDegree_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlNewBranch") private WebElement branch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlNewPaymentType") private WebElement newPaymentType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;

	
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
	public AL_Academic_PA_AdmissionChangeActivities click_admissionChangeActivities_link() throws InterruptedException 
	{
		System.out.println("Click on Admission Change Activities link");	
		js.executeScript("arguments[0].click();", admissionChangeActivities_link);
		
		return this;
	}
	
	public AL_Academic_PA_AdmissionChangeActivities select_searchCriteria() 
	{
		System.out.println("Select Search Criteria");
		Select opt = new Select(searchCriteria_dropdown);
		opt.selectByVisibleText("NAME");
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities enter_searchString() 
	{
		
		searchString_inputfield.sendKeys("m");
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities click_search_button() 
	{
		System.out.println("Click on Search Button");
		search_button.click();
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities click_name_link() 
	{
		
		name_link.click();
		return this;
	}
	
	public AL_Academic_PA_AdmissionChangeActivities click_readmissionWithBranchChangeAndPayTypeMod() 
	{
		selection_radioBtn.click();
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities select_newCollege() 
	{
		System.out.println("Select New College");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollHeight;", newClg_dropdown);
		Select opt = new Select(newClg_dropdown);
		opt.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities select_newDegree() 
	{
		System.out.println("Select New Degree");
		Select opt = new Select(newDegree_dropdown);
		opt.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities select_newBranch() throws InterruptedException 
	{
		System.out.println("Select Branch");
		Select opt = new Select(branch_dropdown);
		opt.selectByVisibleText("Architecture");
		return this;
	}
	public AL_Academic_PA_AdmissionChangeActivities select_newPaymentType() 
	{
		System.out.println("Select New PaymentType");
		Select opt = new Select(newPaymentType_dropdown);
		opt.selectByVisibleText("General");
		return this;
	}
	
	public AL_Academic_PA_AdmissionChangeActivities click_submit_button() throws InterruptedException 
	{
		System.out.println("Click on Submit button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submit_button);
		Thread.sleep(2000);
		click(submit_button);
		return this;
	}
	
	
}
