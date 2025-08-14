package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_PS_StaffEntry extends BaseClass {

	public AL_Examination_PS_StaffEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Staff Entry")
	private WebElement staffEntry_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlcollege")
	private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment")
	private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff")
	private WebElement staffList_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_BtnAddStaff")
	private WebElement addStaff_button;
	@FindBy(xpath = "//a[normalize-space()='EXTERNAL']")
	private WebElement externalTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtIName")
	private WebElement staffName_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMobile")
	private WebElement mobileNo_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtNameOfInst")
	private WebElement instituteName_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBnkName")
	private WebElement bank_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAccNo")
	private WebElement accountNo_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtIFSC")
	private WebElement IFSCCode_inputfield;
	
	@FindBy(xpath = "//input[@title='Edit Record']")
	private WebElement editbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement updateExternalStaffBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement ext_addStaff_button;

	public AL_Examination_PS_StaffEntry click_staffEntry_link() {
		click(staffEntry_link);
		System.out.println("Click on Staff Entry");
		return this;
	}

	public AL_Examination_PS_StaffEntry select_college() {
		Select colg_name = new Select(college_dropdown);
		colg_name.selectByVisibleText("Crescent School of Law");
		System.out.println("College is: Crescent School of Law");
		return this;
	}

	public AL_Examination_PS_StaffEntry select_department() throws InterruptedException {
		Select depart_typ = new Select(department_dropdown);
		WebElement dept_click = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDepartment-container"));
		dept_click.click();
		Thread.sleep(2000);
		WebElement dept_search = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		dept_search.sendKeys("Crescent School of Law");
		dept_search.sendKeys(Keys.ENTER);
		System.out.println("Department is: Crescent School of Law");
		return this;
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Examination_PS_StaffEntry select_staffList() throws InterruptedException {
		WebElement staff_click = driver.findElement(By.xpath("//button[@class='multiselect btn btn-default']"));
		staff_click.click();
		Thread.sleep(2000);
		WebElement staff = driver.findElement(By.xpath("//input[@value='562']"));
		js.executeScript("arguments[0].click();", staff);
		System.out.println("staff Entry is: AAMIR MAJEED PARRAY");
		return this;
	}

	public AL_Examination_PS_StaffEntry click_addStaff_button() {
		js.executeScript("arguments[0].click();", addStaff_button);
		System.out.println("Click on Add Staff Button");
		return this;
	}

	public AL_Examination_PS_StaffEntry click_external_tab() {
		click(externalTab);
		System.out.println("Click on External");
		return this;
	}

	public AL_Examination_PS_StaffEntry Click_EditBtn() {
		System.out.println("Click on Edit Btn");
		js.executeScript("arguments[0].scrollIntoView();",updateExternalStaffBtn);
		click(editbtn);
		return this;
	}
	
	public AL_Examination_PS_StaffEntry Click_UpdateExternalStaffBtn() {
		System.out.println("Click on Update External Staff btn");
		click(updateExternalStaffBtn);
		return this;
	}

}
