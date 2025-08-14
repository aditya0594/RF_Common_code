package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import RFCCAcademic.AL_Academic_AR_BulkUpdateOfPhoto;
import utility.BaseClass;

public class AL_Academic_PA_BulkSectionAllotment extends BaseClass{

	public AL_Academic_PA_BulkSectionAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink") private WebElement bulkSectionAllotment_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlInsName") private WebElement school_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement branch_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rbenroll") private WebElement sortBy_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnFilter") private WebElement filter_button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClassSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourseType") private WebElement courseType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEnrollFrom") private WebElement rangeFrom_input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEnrollTo") private WebElement rangeTo_input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	
	
	
	public AL_Academic_PA_BulkSectionAllotment click_bulkSectionAllotment_link() 
	{
		System.out.println("Click on Bulk Section Allotment link");
		bulkSectionAllotment_link.click();
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment select_school() 
	{
		System.out.println("Select School");
		Select opt = new Select(school_dropdown);
		opt.selectByVisibleText("Crescent School of Law - Chennai");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment select_degree() 
	{
		System.out.println("Select Degree");
		Select opt = new Select(degree_dropdown);
		opt.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment select_branch() 
	{
		System.out.println("Select Branch");
		Select opt = new Select(branch_dropdown);
		opt.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment click_sortByEnrollmentNo() 
	{
		
		sortBy_radioBtn.click();
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment click_filter_button() 
	{
		System.out.println("Click on Filter button");
		filter_button.click();
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment select_section() 
	{
		System.out.println("Select Section");
		Select opt = new Select(section_dropdown);
		opt.selectByVisibleText("C");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment select_courseType() 
	{
		System.out.println("Select CourseType");
		Select opt = new Select(courseType_dropdown);
		opt.selectByVisibleText("All Courses");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment enter_rangeFrom() 
	{
		rangeFrom_input.sendKeys("1");
		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment enter_rangeTo() 
	{
		rangeTo_input.sendKeys("1");
		return this;
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public AL_Academic_PA_BulkSectionAllotment click_confirm_button() throws InterruptedException 
	{
		System.out.println("Click on confirm button");
		 js.executeScript("arguments[0].scrollIntoView();", filter_button);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConfirm")).click();

		return this;
	}
	public AL_Academic_PA_BulkSectionAllotment click_submit_button() throws InterruptedException 
	{
		System.out.println("Click on Submit button");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", sortBy_radioBtn);
		 Thread.sleep(3000);
		click(submit_button);
		return this;
	}
	
	
}
