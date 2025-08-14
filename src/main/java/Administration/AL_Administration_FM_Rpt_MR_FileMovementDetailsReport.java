package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_FM_Rpt_MR_FileMovementDetailsReport  extends BaseClass {
	
	public AL_Administration_FM_Rpt_MR_FileMovementDetailsReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(id="ctl00_repLinks_ctl00_lbLink")
	private WebElement MovementReports;
	
	@FindBy(id= "ctl00_ContentPlaceHolder1_ddlReport")
	private WebElement ReportStatus;
	
	@FindBy(xpath= "(//td[contains(text(),'28-Jul-2023')])/../td[9]/input")
	private WebElement DetailsBtn;
	
	@FindBy(xpath= "//input[@class='form-control form-control-sm']")
	private WebElement searchbar;
	
	public AL_Administration_FM_Rpt_MR_FileMovementDetailsReport ClickOn_MovementReports() {
		System.out.println("Click on Movement Reports ");
		MovementReports.click();
		return this;
	}
	
	
	public AL_Administration_FM_Rpt_MR_FileMovementDetailsReport Select_ReportStatusDropdown() {
		System.out.println("Select Report Status Dropdown");
		Select select = new Select(ReportStatus);
		select.selectByVisibleText("File Movement Details");
		return this;
	}
	
	public AL_Administration_FM_Rpt_MR_FileMovementDetailsReport ClickOn_DetailsBtn() throws InterruptedException {
		System.out.println("Click on Details Button ");
		searchbar.sendKeys("28-Jul-2023");
		Thread.sleep(2000);
		DetailsBtn.click();
		return this;
	}
	

}
